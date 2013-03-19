package de.uop.dimis.air.backendManagement.datasets;

import java.util.Map;

import de.uop.dimis.air.backendManagement.tools.Constants;
import de.uop.dimis.air.backendManagement.tools.Context;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;

/**
 * This object is holding the saved results for one search request.
 * 
 * @author yakimov
 */
public class RequestResultsContainer implements IRequestResultsContainer {
	/**
	 * db id as key, result as value
	 */
	private Map<String, SingleResultContainer> results;
	/**
	 * time stamp until which this object is valid
	 */
	private long timeStamp;
	/**
	 * Context to search the aggregator for.
	 */
	private String aggregatorContext = Constants.DEFAULT;

	/**
	 * Creates a {@link RequestResultsContainer} with the set values.
	 * 
	 * @param timeStamp -
	 *            time stamp until which the object to be valid
	 * @param results -
	 *            a prepared map with results
	 */
	public RequestResultsContainer(long timeStamp,
			Map<String, SingleResultContainer> results) {
		this.timeStamp = timeStamp;
		this.results = results;
	}

	/**
	 * Builds the results of this object into an {@link MpegQueryType}.
	 * 
	 * @return - results of this object
	 */
	public MpegQueryType buildRes() {
		return Context.getAggregator(aggregatorContext).aggregate(
				results.values());
	}

	/**
	 * Returns the aggregator context for this results.
	 * 
	 * @return - aggregator context for this results
	 */
	public String getAggregatorContext() {
		return aggregatorContext;
	}

	/**
	 * Returns the time stamp until which this object is valid.
	 * 
	 * @return - time stamp until which this object is valid
	 */
	public long getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Sets the aggregator context for this results.
	 * 
	 * @param aggregatorContext -
	 *            aggregator context
	 */
	public void setAggregatorContext(String aggregatorContext) {
		this.aggregatorContext = aggregatorContext;
	}

}