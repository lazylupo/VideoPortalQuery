package de.uop.dimis.air.mpqfManagement.processing;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.mpqfManagement.NoSuchServiceException;

/**
 * 
 * @author wolfgang
 * Interface for classes which process a set of MpegQueries.
 */
public interface QueryProcessor{

	/**
	 * Processes the subqueries to get the responses.
	 * @return Returns the responses to the subqueries
	 * @throws NoSuchServiceException is thrown, when a query type is not supported
	 * by any backend service
	 */
	public ConcurrentHashMap<String, List<MpegQueryType>> execute() throws NoSuchServiceException;

}