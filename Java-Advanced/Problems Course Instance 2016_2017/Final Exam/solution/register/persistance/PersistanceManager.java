package register.persistance;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import register.model.Entry;

public final class PersistanceManager {
	
	private static final PersistanceManager INSTANCE = new PersistanceManager();
	
	private static final String SEPARATOR = ",";
	
	private PersistanceManager() {
		
	}
	
	public static PersistanceManager getInstance() {
		return INSTANCE;
	}
	
	public void save(Collection<Entry> entries, String file) throws SavingException {
		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
			for (Entry entry : entries) {
				String line = createString(entry);
				writer.println(line);
			}
		} catch (IOException e) {
			throw new SavingException();
		}
	}
	
	public Collection<Entry> load(String file) throws LoadingException {
		Collection<Entry> entries = new ArrayList<>();
		
		try (Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream(file)))) {			
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				Entry entry = createEntry(line);
				entries.add(entry);
			}
		} catch (FileNotFoundException e) {
			throw new LoadingException();		
		}
		
		return entries;
	}
	
	private String createString(Entry entry) {	
		StringBuilder builder = new StringBuilder();
		builder.append(entry.getDate()).append(SEPARATOR);
		builder.append(entry.getColor()).append(SEPARATOR);
		builder.append(entry.getBreed()).append(SEPARATOR);
		builder.append(entry.getSex()).append(SEPARATOR);
		builder.append(entry.getState()).append(SEPARATOR);
		builder.append(entry.getName()).append(SEPARATOR);
		builder.append(entry.getDateCreated());
		return builder.toString();
	}
	
	private Entry createEntry(String line) {
		String[] elements = line.split(SEPARATOR);
		
		return new Entry(elements[0], elements[1], elements[2], 
				elements[3], elements[4], elements[5], elements[6]);
	}	
}