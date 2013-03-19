package de.uop.dimis.air.mpqfManagement.containers;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.mpqfManagement.NoSuchServiceException;
import de.uop.dimis.air.mpqfManagement.processing.QueryProcessor;
import de.uop.dimis.air.mpqfManagement.processing.SingleQueryProcessor;
import de.uop.dimis.air.mpqfManagement.processing.SubTreeProcessing;
import de.uop.dimis.air.mpqfManagement.strategies.BFS;
import de.uop.dimis.air.mpqfManagement.strategies.DFS;

/**
 * @author wolfgang This class contains all subqueries and responses of a query
 *         and the query itself. When created it processes the query to
 *         subqueries and the subqueries to responses.
 */
public class QueryContainer extends Thread {

	private MpegQueryType query;
	private SubQueryContainer subQueryContainer;
	private ConcurrentHashMap<String, List<MpegQueryType>> responses;
	
	private QueryStatus status = QueryStatus.pending;

	/**
	 * Constructor of the QueryContainer. Creates subqueries and if possible the
	 * responses by using search strategies and query processors.
	 * 
	 * @param query
	 *            Query to process
	 * @throws NoSuchServiceException
	 *             is thrown, when a query type is not supported by any backend
	 *             service
	 */
	public QueryContainer(MpegQueryType query) throws NoSuchServiceException {
		this.query = query;
	}

	// @Override
	public void run() {
		
		if (Config.DFS) {
			subQueryContainer = new SubQueryContainer(new DFS(), query);
		} else {
			subQueryContainer = new SubQueryContainer(new BFS(), query);
		}

		this.setStatus(QueryStatus.pending);
		// FIXME
		QueryProcessor processing;
		if (Config.SINGLE) {
			processing = new SingleQueryProcessor(this);
		} else {
			processing = new SubTreeProcessing(this);
		}
		this.setStatus(QueryStatus.retrieval);
		try {
			responses = processing.execute();
		} catch (NoSuchServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return Returns the list of responses of the subqueries. The ids of the
	 *         responses are the ids of the accordant subqueries.
	 */
	public ConcurrentHashMap<String, List<MpegQueryType>> getResponses() {
		return responses;
	}

	/**
	 * 
	 * @return Returns the query.
	 */
	public MpegQueryType getQuery() {
		return query;
	}

	/**
	 * 
	 * @return Returns the container of the subqueries.
	 */
	public SubQueryContainer getSubQueryContainer() {
		return subQueryContainer;
	}

	/**
	 * 
	 * @return Returns the status of the query
	 */
	public QueryStatus getStatus() {
		return status;
	}

	/**
	 * Method to set the status of the query
	 * 
	 * @param status
	 *            The status of the query is either pending, processing,
	 *            retrieval or finished.
	 */
	public void setStatus(QueryStatus status) {
		this.status = status;
	}

}
