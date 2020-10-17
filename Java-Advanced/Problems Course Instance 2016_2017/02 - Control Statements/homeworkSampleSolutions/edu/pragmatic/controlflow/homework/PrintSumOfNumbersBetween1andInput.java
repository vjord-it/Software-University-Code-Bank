package edu.pragmatic.controlflow.homework;

import java.util.Scanner;

public class PrintSumOfNumbersBetween1andInput {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter upper bound");
		int upperBound = sc.nextInt();
		sc.close();
		int sum = 0;
		for(int number = 1; number <= upperBound; number++) {
			sum += number;
		}
		
		System.out.println("The sumer of numbers between 1 and " + upperBound + " is : " + sum);
	}
}
