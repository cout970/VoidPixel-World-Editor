package com.cout970.worldeditor;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.opengl.Texture;

import com.cout970.worldeditor.util.Vector3;

public class RenderUtil {

	public static void block() {
		//+y
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
		
		//-y
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
		
		//+z
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
		
		//-z
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
		
		//+x
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
		
		//-x
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
	
	public static void line(Vector3 a, Vector3 b){
		bindTexture(TextureManager.water);
		glBegin(GL_LINES);
		glVertex3d(a.x, a.y, a.z);
		glVertex3d(b.x, b.y, b.z);
		glEnd();
	}

	public static void bindTexture(Texture texture) {
		texture.bind();		
	}
}
