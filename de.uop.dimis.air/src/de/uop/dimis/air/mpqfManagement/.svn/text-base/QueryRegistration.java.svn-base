package de.uop.dimis.air.mpqfManagement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.mpqfManagement.containers.QueryContainer;
import de.uop.dimis.air.mpqfManagement.containers.QueryStatus;

/**
 * 
 * @author wolfgang This class contains the query containers for every query
 *         which is being processed or is waiting for delivery. Each container
 *         has a unique id. There can only one instance of this class exist at a
 *         time.
 */
public class QueryRegistration {

	private HashMap<String, QueryContainer> queries;
	private static QueryRegistration queryRegistration;

	private QueryRegistration() {
		queries = new HashMap<String, QueryContainer>();
	}

	/**
	 * Method to get the instance of the QueryRegistration. If there is no
	 * instance it will be created and returned.
	 * 
	 * @return instance of QueryRegistration
	 */
	protected static QueryRegistration getInstance() {
		if (queryRegistration == null) {
			queryRegistration = new QueryRegistration();
		}
		return queryRegistration;
	}

	/**
	 * This method creates a container for each query with an unique id.
	 * 
	 * @param query
	 *            incoming query
	 * @throws NoSuchServiceException
	 *             is thrown, when a query type is not supported by any backend
	 *             service
	 * @return Returns the id of the checked in query
	 */
	protected String checkInNewQuery(MpegQueryType query) throws NoSuchServiceException {
		String id = getIdString();
		
		while (queries.get(id) != null) {
			id = getIdString();
		}
		
		query.setMpqfID(id);
		QueryContainer container = new QueryContainer(query);
		queries.put(id, container);
		container.start();
		
		return id;
	}

	private String getIdString() {
		Random r = new Random();
		long value = r.nextLong();
		return "ID_" + Long.toHexString(value).substring(0, 7);
	}

	protected QueryContainer getQuery(String id) {
		QueryContainer query = queries.get(id);

		if (query != null && (query.getStatus() == QueryStatus.finished || query.getStatus() == QueryStatus.processing)) {
			queries.remove(id);
		} 
		return query;
	}

	protected QueryStatus getQueryStatus(String id) {
		QueryStatus result = null;
		QueryContainer query = queries.get(id);
		
		if(query != null){
			result = query.getStatus();
		}
		
		return result;
	}
	
	public List<String> getFinishedQueries(){
		LinkedList<String> finishedIds = new LinkedList<String>();
		Set<String> keys = queries.keySet();
		for(String key : keys) {
			if(queries.get(key).getStatus() == QueryStatus.finished) {
				finishedIds.add(queries.get(key).getQuery().getMpqfID());
			}
		}
		return finishedIds;
	}
}
