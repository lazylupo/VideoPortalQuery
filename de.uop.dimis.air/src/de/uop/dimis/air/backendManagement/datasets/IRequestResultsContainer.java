package de.uop.dimis.air.backendManagement.datasets;

import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;

/**
 * Defines ways to access the saved results for one request.
 * 
 * @author yakimov
 */
public interface IRequestResultsContainer {

	/**
	 * Builds the results of this object into an {@link MpegQueryType}.
	 * 
	 * @return - results of this object
	 */
	public MpegQueryType buildRes();

	/**
	 * Returns the time stamp until which this object is valid.
	 * 
	 * @return - time stamp until which this object is valid
	 */
	public long getTimeStamp();

}
