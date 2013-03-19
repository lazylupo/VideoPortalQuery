package de.uop.dimis.air.mpqfManagement.processing;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.mpqfManagement.NoSuchServiceException;
import de.uop.dimis.air.mpqfManagement.containers.QueryContainer;

/**
 * 
 * @author wolfgang
 * This class processes whole subtrees of the query if possible.
 * This is faster than SingleQueryProcessing if there are services that 
 * support more than one query type.
 * Else subqueries are processed one by one.
 */
public class SubTreeProcessing implements QueryProcessor {

//	private QueryContainer container;
	private ConcurrentHashMap<String, List<MpegQueryType>> responses;
//	private HashMap<String, HashMap<String, Boolean>> sentQueries;

	/**
	 * Constructor of the SubTreeProcessing
	 * @param container QueryContainer which contains the subqueries to process
	 */
	public SubTreeProcessing(QueryContainer container) {
		super();
//		this.container = container;
		responses = new ConcurrentHashMap<String, List<MpegQueryType>>();
//		sentQueries = new HashMap<String, HashMap<String, Boolean>>();
	}

	/**
	 * @see de.medico.queryBroker.mpqfManagement.processing.QueryProcessors#execute()
	 */
	public ConcurrentHashMap<String, List<MpegQueryType>> execute()
			throws NoSuchServiceException {
//
//		List<Node> nodes = prepareSubTrees();
//		for (int i = nodes.size() - 1; i >= 0; i--) {
////		for (int i = 0; i < nodes.size(); i++) {
//			Node node = nodes.get(i);
//			try {
//				OMElement discovery = buildCapabilityDesc(node.getTypeList());
//				List<AvailableCapabilityType> caps = getServices(discovery);
//				if (caps != null && caps.size() > 0) {
//					for (AvailableCapabilityType capType : caps) {
//						String host = capType.getServiceID();
//						if (sentQueries.get(node.getId()) == null
//								|| sentQueries.get(node.getId()).get(host) == null
//								|| sentQueries.get(node.getId()).get(host) == false) {
//							MpegQueryType mpegQuery = buildQueryFromNode(node);
//								executeQuery(mpegQuery, host);
//							
//							for (String current : node.getIdList()) {
//								if (sentQueries.get(current) == null) {
//									sentQueries.put(current,
//											new HashMap<String, Boolean>());
//								}
//								HashMap<String, Boolean> queryHosts = sentQueries
//										.get(current);
//								queryHosts.put(host, true);
//							}
//						}
//					}
//				}
//
//			} catch (JAXBException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		container.setStatus(QueryStatus.finished);
		return responses;
	}

//	private List<AvailableCapabilityType> getServices(OMElement element)
//			throws JAXBException {
//		List<AvailableCapabilityType> list = null;
//		// TODO implement
//		System.out.println("SubTreeProcessing getServices not implemented yet");
//		return list;
//	}

//	private MpegQueryType buildQueryFromNode(Node node) {
//		BooleanExpressionType expression = node.getExpression();
//		MpegQueryType mpegQuery = new MpegQueryType();
//		Query temp = new Query();
//		mpegQuery.setQuery(temp);
//		InputQueryType inputQueryType = new InputQueryType();
//		temp.setInput(inputQueryType);
//		QueryConditionType condition = new QueryConditionType();
//		inputQueryType.setQueryCondition(condition);
//		condition.setCondition(expression);
//		mpegQuery.setMpqfID(node.getId());
//		return mpegQuery;
//	}
//
//	private List<Node> prepareSubTrees() {
//		List<Node> subQueries = container.getSubQueryContainer()
//				.getAllQueries();
//		for (Node node : subQueries) {
//			String queryId = container.getQuery().getMpqfID();
//			int indexKey = container.getSubQueryContainer().getIndexKey();
//			StringBuilder sb = new StringBuilder();
//			sb.append(queryId);
//			int id = (node.getLayer() * indexKey) + node.getIndex();
//			sb.append(id);
//			String subQueryId = sb.toString();
//			node.addId(subQueryId);
//			node.setId(subQueryId);
//		}
//
//		return subQueries;
//	}

//	private OMElement buildCapabilityDesc(List<String> descList)
//			throws JAXBException, NoSuchServiceException {
//		MpegQueryType mpegQueryType = new MpegQueryType();
//		mpegQueryType.setManagement(new Management());
//		InputManagementType inputManagement = new InputManagementType();
//		CapabilityType cap = new CapabilityType();
//		for (String desc : descList) {
//			CapabilityTermType capTerm = new CapabilityTermType();
//			capTerm.setHref(desc);
//			cap.getSupportedQueryTypes().add(capTerm);
//		}
//		if(descList.size() == 1 && cap.getSupportedQueryTypes().isEmpty()) {
//			throw new NoSuchServiceException("There is no service for " + descList.get(0));
//		}
//		inputManagement.setDesiredCapability(cap);
//		mpegQueryType.getManagement().setInput(inputManagement);
//
//		return CtxSwitch.buildOMEl(mpegQueryType);
//	}

//	private void executeQuery(MpegQueryType query, String host) {
//		// TODO implement
//		System.out.println("SubTreeProcessing  execute Query not implemented yet");
//	}
}
