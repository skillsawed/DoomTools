/*******************************************************************************
 * Copyright (c) 2020-2021 Matt Tropiano
 * This program and the accompanying materials are made available under 
 * the terms of the MIT License, which accompanies this distribution.
 ******************************************************************************/
package net.mtrop.doom.tools.decohack.contexts;

import net.mtrop.doom.tools.decohack.patches.DEHPatchBoom;
import net.mtrop.doom.tools.decohack.patches.PatchBoom;

/**
 * Patch context for Boom.
 * @author Matthew Tropiano
 */
public class PatchBoomContext extends AbstractPatchBoomContext
{
	private static final DEHPatchBoom BOOMPATCH = new PatchBoom();
	
	@Override
	public DEHPatchBoom getSourcePatch()
	{
		return BOOMPATCH;
	}

}
