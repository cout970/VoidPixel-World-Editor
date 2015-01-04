package com.cout970.worldeditor.gui;

import org.lwjgl.opengl.GL11;

import com.cout970.worldeditor.RenderUtil;
import com.cout970.worldeditor.TextureManager;
import com.cout970.worldeditor.WorldEditor;
import com.cout970.worldeditor.world.Material;

public class GuiBotonColorEditor extends GuiBoton{

	public GuiBotonColorEditor(int i, int j, int w, int h, String s,GuiPanel p) {
		super(i, j, w, h, s);
		p.buttons.add(new GuiBotonLittle((int)getVecPos().x+40, (int)getVecPos().y+61, 25, 25, "+","r"));
		p.buttons.add(new GuiBotonLittle((int)getVecPos().x+40, (int)getVecPos().y+35, 25, 25, "+","g"));
		p.buttons.add(new GuiBotonLittle((int)getVecPos().x+40, (int)getVecPos().y+9, 25, 25, "+","b"));
		p.buttons.add(new GuiBotonLittle((int)getVecPos().x+80, (int)getVecPos().y+61, 25, 25, "-","r"));
		p.buttons.add(new GuiBotonLittle((int)getVecPos().x+80, (int)getVecPos().y+35, 25, 25, "-","g"));
		p.buttons.add(new GuiBotonLittle((int)getVecPos().x+80, (int)getVecPos().y+9, 25, 25, "-","b"));
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
	}

	@Override
	public void onClick(int i) {}

}
