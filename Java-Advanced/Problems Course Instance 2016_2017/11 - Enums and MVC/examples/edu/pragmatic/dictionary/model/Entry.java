package edu.pragmatic.dictionary.model;

public class Entry {

	private String word;
	private String translation;
	
	public Entry(String word, String translation) {
		super();
		this.word = word;
		this.translation = translation;
	}
	
	public String getWord() {
		return word;
	}
	
	public String getTranslation() {
		return translation;
	}
}
