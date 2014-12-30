package com.cout970.worldeditor;

import com.cout970.worldeditor.world.Block;
import com.cout970.worldeditor.world.Chunk;
import com.cout970.worldeditor.world.ChunkStorage;

public class WorldEditor {

	public static State estado = State.NONE;
	public static Block selectBlock;
	
	public static Block getBlock(int x, int y, int z){
		if(x < 0 || y < 0 || y >= 32|| z < 0)return null;
		
		int chunkX = x/8;
		int chunkZ = z/8;
		for(Chunk c : ChunkStorage.storage){
			if(c.X == chunkX && c.Z == chunkZ){
				return c.Blocks[y][z%8][x%8];
			}
		}
		return null;
	}
	
	public enum State{
		NONE,SELECT;
	}
}
