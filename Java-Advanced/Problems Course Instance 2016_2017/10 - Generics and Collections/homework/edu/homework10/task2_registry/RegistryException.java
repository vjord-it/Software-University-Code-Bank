package edu.homework10.task2_registry;

public class RegistryException extends Exception {

	private static final long serialVersionUID = 1126333868701157188L;

	public RegistryException() {
		super();
	}

	/**
	 * @param message
	 */
	public RegistryException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public RegistryException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public RegistryException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public RegistryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}