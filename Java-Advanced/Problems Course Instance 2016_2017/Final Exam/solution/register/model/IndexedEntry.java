package register.model;

public class IndexedEntry {
	
	private int index;
	private Entry entry;

	public IndexedEntry(Entry entry, int index) {
		this.entry = entry;
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public Entry getEntry() {
		return entry;
	}
}