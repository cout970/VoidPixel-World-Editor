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
	public static float angleX = 0;
	public static float angleY = 0;

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
			
			GL11.glEnable(GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			
			GL11.glTranslatef(0, 0, -5);
			addAngleX(-30);
			addAngleY(-45);
			
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

	}
	
	public static void addAngleX(float angle){
		angleX += angle;
		glRotatef(angle, 1, 0, 0);
	}
	
	public static void addAngleY(float angle){
		angleY += angle;
		glRotatef(angle, 0, 1, 0);
	}
}
