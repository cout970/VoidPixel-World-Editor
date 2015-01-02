package com.cout970.worldeditor.gui;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import com.cout970.worldeditor.RenderUtil;
import com.cout970.worldeditor.TextureManager;
import com.cout970.worldeditor.WorldEditor;
import com.cout970.worldeditor.util.Vector3;

public class GuiBotonMaterial extends GuiBoton{

	public GuiBotonMaterial(int i, int j, int w, int h, String s) {
		super(i, j, w, h, s);
	}
	
	public void render() {
		GL11.glColor4f(1,1,1,0.5f);
		RenderUtil.bindTexture(TextureManager.text);
		RenderUtil.dynamicQuad(this.getVecPos(),this.getVecExt());
		RenderUtil.renderString(this.name,(int)this.getVecPos().x+(-RenderUtil.getStringLenght(this.name)+this.width)/2,(int)this.getVecPos().y+this.height);
		RenderUtil.bindTexture(TextureManager.block);
		float[] c = WorldEditor.getSelectedMaterial().colorMaterial;
		GL11.glColor4f(c[0], c[1], c[2],1);
		RenderUtil.dynamicQuad(this.getVecPos().add(new Vector3(10,10,0)),this.getVecExt().add(new Vector3(-70,-30,0)));
		GL11.glColor4f(1,1,1,1);
		Color.red.bind();
		RenderUtil.renderString("R:"+((int)(c[0]*255)), (int)getVecPos().x+60, (int)getVecPos().y+85);
		Color.green.bind();
		RenderUtil.renderString("G:"+((int)(c[1]*255)), (int)getVecPos().x+60, (int)getVecPos().y+60);
		Color.blue.bind();
		RenderUtil.renderString("B:"+((int)(c[2]*255)), (int)getVecPos().x+60, (int)getVecPos().y+35);
	}
	
	public void onClick(int i) {}

}
