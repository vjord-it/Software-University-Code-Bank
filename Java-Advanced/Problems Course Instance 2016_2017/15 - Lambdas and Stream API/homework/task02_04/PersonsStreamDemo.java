package task02_04;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonsStreamDemo {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Pesho", 120d), 
				new Person("Ivo", 176.5),
				new Person("Mihail", 134.7), 
				new Person("Ivan", 176d));

		persons.forEach(p -> System.out.println(p.getInfo()));

		System.out.println("List of all persons names: " + getPersonNamesList(persons));

		System.out.println("Symbols in longest name in the list: " + getLongestNameLength(persons));

		Optional<Person> highestPerson = getHighestPerson(persons);
		if (highestPerson.isPresent()) {
			System.out.println("Highest person in the list is " + highestPerson.get().getInfo());
		} else {
			System.out.println("No persons found in list");
		}
	}

	private static Collection<String> getPersonNamesList(Collection<Person> persons) {
		return persons.stream()
				.map(Person::getName)
				.collect(Collectors.toList());
	}

	private static int getLongestNameLength(Collection<Person> persons) {
		return persons.stream()
				.map(x -> x.getName().length())
				.max(Comparator.naturalOrder())
				.orElse(0);
	}

	private static Optional<Person> getHighestPerson(Collection<Person> persons) {
		return persons.stream().max(Comparator.comparing(Person::getHeight));
/*				.sorted(Comparator.comparing(Person::getHeight).reversed())
				//.sorted((x, y) -> Double.compare(y.getHeight(), x.getHeight()))
				.findFirst();*/
	}
}
