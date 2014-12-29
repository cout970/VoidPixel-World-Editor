package com.cout970.worldeditor.world;

public class Chunk {
	
	public boolean createBlock;
	public Object worldGen;
	public boolean generated;
	public boolean saved;
	
	public Block[][][] Blocks = new Block[32][8][8];
	
	public int X;
	public int Z;
	
	public String toString(){
		return "X: "+X+" Z: "+Z+" createBlock: "+createBlock+" worldGen: "+worldGen+" generated: "+generated+" saved: "+saved;
	}
}
