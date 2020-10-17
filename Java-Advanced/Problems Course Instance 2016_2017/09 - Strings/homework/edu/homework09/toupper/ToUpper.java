package edu.homework09.toupper;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToUpper {

	public static void main(String[] args) {
		int repeats;
		System.out.print("Number of repeats (1000): ");
		try (Scanner scanner = new Scanner(System.in)) {
			repeats = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			repeats = 1000;
		}

		String text = "The code between <upcase> a special tag </upcase> is always uppercase and again <upcase> to upper case </upcase>. The code between <upcase> a special tag </upcase> is always uppercase and again <upcase> to upper case </upcase>. The code between <upcase> a special tag </upcase> is always uppercase and again <upcase> to upper case </upcase>";
		String regex = "(?<group><upcase> (?<text>.*?) <\\/upcase>)";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = null;

		// Using String
		String newText = null;
		long timer = System.nanoTime();
		for (int i = 0; i < repeats; i++) {
			newText = text;
			matcher = pattern.matcher(newText);
			while (matcher.find()) {
				newText = newText.replaceFirst(matcher.group("group"), matcher.group("text").toUpperCase());
			}
		}
		timer = System.nanoTime() - timer;
		System.out.println("[String] Elapsed time in milliseconds: " + timer / 1000000);
		System.out.println(newText);
		System.out.println();

		// Using StringBuilder
		StringBuilder sb = new StringBuilder();
		timer = System.nanoTime();
		for (int i = 0; i < repeats; i++) {
			sb = new StringBuilder(text);
			matcher = pattern.matcher(sb.toString());
			while (matcher.find()) {
				sb.replace(matcher.start(), matcher.end(), matcher.group("text").toUpperCase());
				matcher = pattern.matcher(sb.toString());
			}
		}
		timer = System.nanoTime() - timer;
		System.out.println("[StringBuilder] Elapsed time in milliseconds: " + timer / 1000000);
		System.out.println(sb);
		System.out.println();

		// Using Matcher
		timer = System.nanoTime();
		for (int i = 0; i < repeats; i++) {
			newText = text;
			matcher = pattern.matcher(newText);
			while (matcher.find()) {
				newText = matcher.replaceFirst(matcher.group("text").toUpperCase());
				matcher = pattern.matcher(newText);
			}
		}
		timer = System.nanoTime() - timer;
		System.out.println("[Matcher] Elapsed time in milliseconds: " + timer / 1000000);
		System.out.println(newText);
		System.out.println();
		
		// Using StringBuilder 2	
		timer = System.nanoTime();
		for (int i = 0; i < repeats; i++) {
			sb = new StringBuilder();
			matcher = pattern.matcher(text);
			int lastEndIndex = 0;
			while (matcher.find()) {
				int startIndex = matcher.start();												
				sb.append(text.substring(lastEndIndex, startIndex));				
				sb.append(matcher.group("text").toUpperCase());
				lastEndIndex = matcher.end();							
			}
			sb.append(text.substring(lastEndIndex, text.length()));
		}
		timer = System.nanoTime() - timer;
		System.out.println("[StringBuilder 2] Elapsed time in milliseconds: " + timer / 1000000);
		System.out.println(sb);
		System.out.println();
		
		// Using Matcher + StringBuffer
		StringBuffer stringBuffer = new StringBuffer();
		timer = System.nanoTime();
		for (int i = 0; i < repeats; i++) {
			stringBuffer = new StringBuffer();
			matcher = pattern.matcher(text);
			while (matcher.find()) {
				matcher.appendReplacement(stringBuffer, matcher.group("text").toUpperCase());
			}
			matcher.appendTail(stringBuffer);
		}
		timer = System.nanoTime() - timer;
		System.out.println("[Matcher + StringBuffer] Elapsed time in milliseconds: " + timer / 1000000);
		System.out.println(stringBuffer.toString());
	}
	
}
