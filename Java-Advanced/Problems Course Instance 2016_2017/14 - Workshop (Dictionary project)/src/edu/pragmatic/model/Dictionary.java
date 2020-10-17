package edu.pragmatic.model;

import edu.pragmatic.persistance.PersistanceManager;
import edu.pragmatic.persistance.SavingException;

import java.util.*;

public class Dictionary {
	
	private Map<String, Entry> entries;
	
	public Dictionary() {
		load();
	}
	
	public void add(Entry e) throws SavingException {
		entries.put(e.getWord(), e);
		save();
	}

	public Entry search(String word) {
		return entries.get(word);
	}
	
	public boolean delete(String word) throws SavingException {
		Entry entry = entries.remove(word);
		save();
		
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
	
	private void save() throws SavingException {
		PersistanceManager.save(entries.values());
	}
	
	private void load() {
		Collection<Entry> loadedEntries = PersistanceManager.load();
		entries = new HashMap<>();		
		for(Entry entry : loadedEntries) {
			entries.put(entry.getWord(), entry);
		}
	}
}
