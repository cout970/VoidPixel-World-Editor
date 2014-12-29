package com.cout970.worldeditor;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.cout970.worldeditor.world.Chunk;
import com.cout970.worldeditor.world.ChunkStorage;
import com.google.gson.Gson;

public class JsonLoader { 

	public static String chunksFolder = System.getProperty("user.home") + "/Desktop/voidpixel/";
	public static List<File> chunks = new ArrayList<File>();
	
	public static void loadChunk(){

		try {
			File dir = new File(chunksFolder);
			for(File fil : dir.listFiles()){
				if(fil.getName().contains("chunk_")){
					FileReader r = new FileReader(fil);
					Gson g = new Gson();

					Chunk c = g.fromJson(r, Chunk.class);
					ChunkStorage.storage.add(c);
				}
			}
			System.out.println(ChunkStorage.storage.size()+" chunks cargados");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
