package bg.pragmatic.input;

import java.util.*;

public class ReversedInput {
	
	public String generateConcatedString(List<String> strings) {
		StringBuilder builder = new StringBuilder();
		ListIterator<String> iterator = strings.listIterator(strings.size());
		while(iterator.hasPrevious()) {
			builder.append(iterator.previous());
		}
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		ReversedInput reversedInput = new ReversedInput();
		ConsoleReader consoleReader = new ConsoleReader();
		
		List<String> lines = consoleReader.readConsoleLines();
		System.out.println(reversedInput.generateConcatedString(lines));
	}
}
