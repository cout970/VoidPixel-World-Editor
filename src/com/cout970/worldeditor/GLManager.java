package com.cout970.worldeditor;

import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class GLManager {

	public static GLManager instance;
	public static final int frameHeight = 800;
	public static final int frameWidth = 1000;
	public static final Camara camara = new Camara();

	public void InitDisplay(){

		//create display
		try {
			Display.setDisplayMode(new DisplayMode(frameWidth, frameHeight));
			Display.setTitle("VoidPixel World Editor");

			//initialitation OpenGL
			Display.create();
			
			GL11.glEnable(GL11.GL_TEXTURE_2D);          
			GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

			GL11.glViewport(0,0,frameWidth,frameHeight);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);

			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GLU.gluPerspective(-30f, frameWidth/frameHeight, 0.1f, 1000);
			
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			
			GL11.glEnable(GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			GL11.glLoadIdentity();
			camara.move(5.25f, 8f, -60f);
			camara.addAngleX(180-30);
			camara.addAngleY(180+45);
			
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	public static void setupDisplay(){
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
	
	public static void make2D() {
//		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		GL11.glOrtho(0, frameWidth, 0, frameHeight, -1, 1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		}

	public static void make3D() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPopMatrix();
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_DEPTH_TEST);
//		GL11.glEnable(GL11.GL_LIGHTING);
		}

}
