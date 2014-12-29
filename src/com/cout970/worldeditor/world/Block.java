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
	
	public Block(){
		
	}
	
	public double getX(){
		return X;
	}
	
	public double getY(){
		return Y;
	}
	
	public double getZ(){
		return Z;
	}	
}
