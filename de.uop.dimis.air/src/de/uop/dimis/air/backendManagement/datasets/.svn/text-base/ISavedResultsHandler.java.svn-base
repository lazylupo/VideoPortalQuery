package de.uop.dimis.air.backendManagement.datasets;

import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;

/**
 * Defines ways for accessing saved results for all requests.
 * 
 * @author yakimov
 */
public interface ISavedResultsHandler {

	/**
	 * Adds a result to the saved results.
	 * 
	 * @param requestId -
	 *            the request id to save this under
	 * @param results -
	 *            the result to be saved
	 */
	public void addResult(String requestId, RequestResultsContainer results);

	/**
	 * Removes results older than the given time stamp.
	 * 
	 * @param maxTimeStamp -
	 *            maximal age of the saved results
	 */
	public void cleanUpOld(long maxTimeStamp);

	/**
	 * Returns the builded (as {@link MpegQueryType}) result for the request
	 * id.
	 * 
	 * @param requestId -
	 *            id of the request we want the result for
	 * @return - builded result
	 */
	public MpegQueryType getResult(String requestId);

	/**
	 * Removes the result for the specified request id from the saved results.
	 * 
	 * @param requestId -
	 *            result id for which to remove the saved result
	 */
	public void remove(String requestId);

}
