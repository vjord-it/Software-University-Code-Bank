package edu.pragmatic.controlflow.homework;

import java.util.Scanner;

public class PrintMinAndMax {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[15];
		for(int enteredNumber = 0; enteredNumber < numbers.length; enteredNumber++) {
			System.out.println("Please enter "+ enteredNumber +" element ");
			numbers[enteredNumber] = sc.nextInt();
		}
		sc.close();
		
		int minNumber = numbers[0]; 
		int maxNumber = numbers[0];
		for(int index = 1; index < numbers.length; index++) {
			if(numbers[index] < minNumber) {
				minNumber = numbers[index];
			}
			if(numbers[index] > maxNumber) {
				maxNumber = numbers[index];
			}
		}
		
		System.out.println("Min number is " + minNumber);
		System.out.println("Max number is " + maxNumber);
	}
}
