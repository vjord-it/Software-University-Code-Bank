package edu.pragmatic;

import java.util.*;
import java.util.stream.*;

public class Demo {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(-2, 10, 5, 11, -100);
//		numbers.sort(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				if(o1 == o2) {
//					return 0;
//				} else if (o1 < o2) {
//					return -1;
//				} else {
//					return 1;
//				}
//			}
//			
//		});
		
//		numbers.sort(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o1.compareTo(o2);
//			}
//			
//		});
		
		//numbers.sort( (Integer o1, Integer o2) -> { return o1.compareTo(o2); });
		//numbers.sort( (o1, o2) -> { return o1.compareTo(o2); });
		numbers.sort( (o1, o2) -> o1.compareTo(o2) );

		
		System.out.println(numbers);
		
		Stream<Integer> s1 = numbers.stream();
		Stream<Integer> filteredStream = s1.filter(x -> (x % 2 == 0));
		filteredStream.forEach(x -> System.out.println(x));
//		filteredStream.forEach(new Consumer<Integer>() {
//
//			@Override
//			public void accept(Integer t) {
//				System.out.println(t);
//			}
//		});
		
		numbers.stream()
			.filter(x -> x % 2 == 0)
			.forEach(x -> System.out.println(x));
		
		Optional<Integer> result = getFirstChetnoChislo(Arrays.asList(1,3,5)); //getFirstChetnoChislo(numbers);
		if(result.isPresent()) {
			System.out.println(result.get());
		} else {
			System.out.println("Niama namereno chislo");
		}
		
		numbers = Arrays.asList(1, 2, 3, -5 , -4, 18, 120);
		Optional<Integer> first = numbers.stream()
			.filter(x -> x > 3)
			.filter(x -> x % 2 == 0)
			.map(x -> x * 2)
			.findFirst();
		if(first.isPresent()) {
			System.out.println("Doubled: " + first.get());
		} else {
			System.out.println("Niama takova chislo");
		}
		
		Stream<String> words = Stream.of("abv", "aaaaaa", "12345");		
		Stream<Integer> lengths = words.map(s -> s.length());
		List<Integer> listOfLengths = lengths.collect(Collectors.toList());
		System.out.println(listOfLengths);
		
		List<String> names = Arrays.asList("Pesho", "Goshoooo", "John");
		Map<String, Integer> m = names.stream().collect(Collectors.toMap(x -> x, x -> x.length()));
		System.out.println(m);
		
		
		numbers = Arrays.asList(3, 4, -10, 3, 12);
		Optional<Integer> r2 = numbers.stream().reduce((x, y) -> x * y);
		if(r2.isPresent()) {
			System.out.println("Proizvedenieto e: " + r2.get());
		} else {
			System.out.println("Niama elementi");
		}
		
		System.out.println(numbers.stream().reduce((x, y) -> (x < y ? x : y)));
		
		List<Square> squares = Arrays.asList(new Square(10), new Square(3), new Square(20));
		//List<Integer> areas = squares.stream().map(s -> s.calculateArea()).collect(Collectors.toList());
		List<Integer> areas = squares.stream().map(Square::calculateArea).collect(Collectors.toList());
		System.out.println(areas);
		
		List<Integer> sides = Arrays.asList(3, 5, 10, 2, 7);
		
		//System.out.println(sides.stream().map(x -> new Square(x)).collect(Collectors.toList()));
		System.out.println(sides.stream().map(Square::new).collect(Collectors.toList()));
		
		//sides.stream().filter(x -> x % 2 == 0).forEach(x -> System.out.println(x));
		sides.stream().filter(x -> x % 2 == 0).forEach(System.out::println);
		
		Stream<Integer> s3 = Stream.generate(() -> 5);
		System.out.println(s3.findFirst());
		
		Stream<Integer> s4 = Stream.iterate(1, x -> x + 1);
		System.out.println(s4.filter(x -> x % 2 == 0).findFirst());
		s4 = Stream.iterate(1, x -> x + 1);
		//s4.forEach(System.out::println);
	}
	
	static Optional<Integer> getFirstChetnoChislo(Collection<Integer> chisla) {
		for(Integer chislo : chisla) {
			if(chislo % 2 == 0) {
				return Optional.of(chislo);
			}
		}
		
		return Optional.empty();
	}
}
