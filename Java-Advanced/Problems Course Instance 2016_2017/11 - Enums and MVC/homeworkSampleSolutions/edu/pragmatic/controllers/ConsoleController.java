package edu.pragmatic.controllers;

import java.util.List;
import java.util.Scanner;
import edu.pragmatic.model.*;

public class ConsoleController {

	private enum Choice {
		ADD,
		SEARCH,
		DELETE,
		SHOW_ALL_SORTED,
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
			case DELETE:
				delete();
				break;
			case SHOW_ALL_SORTED:
				showAllSorted();
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
		System.out.println("3. Delete");
		System.out.println("4. Show all");
		System.out.println("5. Exit");
		System.out.println("Select option: ");
		int c = sc.nextInt();
		sc.nextLine();
		
		switch (c) {
		case 1: 	return Choice.ADD;
		case 2: return Choice.SEARCH;
		case 3: return Choice.DELETE;
		case 4: return Choice.SHOW_ALL_SORTED;
		case 5: return Choice.EXIT;		
		default: return Choice.INVALID;
		}
	}
	
	private void addEntry() {
		System.out.println("Enter word: ");
		String word = sc.nextLine();
		System.out.println("Enter translation: ");
		String translation = sc.nextLine();
		System.out.println("Enter transcription: ");
		String transcription = sc.nextLine();
		
		Entry e = new Entry(word, translation, transcription);
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
	
	private void delete() {
		System.out.println("Enter a word to delete: ");
		String word = sc.nextLine();
		boolean result = dictionary.delete(word);
		if(result) {
			System.out.println("Word was deleted");
		} else {
			System.out.println("The provided word was not part of the dictionary");
		}
	}
	
	private void showAllSorted() {
		List<Entry> entries = dictionary.getSortedWordEntries();
		
		System.out.println("This dictionary has the following words: ");
		
		for(Entry entry : entries) {
			System.out.println(entry.getWord() + " - " + entry.getTranslation());
		}
	}
}