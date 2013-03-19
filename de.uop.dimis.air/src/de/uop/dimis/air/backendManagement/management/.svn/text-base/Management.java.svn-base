package de.uop.dimis.air.backendManagement.management;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import de.uop.dimis.air.backendManagement.datasets.DBInfoContainer;
import de.uop.dimis.air.backendManagement.datasets.ISavedResultsHandler;
import de.uop.dimis.air.backendManagement.datasets.SavedResultsHandler;
import de.uop.dimis.air.backendManagement.tools.CapabTools;
import de.uop.dimis.air.backendManagement.tools.Constants;
import de.uop.dimis.air.backendManagement.tools.MpqBuilder;
import de.uop.dimis.air.internalObjects.mpqf.AvailableCapabilityType;
import de.uop.dimis.air.internalObjects.mpqf.CapabilityType;
import de.uop.dimis.air.internalObjects.mpqf.InputManagementType;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;

/**
 * An implementation of {@link IManagement}, this object provides the methods
 * needed for the supported operations.
 * 
 * @author yakimov
 */
public class Management implements IManagement {
	/**
	 * the maximum timeout for the synchronous search
	 */
	private long maxRequestTimeout = 20000; // default value is 20 seconds
	
	/**
	 * Context to search the aggregator for.
	 */
	private String aggregatorContext = Constants.DEFAULT;
	/**
	 * the saved results handler
	 */
	private ISavedResultsHandler savedResults = new SavedResultsHandler();
	/**
	 * Contains all registered data bases
	 */
	private Map<String, DBInfoContainer> dbContent;

	/**
	 * Defines the rate for look up if all databases are already finished.
	 */
	private int lookUpStep = 400; // default value is 400. with maxRequestTimeout = 20000 --> lookUp rate is 50ms

	/**
	 * Creates an empty {@link Management}.
	 */
	public Management() {
		dbContent = new HashMap<String, DBInfoContainer>();
	}

	/**
	 * Removes saved results older than the given time stamp.
	 * 
	 * @param maxTimeStamp -
	 *            maximum allowed time stamp
	 */
	public void cleanUpSavedRes(long maxTimeStamp) {
		savedResults.cleanUpOld(maxTimeStamp);
	}

	/**
	 * Proceeds a fetch request, returning the saved result, if such result
	 * exists.
	 * 
	 * @param mpq -
	 *            request for a saved result
	 * @return - result of the request
	 */
	public MpegQueryType fetchResult(MpegQueryType mpq) {
		String id = mpq.getQuery().getFetchResult().getQueryID();
		MpegQueryType result = savedResults.getResult(id);

		if (result == null) {
			return MpqBuilder.buildExcMPQF(Constants.EXC_NODATA_CODE,
					Constants.EXC_NODATA); // no data for this request
		}
		savedResults.remove(id);
		return result;
	}

	/**
	 * Returns the aggregator context for this management.
	 * 
	 * @return - aggregator context for this management
	 */
	public String getAggregatorContext() {
		return aggregatorContext;
	}

	/**
	 * Returns the data base info for the given id.
	 * 
	 * @param id -
	 *            id searched for
	 * @return - the {@link DBInfoContainer} searched for
	 */
	public DBInfoContainer getDBInfoC(String id) {
		return dbContent.get(id);
	}

	/**
	 * Returns the maximal time the thread waits for a synchronous search to
	 * proceed. If the client specifies a timeout, his time out is used, if
	 * smaller than the systems.
	 * 
	 * @return - the systems maximal time out for synchronous search
	 */
	public long getMaxRequestTimeout() {
		return maxRequestTimeout;
	}

	/**
	 * Returns a list of all registered services, build into an
	 * {@link MpegQueryType}.
	 * 
	 * @return - all registered services
	 */
	public MpegQueryType listAllServices() {
		MpegQueryType resp = MpqBuilder.buildStsMPQF(Constants.STAT_SUCC_CODE,
				Constants.STAT_SUCC);
		Collection<DBInfoContainer> dbs = dbContent.values();
		List<AvailableCapabilityType> avL = resp.getManagement().getOutput()
				.getAvailableCapability();
		for (DBInfoContainer d : dbs) {
			AvailableCapabilityType av = CapabTools.buildAvC(d.getImt()
					.getDesiredCapability(), d.getID());
			avL.add(av);
		}
		return resp;
	}

	/**
	 * Lists all registered services in the {@link DBInfoContainer}
	 * representation.
	 * 
	 * @return - all registered services
	 */
	public Collection<DBInfoContainer> listAllServicesAsDBI() {
		return dbContent.values();
	}

	/**
	 * Registers a DB. If there is already a DB registered with this id, the new
	 * one can overwrite it, if the password is correct.
	 * 
	 * @param imt -
	 *            capabilities of the data base to be registered
	 * @param passw -
	 *            password of the database. used if relevant.
	 * @param dbDialect -
	 *            dialect the data base uses
	 * @return - a unique password if successful, <code>null</code> else (on
	 *         illegal or already taken id)
	 */
	public String register(InputManagementType imt, String passw) {
		DBInfoContainer dbInfo = new DBInfoContainer(imt);
		String url = dbInfo.getID();
		DBInfoContainer dbFound = dbContent.get(url);
		if (dbFound != null) {
			if (passw != null && dbFound.getPassword().equals(passw)) {
				dbInfo.setPassword(passw);

				dbContent.put(url, dbInfo);
				return passw;// already registered and knows right password
			}
			return null; // already registered under this id
		}

		String password = UUID.randomUUID().toString();
		dbInfo.setPassword(password);
		dbContent.put(url, dbInfo);
		return password;
	}

	/**
	 * Proceeds a registration request (may be register or unregister) and
	 * returns the result of the operation.
	 * 
	 * @param mpq -
	 *            registration request
	 * @return - result of the operation
	 */
	public MpegQueryType registration(MpegQueryType mpq) {

		if (mpq.getManagement().getInput().getDesiredCapability() != null) {
			String passw = register(mpq.getManagement().getInput(), mpq.getMpqfID());
			if (passw == null) {
				return MpqBuilder.buildExcMPQF(Constants.EXC_ERRPROC_CODE,
						Constants.EXC_ERRPROC);
			}
			mpq = MpqBuilder.buildStsMPQF(Constants.STAT_SUCC_CODE,
					Constants.STAT_SUCC);
			mpq.setMpqfID(passw);
			return mpq;

		} else {
			if (unregister(
					mpq.getManagement().getInput().getServiceID().get(0), mpq
							.getMpqfID())) {
				return MpqBuilder.buildStsMPQF(Constants.STAT_SUCC_CODE,
						Constants.STAT_SUCC);
			}
			return MpqBuilder.buildExcMPQF(Constants.EXC_ERRPROC_CODE,
					Constants.EXC_ERRPROC);
		}
	}

	/**
	 * Discovers registered services using a service id list and the desired
	 * capabilities. Returns services included in the service id list, having at
	 * least the desired capabilities.
	 * 
	 * @param servIDs -
	 *            service ids wanted
	 * @param cap -
	 *            capabilities wanted
	 * @return - services fulfilling the conditions
	 */
	public MpegQueryType serviceByBoth(List<String> servIDs, CapabilityType cap) {
		MpegQueryType resp = MpqBuilder.buildStsMPQF(Constants.STAT_SUCC_CODE,
				Constants.STAT_SUCC);
		Collection<DBInfoContainer> dbs = dbContent.values();

		for (DBInfoContainer d : dbs) {
			if (servIDs.contains(d.getID())
					&& CapabTools.containedInCap(d.getImt()
							.getDesiredCapability(), cap)) {
				AvailableCapabilityType av = CapabTools.buildAvC(d.getImt()
						.getDesiredCapability(), d.getID());
				resp.getManagement().getOutput().getAvailableCapability().add(
						av);
			}

		}
		return resp;
	}

	/**
	 * Discovers registered services having at least the desired capabilities.
	 * 
	 * @param cap -
	 *            capabilities wanted
	 * @return - services fulfilling the conditions
	 */
	public MpegQueryType serviceByCapab(CapabilityType cap) {
		MpegQueryType resp = MpqBuilder.buildStsMPQF(Constants.STAT_SUCC_CODE,
				Constants.STAT_SUCC);
		Collection<DBInfoContainer> dbs = dbContent.values();
		for (DBInfoContainer d : dbs) {
			if (CapabTools.containedInCap(d.getImt().getDesiredCapability(),
					cap)) {
				AvailableCapabilityType av = CapabTools.buildAvC(d.getImt()
						.getDesiredCapability(), d.getID());
				resp.getManagement().getOutput().getAvailableCapability().add(
						av);
			}

		}
		return resp;
	}

	/**
	 * Discovers registered services with the desired ids.
	 * 
	 * @param servIDs -
	 *            wanted ids
	 * @return - services fulfilling the conditions
	 */
	public MpegQueryType serviceByID(List<String> servIDs) {
		MpegQueryType resp = MpqBuilder.buildStsMPQF(Constants.STAT_SUCC_CODE,
				Constants.STAT_SUCC);
		Collection<DBInfoContainer> dbs = dbContent.values();
		for (DBInfoContainer d : dbs) {
			if (servIDs.contains(d.getID())) {
				AvailableCapabilityType av = CapabTools.buildAvC(d.getImt()
						.getDesiredCapability(), d.getID());
				resp.getManagement().getOutput().getAvailableCapability().add(
						av);
			}
		}
		return resp;
	}

	/**
	 * Discovers registered services described in the {@link MpegQueryType}
	 * object. Supports all 4 service discovery routines - give all, by id, by
	 * capability and by id + capability.
	 * 
	 * @param mpq -
	 *            the discovery request
	 * @return - services fulfilling the conditions
	 */
	public MpegQueryType serviceDiscovery(MpegQueryType mpq) {
		if (mpq.getManagement() == null
				|| mpq.getManagement().getInput() == null) {
			return MpqBuilder.buildExcMPQF(Constants.EXC_ERRPROC_CODE,
					Constants.EXC_ERRPROC); // incorrect request
		}

		CapabilityType cap = mpq.getManagement().getInput()
				.getDesiredCapability();
		List<String> servID = mpq.getManagement().getInput().getServiceID();

		if (cap == null && servID.size() < 1) {
			return listAllServices();// give all
		}

		if (cap == null && servID.size() > 0) {
			return serviceByID(servID); // matching ids
		}

		if (cap != null && servID.size() < 1) {
			return serviceByCapab(cap); // matching capabilities
		}

		return serviceByBoth(servID, cap); // matching capabilities and ids
	}

	/**
	 * Sets the aggregator context for this management.
	 * 
	 * @param aggregatorContext -
	 *            aggregator context
	 */
	public void setAggregatorContext(String aggregatorContext) {
		this.aggregatorContext = aggregatorContext;
	}


	/**
	 * Sets the maximal timeout for the synchronous search.
	 * 
	 * @param maxRequestTimeout -
	 *            maximal timeout
	 */
	public void setMaxRequestTimeout(long maxRequestTimeout) {
		this.maxRequestTimeout = maxRequestTimeout;
	}

	/**
	 * Unregisters a DB, if the DB is registered and the password is correct.
	 * 
	 * @param url -
	 *            the id (url) of the DB
	 * @param passw -
	 *            the password of the DB
	 * @return - <code>true</code> if successful, <code>false</code> on
	 *         wrong password
	 */
	public boolean unregister(String url, String passw) {
		DBInfoContainer dbInfo = dbContent.get(url);
		if (dbInfo == null) {
			return true;
		} else if (dbInfo.getPassword().equals(passw)) {
			dbContent.remove(url);
			return true;
		}
		return false;
	}

	public int getLookUpStep() {
		return lookUpStep;
	}

	public void setLookUpStep(int lookUpStep) {
		this.lookUpStep = lookUpStep;
	}
}