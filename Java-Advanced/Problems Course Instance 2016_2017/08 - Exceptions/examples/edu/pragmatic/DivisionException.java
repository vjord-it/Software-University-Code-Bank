package edu.pragmatic;

import java.util.Date;

@SuppressWarnings("serial")
public class DivisionException extends Exception {
	
	private Date date;
	
	public DivisionException(String message, Date date) {
		super(message);
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
}
