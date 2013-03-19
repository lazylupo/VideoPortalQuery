package de.uop.dimis.air.mpqfManagement.containers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.uop.dimis.air.internalObjects.mpqf.BooleanExpressionType;
import de.uop.dimis.air.internalObjects.mpqf.InputQueryType;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.internalObjects.mpqf.QueryConditionType;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType.Query;
import de.uop.dimis.air.mpqfManagement.strategies.SearchStrategy;

/**
 * 
 * @author wolfgang
 * This class creates and contains the subqueries of a query.
 */
public class SubQueryContainer {

	private LinkedList<Node> queryTypes = new LinkedList<Node>();
	private LinkedList<Node> comparisonExpressionTypes = new LinkedList<Node>();
	private LinkedList<Node> all = new LinkedList<Node>();
	private SearchStrategy strategy;
	private MpegQueryType query;

	/**
	 * Constructor of SubQueryContainer 
	 * @param strategy Instance of the SearchStrategy which is used to create the 
	 * subqueries
	 * @param query The Query where the subqueries are to be extracted
	 */
	public SubQueryContainer(SearchStrategy strategy, MpegQueryType query) {
		this.strategy = strategy;
		this.query = query;

		strategy.listConditions(
				query.getQuery().getInput().getQueryCondition(), queryTypes,
				comparisonExpressionTypes, all);
	}
	
	/**
	 * Creates valid MpegQueries out of the subqueries and returns them as list.
	 * @return Returns the list of valid subqueries. 
	 */
	public ArrayList<MpegQueryType> listSubQueries() {
		ArrayList<MpegQueryType> list = new ArrayList<MpegQueryType>();
		int key = strategy.getIndexKey();
		for (Node current : queryTypes) {
			StringBuilder sb = new StringBuilder();
			sb.append(query.getMpqfID());
			int id = (current.getLayer() * key) + current.getIndex();
			sb.append(id);
			String subQueryId = sb.toString();

			BooleanExpressionType expression = current.getExpression();
			MpegQueryType mpegQuery = new MpegQueryType();
			Query temp = new Query();
			mpegQuery.setQuery(temp);
			InputQueryType inputQueryType = new InputQueryType();
			temp.setInput(inputQueryType);
			QueryConditionType condition = new QueryConditionType();
			inputQueryType.setQueryCondition(condition);
			condition.setCondition(expression);
			mpegQuery.setMpqfID(subQueryId);
			list.add(mpegQuery);
		}
		return list;
	}
	
	/**
	 * 
	 * @return Returns the indexKey which is needed to compute the location of the 
	 * subquery in the tree out of its id.
	 */
	public int getIndexKey(){
		return strategy.getIndexKey();
	}

	/**
	 * @return Returns all nodes of the query tree.
	 */
	public List<Node> getAllQueries() {
		return all;
	}

}
