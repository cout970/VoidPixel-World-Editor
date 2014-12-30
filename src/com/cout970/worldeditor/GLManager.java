package com.cout970.worldeditor;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class GLManager {

	public static GLManager instance;
	public final int frameHeight = 500;
	public final int frameWidth = 500;
	public static final Camara camara = new Camara();

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
			GL11.glLoadIdentity();
			camara.move(0.25f, 1.5f, -7f);
			camara.addAngleX(-30);
			camara.addAngleY(-45);
			
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

	}

	public void preRender() {
		GL11.glPushMatrix();
		glTranslatef(camara.cameraX, camara.cameraY, camara.cameraZ);
		glRotatef(camara.angleX, 1, 0, 0);
		glRotatef(camara.angleY, 0, 1, 0);
		glRotatef(camara.angleZ, 0, 0, 1);
	}

	public void posRender() {
		GL11.glPopMatrix();
	}
	
}
