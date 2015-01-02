package com.cout970.worldeditor;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_POINT;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2d;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.glVertex3d;
import static org.lwjgl.opengl.GL11.glVertex3f;

import java.awt.Font;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;

import com.cout970.worldeditor.gui.ToolBox;
import com.cout970.worldeditor.util.Side;
import com.cout970.worldeditor.util.Vector3;
import com.cout970.worldeditor.world.Block;

public class RenderUtil {
	
	public static TrueTypeFont font;
	
	public static void initFonts(){
		Font awtfont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtfont, true);
	}

	public static void block(Block b) {
		//+y
		if(b.shouldRenderSide(Side.DOWN)){
			glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex3f(0,0,0);
			glTexCoord2f(1, 0);
			glVertex3f(0,0,1);
			glTexCoord2f(1, 1);
			glVertex3f(1,0,1);
			glTexCoord2f(0, 1);
			glVertex3f(1,0,0);
			glEnd();
		}

		//-y
		if(b.shouldRenderSide(Side.UP)){
			glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex3f(0,1,0);
			glTexCoord2f(1, 0);
			glVertex3f(0,1,1);
			glTexCoord2f(1, 1);
			glVertex3f(1,1,1);
			glTexCoord2f(0, 1);
			glVertex3f(1,1,0);
			glEnd();
		}
		//+z
		if(b.shouldRenderSide(Side.WEST)){
			glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex3f(0,0,0);
			glTexCoord2f(1, 0);
			glVertex3f(0,1,0);
			glTexCoord2f(1, 1);
			glVertex3f(1,1,0);
			glTexCoord2f(0, 1);
			glVertex3f(1,0,0);
			glEnd();
		}
		//-z
		if(b.shouldRenderSide(Side.EAST)){
			glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex3f(0,0,1);
			glTexCoord2f(1, 0);
			glVertex3f(1,0,1);
			glTexCoord2f(1, 1);
			glVertex3f(1,1,1);
			glTexCoord2f(0, 1);
			glVertex3f(0,1,1);
			glEnd();
		}
		//+x
		if(b.shouldRenderSide(Side.NORTH)){
			glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex3f(0,0,0);
			glTexCoord2f(1, 0);
			glVertex3f(0,0,1);
			glTexCoord2f(1, 1);
			glVertex3f(0,1,1);
			glTexCoord2f(0, 1);
			glVertex3f(0,1,0);
			glEnd();
		}
		//-x
		if(b.shouldRenderSide(Side.SOUTH)){
			glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex3f(1,0,0);
			glTexCoord2f(1, 0);
			glVertex3f(1,0,1);
			glTexCoord2f(1, 1);
			glVertex3f(1,1,1);
			glTexCoord2f(0, 1);
			glVertex3f(1,1,0);
			glEnd();
		}
	}

	public static void line(Vector3 a, Vector3 b){
		glBegin(GL_LINES);
		glVertex3d(a.x, a.y, a.z);
		glVertex3d(b.x, b.y, b.z);
		glEnd();
	}

	public static void bindTexture(Texture texture) {
		texture.bind();		
	}

	public static void point(Vector3 a) {
		glBegin(GL_POINT);
		glVertex3d(a.x, a.y, a.z);
		glEnd();	
	}

	public static void quad() {
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0,0);
		glTexCoord2f(1, 0);
		glVertex2f(0,1);
		glTexCoord2f(1, 1);
		glVertex2f(1,1);
		glTexCoord2f(0, 1);
		glVertex2f(1,0);
		glEnd();
	}

	public static void toolBoxBackground() {
		float startY = ToolBox.startY;
		float finishY = ToolBox.finishY;
		float startX = ToolBox.startX;
		float finishX = ToolBox.finishX;
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(startX,startY);
		glTexCoord2f(1, 0);
		glVertex2f(startX,finishY);
		glTexCoord2f(1, 1);
		glVertex2f(finishX,finishY);
		glTexCoord2f(0, 1);
		glVertex2f(finishX,startY);
		glEnd();
	}

	public static void dynamicQuad(Vector3 a, Vector3 b) {
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2d(a.x,a.y);
		glTexCoord2f(1, 0);
		glVertex2d(a.x,b.y);
		glTexCoord2f(1, 1);
		glVertex2d(b.x,b.y);
		glTexCoord2f(0, 1);
		glVertex2d(b.x,a.y);
		glEnd();
	}

	public static void renderString(String string, int x, int y) {
		GL11.glPushMatrix();
		GL11.glTranslatef(0, y*2, 0);
		GL11.glRotatef(180, 0, 0, 1);
		GL11.glRotatef(180, 0, 1, 0);
		font.drawString(x, y, string);
		GL11.glPopMatrix();
	}

	public static int getStringLenght(String name) {
		return name.length()*12;
	}

	public static void renderString(String string, int x, int y, float f) {
		GL11.glPushMatrix();
		GL11.glScalef(f, f, f);
		GL11.glTranslatef(0, y*2, 0);
		GL11.glRotatef(180, 0, 0, 1);
		GL11.glRotatef(180, 0, 1, 0);
		font.drawString(x, y, string);
		GL11.glPopMatrix();
	}
}
