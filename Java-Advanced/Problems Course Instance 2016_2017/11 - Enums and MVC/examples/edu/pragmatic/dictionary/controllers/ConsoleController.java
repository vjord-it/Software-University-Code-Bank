package edu.pragmatic.dictionary.controllers;

import java.util.Scanner;

import edu.pragmatic.dictionary.model.Dictionary;
import edu.pragmatic.dictionary.model.Entry;

public class ConsoleController {

	private enum Choice {
		ADD,
		SEARCH,
		EXIT,
		INVALID
	}
	
	private Scanner sc;
	private Dictionary dictionary;
	
	public void start() {
		sc = new Scanner(System.in);
		dictionary = new Dictionary();
		
		boolean shouldContinue = true;
		
		do {
			Choice c = showMenu();
			switch (c) {
			case ADD:
				addEntry();
				break;
			case SEARCH:
				search();
				break;
			case EXIT:
				shouldContinue = false;
				break;
			case INVALID:
				System.out.println("Invalid option");
				break;
			}
			
		} while(shouldContinue);
	}
	
	private Choice showMenu() {
		System.out.println("---MENU---");
		System.out.println("1. Add");
		System.out.println("2. Search");
		System.out.println("3. Exit");
		System.out.println("Select option: ");
		int c = sc.nextInt();
		sc.nextLine();
		
		switch (c) {
		case 1: 	return Choice.ADD;
		case 2: return Choice.SEARCH;
		case 3: return Choice.EXIT;
		default: return Choice.INVALID;
		}
	}
	
	private void addEntry() {
		System.out.println("Enter word: ");
		String word = sc.nextLine();
		System.out.println("Enter translation: ");
		String translation = sc.nextLine();
		
		Entry e = new Entry(word, translation);
		dictionary.add(e);
		
		System.out.println("Done");
	}
	
	private void search() {
		System.out.println("Enter word: ");
		String word = sc.nextLine();
		
		Entry e = dictionary.search(word);
		if(e != null) {
			System.out.println("Translation is: " + e.getTranslation());
		} else {
			System.out.println("No such word exists");
		}
	}
	
}





