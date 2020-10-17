package task5;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SqrtOfPossitiveNumbers {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(12, -123, 1, 4, 78, 123123, -344, -7, 6);

		System.out.println(getSqrtOfPossitiveNumbersList(numbers));
	}

	private static Collection<Double> getSqrtOfPossitiveNumbersList(Collection<Integer> numbers) {
		return numbers.stream()
				.filter(x -> x > 0)
				.map(x -> Math.sqrt((double) x))
				.collect(Collectors.toList());
	}
}