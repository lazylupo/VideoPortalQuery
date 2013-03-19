package de.uop.dimis.air.backendManagement.aggregation;

import java.util.Collection;

import de.uop.dimis.air.backendManagement.datasets.SingleResultContainer;
import de.uop.dimis.air.backendManagement.tools.ResultTools;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;

/**
 * Implements {@link IAggregator} and provides an implementation for its
 * aggregation of results.
 * 
 * @author yakimov
 */
public class Aggregator implements IAggregator {

	/**
	 * Aggregates the given results map into one {@link MpegQueryType} object.
	 * 
	 * @param singlRsts -
	 *            results to be aggregated
	 * @return - {@link MpegQueryType} containing the aggregated results
	 */
	public MpegQueryType aggregate(Collection<SingleResultContainer> singlRsts) {
		return ResultTools.buildMap(singlRsts);
	}

}
