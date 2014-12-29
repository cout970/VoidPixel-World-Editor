package com.cout970.worldeditor;

import static org.lwjgl.opengl.GL11.*;

import com.cout970.worldeditor.world.Block;
import com.cout970.worldeditor.world.Chunk;
import com.cout970.worldeditor.world.ChunkStorage;

public class RenderManager {
	
	public static float scale = 0.1f;
	
	public static void renderBlocks() {
		if(ChunkStorage.storage != null){
			renderChunk(ChunkStorage.storage);
		}
	}
	
	public static void renderChunk(Chunk c) {
		glPushMatrix();
		glColor4f(1, 1, 1, 1);
		glTranslatef(c.X*scale*16 - 0.5f, 1, c.Z*scale*16);
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
		if(b.material.material.equalsIgnoreCase("AIR"))return;
		glPushMatrix();
		glTranslatef((float)b.getX(), (float)b.getY(),(float)b.getZ());
		RenderUtil.bindTexture(TextureManager.getTexture(b.material));
		glColor4f(b.colors.red, b.colors.green, b.colors.blue, b.colors.alpha);
		glBegin(GL_QUADS);
		RenderUtil.block();
		glEnd();
		glPopMatrix();
	}

}
