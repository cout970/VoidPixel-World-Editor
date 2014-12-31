package com.cout970.worldeditor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.cout970.worldeditor.world.Material;

public class TextureManager {
	
	public static Texture missingTexture;
	public static Texture water;
	public static Texture air;
	public static Texture grass;
	public static Texture stone;
	public static Texture wood;
	public static Texture select;
	public static Texture hard_stone;
	public static Texture sand;
	public static Texture bug;
	public static Texture overlay;
	
	public static Texture getTexture(Material material) {
		if(material.material.equalsIgnoreCase("GRASS"))return grass;
		if(material.material.equalsIgnoreCase("WATER"))return water;
		if(material.material.equalsIgnoreCase("STONE"))return stone;
		if(material.material.equalsIgnoreCase("HARD_STONE"))return hard_stone;
		if(material.material.equalsIgnoreCase("WOOD"))return wood;
		if(material.material.equalsIgnoreCase("AIR"))return air;
		if(material.material.equalsIgnoreCase("SAND"))return sand;
		if(material.material.equalsIgnoreCase("SELECT"))return select;
		if(material.material.equalsIgnoreCase("BUG"))return bug;
		System.out.println("Error missing material: "+material.material);
		return air;
	}

	static void loadTextures() {
		missingTexture = RegisterTexture("default");
		air = RegisterTexture("air");
		stone = RegisterTexture("stone");
		wood = RegisterTexture("wood");
		water = RegisterTexture("water");
		grass = RegisterTexture("grass");
		select = RegisterTexture("select");
		hard_stone = RegisterTexture("hard_stone");
		sand = RegisterTexture("sand");
		bug = RegisterTexture("bug");
		overlay = RegisterTexture("gui");
	}
	
	public static Texture RegisterTexture(String name){
		try{
			Texture texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("./assets/"+name+".png"));
			return texture;
		}catch(Exception e){
			try {
				return TextureLoader.getTexture("png", new FileInputStream(new File("./assets/default.png")));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

}
