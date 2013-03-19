package de.uop.dimis.air.mpqfManagement.strategies;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import de.uop.dimis.air.internalObjects.mpqf.AND;
import de.uop.dimis.air.internalObjects.mpqf.BooleanExpressionType;
import de.uop.dimis.air.internalObjects.mpqf.ComparisonExpressionType;
import de.uop.dimis.air.internalObjects.mpqf.NOT;
import de.uop.dimis.air.internalObjects.mpqf.OR;
import de.uop.dimis.air.internalObjects.mpqf.QueryByDescription;
import de.uop.dimis.air.internalObjects.mpqf.QueryByFeatureRange;
import de.uop.dimis.air.internalObjects.mpqf.QueryByFreeText;
import de.uop.dimis.air.internalObjects.mpqf.QueryByMedia;
import de.uop.dimis.air.internalObjects.mpqf.QueryByRelevanceFeedback;
import de.uop.dimis.air.internalObjects.mpqf.QueryBySPARQL;
import de.uop.dimis.air.internalObjects.mpqf.QueryByXQuery;
import de.uop.dimis.air.internalObjects.mpqf.QueryConditionType;
import de.uop.dimis.air.internalObjects.mpqf.QueryType;
import de.uop.dimis.air.internalObjects.mpqf.SpatialQuery;
import de.uop.dimis.air.internalObjects.mpqf.TemporalQuery;
import de.uop.dimis.air.internalObjects.mpqf.XOR;
import de.uop.dimis.air.mpqfManagement.containers.Node;

/**
 * 
 * @author wolfgang
 * This class represents the breadth-first search strategy to walk through the query tree
 */
public class BFS implements SearchStrategy {
	
	private int indexKey;
	private int layerEnd = 0;
	private int currentLayer = 0;
	private int maxLayers = 0;
	private int counter = 0;
	private int maxCounter = 0;

	private void correctLayers(LinkedList<Node> nodes) {
		for(Node current : nodes) {
			current.setLayer(current.getLayer() + maxLayers - 1);
		}
	}

	/**
	 * @see de.uop.dimis.air.mpqfManagement.strategies.SearchStrategy#execute()
	 */
	public void listConditions(QueryConditionType query,
			LinkedList<Node> queryTypes,
			LinkedList<Node> comparisonExpressionTypes, LinkedList<Node> all) {


		BooleanExpressionType expression = query.getCondition();
		Queue<Node> queue = new ArrayDeque<Node>();
		Node node = new Node(counter, currentLayer, expression);
		queue.offer(node);

		while (!queue.isEmpty()) {
			Node childNode = null;
			node = queue.poll();
			node.setIndex(counter);
			node.setLayer(currentLayer);
			expression = node.getExpression();
			all.add(node);
			if (expression instanceof AND) {
				List<BooleanExpressionType> list = ((AND) expression)
						.getCondition();
				for (BooleanExpressionType current : list) {
					childNode = new Node(0,0,current);
					childNode.setParent(node);
					node.getChildren().add(childNode);
					queue.offer(childNode);
				}
			} else if (expression instanceof NOT) {
				childNode = new Node(0,0,((NOT) expression).getCondition());
				childNode.setParent(node);
				node.getChildren().add(childNode);
				queue.offer(childNode);
			} else if (expression instanceof OR) {
				List<BooleanExpressionType> list = ((OR) expression)
						.getCondition();
				for (BooleanExpressionType current : list) {
					childNode = new Node(0,0,current);
					childNode.setParent(node);
					node.getChildren().add(childNode);
					queue.offer(childNode);
				}
			} else if (expression instanceof XOR) {
				List<BooleanExpressionType> list = ((XOR) expression)
						.getCondition();
				for (BooleanExpressionType current : list) {
					childNode = new Node(0,0,current);
					childNode.setParent(node);
					node.getChildren().add(childNode);
					queue.offer(childNode);
				}

			} else if (expression instanceof ComparisonExpressionType) {
				node.addType(getCapName(expression));
				comparisonExpressionTypes.add(node);
			} else if (expression instanceof QueryType) {
				node.addType(getCapName(expression));
				queryTypes.add(node);
			}
			if(counter == layerEnd) {
				layerEnd = queue.size() - 1 ;
				currentLayer--;
				if(counter > maxCounter) {
					maxCounter = counter;
				}
				maxLayers = currentLayer * (-1);
				counter = 0;
			} else {
				counter++;
			}
		}
		
		if(maxCounter > maxLayers) {
			indexKey = maxCounter + 1;
		} else {
			indexKey = maxLayers + 1;
		}
		correctLayers(all);
		Collections.sort(all);
	}

	/**
	 * @see de.uop.dimis.air.mpqfManagement.strategies.SearchStrategy#getIndexKey()
	 */
	public int getIndexKey() {
		return indexKey;
	}
	
	private String getCapName(BooleanExpressionType expression) {
		String cap = null;
		if (expression instanceof QueryByDescription) {
			cap ="urn:mpeg:mpqf:2008:CS:full:100.3.6.2";
		} else if (expression instanceof QueryByFeatureRange) {
			cap ="urn:mpeg:mpqf:2008:CS:full:100.3.6.6";
		} else if (expression instanceof QueryByFreeText) {
			cap ="urn:mpeg:mpqf:2008:CS:full:100.3.6.3";
		} else if (expression instanceof QueryByMedia) {
			cap ="urn:mpeg:mpqf:2008:CS:full:100.3.6.1";
		} else if (expression instanceof QueryByRelevanceFeedback) {
			cap ="urn:mpeg:mpqf:2008:CS:full:100.3.6.5";
		} else if (expression instanceof QueryByXQuery) {
			cap ="urn:mpeg:mpqf:2008:CS:full:100.3.6.4";
		} else if (expression instanceof SpatialQuery) {
			cap ="urn:mpeg:mpqf:2008:CS:full:100.3.6.7";
		} else if (expression instanceof TemporalQuery) {
			cap ="urn:mpeg:mpqf:2008:CS:full:100.3.6.8";
		} else if (expression instanceof QueryBySPARQL) {
			cap = "urn:mpeg:mpqf:2008:CS:full:100.3.6.10";
		}
		return cap;
	}

}
