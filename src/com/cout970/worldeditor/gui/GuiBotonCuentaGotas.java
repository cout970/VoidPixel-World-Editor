package com.cout970.worldeditor.gui;

import org.lwjgl.opengl.GL11;

import com.cout970.worldeditor.RenderUtil;
import com.cout970.worldeditor.TextureManager;
import com.cout970.worldeditor.WorldEditor;
import com.cout970.worldeditor.WorldEditor.State;
import com.cout970.worldeditor.world.Material;

public class GuiBotonCuentaGotas extends GuiBoton{

	public GuiBotonCuentaGotas(int i, int j, int w, int h, String s) {
		super(i, j, w, h, s);
	}

	@Override
	public void render() {
		GL11.glColor4f(1,1,1,0.5f);
		RenderUtil.bindTexture(TextureManager.text);
		RenderUtil.dynamicQuad(this.getVecPos(),this.getVecExt());
		RenderUtil.renderString(this.name,(int)this.getVecPos().x+(-RenderUtil.getStringLenght(this.name)+this.width)/2,(int)this.getVecPos().y+this.height);
	}

	@Override
	public void onClick(int i) {
		if(i == 0){
			if(WorldEditor.estado == State.SELECT){
				WorldEditor.setSelectedMaterial(new Material(WorldEditor.getSelectedBlock().material));
			}
		}
	}

}
