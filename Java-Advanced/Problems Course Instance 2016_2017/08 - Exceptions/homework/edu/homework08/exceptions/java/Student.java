package edu.homework08.exceptions.java;

public class Student {
	static enum SexType {
		MALE, FEMALE
	};

	private String name;
	private String family;
	private SexType sex;
	private int age;

	/**
	 * @param name
	 * @param family
	 * @param sex
	 * @param age
	 */
	public Student(String name, String family, String sex, int age) {
		super();
		setName(name);
		setFamily(family);
		setSex(sex);
		setAge(age);
	}

	public Student() {
		super();
	}

	/**
	 * @return the sex
	 */
	public SexType getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		if (sex != null) {
			if ("male".equalsIgnoreCase(sex)) {
				this.sex = SexType.MALE;
				return;
			} else if ("female".equalsIgnoreCase(sex)) {
				this.sex = SexType.FEMALE;
				return;
			}
		}
		throw new IllegalArgumentException("Invalid sex type: " + sex);
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		if (age >= 7 && age <= 18) {
			this.age = age;
		} else {
			throw new IllegalArgumentException("Invalid age: " + age);
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		if (name != null && name.length() <= 12 && name.length() > 0) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Invalid name: " + name);
		}
	}

	/**
	 * @return the family
	 */
	public String getFamily() {
		return family;
	}

	/**
	 * @param family
	 *            the family to set
	 */
	public void setFamily(String family) {
		if (family != null && family.length() <= 20 && family.length() > 0) {
			this.family = family;
		} else {
			throw new IllegalArgumentException("Invalid family name: " + family);
		}
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, family=%s, sex=%s, age=%s]", name, family, sex, age);
	}

}
