package com.cout970.worldeditor.world;

import com.google.gson.annotations.Expose;

public class Material {

	@Expose
	public String material;
	@Expose
	public float[] colorMaterial;
	
	public Material(String string, float d, float e, float f) {
		material = string;
		colorMaterial = new float[3];
		colorMaterial[0] = d;
		colorMaterial[1] = e;
		colorMaterial[2] = f;
	}
	
	public String toString(){
		return "["+material+" red:"+colorMaterial[0]+" green:"+colorMaterial[1]+" blue:"+colorMaterial[2]+"]";
	}
}
