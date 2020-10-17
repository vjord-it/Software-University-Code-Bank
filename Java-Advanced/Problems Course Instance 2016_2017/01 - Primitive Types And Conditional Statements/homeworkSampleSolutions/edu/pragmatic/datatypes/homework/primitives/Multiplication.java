package edu.pragmatic.datatypes.homework.primitives;

import java.util.Scanner;

public class Multiplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter first number");
		int firstNumber = sc.nextInt();
		System.out.println("Please enter second number");
		int secondNumber = sc.nextInt();
		sc.close();
		
		int result = firstNumber * secondNumber;
		if ( result > 0){
			System.out.println(result + " is positive number");
		}else {
			System.out.println(result + " is not positive number");
		}
	}
	
}
