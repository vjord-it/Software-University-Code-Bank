package task01;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CheckForThreeDigitsNumberInList {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(12, -123, 1, 4, 78, 123123);

		if (hasThreeDigitsNumber(numbers)) {
			System.out.println("Found a number with three digits");
		} else {
			System.out.println("No number with three digits found");
		}
	}

	private static boolean hasThreeDigitsNumber(Collection<Integer> numbers) {
		return numbers.stream()
				.anyMatch(x -> (x > 99 && x < 1000) || (x < -99 && x > -1000));
	}
}