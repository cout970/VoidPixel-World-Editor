package com.cout970.worldeditor;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.opengl.Texture;

import com.cout970.worldeditor.util.Side;
import com.cout970.worldeditor.util.Vector3;
import com.cout970.worldeditor.world.Block;

public class RenderUtil {

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
}
