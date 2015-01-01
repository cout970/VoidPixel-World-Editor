package com.cout970.worldeditor;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;


public class Inicio {
	//https://www.dropbox.com/sh/ecluszwj7dsn075/AADNYk7Z-SXFhAuslKP4x1tTa?dl=0
	//http://pastebin.com/bWwP3NXV
	private static boolean working = true;
	public static long renderTime;
	public static int fpsCounter;
	private static long oldTime;

	public static void main(String[] args){
		JsonLoader.loadChunks();
		initUtil();
		TextureManager.loadTextures();
		WorkLoop();
	}

	private static void WorkLoop() {
		while(working){
			renderTime = System.nanoTime();
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GLManager.instance.preRender();
			RenderManager.renderWorld();
			GLManager.instance.posRender();
			KeyLisener.ListenKeyboard();
			Display.update();
			Display.sync(60);
			working = !Display.isCloseRequested();
//			System.out.println((System.nanoTime()-renderTime)/1E6);
			renderTime = System.nanoTime();
			if(System.currentTimeMillis()-oldTime >= 1000){
				oldTime = System.currentTimeMillis();
//				System.out.println(fpsCounter+" FPS");
				fpsCounter = 1;
			}else fpsCounter++;
		}
		Display.destroy();
		System.exit(0);
	}

	private static void initUtil() {
		GLManager.instance = new GLManager();
		GLManager.setupDisplay();
		GLManager.instance.InitDisplay();
	}
}
