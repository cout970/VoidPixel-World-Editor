package com.cout970.worldeditor;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.cout970.worldeditor.world.Chunk;
import com.cout970.worldeditor.world.ChunkStorage;
import com.google.gson.Gson;

public class JsonLoader {

	public static String chunksFolder = "I:/Development/WorldEditorVoidPixel/chunks/";
	
	public static void loadChunk(){

		try {
			File f = new File(chunksFolder+getChunkName(0.0,0.0));
			FileReader r = new FileReader(f);
			Gson g = new Gson();
			
			Chunk c = g.fromJson(r, Chunk.class);
			ChunkStorage.storage = c;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getChunkName(double d, double e) {
		return "chunk_"+d+"_"+e+".json";
	}
}
