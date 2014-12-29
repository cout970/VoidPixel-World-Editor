package com.cout970.worldeditor;

import static org.lwjgl.opengl.GL11.glRotatef;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class GLManager {

	public static GLManager instance;
	private final int frameHeight = 500;
	private final int frameWidth = 500;

	public void InitDisplay(){

		//create display
		try {
			Display.setDisplayMode(new DisplayMode(this.frameWidth, this.frameHeight));
			Display.setTitle("VoidPixel World Editor");

			//initialitation OpenGL
			Display.create();
			
			GL11.glEnable(GL11.GL_TEXTURE_2D);          
			GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

			GL11.glViewport(0,0,this.frameWidth,this.frameHeight);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);

			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GLU.gluPerspective(-30f, frameWidth/frameWidth, 0.0001f, 100);
			
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			
			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glDepthMask(true);
			GL11.glEnable(GL11.GL_DEPTH_FUNC);
			GL11.glTranslatef(0, 0, -5);
			glRotatef(-30, 1, 0, 0);
			glRotatef(-45, 0, 1, 0);
			
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
}
