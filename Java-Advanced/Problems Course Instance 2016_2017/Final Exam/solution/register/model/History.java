package register.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class History {

	private Deque<IndexedEntry> history;
	private Deque<Integer> entriesCount;

	public History() {
		history = new ArrayDeque<>();
		entriesCount = new ArrayDeque<>();
	}

	public void push(Entry entry, int index) {
		history.push(new IndexedEntry(entry, index));
	}

	public IndexedEntry pop() {
		return history.pop();
	}

	public boolean isEmpty() {
		return history.isEmpty();
	}

	public void clear() {
		history.clear();
		entriesCount.clear();
	}
	
	public void pushEntriesCount(int entriesCount) {
		this.entriesCount.push(entriesCount);
	}
	
	public int popEntriesCount() {
		return entriesCount.pop();
	}
}