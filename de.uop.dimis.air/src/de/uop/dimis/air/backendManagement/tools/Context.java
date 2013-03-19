package de.uop.dimis.air.backendManagement.tools;

import java.util.HashMap;
import java.util.Map;

import de.uop.dimis.air.backendManagement.aggregation.Aggregator;
import de.uop.dimis.air.backendManagement.aggregation.IAggregator;
import de.uop.dimis.air.backendManagement.management.IManagement;
import de.uop.dimis.air.backendManagement.management.Management;

/**
 * This abstract class contains all data which services may need at a time.
 * 
 * @author yakimov
 */
public abstract class Context {
	/**
	 * mapped managements
	 */
	private static Map<String, IManagement> managements = new HashMap<String, IManagement>();
	/**
	 * mapped aggregators
	 */
	private static Map<String, IAggregator> aggregators = new HashMap<String, IAggregator>();

	/**
	 * path to the save directory
	 */
	private static String saveDirPath = "";

	static {
		aggregators.put(Constants.DEFAULT, new Aggregator());
		managements.put(Constants.DEFAULT, new Management());
	}

	/**
	 * Adds an aggregator for the specified context, if none is already
	 * registered for this context.
	 * 
	 * @param context -
	 *            context to save the aggregator under. hould not be
	 *            <code>null</code>.
	 * @param aggregator -
	 *            aggregator to be saved. hould not be <code>null</code>.
	 * @return - code>true</code> on success, <code>false</code> else
	 */
	public static boolean addAggregator(String context, IAggregator aggregator) {
		if (aggregators.get(context) == null) {
			aggregators.put(context, aggregator);
			return true;
		}
		return false;
	}

	/**
	 * Adds a management for the specified context, if none is already
	 * registered for this context.
	 * 
	 * @param context -
	 *            context to save the management under. Should not be
	 *            <code>null</code>.
	 * @param management-
	 *            management to be saved. Should not be <code>null</code>.
	 * @return - code>true</code> on success, <code>false</code> else
	 */
	public static boolean addManagement(String context, Management management) {
		if (managements.get(context) == null) {
			managements.put(context, management);
			return true;
		}
		return false;
	}

	/**
	 * Returns the agrregator for this context
	 * 
	 * @param context -
	 *            context to search the aggregator for
	 * @return - agregator
	 */
	public static IAggregator getAggregator(String context) {
		return aggregators.get(context);
	}

	/**
	 * Returns the management for this context
	 * 
	 * @param context -
	 *            context to find a management for
	 * @return - management for the context
	 */
	public static IManagement getManagement(String context) {
		return managements.get(context);
	}

	/**
	 * returns the saved results
	 * 
	 * @return - the saved results
	 */
	public static String getSaveDirPath() {
		return saveDirPath;
	}

	/**
	 * sets the saved results
	 * 
	 * @param saveDirPath -
	 *            saved results
	 */
	public static void setSaveDirPath(String saveDirPath) {
		Context.saveDirPath = saveDirPath;
	}

	/**
	 * updates the given aggregator for this context
	 * 
	 * @param context -
	 *            context for the aggregator
	 * @param aggregator -
	 *            aggregator to be updated
	 * @return - <code>true</code> on success, <code>false</code> else
	 */
	public static boolean updateAggregator(String context,
			IAggregator aggregator) {
		if (aggregators.get(context) != null) {
			aggregators.put(context, aggregator);
			return true;
		}
		return false;
	}

	/**
	 * updates the given management for this context
	 * 
	 * @param context -
	 *            context for the management
	 * @param management -
	 *            management
	 * @return - <code>true</code> on success, <code>false</code> else
	 */
	public static boolean updateManagement(String context, Management management) {
		if (managements.get(context) != null) {
			managements.put(context, management);
			return true;
		}
		return false;
	}

}