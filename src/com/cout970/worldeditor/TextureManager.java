package com.cout970.worldeditor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import resources.Icons;

import com.cout970.worldeditor.world.Material;

public class TextureManager {
	
	public static Texture missingTexture;
	public static Texture water;
	public static Texture air;
	public static Texture grass;
	public static Texture stone;
	public static Texture wood;
	
	public static Texture getTexture(Material material) {
		if(material.material.equalsIgnoreCase("GRASS"))return grass;
		if(material.material.equalsIgnoreCase("WATER"))return water;
		if(material.material.equalsIgnoreCase("HARD_STONE"))return stone;
		if(material.material.equalsIgnoreCase("WOOD"))return wood;
		if(material.material.equalsIgnoreCase("AIR"))return air;
		System.out.println(material.material);
		return air;
	}

	static void loadTextures() {
		missingTexture = RegisterTexture("default");
		air = RegisterTexture("air");
		stone = RegisterTexture("stone");
		wood = RegisterTexture("wood");
		water = RegisterTexture("water");
		grass = RegisterTexture("grass");
	}
	
	public static Texture RegisterTexture(String name){
		try{
			Texture texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(Icons.class.getResource(name+".png").getPath()));
			return texture;
		}catch(Exception e){
			try {
				return TextureLoader.getTexture("png", new FileInputStream(new File(Icons.class.getResource("default.png").getFile())));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

}
