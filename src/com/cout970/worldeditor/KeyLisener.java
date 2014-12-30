package com.cout970.worldeditor;

import static org.lwjgl.input.Keyboard.KEY_A;
import static org.lwjgl.input.Keyboard.KEY_C;
import static org.lwjgl.input.Keyboard.KEY_D;
import static org.lwjgl.input.Keyboard.KEY_E;
import static org.lwjgl.input.Keyboard.KEY_G;
import static org.lwjgl.input.Keyboard.KEY_Q;
import static org.lwjgl.input.Keyboard.KEY_S;
import static org.lwjgl.input.Keyboard.KEY_V;
import static org.lwjgl.input.Keyboard.KEY_W;
import static org.lwjgl.input.Keyboard.KEY_X;
import static org.lwjgl.input.Keyboard.KEY_Z;
import static org.lwjgl.input.Keyboard.create;
import static org.lwjgl.input.Keyboard.isCreated;
import static org.lwjgl.input.Keyboard.isKeyDown;
import static org.lwjgl.opengl.GL11.glTranslatef;

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
				glTranslatef(speed,0,0);
			}
			if(isKeyDown(KEY_D)){
				glTranslatef(-speed,0,0);
			}
			if(isKeyDown(KEY_W)){
				glTranslatef(0,0,speed);
			}
			if(isKeyDown(KEY_S)){
				glTranslatef(0,0,-speed);
			}
			if(isKeyDown(KEY_Q)){
				glTranslatef(0,speed,0);
			}
			if(isKeyDown(KEY_E)){
				glTranslatef(0,-speed,0);
			}
			if(isKeyDown(KEY_Z)){
				GLManager.addAngleX(speed*10);
			}
			if(isKeyDown(KEY_X)){
				GLManager.addAngleX(-speed*10);
			}
			
			if(isKeyDown(KEY_C)){
				GLManager.addAngleY(speed*10);
			}
			if(isKeyDown(KEY_V)){
				GLManager.addAngleY(-speed*10);
			}
			
			if(isKeyDown(KEY_G)){
				JsonLoader.saveChunks();
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
