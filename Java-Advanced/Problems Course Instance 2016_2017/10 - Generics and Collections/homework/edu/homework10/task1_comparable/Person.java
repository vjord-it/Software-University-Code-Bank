package edu.homework10.task1_comparable;

public class Person implements Comparable<Person> {
	private String name;
	private String familyName;
	private long id;

	public Person(String name, String familyName, long id) {
		super();
		this.name = name;
		this.familyName = familyName;
		this.id = id;
	}

	@Override
	public int compareTo(Person other) {
		int cmp = this.name.compareTo(other.name);

		if (cmp == 0) {
			cmp = this.familyName.compareTo(other.familyName);
		}

		if (cmp == 0) {
			cmp = Long.compare(this.id, other.id);
		}

		return cmp;
	}

	@Override
	public String toString() {
		return String.format("Person [name=%s, familyName=%s, id=%s]", name, familyName, id);
	}

}
