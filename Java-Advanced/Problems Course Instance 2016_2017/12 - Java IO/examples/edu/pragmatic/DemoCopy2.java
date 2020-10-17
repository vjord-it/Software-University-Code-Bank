package edu.pragmatic;

import java.io.*;

public class DemoCopy2 {

	public static void main(String[] args) throws IOException {
		
		try (FileReader reader = new FileReader("res/a.txt");
			 FileWriter writer = new FileWriter("res/a_copy2.txt")) {
			
			int ch;
			while ((ch = reader.read()) != -1) {
				writer.write(ch);
			}
		}
		
	}
}
