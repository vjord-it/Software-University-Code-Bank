package edu.pragmatic.enums;

public enum Day {

	MONDAY("mon"), 
	TUESDAY("tue"),
	WEDNESDAY("wed"),
	THURSDAY("thu"),
	FRIDAY("fri"),
	SATURDAY("sat"),
	SUNDAY("sun");
	
	private String shortName;
	
	Day(String shortName) {
		this.shortName = shortName;
	}
	
	public String getShortName() {
		return shortName;
	}
	
}
