package task04_move_file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;

public class MoveFile {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.print("Source: ");
			Path source = Paths.get(reader.readLine().trim());
			System.out.print("Destination: ");
			Path destination = Paths.get(reader.readLine().trim());
			
			if (Files.exists(destination) && !Files.isDirectory(destination)) {
				System.out.println("File " + destination + " will be overwritten");
			}
			Files.move(source, destination, REPLACE_EXISTING);
			
			System.out.println("Moved " + source.toString() + " to " + destination.toString());
		} catch (NoSuchFileException e) {
			System.out.println("Source file not found!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}