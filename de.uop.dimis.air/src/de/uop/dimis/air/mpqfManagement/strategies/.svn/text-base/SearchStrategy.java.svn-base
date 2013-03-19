package de.uop.dimis.air.mpqfManagement.strategies;

import java.util.LinkedList;

import de.uop.dimis.air.internalObjects.mpqf.QueryConditionType;
import de.uop.dimis.air.mpqfManagement.containers.Node;

/**
 * 
 * @author wolfgang
 * Interface for the strategies to walk through the query tree
 */
public interface SearchStrategy {

	/**
	 * Lists the subqueries and stores them according to their type in the lists
	 * @param query This is the query to process
	 * @param queryTypes The list where the QueryType objects will be stored
	 * @param comparisonExpressionTypes The list where the ComparisonExpressionType
	 * objects will be stored
	 * @param all The list where all BooleanExpressionTypes will be stored.
	 */
	public void listConditions(QueryConditionType query,
			LinkedList<Node> queryTypes,
			LinkedList<Node> comparisonExpressionTypes,
			LinkedList<Node> all);
	
	/**
	 * The value of the indexKey is max(layers, max(nodes at layer x)) + 1.
	 * @return Returns the index key of the query tree which is used to compute the 
	 * layer and the index of a subquery out of its id.
	 * 
	 */
	public int getIndexKey();

}
