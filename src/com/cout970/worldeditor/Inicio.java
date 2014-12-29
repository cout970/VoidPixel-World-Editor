package com.cout970.worldeditor;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;


public class Inicio {
	//http://pastebin.com/bWwP3NXV
	private static boolean working = true;

	public static void main(String[] args){
		JsonLoader.loadChunks();
		initUtil();
		TextureManager.loadTextures();
		WorkLoop();
	}

	private static void WorkLoop() {
		while(working){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			RenderManager.renderBlocks();
			KeyLisener.ListenKeyboard();
			Display.update();
			Display.sync(60);
			working = !Display.isCloseRequested();
		}
		Display.destroy();
		System.exit(0);
	}

	private static void initUtil() {
		GLManager.instance = new GLManager();
		GLManager.instance.InitDisplay();
	}
}
