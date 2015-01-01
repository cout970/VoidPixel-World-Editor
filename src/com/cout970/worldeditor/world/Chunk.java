package com.cout970.worldeditor.world;

import com.google.gson.annotations.Expose;

public class Chunk {
	
	@Expose
	public int X;
	@Expose
	public int Z;
	@Expose
	public Block[][][] Blocks = new Block[32][8][8];
	@Expose
	public boolean createdBlock;
	
	private int callList = -1;
	
	public String toString(){
		return "X: "+X+" Z: "+Z;
	}
	
	public void setCallList(int c){
		callList = c;
	}
	
	public int getCallList(){
		return callList;
	}
}
