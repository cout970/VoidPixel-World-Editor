package com.cout970.worldeditor.world;

import com.google.gson.annotations.Expose;

public class Material {

	@Expose
	private String material;
	@Expose
	public float[] colorMaterial;
	
	public Material(String string, float d, float e, float f) {
		material = string;
		colorMaterial = new float[3];
		colorMaterial[0] = d;
		colorMaterial[1] = e;
		colorMaterial[2] = f;
	}
	
	public Material(Material s) {
		material = s.material;
		colorMaterial = new float[3];
		colorMaterial[0] = s.colorMaterial[0];
		colorMaterial[1] = s.colorMaterial[1];
		colorMaterial[2] = s.colorMaterial[2];
	}
	
	public String getMaterialName(){
		return material;
	}

	public String toString(){
		return "["+material+" red:"+colorMaterial[0]+" green:"+colorMaterial[1]+" blue:"+colorMaterial[2]+"]";
	}
}
