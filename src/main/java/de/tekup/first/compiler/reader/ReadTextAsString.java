package de.tekup.first.compiler.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadTextAsString {
	
	public static String readFileAsString(String fileName) {
		String data = "";
		try {
			data = new String(Files.readAllBytes(Paths.get(fileName)));
		} catch (IOException e) {
			System.err.println("Cannot Read File. Error "+e.getMessage());
		}
		
		return data;
	}

}
