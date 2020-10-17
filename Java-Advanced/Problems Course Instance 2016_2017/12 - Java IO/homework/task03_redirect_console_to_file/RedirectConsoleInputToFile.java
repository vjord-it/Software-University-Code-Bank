package task03_redirect_console_to_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.filechooser.FileSystemView;

public class RedirectConsoleInputToFile {
	static final String OUTPUT_FILE = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath()
			+ "\\console.input.txt";

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_FILE)))) {
			int counter = 0;
			System.out.println("Enter text (Ctrl-Z to terminate)");

			String line;
			while ((line = reader.readLine()) != null) {
				output.println(line);
				//output.flush();
				counter++;
			}

			System.out.println(counter + " line(s) written to " + OUTPUT_FILE);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot create output file: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}