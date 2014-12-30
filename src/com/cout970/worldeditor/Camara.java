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
		float scale = RenderManager.scale;
		
		Vector3 cero = new Vector3(0, 0, 0);
		Vector3 cam = new Vector3(-cameraX, -cameraY, -cameraZ);
		
		cam.rotateX(Math.toRadians(-angleX));
		cam.rotateY(Math.toRadians(-angleY));
		cam.rotateZ(Math.toRadians(-angleZ));
		cam.multiply(scale);
		
		float a = 2 * (float)KeyLisener.MouseX/GLManager.instance.frameWidth  - 1;
		float b = 2 * (float)KeyLisener.MouseY/GLManager.instance.frameHeight - 1;
		
		
		Vector3 pos = new Vector3(-a*2-cameraX, -b*2-cameraY, 0);
		cam.add(pos);
		cero.add(pos);
		
		RenderUtil.bindTexture(TextureManager.select);
		RenderUtil.line(cam,cero);
		GL11.glPopMatrix();
	}
}
