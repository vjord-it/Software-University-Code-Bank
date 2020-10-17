package bg.pragmatic.uniquechars;

import java.util.*;

public class UniqueChars {
	public Collection<Character> getUniqueChars(String original) {
		if (original == null || original.isEmpty())
			return null;
		
		char[] allLetters = original.toCharArray();
		Set<Character> uniqueChars = new HashSet<>();
		for (char c : allLetters) {
			uniqueChars.add(c);
		}
		
		return uniqueChars; 
	}
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			String text = sc.nextLine();
			
			UniqueChars u = new UniqueChars();
			Collection<Character> characters = u.getUniqueChars(text);
			if(characters != null) {
				for(Character ch : characters) {
					System.out.print(ch);
				}
			}
		}
	}
}
