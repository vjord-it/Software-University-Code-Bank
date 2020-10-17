package edu.pragmatic.model;

public class Entry {

	private String word;
	private String translation;
	private String transcription;
	
	public Entry(String word, String translation, String transcription) {
		super();
		this.word = word;
		this.translation = translation;
		this.transcription = transcription;
	}
	
	public String getWord() {
		return word;
	}
	
	public String getTranslation() {
		return translation;
	}
	
	public String getTranscription() {
		return transcription;
	}
}
