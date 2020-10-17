package task05_serialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Demo {

	static final String DATA_FILE = "res/persons.data";

	public static void main(String[] args) {

		List<Person> persons = readData(DATA_FILE);

		if (!persons.isEmpty()) {
			System.out.printf("Read data for %d persons from %s%n", persons.size(), DATA_FILE);
		} else {
			System.out.println("No data found in file. Generating random persons...");
			generatePersons(persons);
		}

		printPersons(persons);

		if (saveData(persons, DATA_FILE)) {
			System.out.printf("Saved data for %d persons to %s%n", persons.size(), DATA_FILE);
		}
	}

	public static void generatePersons(List<Person> persons) {
		// String fullName, long id, String accountNumber, String phone, String email, String address
		try {
			persons.add(new Person("J. J.", 12343333L, "XX-123", "0888-12334", "jj@gmail.com", "Varna"));
			persons.add(new Person("B. J.", 66674555L, "XX-566", "0888-34555", "bj@gmail.com", "Sofia"));
			persons.add(new Person("D. J.", 23452224L, "XX-444", "0888-87666", "dj@gmail.com", "Plovdiv"));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Person> readData(String file) {
		try (ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
			return (List<Person>) input.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error reading file");
		} catch (ClassNotFoundException | IllegalArgumentException e) {
			System.out.println("Invalid data in file");
		}

		return new ArrayList<Person>();
	}

	public static boolean saveData(List<Person> persons, String file) {
		try (ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
			output.writeObject(persons);
		} catch (IOException e) {
			System.out.println("Failed to save data to file");
		}
		return true;
	}

	public static void printPersons(List<Person> persons) {
		for (Person person : persons) {
			System.out.println(person.getPersonDetails());
		}
	}
}
