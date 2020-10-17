package edu.pragmatic;

import java.util.Date;

public class Helpers {

	public static int divide(int a, int b) throws DivisionException {
		if(b == 0) {
			throw new DivisionException("Delish na 0", new Date());
		}
		
		System.out.println("before /");
		
		int result = a / b;
		System.out.println("after /");
		return result;
	}
}
