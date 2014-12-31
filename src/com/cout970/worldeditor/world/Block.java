package com.cout970.worldeditor.world;


public class Block {

	public String namaBlock;
	public double X,Y,Z;
	public boolean load;
	public Material material;
	public boolean voidness;
	public boolean prevClickRight;
	public boolean prevClickLeft;
	public Location location;
	public Color colors;
	private boolean shouldRender = false;
	
	public Block(){

	}

	public Block(Material m,double x,double y, double z){
		material = m;
		X = x;
		Y = y;
		Z = z;
		colors = new Color();
	}

	public double getX(){
		return location.X;
	}
	
	public double getY(){
		return location.Y;
	}
	
	public double getZ(){
		return location.Z;
	}	
	
	public boolean shouldRender(){
		return shouldRender;
	}
	
	public void setRenderizable(boolean ren){
		shouldRender = ren;
	}
	
	public String toString(){
		return "x:"+getX()+" y:"+getY()+" z:"+getZ()+" Material: "+material;
	}
}
