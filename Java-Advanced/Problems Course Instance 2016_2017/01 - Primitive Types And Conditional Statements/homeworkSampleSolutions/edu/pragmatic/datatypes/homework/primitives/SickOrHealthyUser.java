package edu.pragmatic.datatypes.homework.primitives;

import java.util.Scanner;

public class SickOrHealthyUser {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("What time is it ?. (0-24h format)");
		int hour = sc.nextInt();
		System.out.println("How much money do you have?");
		float money = sc.nextFloat();
		System.out.println("Are you ill ?");
		boolean isUserIll = sc.nextBoolean();

		if(isUserIll) {
			System.out.println("I am ill I am not going out");
			if(money > 0){
				System.out.println("I am buying some medicine");
			} else {
				System.out.println("I will have to drink a lot of tea");
			}
		} else {
			System.out.println("I am healthy");

			if(money >= 1 && money <= 10) {
				System.out.println("I am going to coffee");
			} else if(money > 10) {
				System.out.println("Party all night");
			} else {
				System.out.println("I will stay at home and will play games");
			}
		}
	}
}
