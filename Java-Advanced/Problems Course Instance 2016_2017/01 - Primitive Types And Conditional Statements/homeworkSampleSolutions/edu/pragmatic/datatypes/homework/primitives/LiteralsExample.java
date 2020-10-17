package edu.pragmatic.datatypes.homework.primitives;

public class LiteralsExample {

	public static void main(String[] args) {
		// boolean
		System.out.println("Boolean literals are ["+ true +"] and ["+ false +"]");
		// char 
		char simpleChar = 'c'; // guess !
		System.out.println(simpleChar);
		char charWithAnEscapeLiterals  = '\n'; // new line
		System.out.println(charWithAnEscapeLiterals);
		char unicodeEscapeSequence = '\u0020' ; // space
		System.out.println(unicodeEscapeSequence);
		// numerical values
		byte byteValueOfOne = 1;
		System.out.println(byteValueOfOne);
		short shortValue = 456;
		System.out.println(shortValue);
		int intValue = 99999999;
		System.out.println(intValue);
		long aLongValue = 4567894465L;
		System.out.println(aLongValue);
		 // floating point 
		float someMoney = 45.05F;
		System.out.println(someMoney);
		// default floating point number is regarded as a Double
		double moreMoney = 456.05;
		System.out.println(moreMoney);
	}
	
}
