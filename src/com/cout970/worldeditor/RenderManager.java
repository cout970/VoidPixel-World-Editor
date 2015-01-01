package com.cout970.worldeditor;

import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glEndList;
import static org.lwjgl.opengl.GL11.glNewList;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

import org.lwjgl.opengl.GL11;

import com.cout970.worldeditor.util.Side;
import com.cout970.worldeditor.world.Block;
import com.cout970.worldeditor.world.Chunk;
import com.cout970.worldeditor.world.ChunkStorage;

public class RenderManager {
	
	public static float scale = 0.1f;
	public static boolean isFirst = true;
	public static boolean isGuiEnable = false;
	private static int nextList = 1;
	
	public static void renderWorld() {
		
		if(isFirst){
			isFirst = false;
			for(Chunk c : ChunkStorage.storage){
				c.setCallList(-1);
				for (int k = 0; k < 32; k++) {
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							for(Side s : Side.values()){
							c.Blocks[k][i][j].setRenderizable(s,shouldRender(s,c.Blocks[k][i][j]));
							}
						}
					}
				}
			}
		}
		for(Chunk c : ChunkStorage.storage){
			renderChunk(c);
		}
//		drawOverlay();
//		GLManager.camara.renderCamara();
	}

//	private static void drawOverlay() {
//		glPushMatrix();
//		glColor4f(1, 1, 1, 1);
//		glLineWidth(5);
//		RenderUtil.bindTexture(TextureManager.overlay);
//		RenderUtil.line(new Vector3(0,0,0),new Vector3(100,0,0));
//		RenderUtil.line(new Vector3(0,0,0),new Vector3(0,100,0));
//		RenderUtil.line(new Vector3(0,0,0),new Vector3(0,0,100));
//		glPopMatrix();
//	}

	public static boolean shouldRender(Side s, Block block) {
		if(WorldEditor.getSelectedBlock() == block)return true;
		if(block.material.getMaterialName().equalsIgnoreCase("AIR"))return false;
		int x = (int)block.getX()+s.OffsetX;
		int y = (int)block.getY()+s.OffsetY;
		int z = (int)block.getZ()+s.OffsetZ;

		Block b = WorldEditor.getBlock(x, y, z);
		if(b == null)return true;
		if(b.material.getMaterialName().equalsIgnoreCase("AIR"))return true;
		return false;
	}

	public static void renderChunk(Chunk c) {
		glPushMatrix();
		glColor4f(1, 1, 1, 1);
		if(c.getCallList() == -1){
			generateCallList(c);
		}else{
			GL11.glCallList(c.getCallList());
		}
		glPopMatrix();
	}

	public static void generateCallList(Chunk c) {
		glNewList(nextList, GL11.GL_COMPILE_AND_EXECUTE);
		for (int k = 0; k < c.Blocks.length; k++) {
			for (int i = 0; i < c.Blocks[0].length; i++) {
				for (int j = 0; j < c.Blocks[0][0].length; j++) {
					renderBlock(c.Blocks[k][i][j]);
				}
			}
		}
		c.setCallList(nextList);
		glEndList();
		nextList++;
	}

	public static void renderBlock(Block b){
		glPushMatrix();
		glTranslatef((float)b.getX(), (float)b.getY(),(float)b.getZ());
		if(WorldEditor.getSelectedBlock() == b)
			RenderUtil.bindTexture(TextureManager.select);
		else
			RenderUtil.bindTexture(TextureManager.getTexture(b.material));
		glColor3f(b.material.colorMaterial[0], b.material.colorMaterial[1], b.material.colorMaterial[2]);
		RenderUtil.block(b);
		glEnd();
		glPopMatrix();
	}

	public static void reloadChunks() {
		isFirst = true;
		
	}

}
