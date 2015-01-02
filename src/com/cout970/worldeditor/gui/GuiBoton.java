package com.cout970.worldeditor.gui;

import com.cout970.worldeditor.util.Vector3;

public abstract class GuiBoton {

	public String name;
	public int x,y;
	public int width,height;
	
	public GuiBoton(int i, int j, int w, int h,String s){
		name = s;
		x = i;
		y = j;
		width = w;
		height = h;
	}

	public Vector3 getVecPos() {
		return new Vector3(x,y,0);
	}

	public Vector3 getVecExt() {
		return getVecPos().add(new Vector3(width,height,0));
	}
	
	public boolean isIn(int mouseX, int mouseY){
		if(mouseX > getVecPos().x && mouseX < getVecExt().x){
			if(mouseY > getVecPos().y && mouseY < getVecExt().y){
				return true;
			}
		}
		return false;
	}
	
	public abstract void render();
	public abstract void onClick(int i);
}
