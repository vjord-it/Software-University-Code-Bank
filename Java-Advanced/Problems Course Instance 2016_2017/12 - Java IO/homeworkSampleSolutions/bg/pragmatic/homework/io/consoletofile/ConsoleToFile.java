package bg.pragmatic.homework.io.consoletofile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ConsoleToFile {
	
	public void printFromConsoleToFile(String filePath) throws IOException{
		if (filePath == null || filePath.isEmpty())
			throw new IllegalArgumentException("File path must be provided");
		
		File outputFile = Paths.get(filePath).toFile();
		if (!outputFile.exists())
			throw new FileNotFoundException(filePath + " is not a correct file path");
		
		try ( FileWriter fw = new FileWriter(outputFile); Scanner console = new Scanner(System.in) ) {
			String consoleLine = console.nextLine();
			fw.write(consoleLine + "\n");
		}
	}
	
}