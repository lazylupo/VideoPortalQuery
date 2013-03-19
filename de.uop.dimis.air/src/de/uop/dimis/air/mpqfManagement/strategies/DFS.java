package de.uop.dimis.air.mpqfManagement.strategies;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
 * This class represents the depth-first search strategy to walk through the query tree
 */
public class DFS implements SearchStrategy {

	private int[] layers = new int[10];
	private LinkedList<Node> nodes;
	private int indexKey;

	
	/**
	 * @see de.uop.dimis.air.mpqfManagement.strategies.SearchStrategy#execute()
	 */
	public void listConditions(QueryConditionType query,
			LinkedList<Node> queryTypes,
			LinkedList<Node> comparisonExpressionTypes, LinkedList<Node> all) {

		nodes = all;
		BooleanExpressionType expression = query.getCondition();
		dfs(expression, queryTypes, comparisonExpressionTypes, all, 0);
		for(Node node : all) {
			if(node.getExpression() instanceof QueryType) {
			node.addType(getCapName(node.getExpression()));
		}
		}
		correctLayers();
		Collections.sort(all);
	}




	private void correctLayers() {
		int numberOfLayers = 0;
		for (Node current : nodes) {
			if (current.getLayer() < numberOfLayers) {
				numberOfLayers = current.getLayer();
			}
		}

		numberOfLayers = -1 * numberOfLayers;
		indexKey = numberOfLayers + 1;

		for (Node current : nodes) {
			current.setLayer(current.getLayer() + numberOfLayers);
		}

		for (int i = 0; i < layers.length; i++) {
			if (layers[i] >= indexKey) {
				indexKey = layers[i];
			}
		}
	}

	private Node dfs(BooleanExpressionType expression,
			LinkedList<Node> queryTypes,
			LinkedList<Node> comparisonExpressionTypes, LinkedList<Node> all,
			int currentLayer) {

		Node node = new Node(incrementNumberOfNodes(currentLayer),
				currentLayer, expression);
		Node child = null;
		if (expression instanceof AND) {
			all.add(node);
			List<BooleanExpressionType> expressions = ((AND) expression)
					.getCondition();
			for (BooleanExpressionType current : expressions) {
				child = dfs(current, queryTypes, comparisonExpressionTypes,
						all, currentLayer - 1);
				if(child != null) {
					node.getChildren().add(child);
					child.setParent(node);
				}
			}

		} else if (expression instanceof NOT) {
			all.add(node);
			child = dfs(((NOT) expression).getCondition(), queryTypes,
					comparisonExpressionTypes, all, currentLayer - 1);
			if(child != null) {
				node.getChildren().add(child);
				child.setParent(node);
			}
		} else if (expression instanceof OR) {
			all.add(node);
			List<BooleanExpressionType> expressions = ((OR) expression)
					.getCondition();
			for (BooleanExpressionType current : expressions) {
				child = dfs(current, queryTypes, comparisonExpressionTypes,
						all, currentLayer - 1);
				if(child != null) {
					node.getChildren().add(child);
					child.setParent(node);
				}
			}
		} else if (expression instanceof XOR) {
			all.add(node);
			List<BooleanExpressionType> expressions = ((XOR) expression)
					.getCondition();
			for (BooleanExpressionType current : expressions) {
				child = dfs(current, queryTypes, comparisonExpressionTypes,
						all, currentLayer - 1);
				if(child != null) {
					node.getChildren().add(child);
					child.setParent(node);
				}
			}
		} else if (expression instanceof ComparisonExpressionType) {
			
			comparisonExpressionTypes.add(node);
			all.add(node);
//			if(child != null) {
//				node.getChildren().add(child);			
//				child.setParent(node);	
//			}
//			node.addType(getCapName(expression));
		} else if (expression instanceof QueryType) {
			
			all.add(node);
			queryTypes.add(node);
//			if(child != null) {
//				node.getChildren().add(child);			
//				child.setParent(node);	
//			}
//			node.addType(getCapName(expression));
		}

		return node;
	}

	private void morelayers() {
		int[] temp = new int[layers.length + 10];
		for (int i = 0; i < layers.length; i++) {
			temp[i] = layers[i];
		}
		layers = temp;
	}

	private int incrementNumberOfNodes(int layer) {
		int current = 0;

		try {
			current = layers[layer + (-2 * layer)];
		} catch (ArrayIndexOutOfBoundsException e) {
			morelayers();
		} finally {
			layers[layer + (-2 * layer)]++;
		}
		return current;
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
