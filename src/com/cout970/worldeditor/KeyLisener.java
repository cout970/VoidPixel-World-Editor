package com.cout970.worldeditor;

import static org.lwjgl.input.Keyboard.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;

public class KeyLisener {

	public static int MouseX;
	public static int MouseY;
	public static boolean isLeftClick = false;
	public static boolean isRightClick = false;
	private static float speed = 0.025f;
	

	public static void ListenKeyboard() {
		if(!isCreated()){
			try {
				create();
			} catch (LWJGLException e) {
				e.printStackTrace();
			}
		}else{
			if(isKeyDown(KEY_A)){
				GLManager.camara.move(speed,0,0);
			}
			if(isKeyDown(KEY_D)){
				GLManager.camara.move(-speed,0,0);
			}
			if(isKeyDown(KEY_W)){
				GLManager.camara.move(0,speed,0);
			}
			if(isKeyDown(KEY_S)){
				GLManager.camara.move(0,-speed,0);
			}
			if(isKeyDown(KEY_Q)){
				GLManager.camara.move(0,0,speed);
			}
			if(isKeyDown(KEY_E)){
				GLManager.camara.move(0,0,-speed);
			}
			if(isKeyDown(KEY_Z)){
				GLManager.camara.addAngleX(speed*10);
			}
			if(isKeyDown(KEY_X)){
				GLManager.camara.addAngleX(-speed*10);
			}
			
			if(isKeyDown(KEY_C)){
				GLManager.camara.addAngleY(speed*10);
			}
			if(isKeyDown(KEY_V)){
				GLManager.camara.addAngleY(-speed*10);
			}
			
			if(isKeyDown(KEY_G)){
				JsonLoader.saveChunks();
			}
			if(isKeyDown(KEY_T)){
				JsonLoader.loadChunks();
			}
		}
		if(!Mouse.isCreated()){
			try {
				Mouse.create();
			} catch (LWJGLException e) {
				e.printStackTrace();
			}
		}else{
			MouseX = Mouse.getX();
			MouseY = Mouse.getY();

			if(Mouse.isButtonDown(0)){
				if(!isLeftClick){
					isLeftClick = true;
//					Block b = RayTracer.rayTrace();
//					if(b != null){
//						b.material.material = "HARD_STONE";
//					}
				}
			}else{
				isLeftClick = false;
			}
			if(Mouse.isButtonDown(1)){
				if(!isRightClick){
					isRightClick = true;
				}
			}else{
				isRightClick = false;
			}
		}
		
	}

}
