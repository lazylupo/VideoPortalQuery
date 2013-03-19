package de.uop.dimis.air.mpqfManagement.processing;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.uop.dimis.air.internalObjects.mpqf.AvailableCapabilityType;
import de.uop.dimis.air.internalObjects.mpqf.BooleanExpressionType;
import de.uop.dimis.air.internalObjects.mpqf.CapabilityTermType;
import de.uop.dimis.air.internalObjects.mpqf.CapabilityType;
import de.uop.dimis.air.internalObjects.mpqf.InputManagementType;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.internalObjects.mpqf.ObjectFactory;
import de.uop.dimis.air.internalObjects.mpqf.QueryByDescription;
import de.uop.dimis.air.internalObjects.mpqf.QueryByFeatureRange;
import de.uop.dimis.air.internalObjects.mpqf.QueryByFreeText;
import de.uop.dimis.air.internalObjects.mpqf.QueryByMedia;
import de.uop.dimis.air.internalObjects.mpqf.QueryByRelevanceFeedback;
import de.uop.dimis.air.internalObjects.mpqf.QueryBySPARQL;
import de.uop.dimis.air.internalObjects.mpqf.QueryByXQuery;
import de.uop.dimis.air.internalObjects.mpqf.ServiceSelectionType;
import de.uop.dimis.air.internalObjects.mpqf.SpatialQuery;
import de.uop.dimis.air.internalObjects.mpqf.TemporalQuery;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType.Management;
import de.uop.dimis.air.mpqfManagement.NoSuchServiceException;
import de.uop.dimis.air.mpqfManagement.containers.QueryContainer;
import de.uop.dimis.air.mpqfManagement.containers.QueryStatus;
import de.uop.dimis.air.searchInterface.SearchInterface;

/**
 * 
 * @author wolfgang This class processes each single leaf of the query tree
 * @modified Christian Vilsmaier, Christian.Vilsmaier@me.com
 * 
 */
public class SingleQueryProcessor implements QueryProcessor {

    private QueryContainer container;
    private ConcurrentHashMap<String, List<MpegQueryType>> responses;

    /**
     * Constructor of the SingleQueryProcessor
     *
     * @param container
     *            QueryContainer which contains the subqueries to process
     */
    public SingleQueryProcessor(QueryContainer container) {
        super();
        this.container = container;
        responses = new ConcurrentHashMap<String, List<MpegQueryType>>();
    }

    /**
     * @see de.medico.queryBroker.mpqfManagement.processing.QueryProcessors#execute()
     */
    public ConcurrentHashMap<String, List<MpegQueryType>> execute()
            throws NoSuchServiceException {
        List<MpegQueryType> queries = container.getSubQueryContainer().listSubQueries();

        for (MpegQueryType current : queries) {
            processSubQuery(current);
        }
        container.setStatus(QueryStatus.finished);
        return responses;
    }

    private void processSubQuery(MpegQueryType subQuery)
            throws NoSuchServiceException {
        SubQueryProcessing processing = new SubQueryProcessing(subQuery);
        processing.execute();
    }

    private class SubQueryProcessing {

        private MpegQueryType subQuery;

        private SubQueryProcessing(MpegQueryType subQuery) {
            this.subQuery = subQuery;
        }

        private void execute() throws NoSuchServiceException {

            List<AvailableCapabilityType> hosts = discoverServices();

            if (hosts != null) {
                if (hosts.size() > 0) {
                    for (AvailableCapabilityType current : hosts) {
                        executeQuery(subQuery, current.getServiceID());
                    }
                } else {
                    throw new NoSuchServiceException("There is no service for "
                            + subQuery.getQuery().getInput().getQueryCondition().getCondition().getClass().getName());
                }
            } else {
                throw new NoSuchServiceException("There is no service for "
                        + subQuery.getQuery().getInput().getQueryCondition().getCondition().getClass().getName());
            }
        }

        private List<AvailableCapabilityType> discoverServices() {
	        MpegQueryType mpegQueryTypeResult = null;
	
	        BooleanExpressionType type = (BooleanExpressionType) subQuery.getQuery().getInput().getQueryCondition().getCondition();
	        de.uop.dimis.air.backendManagement.management.Management backendMngmt = de.uop.dimis.air.mpqfManagement.Management.getInstance().getBackendMng();
	        mpegQueryTypeResult = backendMngmt.serviceDiscovery(checkForCapab(type));
	        List<AvailableCapabilityType> list = mpegQueryTypeResult.getManagement().getOutput().getAvailableCapability();
	
	        return list;
        }

        private MpegQueryType checkForCapab(BooleanExpressionType type) {

            if (type instanceof QueryByDescription) {
                return encapsulateCapab("urn:mpeg:mpqf:2008:CS:full:100.3.6.2");
            } else if (type instanceof QueryByFeatureRange) {
                return encapsulateCapab("urn:mpeg:mpqf:2008:CS:full:100.3.6.6");
            } else if (type instanceof QueryByFreeText) {
                return encapsulateCapab("urn:mpeg:mpqf:2008:CS:full:100.3.6.3");
            } else if (type instanceof QueryByMedia) {
                return encapsulateCapab("urn:mpeg:mpqf:2008:CS:full:100.3.6.1");
            } else if (type instanceof QueryByRelevanceFeedback) {
                return encapsulateCapab("urn:mpeg:mpqf:2008:CS:full:100.3.6.5");
            } else if (type instanceof QueryByXQuery) {
                return encapsulateCapab("urn:mpeg:mpqf:2008:CS:full:100.3.6.4");
            } else if (type instanceof SpatialQuery) {
                return encapsulateCapab("urn:mpeg:mpqf:2008:CS:full:100.3.6.7");
            } else if (type instanceof TemporalQuery) {
                return encapsulateCapab("urn:mpeg:mpqf:2008:CS:full:100.3.6.8");
            } else if (type instanceof QueryBySPARQL) {
                return encapsulateCapab("urn:mpeg:mpqf:2008:CS:full:100.3.6.10");
            }

            return null;
        }

        private MpegQueryType encapsulateCapab(String desc) {
            MpegQueryType mpegQueryType = new MpegQueryType();
            mpegQueryType.setManagement(new Management());
            InputManagementType inputManagement = new InputManagementType();
            CapabilityType cap = new CapabilityType();
            CapabilityTermType capTerm = new CapabilityTermType();
            capTerm.setHref(desc);
            cap.getSupportedQueryTypes().add(capTerm);
            inputManagement.setDesiredCapability(cap);
            mpegQueryType.getManagement().setInput(inputManagement);

            return mpegQueryType;
        }

        private void executeQuery(MpegQueryType query, String host) {
	        MpegQueryType response = null;
            Class<?> searchClass = null;

            try {
 			    
    
            	
//              **********
//              Edit by CV

				if (host.split("//").length>1){
            	
                searchClass = Class.forName(host.split("//")[0]);
                SearchInterface select = (SearchInterface) searchClass.newInstance();
                ObjectFactory of = new ObjectFactory();
                ServiceSelectionType sst = of.createServiceSelectionType();
                //INFO about path and configuration
                sst.getServiceID().add(host.substring(host.indexOf("//")+2));
                query.getQuery().getInput().setServiceSelection(sst);
                response = select.execute(query);

                }
                
//    			Edit by CV
//    			**********
				else{
				searchClass = Class.forName(host);
                SearchInterface select = (SearchInterface) searchClass.newInstance();
                response = select.execute(query);
                }
                
            } catch (InstantiationException ex) {
                Logger.getLogger(SingleQueryProcessor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(SingleQueryProcessor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
	
	        if (responses.get(query.getMpqfID()) == null) {
	            responses.put(query.getMpqfID(), new LinkedList<MpegQueryType>());
	        }
	        responses.get(query.getMpqfID()).add(response);
        }
    }
}
