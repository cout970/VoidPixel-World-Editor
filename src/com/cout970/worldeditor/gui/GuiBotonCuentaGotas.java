package com.cout970.worldeditor.gui;

import org.lwjgl.opengl.GL11;

import com.cout970.worldeditor.RenderUtil;
import com.cout970.worldeditor.TextureManager;
import com.cout970.worldeditor.WorldEditor;
import com.cout970.worldeditor.WorldEditor.State;
import com.cout970.worldeditor.util.Vector3;
import com.cout970.worldeditor.world.Material;

public class GuiBotonCuentaGotas extends GuiBoton{
	
	public boolean active;

	public GuiBotonCuentaGotas(int i, int j, int w, int h, String s) {
		super(i, j, w, h, s);
	}

	@Override
	public void render() {
		GL11.glColor4f(1,1,1,0.5f);
		RenderUtil.bindTexture(TextureManager.text);
		RenderUtil.dynamicQuad(this.getVecPos(),this.getVecExt());
		if(active){
			Vector3 v = getVecPos().add(new Vector3(100,5,0));
			RenderUtil.dynamicQuad(v,getVecExt().add(new Vector3(-5,-5,0)));
		}
		RenderUtil.renderString(this.name,(int)this.getVecPos().x+(-RenderUtil.getStringLenght(this.name)+this.width)/2-10,(int)this.getVecPos().y+this.height);
	}

	@Override
	public void onClick(int i) {
		if(i == 0){
			ToolBox.action = Action.Select;
			active = true;
			if(WorldEditor.estado == State.SELECT){
				WorldEditor.setSelectedMaterial(new Material(WorldEditor.getSelectedBlock().material));
			}
		}
	}

}
