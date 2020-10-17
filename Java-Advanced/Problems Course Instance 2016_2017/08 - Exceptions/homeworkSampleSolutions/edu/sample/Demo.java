package edu.sample;

public class Demo {
	public static void main(String[] args) {
		try {
			Student s = new Student("Chuck", "Norris", 12, true);
			System.out.println(s);
		} catch (InvalidStudentDataException e) {
			e.printStackTrace();
		}
	}
}
