package com.cout970.worldeditor;

import static org.lwjgl.opengl.GL11.*;

import com.cout970.worldeditor.util.Side;
import com.cout970.worldeditor.world.Block;
import com.cout970.worldeditor.world.Chunk;
import com.cout970.worldeditor.world.ChunkStorage;

public class RenderManager {
	
	public static float scale = 0.1f;
	public static boolean isFirst = true;
	public static boolean isGuiEnable = false;
	
	public static void renderWorld() {
		
		if(isFirst){
			isFirst = false;
			for(Chunk c : ChunkStorage.storage){
				for (int k = 0; k < 32; k++) {
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							c.Blocks[k][i][j].setRenderizable(shouldRender(c.Blocks[k][i][j]));
						}
					}
				}
			}
		}
		for(Chunk c : ChunkStorage.storage){
			renderChunk(c);
		}
		drawOverlay();
//		GLManager.camara.renderCamara();
	}

	private static void drawOverlay() {
//		if(isGuiEnable){
//			glPushMatrix();
//			glColor4f(1, 1, 1, 1);
//			float s = 100;
//			glScalef(s,s,s);
//			RenderUtil.bindTexture(TextureManager.overlay);
//			RenderUtil.quad();
//			glPopMatrix();
//		}
	}

	private static boolean shouldRender(Block block) {
		if(block.material.material.equalsIgnoreCase("AIR"))return false;
		if(WorldEditor.selectBlock == block)return true;
		for(Side s: Side.values()){
			int x = (int)block.getX()+s.OffsetX;
			int y = (int)-block.getY()+s.OffsetY;
			int z = (int)block.getZ()+s.OffsetZ;
			
			Block b = WorldEditor.getBlock(x, y, z);
			if(b != null){
				if(b.material.material.equalsIgnoreCase("AIR"))return true;
			}else{
				return true;
			}
		}
		return false;
	}

	public static void renderChunk(Chunk c) {
		glPushMatrix();
		glColor4f(1, 1, 1, 1);
		for (int k = 0; k < 32; k++) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					renderBlock(c.Blocks[k][i][j]);
				}
			}
		}
		glPopMatrix();
	}

	public static void renderBlock(Block b){
		if(!b.shouldRender())return;
		glPushMatrix();
		glTranslatef((float)b.getX(), (float)b.getY(),(float)b.getZ());
		if(WorldEditor.selectBlock == b)
			RenderUtil.bindTexture(TextureManager.select);
		else
			RenderUtil.bindTexture(TextureManager.getTexture(b.material));
		glColor4f(b.colors.red, b.colors.green, b.colors.blue, b.colors.alpha);
		RenderUtil.block();
		glEnd();
		glPopMatrix();
	}

	public static void reloadChunks() {
		isFirst = true;
	}

}
