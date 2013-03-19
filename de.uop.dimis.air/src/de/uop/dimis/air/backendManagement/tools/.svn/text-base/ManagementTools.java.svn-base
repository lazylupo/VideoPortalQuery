package de.uop.dimis.air.backendManagement.tools;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.uop.dimis.air.backendManagement.datasets.DBInfoContainer;
import de.uop.dimis.air.internalObjects.mpqf.AND;
import de.uop.dimis.air.internalObjects.mpqf.BooleanExpressionType;
import de.uop.dimis.air.internalObjects.mpqf.CapabilityTermType;
import de.uop.dimis.air.internalObjects.mpqf.NOT;
import de.uop.dimis.air.internalObjects.mpqf.OR;
import de.uop.dimis.air.internalObjects.mpqf.QueryByDescription;
import de.uop.dimis.air.internalObjects.mpqf.QueryByFeatureRange;
import de.uop.dimis.air.internalObjects.mpqf.QueryByFreeText;
import de.uop.dimis.air.internalObjects.mpqf.QueryByMedia;
import de.uop.dimis.air.internalObjects.mpqf.QueryByRelevanceFeedback;
import de.uop.dimis.air.internalObjects.mpqf.QueryBySPARQL;
import de.uop.dimis.air.internalObjects.mpqf.QueryByXQuery;
import de.uop.dimis.air.internalObjects.mpqf.SpatialQuery;
import de.uop.dimis.air.internalObjects.mpqf.TemporalQuery;
import de.uop.dimis.air.internalObjects.mpqf.XOR;

/**
 * Tool class for some useful methods for a management.
 * 
 * @author yakimov
 */
public abstract class ManagementTools {
	/**
	 * Selects those data bases out of the {@link DBInfoContainer} list, which
	 * support the listed media types and with ids corresponding to ids in the
	 * list. Each of the last two parameters may be <code>null</code>, in
	 * which case this parameter is ignored.
	 * 
	 * @param dbs -
	 *            data bases to choose from
	 * @param targMedTypes -
	 *            media types to be supported
	 * @param ids -
	 *            ids to be matched
	 * @param supQTypes -
	 *            list of the query types the dbs must support
	 * @return - all data bases fulfilling the conditions
	 */
	public static Collection<DBInfoContainer> chooseDBs(
			Collection<DBInfoContainer> dbs, List<String> targMedTypes,
			List<String> ids, List<String> supQTypes) {

		List<DBInfoContainer> resultingDBs = new LinkedList<DBInfoContainer>();
		if (ids != null && ids.size() > 0) {
			Iterator<DBInfoContainer> dbIt = dbs.iterator();
			while (dbIt.hasNext()) {
				DBInfoContainer db = dbIt.next();
				if (ids.contains(db.getID())) {
					resultingDBs.add(db);
				}
			}
		} else {
			resultingDBs.addAll(dbs);
		}
	
		dbs = new LinkedList<DBInfoContainer>();
		if (supQTypes != null) {
			System.out.println("supQTypes.size = " + supQTypes.size());
			Iterator<DBInfoContainer> dbIt = resultingDBs.iterator();
			while (dbIt.hasNext()) {
				DBInfoContainer db = dbIt.next();
				if (supportsQTypes(db, supQTypes)) {
					dbs.add(db);
				}
			}
		} else {
			dbs.addAll(resultingDBs);
		}
		
		resultingDBs = new LinkedList<DBInfoContainer>();
		if (targMedTypes != null) {
			Iterator<DBInfoContainer> dbIt = dbs.iterator();
			while (dbIt.hasNext()) {
				DBInfoContainer db = dbIt.next();
				if (supportsMedTypes(db, targMedTypes)) {
					resultingDBs.add(db);
				}
			}
		} else {
			resultingDBs.addAll(dbs);
		}
		
	return dbs;
	}

	/**
	 * Recursive build of the suported query types
	 * 
	 * @param query
	 * @param resultList
	 */
	public static List<String> getSupQTypes(BooleanExpressionType query,
			List<String> resultList) {
		Class<?> qClass = query.getClass();
		
		//TODO Wert anpassen
		if (resultList.size() >= 9) {
			return resultList; // all queries already inside
		}

		if (qClass.equals(TemporalQuery.class)
				&& !resultList.contains(Constants.TEMPORAL_QUERY)) {
			resultList.add(Constants.DEFAULT_NAME_PREFIX + ":"
					+ Constants.TEMPORAL_QUERY);
			return resultList;
		}

		if (qClass.equals(QueryByMedia.class)
				&& !resultList.contains(Constants.QUERY_BY_MEDIA)) {
			resultList.add(Constants.DEFAULT_NAME_PREFIX + ":"
					+ Constants.QUERY_BY_MEDIA);
			return resultList;
		}

		if (qClass.equals(QueryByDescription.class)
				&& !resultList.contains(Constants.QUERY_BY_DESCRIPTION)) {
			resultList.add(Constants.DEFAULT_NAME_PREFIX + ":"
					+ Constants.QUERY_BY_DESCRIPTION);
			return resultList;
		}

		if (qClass.equals(QueryByFreeText.class)
				&& !resultList.contains(Constants.QUERY_BY_FREE_TEXT)) {
			resultList.add(Constants.DEFAULT_NAME_PREFIX + ":"
					+ Constants.QUERY_BY_FREE_TEXT);
			return resultList;
		}

		if (qClass.equals(QueryByXQuery.class)
				&& !resultList.contains(Constants.QUERY_BY_X_QUERY)) {
			resultList.add(Constants.DEFAULT_NAME_PREFIX + ":"
					+ Constants.QUERY_BY_X_QUERY);
			return resultList;
		}

		if (qClass.equals(QueryByRelevanceFeedback.class)
				&& !resultList.contains(Constants.QUERY_BY_RELEVANCE_FEEDBACK)) {
			resultList.add(Constants.DEFAULT_NAME_PREFIX + ":"
					+ Constants.QUERY_BY_RELEVANCE_FEEDBACK);
			return resultList;
		}

		if (qClass.equals(QueryByFeatureRange.class)
				&& !resultList.contains(Constants.QUERY_BY_FEATURE_RANGE)) {
			resultList.add(Constants.DEFAULT_NAME_PREFIX + ":"
					+ Constants.QUERY_BY_FEATURE_RANGE);
			return resultList;
		}

		if (qClass.equals(SpatialQuery.class)
				&& !resultList.contains(Constants.SPATIAL_QUERY)) {
			resultList.add(Constants.DEFAULT_NAME_PREFIX + ":"
					+ Constants.SPATIAL_QUERY);
			return resultList;
		}

		//TODO REGION OF INTEREST
		
		if (qClass.equals(QueryBySPARQL.class)
				&& !resultList.contains(Constants.SPARQL_QUERY)) {
			resultList.add(Constants.DEFAULT_NAME_PREFIX + ":"
					+ Constants.SPARQL_QUERY);
			return resultList;
		}
		
		Iterator<BooleanExpressionType> conds = null;
		if (qClass.equals(AND.class)) {
			AND and = (AND) query;
			conds = and.getCondition().iterator();
			while (resultList.size() < 9 && conds.hasNext()) {
				resultList = getSupQTypes(conds.next(), resultList);
			}
			return resultList;
		}

		if (qClass.equals(OR.class)) {
			OR or = (OR) query;
			conds = or.getCondition().iterator();
			while (resultList.size() < 9 && conds.hasNext()) {
				resultList = getSupQTypes(conds.next(), resultList);
			}
			return resultList;
		}

		if (qClass.equals(NOT.class)) {
			NOT not = (NOT) query;
			return getSupQTypes(not.getCondition(), resultList);
		}

		if (qClass.equals(XOR.class)) {
			XOR xor = (XOR) query;
			conds = xor.getCondition().iterator();
			while (resultList.size() < 9 && conds.hasNext()) {
				resultList = getSupQTypes(conds.next(), resultList);
			}
			return resultList;
		}
		
		return resultList;
	}

	/**
	 * Returns whether the {@link DBInfoContainer} object represents a data base
	 * supporting all listed media types.
	 * 
	 * @param db -
	 *            data base to be tested
	 * @param targMedTypes -
	 *            media types to be tested for
	 * @return - <code>true</code> if supported, <code>false</code> else
	 */
	public static boolean supportsMedTypes(DBInfoContainer db,
			List<String> targMedTypes) {
		if (db.getImt().getDesiredCapability().getSupportedResultMediaTypes()
				.containsAll(targMedTypes)) {
			return true;
		}
		return false;
	}

	/**
	 * Tests if the given data base supports the specified query types.
	 * 
	 * @param db -
	 *            data base
	 * @param supQTypes -
	 *            list with query types
	 * @return - <code>true</code> if the data base supports all specified
	 *         query types, <code>false</code> else
	 */
	public static boolean supportsQTypes(DBInfoContainer db,
			List<String> supQTypes) {
		if (supQTypes.size() < 1) {
			return true;
		}

		Iterator<String> supQ = supQTypes.iterator();
		while (supQ.hasNext()) {
			boolean flag = false;
			Iterator<CapabilityTermType> capTs = db.getImt()
					.getDesiredCapability().getSupportedQueryTypes().iterator();
			String sQ = supQ.next();
			
			while (capTs.hasNext() && !flag) {
				if (sQ.equals(capTs.next().getHref())) {
					flag = true;
				}
			}
			if (!flag) {
				return false;
			}

		}

		return true;
	}

}
