package com.cout970.worldeditor;

import static org.lwjgl.input.Keyboard.*;
import static org.lwjgl.opengl.GL11.*;

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
