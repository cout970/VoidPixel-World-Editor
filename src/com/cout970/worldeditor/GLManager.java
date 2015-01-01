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
//	public static final JFrame mainFrame = new JFrame();
//	public static final Canvas glCanvas = new Canvas();
	public static final Camara camara = new Camara();

	public void InitDisplay(){

		//create display
		try {
			Display.setDisplayMode(new DisplayMode(frameWidth, frameHeight));
			Display.setTitle("VoidPixel World Editor");

			//initialitation OpenGL
//			glCanvas.setSize(frameWidth, frameWidth);
//			glCanvas.setVisible(true);
//			Display.setParent(glCanvas);
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
//		mainFrame.setBounds(500, 50, frameWidth, frameHeight);
//		mainFrame.setVisible(true);
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
