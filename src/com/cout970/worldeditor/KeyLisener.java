package com.cout970.worldeditor;

import static org.lwjgl.input.Keyboard.KEY_A;
import static org.lwjgl.input.Keyboard.KEY_ADD;
import static org.lwjgl.input.Keyboard.KEY_C;
import static org.lwjgl.input.Keyboard.KEY_D;
import static org.lwjgl.input.Keyboard.KEY_DOWN;
import static org.lwjgl.input.Keyboard.KEY_E;
import static org.lwjgl.input.Keyboard.KEY_G;
import static org.lwjgl.input.Keyboard.KEY_I;
import static org.lwjgl.input.Keyboard.KEY_K;
import static org.lwjgl.input.Keyboard.KEY_LEFT;
import static org.lwjgl.input.Keyboard.KEY_O;
import static org.lwjgl.input.Keyboard.KEY_Q;
import static org.lwjgl.input.Keyboard.KEY_RIGHT;
import static org.lwjgl.input.Keyboard.KEY_S;
import static org.lwjgl.input.Keyboard.KEY_SUBTRACT;
import static org.lwjgl.input.Keyboard.KEY_T;
import static org.lwjgl.input.Keyboard.KEY_UP;
import static org.lwjgl.input.Keyboard.KEY_V;
import static org.lwjgl.input.Keyboard.KEY_W;
import static org.lwjgl.input.Keyboard.KEY_X;
import static org.lwjgl.input.Keyboard.KEY_Z;
import static org.lwjgl.input.Keyboard.create;
import static org.lwjgl.input.Keyboard.isCreated;
import static org.lwjgl.input.Keyboard.isKeyDown;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;

import com.cout970.worldeditor.WorldEditor.State;
import com.cout970.worldeditor.gui.ToolBox;
import com.cout970.worldeditor.world.Block;
import com.cout970.worldeditor.world.Material;

public class KeyLisener {

	public static int MouseX;
	public static int MouseY;
	public static boolean isLeftClick = false;
	public static boolean isRightClick = false;
	private static float speed = 0.25f;
	public static int cooldown;
	

	public static void ListenKeyboard() {
		if(cooldown > 0)cooldown--;
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
					WorldEditor.setMaterialForSelectedblock(WorldEditor.getSelectedMaterial());	
				}
				if(isKeyDown(KEY_K)){
					WorldEditor.getSelectedBlock().material = new Material("AIR", 1, 1, 1);	
				}
				if(isKeyDown(KEY_O)){
					WorldEditor.setSelectedMaterial(new Material(WorldEditor.getSelectedBlock().material));	
				}
				if(isKeyDown(KEY_ADD) && cooldown == 0){
					cooldown = 10;
					Block b = WorldEditor.getBlock((int)WorldEditor.getSelectedBlock().getX(),
							((int)WorldEditor.getSelectedBlock().getY()+1),
							(int)WorldEditor.getSelectedBlock().getZ());
					if(b != null){
						WorldEditor.selectBlock(b);
					}
				}
				if(isKeyDown(KEY_SUBTRACT) && cooldown == 0){
					cooldown = 10;
					Block b = WorldEditor.getBlock((int)WorldEditor.getSelectedBlock().getX(),
							((int)WorldEditor.getSelectedBlock().getY()-1),
							(int)WorldEditor.getSelectedBlock().getZ());
					if(b != null){
						WorldEditor.selectBlock(b);
					}
				}
				if(isKeyDown(KEY_LEFT) && cooldown == 0){
					cooldown = 10;
					Block b = WorldEditor.getBlock((int)WorldEditor.getSelectedBlock().getX(),
							((int)WorldEditor.getSelectedBlock().getY()),
							(int)WorldEditor.getSelectedBlock().getZ()-1);
					if(b != null){
						WorldEditor.selectBlock(b);
					}
				}
				if(isKeyDown(KEY_RIGHT) && cooldown == 0){
					cooldown = 10;
					Block b = WorldEditor.getBlock((int)WorldEditor.getSelectedBlock().getX(),
							((int)WorldEditor.getSelectedBlock().getY()),
							(int)WorldEditor.getSelectedBlock().getZ()+1);
					if(b != null){
						WorldEditor.selectBlock(b);
					}
				}
				if(isKeyDown(KEY_UP) && cooldown == 0){
					cooldown = 10;
					Block b = WorldEditor.getBlock(((int)WorldEditor.getSelectedBlock().getX()+1),
							((int)WorldEditor.getSelectedBlock().getY()),
							(int)WorldEditor.getSelectedBlock().getZ());
					if(b != null){
						WorldEditor.selectBlock(b);
					}
				}
				if(isKeyDown(KEY_DOWN) && cooldown == 0){
					cooldown = 10;
					Block b = WorldEditor.getBlock(((int)WorldEditor.getSelectedBlock().getX()-1),
							((int)WorldEditor.getSelectedBlock().getY()),
							(int)WorldEditor.getSelectedBlock().getZ());
					if(b != null){
						WorldEditor.selectBlock(b);
					}
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
					if(!ToolBox.onClick(0)){
						WorldEditor.handleClick(0);
					}
				}
			}else{
				isLeftClick = false;
			}
			if(Mouse.isButtonDown(1)){
				if(!isRightClick){
					isRightClick = true;
					if(!ToolBox.onClick(1)){
					}
				}
				GLManager.camara.addAngleX(Mouse.getDY()*0.1f);
				GLManager.camara.addAngleY(Mouse.getDX()*0.1f);
			}else{
				isRightClick = false;
			}
			if(Mouse.isButtonDown(2)){
				GLManager.camara.move(-Mouse.getDX()*0.03125f, 0, 0);
				GLManager.camara.move(0, -Mouse.getDY()*0.03125f, 0);
			}
			
			GLManager.camara.move(0, 0, Mouse.getDWheel()*0.0625f);
		}
		
	}

}
