package edu.pragmatic.controlflow.homework;

import java.util.Scanner;

public class PrintNumbersWithinAnInterval {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter lower bound:");
		int lowerBound = sc.nextInt();
		System.out.print("Please enter upper bound:");
		int upperBound = sc.nextInt();
		System.out.print("Result: ");
		sc.close();
		for(int number = lowerBound; number <= upperBound; number++) {
			System.out.print(number + " ");
		}
	}
}
