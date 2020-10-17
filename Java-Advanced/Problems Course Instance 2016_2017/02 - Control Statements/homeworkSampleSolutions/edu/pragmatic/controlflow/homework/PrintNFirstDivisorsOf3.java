package edu.pragmatic.controlflow.homework;

import java.util.Scanner;

public class PrintNFirstDivisorsOf3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter n:");
		int maxNumber = sc.nextInt();
		sc.close();
		
		boolean hasPrintedFirstNumber = false;
		for(int i = 3; i < maxNumber; i++) {
			if(i % 3 == 0) {
				if(hasPrintedFirstNumber) {
					System.out.print(", ");
				} else {
					hasPrintedFirstNumber = true;
				}
				
				System.out.print(i);
			}
		}
	}
}
