package edu.pragmatic;

import java.io.*;

public class DemoCopy {

	public static void main(String[] args) throws IOException {		
		
		try (FileInputStream input = new FileInputStream("res/a.txt");
			FileOutputStream output = new FileOutputStream("res/a_copy.txt")) {
			
//			int b = input.read();
//			while (b != -1) {
//				output.write(b);
//				b = input.read();
//			}
			
			int b;
			while( (b = input.read())  != -1) {
				output.write(b);
			}
		}
	}
}
