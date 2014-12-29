package com.cout970.worldeditor;

import static org.lwjgl.input.Keyboard.*;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;

public class KeyLisener {

	private static float speed = 0.025f;

	public static void ListenKeyboard() {
		if(!isCreated()){
			try {
				create();
			} catch (LWJGLException e) {
				e.printStackTrace();
			}
		}
		else{
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
				glRotatef(speed*10, 1, 0, 0);
			}
			if(isKeyDown(KEY_X)){
				glRotatef(-speed*10, 1, 0, 0);
			}
			
			if(isKeyDown(KEY_C)){
				glRotatef(speed*10, 0, 1, 0);
			}
			if(isKeyDown(KEY_V)){
				glRotatef(-speed*10, 0, 1, 0);
			}
		}
	}

}
