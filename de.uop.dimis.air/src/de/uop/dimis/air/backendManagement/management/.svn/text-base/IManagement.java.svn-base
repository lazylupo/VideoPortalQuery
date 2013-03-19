package de.uop.dimis.air.backendManagement.management;

import java.util.Collection;
import java.util.List;

import de.uop.dimis.air.backendManagement.datasets.DBInfoContainer;
import de.uop.dimis.air.internalObjects.mpqf.CapabilityType;
import de.uop.dimis.air.internalObjects.mpqf.InputManagementType;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;

/**
 * The main interface of the middle ware, this interface defines ways to access
 * the operations supported by the middle ware.
 * 
 * @author yakimov
 */
public interface IManagement {

	/**
	 * Cleans up results with time stamp older than the given.
	 * 
	 * @param maxTimeStamp -
	 *            oldest allowed time stamp
	 */
	public void cleanUpSavedRes(long maxTimeStamp); 

	/**
	 * Proceeds a fetch request, returning the saved result, if such result
	 * exists.
	 * 
	 * @param mpq -
	 *            request for a saved result
	 * @return - result of the request
	 */
	public MpegQueryType fetchResult(MpegQueryType mpq);

	/**
	 * Returns the data base info for the given id.
	 * 
	 * @param id -
	 *            id searched for
	 * @return - the {@link DBInfoContainer} searched for
	 */
	public DBInfoContainer getDBInfoC(String id);

	/**
	 * Returns a list of all registered services, build into an
	 * {@link MpegQueryType}.
	 * 
	 * @return - all registered services
	 */
	public MpegQueryType listAllServices();

	/**
	 * Lists all registered services in the {@link DBInfoContainer}
	 * representation.
	 * 
	 * @return - all registered services
	 */
	public Collection<DBInfoContainer> listAllServicesAsDBI();

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
	public String register(InputManagementType imt, String passw);

	/**
	 * Proceeds a registration request (may be register or unregister) and
	 * returns the result of the operation.
	 * 
	 * @param mpq -
	 *            registration request
	 * @return - result of the operation
	 */
	public MpegQueryType registration(MpegQueryType mpq);

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
	public MpegQueryType serviceByBoth(List<String> servIDs, CapabilityType cap);

	/**
	 * Discovers registered services having at least the desired capabilities.
	 * 
	 * @param cap -
	 *            capabilities wanted
	 * @return - services fulfilling the conditions
	 */
	public MpegQueryType serviceByCapab(CapabilityType cap);

	/**
	 * Discovers registered services with the desired ids.
	 * 
	 * @param servIDs -
	 *            wanted ids
	 * @return - services fulfilling the conditions
	 */
	public MpegQueryType serviceByID(List<String> servIDs);

	/**
	 * Discovers registered services described in the {@link MpegQueryType}
	 * object. Supports all 4 service discovery routines - give all, by id, by
	 * capability and by id + capability.
	 * 
	 * @param mpq -
	 *            the discovery request
	 * @return - services fulfilling the conditions
	 */
	public MpegQueryType serviceDiscovery(MpegQueryType mpq);

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
	public boolean unregister(String url, String passw);

}
