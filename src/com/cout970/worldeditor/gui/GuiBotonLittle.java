package com.cout970.worldeditor.gui;

import org.lwjgl.opengl.GL11;

import com.cout970.worldeditor.RenderUtil;
import com.cout970.worldeditor.TextureManager;
import com.cout970.worldeditor.WorldEditor;
import com.cout970.worldeditor.world.Material;

public class GuiBotonLittle extends GuiBoton{

	public String use;

	public GuiBotonLittle(int i, int j, int w, int h, String s,String use) {
		super(i, j, w, h, s);
		this.use = use;
	}

	@Override
	public void render() {
		GL11.glColor4f(1,1,1,0.5f);
		RenderUtil.bindTexture(TextureManager.text);
		RenderUtil.dynamicQuad(this.getVecPos(),this.getVecExt());
		RenderUtil.renderString(this.name,(int)this.getVecPos().x+(-RenderUtil.getStringLenght(this.name)+this.width)/2+1,(int)this.getVecPos().y+this.height+1);
	}

	@Override
	public void onClick(int i) {
		if(i == 0){
			Material m = new Material(WorldEditor.getSelectedMaterial());
			if(name == "+"){
				float s = 5/256f;
				if(use == "r"){
					if(m.colorMaterial[0] < 1){
						m.colorMaterial[0]+=s;
						if(m.colorMaterial[0] >= 1)
							m.colorMaterial[0] = 1;
					}
				}else if(use == "g"){
					if(m.colorMaterial[1] < 1) {
						m.colorMaterial[1]+=s;
						if(m.colorMaterial[1] >= 1)
							m.colorMaterial[1] = 1;
					}
				}else if(use == "b"){
					if(m.colorMaterial[2] < 1){
						m.colorMaterial[2]+=s;
						if(m.colorMaterial[2] >= 1)
							m.colorMaterial[2] = 1;
					}
				}
			}else if(name == "-"){
				float s = 5/256f;
				if(use == "r"){
					if(m.colorMaterial[0] > 0){
						m.colorMaterial[0]-=s;
						if(m.colorMaterial[0] <= 0)
							m.colorMaterial[0] = 0;
					}
				}else if(use == "g"){
					if(m.colorMaterial[1] > 0){
						m.colorMaterial[1]-=s;
						if(m.colorMaterial[1] <= 0)
							m.colorMaterial[1] = 0;
					}
				}else if(use == "b"){
					if(m.colorMaterial[2] > 0){
						m.colorMaterial[2]-=s;
						if(m.colorMaterial[2] <= 0)
							m.colorMaterial[2] = 0;
					}
				}
			}
			WorldEditor.setSelectedMaterial(m);
		}
	}
}
