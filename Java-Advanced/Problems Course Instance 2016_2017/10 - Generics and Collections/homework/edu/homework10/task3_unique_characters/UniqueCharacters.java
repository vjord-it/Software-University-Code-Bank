package edu.homework10.task3_unique_characters;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueCharacters {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter text: ");
			char[] chars = scanner.nextLine().toCharArray();

			Set<Character> uniqueChars = new LinkedHashSet<>();
			for (char aChar : chars) {
				uniqueChars.add(aChar);
			}

			System.out.println(
					"Unique characters: " + Arrays.toString(uniqueChars.toArray()).replaceAll("[\\[\\], ]", ""));
		}
	}

}
