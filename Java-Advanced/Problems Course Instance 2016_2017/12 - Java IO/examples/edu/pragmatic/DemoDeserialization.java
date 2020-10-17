package edu.pragmatic;

import java.io.*;
import java.util.*;

public class DemoDeserialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("res/students.data"))) {
			
			@SuppressWarnings("unchecked")
			List<Student> students = (List<Student>)input.readObject();
			for(Student s : students) {
				System.out.println(s.getName() + " - " + s.getAge());
			}
		}
	}
}
