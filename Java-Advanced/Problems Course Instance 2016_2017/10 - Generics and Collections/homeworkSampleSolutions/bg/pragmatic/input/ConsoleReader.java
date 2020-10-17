package bg.pragmatic.input;

import java.util.*;

public class ConsoleReader {
	private static final String END_STRING = "END OF TEXT";
	
	public List<String> readConsoleLines() {
		try(Scanner sc = new Scanner(System.in)) {
			List<String> lines = new ArrayList<String>();
			
			String line = sc.nextLine();
			while(!line.equals(END_STRING)) {
				lines.add(line);
				line = sc.nextLine();
			}
			
			return lines;
		}
	}
}
