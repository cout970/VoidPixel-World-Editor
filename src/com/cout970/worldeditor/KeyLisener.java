package com.cout970.worldeditor;

import static org.lwjgl.input.Keyboard.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;

import com.cout970.worldeditor.WorldEditor.State;
import com.cout970.worldeditor.world.Block;

public class KeyLisener {

	public static int MouseX;
	public static int MouseY;
	public static boolean isLeftClick = false;
	public static boolean isRightClick = false;
	private static float speed = 0.25f;
	

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
				GLManager.camara.addAngleX(speed);
			}
			if(isKeyDown(KEY_X)){
				GLManager.camara.addAngleX(-speed);
			}
			
			if(isKeyDown(KEY_C)){
				GLManager.camara.addAngleY(speed);
			}
			if(isKeyDown(KEY_V)){
				GLManager.camara.addAngleY(-speed);
			}
			
			if(isKeyDown(KEY_G)){
				JsonLoader.saveChunks();
			}
			if(isKeyDown(KEY_T)){
				JsonLoader.loadChunks();
			}
			if(WorldEditor.estado == State.SELECT){
				if(isKeyDown(KEY_I)){
					WorldEditor.selectBlock.material.material = "STONE";	
				}
				if(isKeyDown(KEY_O)){
					Block b = WorldEditor.getBlock((int)WorldEditor.selectBlock.getX(), (int)WorldEditor.selectBlock.getY()+1, (int)WorldEditor.selectBlock.getZ());
					if(b != null)
						WorldEditor.selectBlock = b;	
				}
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
					RayTracer.rayTracer();
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
