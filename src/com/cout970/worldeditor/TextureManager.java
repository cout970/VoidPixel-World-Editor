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
	public static Texture select;
	public static Texture block;
	public static Texture background;
	public static Texture text;
	
	public static Texture getTexture(Material material) {
		return block;
	}

	static void loadTextures() {
		missingTexture = RegisterTexture("default");
		select = RegisterTexture("select");
		block = RegisterTexture("block");
		background = RegisterTexture("bg");
		text = RegisterTexture("text");
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
