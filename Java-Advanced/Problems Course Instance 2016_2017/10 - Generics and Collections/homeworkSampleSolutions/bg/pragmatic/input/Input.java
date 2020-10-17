package bg.pragmatic.input;

import java.util.*;

public class Input {

	public String generateConcatedString(List<String> strings) {
		StringBuilder builder = new StringBuilder();
		for(String string : strings) {
			builder.append(string);
		}
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		Input input = new Input();
		ConsoleReader consoleReader = new ConsoleReader();
		
		List<String> lines = consoleReader.readConsoleLines();
		System.out.println(input.generateConcatedString(lines));
	}
}
