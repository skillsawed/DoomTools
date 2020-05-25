/*******************************************************************************
 * Copyright (c) 2020 Matt Tropiano
 * This program and the accompanying materials are made available under 
 * the terms of the MIT License, which accompanies this distribution.
 ******************************************************************************/
package net.mtrop.doom.tools.wtexport;

import java.util.HashMap;

import net.mtrop.doom.texture.Animated;

/**
 * Texture Extractor tables.
 * @author Matthew Tropiano
 */
public interface TextureTables
{
	/** All animated entries. */
	public static final Animated ALL_ANIMATED = new Animated()
	{{
		addEntry(Animated.texture("BLODGR4", "BLODGR1", 8, true));
		addEntry(Animated.texture("SLADRIP3", "SLADRIP1", 8, true));
		addEntry(Animated.texture("BLODRIP4", "BLODRIP1", 8, true));
		addEntry(Animated.texture("FIREWALL", "FIREWALA", 8, false));
		addEntry(Animated.texture("GSTFONT3", "GSTFONT1", 8, true));
		addEntry(Animated.texture("FIRELAVA", "FIRELAV3", 8, false));
		addEntry(Animated.texture("FIREMAG3", "FIREMAG1", 8, false));
		addEntry(Animated.texture("FIREBLU2", "FIREBLU1", 8, false));
		addEntry(Animated.texture("ROCKRED3", "ROCKRED1", 8, true));
		addEntry(Animated.texture("BFALL4", "BFALL1", 8, false));
		addEntry(Animated.texture("SFALL4", "SFALL1", 8, false));
		addEntry(Animated.texture("WFALL4", "WFALL1", 8, false));
		addEntry(Animated.texture("DBRAIN4", "DBRAIN1", 8, false));
		addEntry(Animated.texture("LAVAFL3", "LAVAFL1", 6, false));
		addEntry(Animated.texture("WATRWAL3", "WATRWAL1", 4, false));
		addEntry(Animated.texture("SCAN08", "SCAN05", 4, false));
		addEntry(Animated.texture("SWTRMG03", "SWTRMG01", 4, false));
		addEntry(Animated.texture("SCAN04", "SCAN01", 4, false));
		addEntry(Animated.texture("COMP04", "COMP01", 4, false));
		addEntry(Animated.texture("COMP08", "COMP05", 6, false));
		addEntry(Animated.texture("COMP12", "COMP09", 11, false));
		addEntry(Animated.texture("COMP16", "COMP13", 12, false));
		addEntry(Animated.texture("COMP20", "COMP17", 12, false));
		addEntry(Animated.texture("COMP24", "COMP21", 12, false));
		addEntry(Animated.texture("COMP28", "COMP25", 12, false));
		addEntry(Animated.texture("COMP32", "COMP29", 12, false));
		addEntry(Animated.texture("COMP37", "COMP33", 12, false));
		addEntry(Animated.texture("COMP41", "COMP38", 12, false));
		addEntry(Animated.texture("COMP49", "COMP42", 10, false));
		addEntry(Animated.texture("BRKGRY16", "BRKGRY13", 10, false));
		addEntry(Animated.texture("BRNSCN04", "BRNSCN01", 10, false));
		addEntry(Animated.texture("CONCRT12", "CONCRT09", 11, false));
		addEntry(Animated.texture("CONCRT25", "CONCRT22", 11, false));
		addEntry(Animated.texture("WALPMP02", "WALPMP01", 16, false));
		addEntry(Animated.texture("WALTEK17", "WALTEK16", 8, false));
		addEntry(Animated.texture("FORCE04", "FORCE01", 4, false));
		addEntry(Animated.texture("FORCE08", "FORCE05", 4, false));
		addEntry(Animated.texture("FAN02", "FAN01", 4, false));
		
		addEntry(Animated.flat("NUKAGE3", "NUKAGE1", 8));
		addEntry(Animated.flat("FWATER4", "FWATER1", 8));
		addEntry(Animated.flat("SWATER4", "SWATER1", 8));
		addEntry(Animated.flat("LAVA4", "LAVA1", 8));
		addEntry(Animated.flat("BLOOD3", "BLOOD1", 8));
		addEntry(Animated.flat("RROCK08", "RROCK05", 8));
		addEntry(Animated.flat("SLIME04", "SLIME01", 8));
		addEntry(Animated.flat("SLIME08", "SLIME05", 8));
		addEntry(Animated.flat("SLIME12", "SLIME09", 8));
		addEntry(Animated.flat("FLTWAWA3", "FLTWAWA1", 8));
		addEntry(Animated.flat("FLTSLUD3", "FLTSLUD1", 8));
		addEntry(Animated.flat("FLTTELE4", "FLTTELE1", 6));
		addEntry(Animated.flat("FLTFLWW3", "FLTFLWW1", 9));
		addEntry(Animated.flat("FLTLAVA4", "FLTLAVA1", 8));
		addEntry(Animated.flat("FLATHUH4", "FLATHUH1", 8));
		addEntry(Animated.flat("F_SCANR8", "F_SCANR5", 4));
		addEntry(Animated.flat("F_WATR03", "F_WATR01", 8));
		addEntry(Animated.flat("F_PWATR3", "F_PWATR1", 11));
		addEntry(Animated.flat("F_SCANR4", "F_SCANR1", 4));
		addEntry(Animated.flat("F_VWATR3", "F_VWATR1", 4));
		addEntry(Animated.flat("F_HWATR3", "F_HWATR1", 4));
		addEntry(Animated.flat("F_TELE2", "F_TELE1", 4));
		addEntry(Animated.flat("F_FAN2", "F_FAN1", 4));
		addEntry(Animated.flat("F_CONVY2", "F_CONVY1", 4));
		addEntry(Animated.flat("F_RDALN4", "F_RDALN1", 4));
	}};
	
	/**
	 * Switch texture groups.
	 */
	public static final HashMap<String, String> SWITCH_TABLE = new HashMap<String, String>()
	{
		private static final long serialVersionUID = 3990043334727188715L;
		{
			put("SW1BRCOM", "SW2BRCOM");
			put("SW1BRN1", "SW2BRN1");
			put("SW1BRN2", "SW2BRN2");
			put("SW1BRNGN", "SW2BRNGN");
			put("SW1BROWN", "SW2BROWN");
			put("SW1COMM", "SW2COMM");
			put("SW1COMP", "SW2COMP");
			put("SW1DIRT", "SW2DIRT");
			put("SW1EXIT", "SW2EXIT");
			put("SW1GRAY", "SW2GRAY");
			put("SW1GRAY1", "SW2GRAY1");
			put("SW1METAL", "SW2METAL");
			put("SW1PIPE", "SW2PIPE");
			put("SW1SLAD", "SW2SLAD");
			put("SW1STARG", "SW2STARG");
			put("SW1STON1", "SW2STON1");
			put("SW1STON2", "SW2STON2");
			put("SW1STONE", "SW2STONE");
			put("SW1STRTN", "SW2STRTN");
			put("SW1BLUE", "SW2BLUE");
			put("SW1CMT", "SW2CMT");
			put("SW1GARG", "SW2GARG");
			put("SW1GSTON", "SW2GSTON");
			put("SW1HOT", "SW2HOT");
			put("SW1LION", "SW2LION");
			put("SW1SATYR", "SW2SATYR");
			put("SW1SKIN", "SW2SKIN");
			put("SW1VINE", "SW2VINE");
			put("SW1WOOD", "SW2WOOD");
			put("SW1PANEL", "SW2PANEL");
			put("SW1ROCK", "SW2ROCK");
			put("SW1MET2", "SW2MET2");
			put("SW1WDMET", "SW2WDMET");
			put("SW1BRIK", "SW2BRIK");
			put("SW1MOD1", "SW2MOD1");
			put("SW1ZIM", "SW2ZIM");
			put("SW1STON6", "SW2STON6");
			put("SW1TEK", "SW2TEK");
			put("SW1MARB", "SW2MARB");
			put("SW1SKULL", "SW2SKULL");
			put("SW1OFF", "SW1ON");
			put("SW2OFF", "SW2ON");
			put("SW_1_UP", "SW_1_DN");
			put("SW_2_UP", "SW_2_DN");
			put("VALVE1", "VALVE2");
			put("SW51_OFF", "SW51_ON");
			put("SW52_OFF", "SW52_ON");
			put("SW53_UP", "SW53_DN");
			put("PUZZLE5", "PUZZLE9");
			put("PUZZLE6", "PUZZLE10");
			put("PUZZLE7", "PUZZLE11");
			put("PUZZLE8", "PUZZLE12");
			put("GLASS01", "GLASS02");
			put("GLASS03", "GLASS04");
			put("GLASS05", "GLASS06");
			put("GLASS07", "GLASS08");
			put("GLASS17", "GLASS18");
			put("GLASS19", "GLASS20");
			put("SWKNOB01", "SWKNOB02");
			put("SWLITE01", "SWLITE02");
			put("SWCHN01", "SWCHN02");
			put("COMP01", "COMP04B");
			put("COMP05", "COMP12B");
			put("COMP09", "COMP12B");
			put("COMP12", "COMP04B");
			put("COMP13", "COMP12B");
			put("COMP17", "COMP20B");
			put("COMP21", "COMP28B");
			put("WALTEK09", "WALTEKB1");
			put("WALTEK10", "WALTEKB1");
			put("WALTEK15", "WALTEKB1");
			put("SWFORC01", "SWFORC02");
			put("SWEXIT01", "SWEXIT02");
			put("DORSBK01", "DORSBK02");
			put("SWSLD01", "SWSLD02");
			put("DORWS04", "DORWS05");
			put("SWIRON01", "SWIRON02");
			put("GLASS09", "GLASS10");
			put("GLASS11", "GLASS12");
			put("GLASS13", "GLASS14");
			put("GLASS15", "GLASS16");
			put("SWFORC03", "SWFORC04");
			put("SWCIT01", "SWCIT02");
			put("SWTRMG01", "SWTRMG04");
			put("SWMETL01", "SWMETL02");
			put("SWWOOD01", "SWWOOD02");
			put("SWTKBL01", "SWTKBL02");
			put("AZWAL21", "AZWAL22");
			put("SWINDT01", "SWINDT02");
			put("SWRUST01", "SWRUST02");
			put("SWCHAP01", "SWCHAP02");
			put("SWALIN01", "SWALIN02");
			put("SWWALG01", "SWWALG02");
			put("SWWALG03", "SWWALG04");
			put("SWTRAM01", "SWTRAM02");
			put("SWTRAM03", "SWTRAM04");
			put("SWORC01", "SWORC02");
			put("SWBRIK01", "SWBRIK02");
			put("SWIRON03", "SWIRON04");
			put("SWIRON05", "SWIRON06");
			put("SWIRON07", "SWIRON08");
			put("SWCARD01", "SWCARD02");
			put("SWSIGN01", "SWSIGN02");
			put("SWLEV01", "SWLEV02");
			put("SWLEV03", "SWLEV04");
			put("SWLEV05", "SWLEV06");
			put("SWBRN01", "SWBRN02");
			put("SWPIP01", "SWPIP02");
			put("SWPALM01", "SWPALM02");
			put("SWKNOB03", "SWKNOB04");
			put("ALTSW01", "ALTSW02");
			put("COMP25", "COMP28B");
			put("COMP29", "COMP20B");
			put("COMP33", "COMP50");
			put("COMP42", "COMP51");
			put("GODSCRN1", "GODSCRN2");
			put("ALIEN04", "ALIEN05");
			put("CITADL04", "CITADL05");
			put("SWITE03", "SWITE04");
			put("SWTELP01", "SWTELP02");
			put("BRNSCN01", "BRNSCN05");
			put("WALTEKB1", "WALTEK09");
			put("SWLEV06", "SWLEV05");
			put("SWORC02", "SWORC01");
			put("SWLEV04", "SWLEV03");
			put("SWLEV02", "SWLEV01");
			put("SW53_DN", "SW53_UP");
			put("SWALIN02", "SWALIN01");
			put("SWPIP02", "SWPIP01");
			put("SWTRAM02", "SWTRAM01");
			put("SWTRAM04", "SWTRAM03");
			put("SW2EXIT", "SW1EXIT");
			put("DORSBK02", "DORSBK01");
			put("SW2LION", "SW1LION");
			put("WALTEKB1", "WALTEK10");
			put("SWPALM02", "SWPALM01");
			put("WALTEKB1", "WALTEK15");
			put("SW2HOT", "SW1HOT");
			put("SW2CMT", "SW1CMT");
			put("SW2COMP", "SW1COMP");
			put("SW2METAL", "SW1METAL");
			put("SWTKBL02", "SWTKBL01");
			put("SW2COMM", "SW1COMM");
			put("SW2PANEL", "SW1PANEL");
			put("GODSCRN2", "GODSCRN1");
			put("COMP51", "COMP42");
			put("SW_2_DN", "SW_2_UP");
			put("SW2WDMET", "SW1WDMET");
			put("BRNSCN05", "BRNSCN01");
			put("SWBRN02", "SWBRN01");
			put("SW2GSTON", "SW1GSTON");
			put("PUZZLE12", "PUZZLE8");
			put("PUZZLE11", "PUZZLE7");
			put("SWCHAP02", "SWCHAP01");
			put("PUZZLE10", "PUZZLE6");
			put("PUZZLE9", "PUZZLE5");
			put("SWRUST02", "SWRUST01");
			put("SW2ZIM", "SW1ZIM");
			put("SW51_ON", "SW51_OFF");
			put("COMP50", "COMP33");
			put("SW2TEK", "SW1TEK");
			put("SW2MET2", "SW1MET2");
			put("SW2BRN2", "SW1BRN2");
			put("VALVE2", "VALVE1");
			put("SWFORC04", "SWFORC03");
			put("SW2BRN1", "SW1BRN1");
			put("SWFORC02", "SWFORC01");
			put("SWINDT02", "SWINDT01");
			put("COMP20B", "COMP29");
			put("SWLITE02", "SWLITE01");
			put("COMP28B", "COMP25");
			put("SW2MARB", "SW1MARB");
			put("COMP28B", "COMP21");
			put("ALTSW02", "ALTSW01");
			put("SWMETL02", "SWMETL01");
			put("SWSLD02", "SWSLD01");
			put("SWCHN02", "SWCHN01");
			put("GLASS02", "GLASS01");
			put("GLASS04", "GLASS03");
			put("GLASS06", "GLASS05");
			put("GLASS08", "GLASS07");
			put("SW2PIPE", "SW1PIPE");
			put("GLASS10", "GLASS09");
			put("SW2WOOD", "SW1WOOD");
			put("SW2VINE", "SW1VINE");
			put("COMP20B", "COMP17");
			put("SWCARD02", "SWCARD01");
			put("COMP12B", "COMP13");
			put("COMP04B", "COMP12");
			put("SWCIT02", "SWCIT01");
			put("SW_1_DN", "SW_1_UP");
			put("GLASS12", "GLASS11");
			put("GLASS14", "GLASS13");
			put("SW2ON", "SW2OFF");
			put("GLASS16", "GLASS15");
			put("CITADL05", "CITADL04");
			put("GLASS18", "GLASS17");
			put("SWKNOB04", "SWKNOB03");
			put("SW2GARG", "SW1GARG");
			put("GLASS20", "GLASS19");
			put("SWKNOB02", "SWKNOB01");
			put("DORWS05", "DORWS04");
			put("SW2BRNGN", "SW1BRNGN");
			put("COMP12B", "COMP09");
			put("SWBRIK02", "SWBRIK01");
			put("SW2DIRT", "SW1DIRT");
			put("COMP12B", "COMP05");
			put("SW2SATYR", "SW1SATYR");
			put("COMP04B", "COMP01");
			put("SW2SKIN", "SW1SKIN");
			put("SW2BRIK", "SW1BRIK");
			put("SW2STRTN", "SW1STRTN");
			put("SW2MOD1", "SW1MOD1");
			put("SWITE04", "SWITE03");
			put("SW2STONE", "SW1STONE");
			put("SWIRON08", "SWIRON07");
			put("SW2ROCK", "SW1ROCK");
			put("SW52_ON", "SW52_OFF");
			put("SWIRON06", "SWIRON05");
			put("SW2GRAY", "SW1GRAY");
			put("SW2SKULL", "SW1SKULL");
			put("SWIRON04", "SWIRON03");
			put("SWWOOD02", "SWWOOD01");
			put("SWIRON02", "SWIRON01");
			put("SW2STARG", "SW1STARG");
			put("SW2BLUE", "SW1BLUE");
			put("SWTELP02", "SWTELP01");
			put("SWSIGN02", "SWSIGN01");
			put("SWWALG02", "SWWALG01");
			put("SWWALG04", "SWWALG03");
			put("ALIEN05", "ALIEN04");
			put("SW2BROWN", "SW1BROWN");
			put("SW2SLAD", "SW1SLAD");
			put("SW2STON6", "SW1STON6");
			put("AZWAL22", "AZWAL21");
			put("SW2STON2", "SW1STON2");
			put("SW2BRCOM", "SW1BRCOM");
			put("SW2STON1", "SW1STON1");
			put("SWEXIT02", "SWEXIT01");
			put("SWTRMG04", "SWTRMG01");
			put("SW1ON", "SW1OFF");
			put("SW2GRAY1", "SW1GRAY1");
		}
	};
	
}