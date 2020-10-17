package dictionary.model;

import java.util.*;

import dictionary.model.Entry;

public class Dictionary {

	private Map<String, Entry> entries;

	public Dictionary() {
		entries = new TreeMap<>();
	}

	public void add(Entry e) {
		entries.put(e.getWord(), e);
	}

	public Entry search(String word) {
		return entries.get(word);
	}

	public Entry remove(String word) {
		return entries.remove(word);
	}

	public Collection<Entry> getEntries() {
		return Collections.unmodifiableCollection(entries.values());
	}
}
