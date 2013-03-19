package de.uop.dimis.air.backendManagement.datasets;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;

/**
 * This class handles all saved results, for all requests.
 * 
 * @author yakimov
 */
public class SavedResultsHandler implements ISavedResultsHandler {
	/**
	 * request id as key, result (container) as result
	 */
	private Map<String, IRequestResultsContainer> savedResults = new HashMap<String, IRequestResultsContainer>();

	/**
	 * Adds a result to the saved results.
	 * 
	 * @param requestId -
	 *            the request id to save this under
	 * @param results -
	 *            the result to be saved
	 */
	public void addResult(String requestId, RequestResultsContainer results) {
		savedResults.put(requestId, results);
	}

	/**
	 * Removes results older than the given time stamp.
	 * 
	 * @param maxTimeStamp -
	 *            maximal age of the saved results
	 */
	public void cleanUpOld(long maxTimeStamp) {
		if (savedResults.size() > 0) {
			for (Entry<String, IRequestResultsContainer> entr : savedResults
					.entrySet()) {
				if (entr.getValue().getTimeStamp() < maxTimeStamp) {
					savedResults.remove(entr.getKey());
				}
			}
		}
	}

	/**
	 * Returns the builded (as {@link MpegQueryType}) result for the request
	 * id.
	 * 
	 * @param requestId -
	 *            id of the request we want the result for
	 * @return - builded result
	 */
	public MpegQueryType getResult(String requestId) {
		return savedResults.get(requestId).buildRes();
	}

	/**
	 * Removes the result for the specified request id from the saved results.
	 * 
	 * @param requestId -
	 *            result id for which to remove the saved result
	 */
	public void remove(String requestId) {
		savedResults.remove(requestId);
	}

}
