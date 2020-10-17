package edu.homework08.exceptions.java;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Demo {

	public static void main(String[] args) {
		final String ERROR_LOG_FILE = "error.log";

		try (PrintStream errorLogFile = new PrintStream(new FileOutputStream(ERROR_LOG_FILE))) {
			System.setErr(errorLogFile);

			studentsDemo();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void studentsDemo() {

		Student s1;

		try {
			s1 = new Student("John", "Dow", "male", 18);
			System.out.println(s1);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			s1 = new Student("Ana", "Sinona", "female", 7);
			System.out.println(s1);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			s1 = new Student(null, "Dow", "male", 18);
			System.out.println(s1);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			s1 = new Student("John", null, "male", 18);
			System.out.println(s1);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			s1 = new Student("John", "Dow", null, 18);
			System.out.println(s1);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			s1 = new Student("VeryLongFirstName", "Dow", "male", 18);
			System.out.println(s1);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			s1 = new Student("John", "VeryVeryLongFamilyName", "male", 18);
			System.out.println(s1);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			s1 = new Student("John", "Dow", "invalid sex type", 18);
			System.out.println(s1);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			s1 = new Student("John", "Dow", "male", 19);
			System.out.println(s1);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			s1 = new Student("John", "Dow", "male", 6);
			System.out.println(s1);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
