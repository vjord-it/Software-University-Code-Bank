package edu.homework09.concatenation;

import java.util.Scanner;

public class Concatenation {

	public static void main(String[] args) {
		int concatenations = 0;

		System.out.print("Number of string concatenations: ");
		try (Scanner scanner = new Scanner(System.in)) {
			concatenations = Integer.parseInt(scanner.nextLine());
		}

		long timer = System.nanoTime();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= concatenations; i++) {
			sb.append(i).append(System.lineSeparator());
		}
		timer = System.nanoTime() - timer;
		System.out.println("[StringBuilder] Elapsed time in milliseconds: " + timer / 1000000);

		// A very slow solution for the problem - concatenating String objects:
		timer = System.nanoTime();
		String result = "";
		for (int i = 1; i <= concatenations; i++) {
			result = result.concat(Integer.toString(i)).concat(System.lineSeparator());
		}
		timer = System.nanoTime() - timer;
		System.out.println("[string.concat] Elapsed time in milliseconds: " + timer / 1000000);
	}

}
