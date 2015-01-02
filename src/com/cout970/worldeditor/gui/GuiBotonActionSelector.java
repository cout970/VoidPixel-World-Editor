package com.cout970.worldeditor.gui;

import org.lwjgl.opengl.GL11;

import com.cout970.worldeditor.RenderUtil;
import com.cout970.worldeditor.TextureManager;

public class GuiBotonActionSelector extends GuiBoton{

	
	public GuiBotonActionSelector(int i, int j, int w, int h,String s){
		super(i,j,w,h,s);
	}
	
	public void onClick(int i) {
		Action a = Action.valueOf(name);
		a = Action.values()[(a.ordinal()+1)%Action.values().length];
		name = a.name();
		ToolBox.action = a;
	}

	public void render() {
		GL11.glColor4f(1,1,1,0.5f);
		RenderUtil.bindTexture(TextureManager.text);
		RenderUtil.dynamicQuad(this.getVecPos(),this.getVecExt());
		RenderUtil.renderString(this.name,(int)this.getVecPos().x+(-RenderUtil.getStringLenght(this.name)+this.width)/2,(int)this.getVecPos().y+this.height);
	}
}
