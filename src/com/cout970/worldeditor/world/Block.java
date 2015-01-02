package com.cout970.worldeditor.world;

import com.cout970.worldeditor.util.Side;
import com.google.gson.annotations.Expose;


public class Block {

	@Expose
	public Material material;
	@Expose
	public boolean voidness;
	
	public Location location = new Location();
	
	public boolean faceN;
	public boolean faceS;
	public boolean faceE;
	public boolean faceW;
	public boolean faceU;
	public boolean faceD;
	
	public Block(){}

	public Block(Material m){
		material = m;
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
	
	public boolean shouldRenderSide(Side s){
		if(s == Side.UP)return faceU;
		if(s == Side.DOWN)return faceD;
		if(s == Side.NORTH)return faceN;
		if(s == Side.SOUTH)return faceS;
		if(s == Side.EAST)return faceE;
		if(s == Side.WEST)return faceW;
		return false;
	}
	
	public void setRenderizable(Side s,boolean ren){
		if(s == Side.UP) faceU = ren;
		if(s == Side.DOWN) faceD = ren;
		if(s == Side.NORTH) faceN = ren;
		if(s == Side.SOUTH) faceS = ren;
		if(s == Side.EAST) faceE = ren;
		if(s == Side.WEST) faceW = ren;
	}
	
	public String toString(){
		return "x:"+getX()+" y:"+getY()+" z:"+getZ()+" Material: "+material;
	}
}
