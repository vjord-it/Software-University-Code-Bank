package edu.pragmatic;

import java.util.*;

public class Demo {

	public static void main(String[] args) {
		System.out.println("before f()");
		//f();
		g();
		System.out.println("after f()");
	}
	
	private static void f() {
		System.out.println("start f()");
		Scanner sc = new Scanner(System.in);
//		try {		
//			int r = Helpers.divide(a, b);			
//			System.out.println("Result is: " + r);
//		} catch (ArithmeticException ex) {
//			System.out.println("Greshka pri deleneto: " + ex.getMessage());			
//		} finally {
//			System.out.println("FINALLY");
//		}
		
		try {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int r = Helpers.divide(a, b);			
			System.out.println("Result is: " + r);
		} catch (DivisionException ex) {
			System.out.println("Greshka pri deleneto: " + ex.getMessage() + "   " + ex.getDate());			
		} finally {
			System.out.println("FINALLY");
			sc.close();
		}
	}
	
	private static void g() {
		System.out.println("start f()");
				
		try (Scanner sc = new Scanner(System.in)) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int r = Helpers.divide(a, b);			
			System.out.println("Result is: " + r);
		} catch (DivisionException ex) {
			System.out.println("Greshka pri deleneto: " + ex.getMessage() + "   " + ex.getDate());			
		}
	}
}
