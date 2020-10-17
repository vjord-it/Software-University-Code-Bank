package edu.pragmatic;

import java.util.*;
import java.io.*;

public class DemoSerialization {

	public static void main(String[] args) throws IOException {
		
		List<Student> students = new ArrayList<>();
		students.add(new Student(5, "Gosho"));
		students.add(new Student(15, "Pesho"));
		
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("res/students.data"))) {			
			output.writeObject(students);
		}
	}
}
