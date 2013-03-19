package de.uop.dimis.air.mpqfManagement;

public class NoSuchServiceException extends Exception {
	/**
	 * this exception should be thrown, when a query type
	 * is not supported by any backend service
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchServiceException(String message) {
		super(message);
	}
}
