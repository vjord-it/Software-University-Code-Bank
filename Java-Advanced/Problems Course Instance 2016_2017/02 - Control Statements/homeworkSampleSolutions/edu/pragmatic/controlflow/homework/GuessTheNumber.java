package edu.pragmatic.controlflow.homework;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

	public static void main(String[] args) {
		Random randomGenerator = new Random();
		int randomNumber = randomGenerator.nextInt(20) + 1;
		
		int remainingTriesCount = 2;
		boolean hasWon = false;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Guess the number: ");
			int userNumber = sc.nextInt();
			if(userNumber == randomNumber) {
				System.out.println("You win");
				hasWon = true;
				break;
			} else if(remainingTriesCount > 0) {
				if(userNumber < randomNumber) {
					System.out.println("Your number is smaller. Try with a bigger one");
				} else {
					System.out.println("Your number is bigger. Try with a smaller one");
				}
			} else {
				break;
			}
			
			remainingTriesCount--;
		} while(true);
		
		sc.close();
		
		if(!hasWon) {
			System.out.println("Game Over. The number was: " + randomNumber);
		}
	}
	
}
