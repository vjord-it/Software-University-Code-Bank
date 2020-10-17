package edu.sample;

/**
 * 
 * @author pragmatic
 *
 */
public class Student {
	private String firstName;
	private String lastName;
	private int age;
	private boolean isMale;
	
	public Student(String firstName, String lastName, int age, boolean isMale) throws InvalidStudentDataException  {
		super();
		
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
		
		this.isMale = isMale;
	}
	
	/**
	 * Set first name of the student
	 * 
	 * @param firstName - first name of the student
	 * @throws InvalidStudentDataException - throws if firstName.length > 10
	 */
	public void setFirstName(String firstName) throws InvalidStudentDataException {
		if(firstName.length() <= 10) {
			this.firstName = firstName;
		} else {
			throw new InvalidStudentDataException();
		}
	}
	
	public void setLastName(String lastName) throws InvalidStudentDataException {
		if(lastName.length() <= 20) {
			this.lastName = lastName;
		} else {
			throw new InvalidStudentDataException();
		}
	}
	
	public void setAge(int age) throws InvalidStudentDataException {
		if(age >= 7 && age <= 18) {
			this.age = age;
		} else {
			throw new InvalidStudentDataException();
		}
	}
	
	public String toString() {
		return ("Student name is: " + firstName + " " + lastName + "  age: " + age + "   isMale: " + isMale);
	}
}
