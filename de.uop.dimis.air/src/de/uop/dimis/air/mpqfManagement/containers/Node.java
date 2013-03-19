package de.uop.dimis.air.mpqfManagement.containers;

import java.util.ArrayList;
import java.util.List;

import de.uop.dimis.air.internalObjects.mpqf.BooleanExpressionType;
/**
 * 
 * @author wolfgang
 * This is a container class for BooleanExpressionType treenodes 
 * Each Node object has references to its children and its parent, so that the 
 * tree can be traversed bottom up and top down, which is necessary for SubTreeProcessing
 * Also each node contains a list of ids of all nodes below it and a list of all
 * query types below it.
 */
public class Node implements Comparable<Node> {

	private int index;
	private int layer;
	private BooleanExpressionType expression;
	private ArrayList<String> idList;
	private ArrayList<String> typeList;
	private ArrayList<Node> children;
	private Node parent;
	private String id;
	
	/**
	 * Constructor of a Node object.
	 * @param index if the index position is known at the time of creation it is set
	 * here, else it can be set later. In this case 0 should be inserted
	 * Index is the position of the node in the current layer of the tree
	 * @param layer if the layer is known at the time of creation it is set here, else
	 * it can be set later. In this case 0 should be inserted
	 * layer is the layer where the node is located in the tree.
	 * @param expression the BooleanExpression to contain.
	 */
	public Node(int index, int layer, BooleanExpressionType expression) {
		this.index = index;
		this.layer = layer;
		this.expression = expression;
		idList = new ArrayList<String>();
		typeList = new ArrayList<String>();
		children = new ArrayList<Node>();
	}
	

	/**
	 * @return list of the children of the node.
	 * If the node is a leaf the list is empty.
	 */
	public ArrayList<Node> getChildren() {
		return children;
	}

	/**
	 * Method to set a reference to the parent node.
	 * @param node parent node
	 */
	public void setParent(Node node) {
		parent = node;
	}
	
	/**
	 * @return parent node. 
	 * Returns null if the current node is the root of the tree.
	 */
	public Node getParent() {
		return parent;
	}
	
	/**
	 * @return index of the node
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * Method to belatedly set the index of the node
	 * @param index index of the node
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * Adds an id of an other node to the id list.
	 * The id is only added if it is not already in the list.
	 * @param id to be added
	 */
	public void addId(String id) {
		if (!listContains(idList, id)) {
			idList.add(id);
			Node node = this;
			while (node.getParent() != null) {
				node = node.getParent();
				node.addId(id);
			}
		}
	}

	/**
	 * Adds an query type of an other node to the type list.
	 * The query type is only added if it is not already in the list.
	 * @param type query type to add
	 */
	public void addType(String type) {
		if (!listContains(typeList, type)) {
			typeList.add(type);
			Node node = this;
			while (node.getParent() != null) {
				node = node.getParent();
				node.addType(type);
			}
		}
	}

	/**
	 * @return Returns the layer of the node.
	 */
	public int getLayer() {
		return layer;
	}
	
	/**
	 * Method to set the layer of the node.
	 * @param layer Layer to set.
	 */
	public void setLayer(int layer) {
		this.layer = layer;
	}

	/**
	 * @return Returns the BooleanExpressionType contained by the node.
	 */
	public BooleanExpressionType getExpression() {
		return expression;
	}

	@Override
	public int compareTo(Node o) {
		int aux = 0;
		if (layer > o.layer) {
			aux = 1;
		} else if (layer == o.layer && index > o.index) {
			aux = 1;
		} else if (layer == o.layer && index < o.index) {
			aux = -1;
		} else if (layer < o.layer) {
			aux = -1;
		}
		return aux;
	}

	/**
	 * @return Returns the idList of the node.
	 */
	public List<String> getIdList() {
		return idList;
	}

	/**
	 * @return Returns the typeList of the node.
	 */
	public List<String> getTypeList() {
		return typeList;
	}

	private boolean listContains(List<String> list, String element) {
		boolean contains = false;
		for (String current : list) {
			if (current.equals(element)) {
				contains = true;
			}
		}
		return contains;
	}

	/**
	 * Method to set the id for the node.
	 * @param id id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return Returns the id of the node.
	 */
	public String getId() {
		return id;
	}
}