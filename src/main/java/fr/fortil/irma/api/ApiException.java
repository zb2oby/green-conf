package fr.fortil.irma.api;

public class ApiException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3646332302743566850L;

	public ApiException(int code, String msg) {
		super(msg);
	}
}
