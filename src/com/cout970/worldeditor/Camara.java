package com.cout970.worldeditor;

import org.lwjgl.opengl.GL11;

import com.cout970.worldeditor.util.Vector3;

public class Camara {
	
	public float angleX = 0;
	public float angleY = 0;
	public float angleZ = 0;
	
	public float cameraX = 0;
	public float cameraY = 0;
	public float cameraZ = 0;
	
	public void addAngleX(float angle){
		angleX += angle;
	}
	
	public void addAngleY(float angle){
		angleY += angle;
	}
	
	public void addAngleZ(float angle){
		angleZ += angle;
	}
	
	public void move(float x, float y, float z){
		cameraX += x;
		cameraY += y;
		cameraZ += z;
	}
	
	public String toString(){
		return "x:"+cameraX+" y:"+cameraY+" z:"+cameraZ+" angleX:"+angleX+" angleY:"+angleY+" angleZ:"+angleZ;
	}

	public void renderCamara() {
		GL11.glPushMatrix();
		GL11.glLineWidth(1000);
		GL11.glPointSize(100);
		RenderUtil.bindTexture(TextureManager.select);
		RenderUtil.line(new Vector3(0, 0, 0),new Vector3(cameraX, cameraY, cameraZ));
		GL11.glPopMatrix();
//		System.out.println(toString());
	}
}
