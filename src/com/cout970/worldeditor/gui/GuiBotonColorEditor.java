package com.cout970.worldeditor.gui;

import org.lwjgl.opengl.GL11;

import com.cout970.worldeditor.RenderUtil;
import com.cout970.worldeditor.TextureManager;
import com.cout970.worldeditor.WorldEditor;
import com.cout970.worldeditor.util.Vector3;
import com.cout970.worldeditor.world.Material;

public class GuiBotonColorEditor extends GuiBoton{

	public GuiBotonColorEditor(int i, int j, int w, int h, String s) {
		super(i, j, w, h, s);
	}

	@Override
	public void render() {
		GL11.glColor4f(1,1,1,0.5f);
		RenderUtil.bindTexture(TextureManager.text);
		RenderUtil.dynamicQuad(this.getVecPos(),this.getVecExt());
		Material m = WorldEditor.getSelectedMaterial();
		RenderUtil.renderString(m.getMaterialName(), (int)getVecPos().x+30, (int)getVecPos().y+530,0.5f);
		RenderUtil.renderString("R", (int)getVecPos().x+10, (int)getVecPos().y+85);
		RenderUtil.renderString("G", (int)getVecPos().x+10, (int)getVecPos().y+60);
		RenderUtil.renderString("B", (int)getVecPos().x+10, (int)getVecPos().y+35);
		GL11.glColor4f(1,1,1,0.5f);
		RenderUtil.bindTexture(TextureManager.text);
		RenderUtil.dynamicQuad(this.getVecPos().add(new Vector3(45,60,0)),this.getVecExt().add(new Vector3(-53,-25,0)));
		RenderUtil.dynamicQuad(this.getVecPos().add(new Vector3(82,60,0)),this.getVecExt().add(new Vector3(-20,-25,0)));
		
		RenderUtil.dynamicQuad(this.getVecPos().add(new Vector3(45,36,0)),this.getVecExt().add(new Vector3(-53,-53,0)));
		RenderUtil.dynamicQuad(this.getVecPos().add(new Vector3(82,36,0)),this.getVecExt().add(new Vector3(-20,-53,0)));
		
		RenderUtil.dynamicQuad(this.getVecPos().add(new Vector3(45,10,0)),this.getVecExt().add(new Vector3(-53,-77,0)));
		RenderUtil.dynamicQuad(this.getVecPos().add(new Vector3(82,10,0)),this.getVecExt().add(new Vector3(-20,-77,0)));
		
		RenderUtil.renderString("+", (int)getVecPos().x+50, (int)getVecPos().y+85);
		RenderUtil.renderString("-", (int)getVecPos().x+90, (int)getVecPos().y+85);
		
		RenderUtil.renderString("+", (int)getVecPos().x+50, (int)getVecPos().y+60);
		RenderUtil.renderString("-", (int)getVecPos().x+90, (int)getVecPos().y+60);
		
		RenderUtil.renderString("+", (int)getVecPos().x+50, (int)getVecPos().y+35);
		RenderUtil.renderString("-", (int)getVecPos().x+90, (int)getVecPos().y+35);
	}

	@Override
	public void onClick(int i) {
		if(i == 0){
//			int x = KeyLisener.MouseX;
//			int y = KeyLisener.MouseY;
		}
	}

}
