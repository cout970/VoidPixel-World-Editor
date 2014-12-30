package com.cout970.worldeditor;

import static org.lwjgl.opengl.GL11.*;

import com.cout970.worldeditor.util.Side;
import com.cout970.worldeditor.util.Vector3;
import com.cout970.worldeditor.world.Block;
import com.cout970.worldeditor.world.Chunk;
import com.cout970.worldeditor.world.ChunkStorage;

public class RenderManager {
	
	public static float scale = 0.1f;
	public static boolean isFirst = true;
	
	
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
		drawCuadricula();
		GLManager.camara.renderCamara();
	}
	
	private static void drawCuadricula() {
		glPushMatrix();
		glColor4f(1, 1, 1, 1);
		RenderUtil.bindTexture(TextureManager.water);
		glLineWidth(1000);
		RenderUtil.line(new Vector3(0, 0, 0), new Vector3(10, 0, 0));
		RenderUtil.line(new Vector3(0, 0, 0), new Vector3(0, 10, 0));
		RenderUtil.line(new Vector3(0, 0, 0), new Vector3(0, 0, 10));
		glPopMatrix();
	}

	private static boolean shouldRender(Block block) {
		if(block.material.material.equalsIgnoreCase("AIR"))return false;
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
//		glTranslatef(c.X*scale*4, 1, c.Z*scale);
		glScalef(scale, scale, scale);
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
