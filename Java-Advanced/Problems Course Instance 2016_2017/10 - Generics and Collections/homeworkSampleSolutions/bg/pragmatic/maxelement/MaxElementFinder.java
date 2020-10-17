package bg.pragmatic.maxelement;

import java.util.*;

public class MaxElementFinder {
	public static void main(String[] args) {
		/*
		Number[] numbers = new Number[] { 
			new Number(-4),new Number(0),new Number(7),
			new Number(-14),new Number(24),new Number(10)
		};
		*/
		
		List<Number> numbers = new ArrayList<>();
		numbers.add(new Number(-4));
		numbers.add(new Number(0));
		numbers.add(new Number(7));
		numbers.add(new Number(-14));
		numbers.add(new Number(24));
		numbers.add(new Number(10));
		
		System.out.println(findMaxNumber(numbers));
	}

	private static Number findMaxNumber(List<Number> numbers) {
		if(numbers.size() == 0) {
			return null;
		}
		
		Number maxNumber = numbers.get(0);
		for(Number number : numbers) {
			if(number.compareTo(maxNumber) == -1) {
				maxNumber = number;
			}
		}
	
		return maxNumber;
	}
}
