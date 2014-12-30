package com.cout970.worldeditor.util;
public enum Side {

	DOWN(0,-1,0),
	UP(0,1,0),
	NORTH(-1,0,0),
	SOUTH(1,0,0),
	WEST(0,0,-1),
	EAST(0,0,1);
	
	public int OffsetX;
	public int OffsetY;
	public int OffsetZ;
	
	private Side(int x, int y, int z){
		OffsetX = x;
		OffsetY = y;
		OffsetZ = z;
	}
}
