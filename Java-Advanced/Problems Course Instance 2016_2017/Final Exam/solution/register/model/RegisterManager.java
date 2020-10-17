package register.model;

import java.util.ArrayList;
import java.util.Collection;

import register.persistance.LoadingException;
import register.persistance.PersistanceManager;
import register.persistance.SavingException;

public final class RegisterManager {

	private PersistanceManager persistanceManager;
	private History history;
	private Register register;

	public RegisterManager(PersistanceManager persistanceManager, History history, Register register) {
		super();
		this.persistanceManager = persistanceManager;
		this.history = history;
		this.register = register;
	}

	public void loadData(String file) throws LoadingException {
		this.register.initEntries(persistanceManager.load(file));
		history.clear();
	}

	public void saveData(String file) throws SavingException {
		PersistanceManager.getInstance().save(getEntries(), file);
	}

	public void deleteEntries(int[] indexes) {
		int deletedEntries = 0;
		for (int index = indexes.length -1; index >= 0; index--) {
			if (deleteEntry(indexes[index])) {
				deletedEntries++;
			}
		}
		history.pushEntriesCount(deletedEntries);
	}
	
	public Entry getEntry(int index) {
		return register.getEntry(index);
	}

	public Collection<Integer> undoLast() {
		Collection<Integer> restoredRows = new ArrayList<>(); 
		if (canUndo()) {
			int lastDeletedCount = history.popEntriesCount();
			for (int i = 0; i < lastDeletedCount; i++) {
				IndexedEntry indexedEntry = history.pop();
				addEntry(indexedEntry.getEntry(), indexedEntry.getIndex());
				restoredRows.add(indexedEntry.getIndex());
			}
		}
		return restoredRows;
	}
	
	private void addEntry(Entry entry, int index) {
		register.addEntry(entry, index);
	}
	
	private boolean deleteEntry(int index) {
		Entry entry = register.deleteEntry(index);
		if (entry != null) {
			history.push(entry, index);
			return true;
		}
		return false;
	}
	
	public boolean canUndo() {
		return !history.isEmpty();
	}

	public int getRegisterSize() {
		return register.getSize();
	}
	
	public int getEntryPropertiesCount() {
		return Entry.PROPERTIES_COUNT;
	}
	
	public String getPropertyName(int index) {
		return Entry.getPropertyName(index);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Entry entry = register.getEntry(rowIndex);
		if (entry != null) {
			return entry.getPropertyValue(columnIndex);
		}
		return null;
	}
	
	public Collection<Entry> getEntries() {
		return register.getEntries();
	}
}