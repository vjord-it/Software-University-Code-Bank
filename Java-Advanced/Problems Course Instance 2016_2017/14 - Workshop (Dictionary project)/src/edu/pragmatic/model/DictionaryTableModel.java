package edu.pragmatic.model;

import javax.swing.table.AbstractTableModel;
import java.util.*;

@SuppressWarnings("serial")
public class DictionaryTableModel extends AbstractTableModel {

	private List<Entry> entries;
	
	public void setEntries(List<Entry> entries) {
		this.entries = entries;
		
		fireTableDataChanged();
	}
	
	@Override
	public int getRowCount() {		
		return (entries != null ? entries.size() : 0);
	}

	@Override
	public int getColumnCount() {		
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Entry entry = entries.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return entry.getWord();
		case 1:
			return entry.getTranscription();
		case 2:
			return entry.getTranslation();
		}
		
		return null;
	}

	@Override
	public String getColumnName(int column) {
		switch(column) {
		case 0:
			return "Word";
		case 1:
			return "Transcription";
		case 2:
			return "Translation";			
		}
		return null;
	}
}
