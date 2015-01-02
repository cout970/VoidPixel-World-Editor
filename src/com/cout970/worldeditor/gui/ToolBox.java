package com.cout970.worldeditor.gui;


import com.cout970.worldeditor.GLManager;
import com.cout970.worldeditor.KeyLisener;

public class ToolBox {

	public static Action action = Action.Select;
	
	public static GuiPanel panel;
	public static float startX = 0;
	public static float startY = GLManager.frameHeight/5;
	public static float finishX = GLManager.frameWidth/7;
	public static float finishY = 4*GLManager.frameHeight/5;
	
	public static void renderThings() {
		for(GuiBoton b : panel.buttons){
			b.render();
		}
	}
	
	public static void loadGui(GuiPanel p){
		if(p == null)
		panel = new GuiPanel();
		else panel = p;
	}

	public static boolean onClick(int i) {
		if(i == 0){
			for(GuiBoton b : panel.buttons){
				if(b.isIn(KeyLisener.MouseX, KeyLisener.MouseY)){
					b.onClick(i);
					return true;
				}
			}
		}
		return false;
	}

}
