package de.uop.dimis.air.backendManagement.datasets;

import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;

/**
 * Contains the result for one database for one request.
 * 
 * @author yakimov
 */
public class SingleResultContainer {
	/**
	 * result of the request
	 */
	private MpegQueryType value = null;

	/**
	 * Constructs a new {@link SingleResultContainer}.
	 */
	public SingleResultContainer() {
		super();
	}

	/**
	 * Gets the result of the search.
	 * 
	 * @return - result of the search. Will be <code>null</code> if no
	 *         response has arrived
	 */
	public MpegQueryType getValue() {
		return value;
	}

	/**
	 * Sets the result for this search.
	 * 
	 * @param value -
	 *            result for this search
	 */
	public void setValue(MpegQueryType value) {
		System.out.println("saving value : " + value.getMpqfID());
		this.value = value;
	}

}
