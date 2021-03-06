package com.cout970.worldeditor;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cout970.worldeditor.world.Chunk;
import com.cout970.worldeditor.world.ChunkStorage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonLoader { 

	public static String chunksFolder = "./chunks/";//System.getProperty("user.home") + "/Desktop/voidpixel/";
	public static List<File> chunks = new ArrayList<File>();

	public static void loadChunks(){
		ChunkStorage.storage.clear();
		RenderManager.reloadChunks();
		try {
			File dir = new File(chunksFolder);
			for(File fil : dir.listFiles()){
				if(fil.getName().contains("chunk_")){
					FileReader r = new FileReader(fil);
					Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

					Chunk c = g.fromJson(r, Chunk.class);
					for(int y = 0; y < c.Blocks.length; y++){
						for(int z = 0; z < c.Blocks[0].length; z++){
							for(int x = 0; x < c.Blocks[0][0].length; x++){
								c.Blocks[y][z][x].location.X = -x+c.X*c.Blocks[0][0].length+7;
								c.Blocks[y][z][x].location.Y = y;
								c.Blocks[y][z][x].location.Z = z+c.Z*c.Blocks[0].length;
							}	
						}
					}
					ChunkStorage.storage.add(c);
					r.close();
				}
			}
			System.out.println(ChunkStorage.storage.size()+" chunks cargados");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveChunks(){

		try {
			for(Chunk c : ChunkStorage.storage){
				File dir = new File(chunksFolder+getChunkName(c));
				FileWriter r = new FileWriter(dir);
				Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
				String json = g.toJson(c);
				r.write(json);
				r.close();
			}
			System.out.println(ChunkStorage.storage.size()+" chunks guardados");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getChunkName(Chunk c) {
		return "chunk_"+c.X+".0_"+c.Z+".0.json";
	}
}
