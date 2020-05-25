/*******************************************************************************
 * Copyright (c) 2020 Matt Tropiano
 * This program and the accompanying materials are made available under 
 * the terms of the MIT License, which accompanies this distribution.
 ******************************************************************************/
package net.mtrop.doom.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import net.mtrop.doom.WadFile;
import net.mtrop.doom.struct.io.IOUtils;
import net.mtrop.doom.texture.Animated;
import net.mtrop.doom.texture.Switches;
import net.mtrop.doom.tools.common.Common;
import net.mtrop.doom.tools.common.ParseException;
import net.mtrop.doom.tools.common.Utility;

/**
 * Main class for JSwantbls.
 * @author Matthew Tropiano
 */
public final class WSwAnTablesMain
{
	private static final String DOOM_VERSION = Common.getVersionString("doom");
	private static final String VERSION = Common.getVersionString("wswantbls");

	private static final int ERROR_NONE = 0;
	private static final int ERROR_BAD_INPUTOUTPUT_FILE = 1;
	private static final int ERROR_BAD_PARSE = 2;
	private static final int ERROR_MISSING_DATA = 3;

	private static final String SWITCH_HELP = "--help";
	private static final String SWITCH_HELP2 = "-h";
	private static final String SWITCH_VERBOSE = "--verbose";
	private static final String SWITCH_VERBOSE2 = "-v";
	private static final String SWITCH_VERSION = "--version";
	private static final String SWITCH_EXPORT = "--export";
	private static final String SWITCH_EXPORT2 = "-x";
	private static final String SWITCH_IMPORT = "--import";
	private static final String SWITCH_IMPORT2 = "-i";

	private static final String SWANTBLS_OUTPUT_HEADER = (new StringBuilder())
		.append("# Table file generated by WSWANTBLS v").append(VERSION).append(" by Matt Tropiano")
	.toString();

	/**
	 * Program options.
	 */
	public static class Options
	{
		private PrintStream out;
		private PrintStream err;
		private BufferedReader in;
		
		private boolean help;
		private boolean version;
		private boolean verbose;
		private Boolean exportMode;
		private File sourceFile;
		private File wadFile;
		
		public Options(PrintStream out, PrintStream err, BufferedReader in)
		{
			this.out = out;
			this.err = err;
			this.in = in;
			
			this.help = false;
			this.version = false;
			this.verbose = false;
			this.exportMode = null;
			this.sourceFile = null;
			this.wadFile = null;
		}
		
		void println(Object msg)
		{
			out.println(msg);
		}
		
		void errln(Object msg)
		{
			err.println(msg);
		}
		
		void errf(String fmt, Object... args)
		{
			err.printf(fmt, args);
		}

		char readChar() throws IOException
		{
			return (char)in.read();
		}
		
		String readLine() throws IOException
		{
			return in.readLine();
		}	
	}
	
	/**
	 * Prints the splash.
	 * @param out the print stream to print to.
	 */
	private static void splash(PrintStream out)
	{
		out.println("WSwAnTbl v" + VERSION + " by Matt Tropiano (using DoomStruct v" + DOOM_VERSION + ")");
	}

	/**
	 * Prints the usage.
	 * @param out the print stream to print to.
	 */
	private static void usage(PrintStream out)
	{
		out.println("Usage: wswantbl [--help | -h | --version] [file] [mode] [switches]");
	}

	/**
	 * Prints the help.
	 * @param out the print stream to print to.
	 */
	private static void help(PrintStream out)
	{
		out.println("    --help              Prints help and exits.");
		out.println("    -h");
		out.println();
		out.println("    --version           Prints version, and exits.");
		out.println();
		out.println("[file]:");
		out.println("    <filename>          The WAD file.");
		out.println();
		out.println("[mode]:");
	    out.println("    --export [dstfile]  Export mode.");
	    out.println("    -x [dstfile]        Exports ANIMATED and SWITCHES from [file] to [dstfile].");
		out.println();
	    out.println("    --import [srcfile]  Import mode.");
	    out.println("    -i [srcfile]        Imports ANIMATED and SWITCHES from [srcfile] into");
	    out.println("                        [file]. WAD file is created if it doesn't exist.");
		out.println();
		out.println("[switches]:");
		out.println("    --verbose           Prints verbose output.");
		out.println("    -v");
	}

	/**
	 * Reads command line arguments and sets options.
	 * @param options the program options.
	 * @param args the argument args.
	 */
	public static void scanOptions(Options options, String[] args)
	{
		final int STATE_START = 0;
		final int STATE_IMPORTEXPORT = 1;
		int state = STATE_START;
		
		int i = 0;
		while (i < args.length)
		{
			String arg = args[i];
			switch (state)
			{
				case STATE_START:
				{
					if (arg.equals(SWITCH_HELP) || arg.equals(SWITCH_HELP2))
						options.help = true;
					else if (arg.equals(SWITCH_VERBOSE) || arg.equals(SWITCH_VERBOSE2))
						options.verbose = true;
					else if (arg.equals(SWITCH_VERSION))
						options.version = true;
					else if (arg.equals(SWITCH_EXPORT) || arg.equals(SWITCH_EXPORT2))
					{
						state = STATE_IMPORTEXPORT;
						options.exportMode = true;
					}
					else if (arg.equals(SWITCH_IMPORT) || arg.equals(SWITCH_IMPORT2))
					{
						state = STATE_IMPORTEXPORT;
						options.exportMode = false;
					}
					else
						options.wadFile = new File(arg);
				}
				break;

				case STATE_IMPORTEXPORT:
				{
					options.sourceFile = new File(arg);
					state = STATE_START;
				}
				break;
			}
			i++;
		}
	}
	
	/**
	 * Calls this program.
	 * @param options the program options.
	 * @return the return code.
	 */
	public static int call(Options options)
	{
		if (options.help)
		{
			splash(options.out);
			usage(options.out);
			options.out.println();
			help(options.out);
			options.out.println();
			return ERROR_NONE;
		}
		
		if (options.version)
		{
			splash(options.out);
			return ERROR_NONE;
		}
		
		if (options.wadFile == null)
		{
			options.err.println("ERROR: No WAD file specified.");
			usage(options.out);
			return ERROR_MISSING_DATA;
		}
	
		if (options.exportMode == null)
		{
			options.err.println("ERROR: Import or export mode not specified.");
			usage(options.out);
			return ERROR_MISSING_DATA;
		}
	
		if (options.sourceFile == null)
		{
			options.err.println("ERROR: No source file specified.");
			usage(options.out);
			return ERROR_MISSING_DATA;
		}
	
		WadFile wad = null;
		try 
		{
			if (!options.exportMode && !options.wadFile.exists())
				wad = WadFile.createWadFile(options.wadFile);
			else
				wad = new WadFile(options.wadFile);
		}
		catch (FileNotFoundException e)
		{
			options.err.printf("ERROR: File %s not found.\n", options.wadFile.getPath());
			return ERROR_BAD_INPUTOUTPUT_FILE;
		}
		catch (IOException e)
		{
			options.err.printf("ERROR: %s.\n", e.getLocalizedMessage());
			return ERROR_BAD_INPUTOUTPUT_FILE;
		}
		catch (SecurityException e)
		{
			options.err.printf("ERROR: File %s not readable (access denied).\n", options.wadFile.getPath());
			return ERROR_BAD_INPUTOUTPUT_FILE;
		}
	
		String streamName = null;
		BufferedReader reader = null;
		PrintWriter writer = null;
	
		try
		{
			Animated animated;
			boolean replaceAnimated = true;
			if ((animated = wad.getDataAs("ANIMATED", Animated.class)) == null)
			{
				animated = new Animated();
				replaceAnimated = false;
			}
			
			Switches switches;
			boolean replaceSwitches = true;
			if ((switches = wad.getDataAs("SWITCHES", Switches.class)) == null)
			{
				switches = new Switches();
				replaceSwitches = false;
			}
	
			if (options.exportMode)
			{
				try
				{
					writer = new PrintWriter(new FileOutputStream(options.sourceFile), true, Charset.forName("ASCII"));
					streamName = options.sourceFile.getPath();
				}
				catch (IOException e)
				{
					options.err.printf("ERROR: File %s not writable.\n", options.sourceFile.getPath());
					return ERROR_BAD_INPUTOUTPUT_FILE;
				}
				catch (SecurityException e)
				{
					options.err.printf("ERROR: File %s not writable (access denied).\n", options.sourceFile.getPath());
					return ERROR_BAD_INPUTOUTPUT_FILE;
				}
	
				Utility.writeSwitchAnimatedTables(switches, animated, SWANTBLS_OUTPUT_HEADER, writer);
				options.out.printf("Wrote `%s`.\n", streamName);
			}
			else // import mode
			{
				try
				{
					reader = new BufferedReader(new InputStreamReader(new FileInputStream(options.sourceFile)));
					streamName = options.sourceFile.getPath();
				}
				catch (FileNotFoundException e)
				{
					options.out.printf("ERROR: File %s not found.\n", options.sourceFile.getPath());
					return ERROR_BAD_INPUTOUTPUT_FILE;
				}
				catch (SecurityException e)
				{
					options.out.printf("ERROR: File %s not readable (access denied).\n", options.sourceFile.getPath());
					return ERROR_BAD_INPUTOUTPUT_FILE;
				}
	
				Utility.readSwitchAnimatedTables(reader, animated, switches);
	
				if (replaceAnimated)
				{
					wad.replaceEntry(wad.indexOf("ANIMATED"), animated);
					if (options.verbose)
						options.out.printf("Replaced `ANIMATED` in `%s`.\n", options.wadFile.getPath());
				}
				else
				{
					wad.addData("ANIMATED", animated);
					if (options.verbose)
						options.out.printf("Added `ANIMATED` to `%s`.\n", options.wadFile.getPath());
				}
				
				if (replaceSwitches)
				{
					wad.replaceEntry(wad.indexOf("SWITCHES"), switches);
					if (options.verbose)
						options.out.printf("Replaced `SWITCHES` in `%s`.\n", options.wadFile.getPath());
				}
				else
				{
					wad.addData("SWITCHES", switches);
					if (options.verbose)
						options.out.printf("Added `SWITCHES` to `%s`.\n", options.wadFile.getPath());
				}
				
				options.out.printf("Imported into `%s`.\n", options.wadFile.getPath());
			}
		}
		catch (IOException e)
		{
			options.out.printf("ERROR: %s\n", e.getLocalizedMessage());
			return ERROR_BAD_INPUTOUTPUT_FILE;
		}
		catch (ParseException e)
		{
			options.out.printf("ERROR: %s, %s\n", streamName, e.getLocalizedMessage());
			return ERROR_BAD_PARSE;
		}
		finally
		{
			IOUtils.close(reader);
			IOUtils.close(writer);
			IOUtils.close(wad);
		}
		
		return ERROR_NONE;
	}

	public static void main(String[] args) throws IOException
	{
		Options options = new Options(System.out, System.err, Common.openTextStream(System.in));
		scanOptions(options, args);
		System.exit(call(options));
	}

}
