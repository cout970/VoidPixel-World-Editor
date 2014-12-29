package com.cout970.worldeditor;

import com.cout970.worldeditor.world.Block;

public class WorldEditor {

	public static State estado = State.NONE;
	public static Block selectBlock;
	
	
	public enum State{
		NONE,SELECT;
	}
}
