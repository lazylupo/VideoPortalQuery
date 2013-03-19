package de.uop.dimis.air.mpqfManagement;

import de.uop.dimis.air.backendManagement.tools.Constants;
import de.uop.dimis.air.backendManagement.tools.MpqBuilder;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.mpqfManagement.containers.QueryContainer;

public class Management {

    private static Management instance;

    private static de.uop.dimis.air.backendManagement.management.Management mng;
    
    private Management() {
//            System.out.println("Local Mode activ");
    		Management.mng = new de.uop.dimis.air.backendManagement.management.Management();
    }

    public synchronized static Management getInstance() {
        if (instance == null) {
            instance = new Management();
        }
        return instance;
    }

    public de.uop.dimis.air.backendManagement.management.Management getBackendMng() {
    	return Management.mng;
    }
    
	/**
	 * 
	 * @param mpq
	 * @return Retunrns either an Object of the Type List<String> containing the ID�s of finished queries
	 * or an Object of the Type QueryContainer containing the responses to the query
	 * or an Object of the Type MpegQueryType if a asynch query has been successfull.
	 * @throws NoSuchServiceException
	 */
	public Object search(MpegQueryType mpq) throws NoSuchServiceException {
		Object result = null;
		
		//a result or all queries in state finished should be fetched...
		if (mpq.getQuery().getFetchResult() != null) {

			//get all finished queries...
			if (mpq.getQuery().getFetchResult().getQueryID() == null || mpq.getQuery().getFetchResult().getQueryID().length() == 0) {
				result = QueryRegistration.getInstance().getFinishedQueries();
			
			//get a specified result
			} else {
				String id = mpq.getQuery().getFetchResult().getQueryID();
				QueryContainer container = QueryRegistration.getInstance()
						.getQuery(id);
				if (container != null) {
					result = container;
				} else {
					System.out.println("The result was null!!!");
				}
			}
			
		//a synchroneous query...immediate response needed...
		} else if (mpq.getQuery()!= null && mpq.getQuery().getInput() != null && mpq.getQuery().getInput().isImmediateResponse()) {
			String id = QueryRegistration.getInstance().checkInNewQuery(mpq);
			
			try {
				result = QueryRegistration.getInstance().getQuery(id);
				// wait until the query is executed
				System.out.println(result);
				((QueryContainer) result).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		//an async query...
		} else {
			//mpq.getQuery().setInput(new InputQueryType());
			mpq.getQuery().getInput().setImmediateResponse(true);
			String id = QueryRegistration.getInstance().checkInNewQuery(mpq);
			result = createSuccessResponse(id);
		}

		return result;
	}

	private MpegQueryType createSuccessResponse(String id) {
		MpegQueryType mpq = MpqBuilder.buildStsMPQF(Constants.STAT_SUCC_CODE, Constants.STAT_SUCC);
		mpq.setMpqfID(id); // fetch code in the mpdfId
		return mpq;
	}
}
