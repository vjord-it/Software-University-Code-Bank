package edu.homework10.task4_queued_text;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class QueuedText {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Deque<String> queue = new ArrayDeque<>();

			System.out.println("Enter text (use \"END OF TEXT\" to end):");

			String text;
			while (!"END OF TEXT".equalsIgnoreCase(text = scanner.nextLine())) {
				queue.offer(text);
			}

			StringBuilder result = new StringBuilder();

			while (!queue.isEmpty()) {
				result.append(queue.poll());
			}

			System.out.println(result);
		}
	}

}
