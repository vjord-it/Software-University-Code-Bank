package edu.pragmatic.persistance;

import java.util.*;
import edu.pragmatic.model.Entry;
import java.io.*;

public class PersistanceManager {

	private static final String SEPARATOR = "=";
	private static final String FILE_NAME = "words.txt";
	
	public static void save(Collection<Entry> entries) throws SavingException {
		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME)))) {
			
			for (Entry entry : entries) {
				String line = createString(entry);
				writer.println(line);
			}
		} catch (IOException e) {
			throw new SavingException();
		}
	}
	
	public static Collection<Entry> load() /*throws LoadingException*/ {
		Collection<Entry> entries = new ArrayList<>();
		
		try (Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream(FILE_NAME)))) {			
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				Entry entry = createEntry(line);
				entries.add(entry);
			}
		} catch (FileNotFoundException e) {
			return entries;		
		}
		
		return entries;
	}
	
	private static String createString(Entry entry) {
		StringBuilder builder = new StringBuilder();
		builder.append(entry.getWord());
		builder.append(SEPARATOR);
		builder.append(entry.getTranslation());
		builder.append(SEPARATOR);
		builder.append(entry.getTranscription());
		
		return builder.toString();
	}
	
	private static Entry createEntry(String line) {
		String[] elements = line.split(SEPARATOR);
		
		return new Entry(elements[0], elements[1], elements[2]);
	}
}
