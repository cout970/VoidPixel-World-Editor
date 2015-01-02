package com.cout970.worldeditor;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glEndList;
import static org.lwjgl.opengl.GL11.glLineWidth;
import static org.lwjgl.opengl.GL11.glNewList;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import com.cout970.worldeditor.gui.Action;
import com.cout970.worldeditor.gui.ToolBox;
import com.cout970.worldeditor.util.Side;
import com.cout970.worldeditor.util.Vector3;
import com.cout970.worldeditor.world.Block;
import com.cout970.worldeditor.world.Chunk;
import com.cout970.worldeditor.world.ChunkStorage;

public class RenderManager {
	
	public static float scale = 0.1f;
	public static boolean isFirst = true;
	public static boolean isGuiEnable = true;
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
		drawGrid();
//		GLManager.camara.renderCamara();
	}

	private static void drawGrid() {
		glPushMatrix();
		glColor4f(1, 1, 1, 1);
		glLineWidth(5);
		Color.blue.bind();
		RenderUtil.line(new Vector3(0,0,0),new Vector3(100,0,0));
		Color.green.bind();
		RenderUtil.line(new Vector3(0,0,0),new Vector3(0,100,0));
		Color.red.bind();
		RenderUtil.line(new Vector3(0,0,0),new Vector3(0,0,100));
		glPopMatrix();
	}

	public static boolean shouldRender(Side s, Block block) {
		if(WorldEditor.getSelectedBlock() == block && ToolBox.action == Action.Select)return true;
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
		nextList = GL11.glGenLists(1);
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
		if(WorldEditor.getSelectedBlock() == b && ToolBox.action == Action.Select)
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

	public static void renderGUI() {
		
		glPushMatrix();
		glEnable(GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		RenderUtil.bindTexture(TextureManager.text);
		RenderUtil.renderString(Inicio.fps+" FPS", 10, GLManager.frameHeight-10);
		glColor4f(1, 1, 1, 0.5f);
		RenderUtil.bindTexture(TextureManager.background);
		RenderUtil.toolBoxBackground();
		glColor4f(1, 1, 1, 0.25f);
		ToolBox.renderThings();
		glDisable(GL_BLEND);
		glPopMatrix();
	}

}
