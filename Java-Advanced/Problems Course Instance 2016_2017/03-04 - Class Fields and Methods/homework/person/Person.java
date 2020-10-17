package person;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;
	private String familyName;
	private int age;
	private int height;
	private double weight;
	private char sex;
	private List<Person> family;
	private List<Person> friends;

	public Person() {
		this("", "", 0, 0, 0d, 'M');
	}

	public Person(String name, String familyName, int age, int height, double weight, char sex) {
		super();
		this.name = name;
		this.familyName = familyName;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.sex = sex;
		family = new ArrayList<Person>();
		friends = new ArrayList<Person>();
	}

	@Override
	public String toString() {
		return String.format(
				"Name: %s%n" + "Family Name: %s%n" + "Sex: %s%n" + "Age: %d%n" + "Height: %d cm%n" + "Weight: %.2f kg%n"
						+ "Family members: %s%n" + "Friends: %s%n",
				this.name, this.familyName, this.getSex(), this.age, this.height, this.weight,
				this.getFamilyMembersNamesList(), this.getFriendsNamesList());
	}

	public String getFamilyMembersNamesList() {
		if (!this.hasFamily()) {
			return "none";
		}

		StringBuilder sb = new StringBuilder();
		for (Person person : this.family) {
			sb.append(person.name).append("; ");
		}
		return sb.toString();
	}

	public String getFriendsNamesList() {
		if (!this.hasFriends()) {
			return "none";
		}

		StringBuilder sb = new StringBuilder();
		for (Person person : this.friends) {
			sb.append(person.name).append("; ");
		}
		return sb.toString();
	}

	public void marry(Person person) {
		System.out.println(this.name + " marries " + person.name);
		this.addFamilyMember(person);
		person.addFamilyMember(this);
	}

	public void makeFriend(Person person) {
		System.out.println(this.name + " and " + person.name + " are frirends now");
		this.addFriend(person);
		person.addFriend(this);
	}

	public boolean hasFamily() {
		return !this.family.isEmpty();
	}

	public boolean hasFriends() {
		return !this.friends.isEmpty();
	}

	public List<Person> getFamily() {
		return family;
	}

	public void addFamilyMember(Person person) {
		this.family.add(person);
	}

	public List<Person> getFriends() {
		return friends;
	}

	private void addFriend(Person person) {
		this.friends.add(person);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getSex() {
		switch (this.sex) {
		case 'F':
		case 'f':
			return "Female";
		case 'M':
		case 'm':
			return "Male";
		default:
			return "undefined";
		}
	}

	public void setSex(char sex) {
		this.sex = sex;
	}
}
