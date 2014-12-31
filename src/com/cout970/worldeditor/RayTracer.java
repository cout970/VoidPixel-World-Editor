package com.cout970.worldeditor;

import java.util.Vector;

import org.lwjgl.util.vector.Vector3f;

import com.cout970.worldeditor.util.Vector3;
import com.cout970.worldeditor.world.Block;

public class RayTracer {

	public static Vector3f origin;
	public static Vector3f direction;
	
	public static void rayTracer(){
		origin = UnprojectUtil.unproject(KeyLisener.MouseX, GLManager.instance.frameHeight-KeyLisener.MouseY, 0);
		direction = UnprojectUtil.unproject(KeyLisener.MouseX, GLManager.instance.frameHeight-KeyLisener.MouseY, 1);
		origin.y = -origin.y;
		direction.y = -direction.y;
		
		Block b = null;
		Vector3 or = new Vector3(origin);
    	Vector3 d = new Vector3(direction);
    	Vector3 dif = d.copy().add(or.copy().negate());
    	double mod = dif.module()*10;
    	
    	for(int i=0;i<mod;i++){
    		Vector3 f = or.copy().add(dif.copy().multiply(i/mod));
    		Block g = WorldEditor.getBlock((int)Math.round(-f.x),(int)Math.round(-f.y),(int)Math.round(f.z));
    		if(g != null && !g.material.material.equalsIgnoreCase("AIR")){
    			if(check(g,f)){
    				b = g;
    				break;
    			}
    		}
    	}

    	if(b != null){
    		b.material.material = "SELECT";
    	}
	}

	private static boolean check(Block g, Vector3 f) {
		if(g.getX() > f.x || g.getX()+1 < f.x)return false;
		if(g.getY() > f.y || g.getY()+1 < f.y)return false;
		if(g.getZ() > f.z || g.getZ()+1 < f.z)return false;
		return true;
	}
}
