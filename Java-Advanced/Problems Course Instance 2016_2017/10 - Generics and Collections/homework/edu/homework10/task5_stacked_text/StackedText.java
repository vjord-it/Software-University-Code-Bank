package edu.homework10.task5_stacked_text;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StackedText {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Deque<String> stack = new ArrayDeque<>();

			System.out.println("Enter text (use \"END OF TEXT\" to end):");

			String text;
			while (!"END OF TEXT".equalsIgnoreCase(text = scanner.nextLine())) {
				stack.push(text);
			}

			StringBuilder result = new StringBuilder();

			while (!stack.isEmpty()) {
				result.append(stack.pop());
			}

			System.out.println(result);
		}
	}

}
