package com.cout970.worldeditor;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.opengl.Texture;

public class RenderUtil {

	public static void block() {
		
		//+y
//		glTexCoord2f(0, 0);
//		glVertex3f(0,0,0);
//		glTexCoord2f(1, 0);
//		glVertex3f(0,0,1);
//		glTexCoord2f(1, 1);
//		glVertex3f(1,0,1);
//		glTexCoord2f(0, 1);
//		glVertex3f(1,0,0);
		
		//-y
//		glTexCoord2f(0, 0);
//		glVertex3f(0,1,0);
//		glTexCoord2f(1, 0);
//		glVertex3f(0,1,1);
//		glTexCoord2f(1, 1);
//		glVertex3f(1,1,1);
//		glTexCoord2f(0, 1);
//		glVertex3f(1,1,0);
		
//		//+z
//		glTexCoord2f(0, 0);
//		glVertex3f(0,0,0);
//		glTexCoord2f(1, 0);
//		glVertex3f(0,1,0);
//		glTexCoord2f(1, 1);
//		glVertex3f(1,1,0);
//		glTexCoord2f(0, 1);
//		glVertex3f(1,0,0);
		
//		//-z
		glTexCoord2f(0, 0);
		glVertex3f(0,0,1);
		glTexCoord2f(1, 0);
		glVertex3f(1,0,1);
		glTexCoord2f(1, 1);
		glVertex3f(1,1,1);
		glTexCoord2f(0, 1);
		glVertex3f(0,1,1);
		
		//+x
		glTexCoord2f(0, 0);
		glVertex3f(0,0,0);
		glTexCoord2f(1, 0);
		glVertex3f(0,0,1);
		glTexCoord2f(1, 1);
		glVertex3f(0,1,1);
		glTexCoord2f(0, 1);
		glVertex3f(0,1,0);
		
//		//-x
//		glTexCoord2f(0, 0);
//		glVertex3f(1,0,0);
//		glTexCoord2f(1, 0);
//		glVertex3f(1,0,1);
//		glTexCoord2f(1, 1);
//		glVertex3f(1,1,1);
//		glTexCoord2f(0, 1);
//		glVertex3f(1,1,0);
	}

	public static void bindTexture(Texture texture) {
		texture.bind();		
	}
}
