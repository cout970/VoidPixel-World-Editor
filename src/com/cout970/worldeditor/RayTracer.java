package com.cout970.worldeditor;


import org.lwjgl.util.vector.Vector3f;

import com.cout970.worldeditor.gui.Action;
import com.cout970.worldeditor.util.Side;
import com.cout970.worldeditor.util.Vector3;
import com.cout970.worldeditor.world.Block;
import com.cout970.worldeditor.world.Material;

public class RayTracer {

	public static Vector3f origin;
	public static Vector3f direction;
	
	public static void rayTracer(Action act){
		origin = UnprojectUtil.unproject(KeyLisener.MouseX, GLManager.frameHeight-KeyLisener.MouseY, 0);
		direction = UnprojectUtil.unproject(KeyLisener.MouseX, GLManager.frameHeight-KeyLisener.MouseY, 1);
		origin.y = -origin.y;
		direction.y = -direction.y;
		
		Block b = null;
		Vector3 or = new Vector3(origin);
    	Vector3 d = new Vector3(direction);
    	Vector3 dif = d.copy().add(or.copy().negate());
    	double mod = dif.module()*10;
    	Block before1 = null;
    	Block before2 = null;
    	Boolean bef1 = null;
    	
    	for(int i=0;i<mod;i++){
    		Vector3 f = or.copy().add(dif.copy().multiply(i/mod));
    		int x = (int)f.x;
    		int y = (int)f.y;
    		int z = (int)f.z;
    		Block g = WorldEditor.getBlock(x,y,z);
    		if(g != null){ 
    			if(!g.material.getMaterialName().equalsIgnoreCase("AIR")){
    				if(check(g,f)){
    					b = g;
    					break;
    				}else{
    					before1 = g;
    					bef1 = true;
    				}
    			}else{
    				before1 = g;
    				bef1 = true;
    			}
    		}
    		x = (int)Math.floor(f.x);
    		y = (int)Math.floor(f.y);
    		z = (int)Math.floor(f.z);
    		g = WorldEditor.getBlock(x,y,z);
    		if(g != null){
    			if(!g.material.getMaterialName().equalsIgnoreCase("AIR")){
    				if(check(g,f)){
    					b = g;
    					break;
    				}else{
    					before2 = g;
    					bef1 = false;
    				}
    			}else{
    				before2 = g;
					bef1 = false;
    			}
    		}
    	}
    	if(act == Action.Select)WorldEditor.selectBlock(b);
    	else if(b != null){
    		if(act == Action.Break){
    			b.material = new Material("AIR",1,1,1);
    			RenderManager.reloadChunks();
    		}else if(act == Action.Remplace){
    			b.material = new Material(WorldEditor.getSelectedMaterial());
    			RenderManager.reloadChunks();
    		}else if(act == Action.Place){
    			if(bef1 != null){
    				Side s = null;
    				if(!bef1.booleanValue())
    					s = getSide(b,before1);
    				else
    					s = getSide(b,before2);
    				if(s == null)return;
    				Block v = WorldEditor.getBlock((int)b.getX()+s.OffsetX, (int)b.getY()+s.OffsetY, (int)b.getZ()+s.OffsetZ);
    				if(v != null){
    					v.material = new Material(WorldEditor.getSelectedMaterial());
    					RenderManager.reloadChunks();
    				}
    			}
    		}
    	}
    	
	}

	private static Side getSide(Block b, Block v) {
		if(b == v)return null;
		if(b == null || v == null)return null;
		if((int)b.getX() == (int)v.getX() && (int)b.getZ() == (int)v.getZ()){
			if((int)b.getY()+1 == (int)v.getY())return Side.UP;
			if((int)b.getY()-1 == (int)v.getY())return Side.DOWN;
		}
		if((int)b.getX() == (int)v.getX() && (int)b.getY() == (int)v.getY()){
			if((int)b.getZ()+1 == (int)v.getZ())return Side.EAST;
			if((int)b.getZ()-1 == (int)v.getZ())return Side.WEST;
		}
		if((int)b.getY() == (int)v.getY() && (int)b.getZ() == (int)v.getZ()){
			if((int)b.getX()+1 == (int)v.getX())return Side.SOUTH;
			if((int)b.getX()-1 == (int)v.getX())return Side.NORTH;
		}
		return null;
	}

	private static boolean check(Block g, Vector3 f) {
		if(g.getX() >= f.x || g.getX()+1 <= f.x)return false;
		if(g.getY() >= f.y || g.getY()+1 <= f.y)return false;
		if(g.getZ() >= f.z || g.getZ()+1 <= f.z)return false;
		return true;
	}
}
