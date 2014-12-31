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

	public void renderCamara(){
		if(RayTracer.origin != null && RayTracer.direction != null){
			GL11.glPushMatrix();
			GL11.glLineWidth(1000);
			RenderUtil.bindTexture(TextureManager.select);
			//		Vector3 o = new Vector3(RayTracer.origin);
			//		Vector3 d1 = new Vector3(RayTracer.direction);
			//		
			//		Vector3 p = new Vector3(RayTracer.origin);
			//		Vector3 direcion = new Vector3(RayTracer.direction);
			//		double mod = direcion.module()*2;
			//    	direcion.divide(mod);
			//    	
			//    	RenderUtil.line(new Vector3(0,0,0).add(p),direcion.add(p));
			//		RenderUtil.line(d1,o);
			Vector3 or = new Vector3(RayTracer.origin);
			Vector3 d = new Vector3(RayTracer.direction);
			Vector3 dif = d.copy().add(or.copy().negate());
			double mod = dif.module();

			GL11.glBegin(GL11.GL_LINES);
			for(int i=0;i<mod;i++){
				Vector3 f = or.copy().add(dif.copy().multiply(i/mod));
				GL11.glVertex3d(f.x, f.y, f.z);
			}
			GL11.glEnd();
			GL11.glPopMatrix();
		}
	}
}
