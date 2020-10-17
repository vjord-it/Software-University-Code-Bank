/**
 * 
 */
package edu.homework08.exceptions.custom;

public class InvalidStudentDataException extends Exception {

	private static final long serialVersionUID = 1126333868701157188L;

	public InvalidStudentDataException() {
		super();
	}

	/**
	 * @param message
	 */
	public InvalidStudentDataException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidStudentDataException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidStudentDataException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidStudentDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
