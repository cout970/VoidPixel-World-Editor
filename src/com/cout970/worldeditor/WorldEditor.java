package com.cout970.worldeditor;

import com.cout970.worldeditor.util.Side;
import com.cout970.worldeditor.world.Block;
import com.cout970.worldeditor.world.Chunk;
import com.cout970.worldeditor.world.ChunkStorage;
import com.cout970.worldeditor.world.Material;

public class WorldEditor {

	public static State estado = State.NONE;
	private static Block selectBlock;
	private static Material selectedMaterial = new Material("STONE", 1, 1, 1);
	
	public static Block getBlock(int x, int y, int z){
		if(y < 0 ||y >= 32)return null;
		int chunkX = x>=0 ? x/8 : x/8-1;
		int chunkZ = z>=0 ? z/8 : z/8-1;
		int xx = x%8>=0 ? x%8 : 8+x%8;
		int zz = z%8>=0 ? z%8 : 8+z%8;
		
		for(Chunk c : ChunkStorage.storage){
			if(c.X == chunkX && c.Z == chunkZ){
				return c.Blocks[y][zz][xx];
			}
		}
		return null;
	}
	
	public enum State{
		NONE,SELECT;
	}

	public static void selectBlock(Block b) {
		if(b == null){
			WorldEditor.selectBlock = b;
			estado = State.NONE;
		}else{
			estado = State.SELECT;
			Block old = selectBlock;
			selectBlock = b;
			for(Side s : Side.values())
			b.setRenderizable(s,true);
			if(old != null){
				for(Side s : Side.values())
				old.setRenderizable(s,RenderManager.shouldRender(s,old));
			}
			RenderManager.reloadChunks();
		}
	}

	public static Block getSelectedBlock(){
		return selectBlock;
	}

	public static Material getSelectedMaterial() {
		return selectedMaterial ;
	}
}
