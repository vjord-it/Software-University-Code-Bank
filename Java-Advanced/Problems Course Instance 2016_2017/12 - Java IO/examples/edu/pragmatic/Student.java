package edu.pragmatic;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable {

	private int age;
	private String name;
	
	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
}
