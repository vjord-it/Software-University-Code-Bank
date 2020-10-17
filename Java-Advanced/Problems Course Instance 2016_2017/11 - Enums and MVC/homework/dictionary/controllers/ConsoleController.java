package dictionary.controllers;

import java.util.Collection;
import java.util.Scanner;
import dictionary.model.*;

public class ConsoleController {

	private enum Choice {
		ADD, SEARCH, REMOVE, LIST, EXIT, INVALID
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
			case REMOVE:
				remove();
				break;
			case LIST:
				listAll();
				break;
			case EXIT:
				System.out.println("Good bye!");
				shouldContinue = false;
				break;
			case INVALID:
				System.out.println("Invalid option");
				break;
			}

		} while (shouldContinue);
	}

	private Choice showMenu() {
		System.out.println();
		System.out.println("---MENU---");
		System.out.println("1. Add");
		System.out.println("2. Search");
		System.out.println("3. Remove");
		System.out.println("4. List all words");
		System.out.println("5. Exit");
		System.out.print("Select option: ");
		int c = sc.nextInt();
		sc.nextLine();
		System.out.println();

		switch (c) {
		case 1:
			return Choice.ADD;
		case 2:
			return Choice.SEARCH;
		case 3:
			return Choice.REMOVE;
		case 4:
			return Choice.LIST;
		case 5:
			return Choice.EXIT;
		default:
			return Choice.INVALID;
		}
	}

	private void addEntry() {
		System.out.print("Enter word: ");
		String word = sc.nextLine();
		System.out.print("Enter translation: ");
		String translation = sc.nextLine();
		System.out.print("Enter transcription: ");
		String transcription = sc.nextLine();
		Entry e = new Entry(word, translation, transcription);
		dictionary.add(e);

		System.out.println("Done");
	}

	private void search() {
		System.out.print("Enter word: ");
		String word = sc.nextLine();

		Entry e = dictionary.search(word);
		if (e != null) {
			System.out.println("Translation is: " + e.getTranslation() + " [" + e.getTranscription() + "]");
		} else {
			System.out.println("No such word exists");
		}
	}

	private void listAll() {
		System.out.println("Dictionary contents (sorted alphabetically):");
		
		Collection<Entry> entries = dictionary.getEntries();
		for(Entry entry : entries) {
			System.out.println(getEntryDetails(entry));
		}
	}

	private void remove() {
		System.out.print("Enter word to remove: ");
		String word = sc.nextLine();
		Entry removed = dictionary.remove(word);
		if (removed == null) {
			System.out.println(word + " not found in dictionary!");
		} else {
			System.out.println("Removed successfully: " + getEntryDetails(removed));
		}
	}

	private String getEntryDetails(Entry e) {
		return (e.getWord() + " - " + e.getTranslation() + " [" + e.getTranscription() + "]");
	}
}
