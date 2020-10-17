package edu.pragmatic.model;

import java.util.*;

public class Dictionary {
	
	private Map<String, Entry> entries;
	
	public Dictionary() {
		entries = new HashMap<>();
	}
	
	public void add(Entry e) {
		entries.put(e.getWord(), e);
	}

	public Entry search(String word) {
		return entries.get(word);
	}
	
	public boolean delete(String word) {
		Entry entry = entries.remove(word);
		
		return (entry != null);
	}
	
	public List<Entry> getSortedWordEntries() {
		List<Entry> allWordEntries = new ArrayList<>(entries.values());
		Collections.sort(allWordEntries, new Comparator<Entry>() {
			@Override
			public int compare(Entry o1, Entry o2) {
				String firstWord = o1.getWord();
				String secondWord = o2.getWord();
				
				return firstWord.compareTo(secondWord);
			}			
		});
		
		return allWordEntries;
	}
}
