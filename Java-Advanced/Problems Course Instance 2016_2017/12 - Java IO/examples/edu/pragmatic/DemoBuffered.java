package edu.pragmatic;

import java.io.*;

public class DemoBuffered {

	public static void main(String[] args) throws IOException {

		try (FileInputStream input = new FileInputStream("res/a.txt");
			 FileOutputStream output = new FileOutputStream("res/a_copy_buff.txt");
			 BufferedInputStream buffInput = new BufferedInputStream(input);
			 BufferedOutputStream buffOutput = new BufferedOutputStream(output)) {
						
			int b;
			while( (b = buffInput.read())  != -1) {
				buffOutput.write(b);
			}			
		}
		
	}
}
