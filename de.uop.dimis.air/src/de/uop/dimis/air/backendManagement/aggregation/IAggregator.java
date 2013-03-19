package de.uop.dimis.air.backendManagement.aggregation;

import java.util.Collection;

import de.uop.dimis.air.backendManagement.datasets.SingleResultContainer;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;

/**
 * Defines a method all aggregators must implement, allowing the aggregation of
 * a result.
 * 
 * @author yakimov
 */
public interface IAggregator {

	/**
	 * Aggregates the given results map into one {@link MpegQueryType} object.
	 * 
	 * @param singlRsts -
	 *            results to be aggregated
	 * @return - {@link MpegQueryType} containing the aggregated results
	 */
	public MpegQueryType aggregate(Collection<SingleResultContainer> singlRsts);

}
