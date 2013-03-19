package de.uop.dimis.air.backendManagement.tools;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import de.uop.dimis.air.internalObjects.mpqf.AvailableCapabilityType;
import de.uop.dimis.air.internalObjects.mpqf.CapabilityTermType;
import de.uop.dimis.air.internalObjects.mpqf.CapabilityType;
import de.uop.dimis.air.internalObjects.mpqf.TermType;
import de.uop.dimis.air.internalObjects.mpqf.CapabilityType.UsageConditions;

/**
 * Tool class containing methods to test and transform a {@link CapabilityType}
 * object. Methods would need change should the {@link CapabilityType}
 * definition change.
 * 
 * @author yakimov
 */
public class CapabTools {

	/**
	 * query name to url map
	 */
	private static Map<String, String> nameToUri;
	static {
		nameToUri = new HashMap<String, String>();
		nameToUri.put("QueryByMedia", "urn:mpeg:mpqf:2008:CS:full:100.3.6.1");
		nameToUri.put("QueryByDescription",
				"urn:mpeg:mpqf:2008:CS:full:100.3.6.2");
		nameToUri
				.put("QueryByFreeText", "urn:mpeg:mpqf:2008:CS:full:100.3.6.3");
		nameToUri.put("QueryByXQuery", "urn:mpeg:mpqf:2008:CS:full:100.3.6.4");
		nameToUri.put("QueryByRelevanceFeedback",
				"urn:mpeg:mpqf:2008:CS:full:100.3.6.5");
		nameToUri.put("QueryByFeatureRange",
				"urn:mpeg:mpqf:2008:CS:full:100.3.6.6");
		nameToUri.put("SpatialQuery", "urn:mpeg:mpqf:2008:CS:full:100.3.6.7");
		nameToUri.put("TemporalQuery", "urn:mpeg:mpqf:2008:CS:full:100.3.6.8");
		//TODO RegionOfInterest
		//nameToUri.put("RegionOfInterest", "urn:mpeg:mpqf:2008:CS:full:100.3.6.9");
		nameToUri.put("QueryBySPARQL", "urn:mpeg:mpqf:2008:CS:full:100.3.6.10");
	}

	/**
	 * Builds an {@link AvailableCapabilityType}, based on the id and
	 * {@link CapabilityType} provided. Both should not be <code>null</code>.
	 * 
	 * @param cap -
	 *            {@link CapabilityType} to be used for the build
	 * @param id -
	 *            id to be used for the build
	 * @return - an build {@link AvailableCapabilityType}
	 */
	public static AvailableCapabilityType buildAvC(CapabilityType cap, String id) {
		AvailableCapabilityType av = new AvailableCapabilityType();
		av.setServiceID(id);

		List<String> lStr = cap.getSupportedExampleMediaTypes();
		if (lStr != null) {
			av.getSupportedExampleMediaTypes().addAll(lStr);
		}

		List<CapabilityTermType> lCTT = cap.getSupportedExpressions();
		if (lCTT != null) {
			av.getSupportedExpressions().addAll(lCTT);
		}

		lStr = cap.getSupportedMetadata();
		if (lStr != null) {
			av.getSupportedMetadata().addAll(lStr);
		}

		av.setSupportedQFProfile(cap.getSupportedQFProfile());

		lCTT = cap.getSupportedQueryTypes();
		if (lCTT != null) {
			av.getSupportedQueryTypes().addAll(lCTT);
		}

		lStr = cap.getSupportedResultMediaTypes();
		if (lStr != null) {
			av.getSupportedResultMediaTypes().addAll(lStr);
		}

		List<UsageConditions> lUC = cap.getUsageConditions();
		if (lUC != null) {
			av.getUsageConditions().addAll(lUC);
		}

		return av;
	}

	/**
	 * Tests if the conditions in one {@link CapabilityType} object are
	 * contained in an other {@link CapabilityType} object.
	 * 
	 * @param contains -
	 *            {@link CapabilityType} tested to contain
	 * @param contained -
	 *            {@link CapabilityType} tested to be contained
	 * @return <code>true</code> if <code>contained</code> is a subset of
	 *         <code>contains</code>, <code>false</code> else
	 */
	public static boolean containedInCap(CapabilityType contains,
			CapabilityType contained) {
		
		//contained ist das was man haben will!!
		
		if (contains == null) {
			if (contained != null) {
				return false;
			}
			return true;
		}

		// empty list = support all
		// 101 contains 101.1 contains 101.1.1 ...

		if (!containedInStrList(contains.getSupportedExampleMediaTypes(),
				contained.getSupportedExampleMediaTypes())) {
			return false;
		}

		CapabTools capT = new CapabTools();
		for (CapabilityTermType q : contained.getSupportedExpressions()) {
			Iterator<CapabilityTermType> cts = contains
					.getSupportedExpressions().iterator();
			boolean isCont = false;
			while (!isCont && cts.hasNext()) {
				if (capT.containedInCapTermT(cts.next(), q)) {
					isCont = true;
				}
			}
			if (!isCont) {
				return false;
			}
		}

		if (!containedInStrList(contains.getSupportedMetadata(), contained
				.getSupportedMetadata())) {
			return false;
		}

		if (!capT.containedInCapTermT(contains.getSupportedQFProfile(),
				contained.getSupportedQFProfile())) {
			return false;
		}

		for (CapabilityTermType q : contained.getSupportedQueryTypes()) {
			Iterator<CapabilityTermType> cts = contains
					.getSupportedQueryTypes().iterator();
			boolean isCont = false;
			while (!isCont && cts.hasNext()) {
				if (capT.containedInCapTermT(cts.next(), q)) {
					isCont = true;
				}
			}
			if (!isCont) {
				return false;
			}
		}

		if (!containedInStrList(contains.getSupportedResultMediaTypes(),
				contained.getSupportedResultMediaTypes())) {
			return false;
		}

		for (UsageConditions u : contained.getUsageConditions()) {
			Iterator<UsageConditions> cts = contains.getUsageConditions()
					.iterator();
			boolean isCont = false;
			while (!isCont && cts.hasNext()) {
				if (capT.containedInUC(cts.next(), u)) {
					isCont = true;
				}
			}
			if (!isCont) {
				return false;
			}

		}

		return true;
	}

	/**
	 * Tests whether the first list contains the seconds conditions.
	 * 
	 * @param contains -
	 *            to contain the conditions
	 * @param contained -
	 *            to be contained
	 * @return - <code>true</code> if first contains second,
	 *         <code>false</code> else
	 */
	public static boolean containedInStrList(List<String> contains,
			List<String> contained) {
		if (contains.size() < 1) {// empty list = support all
			return true;
		}

		if (contained.size() < 1) {// no capability requested
			return true;
		}

		for (String s : contained) {
			boolean isCont = false;
			Iterator<String> ctsIt = contains.iterator();
			while (!isCont && ctsIt.hasNext()) {
				
				String b = ctsIt.next();
				
				System.out.println("s: " + s + " it-s: " + b);
				
				if (s.contains(b)) {// capab 101 contains 101.1 ...
					isCont = true;
				}
			}
			if (!isCont) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns the uri value for the specified String. For example
	 * urn:mpeg:mpqf:2008:CS:full:100.3.6.3 for QueryByFreeText.
	 * 
	 * @param name -
	 *            name of the uri
	 * @return - the uri
	 */
	public static String nameToUri(String name) { // NO_UCD
		return nameToUri.get(name);
	}

	/**
	 * used to map the ref ids for the contains object
	 */
	private Map<String, String> refMappingCts;

	/**
	 * used to map the ref ids for the contained object
	 */
	private Map<String, String> refMappingCtnd;

	/**
	 * Creates an empty {@link CapabTools} Object. It is needed for
	 * {@link CapabilityTermType} testing for example.
	 */
	public CapabTools() {
		refMappingCts = new HashMap<String, String>();
		refMappingCtnd = new HashMap<String, String>();
	}

	/**
	 * Tests whether the first object contains the seconds conditions.
	 * 
	 * @param contains -
	 *            to contain the conditions
	 * @param contained -
	 *            to be contained
	 * @return - <code>true</code> if first contains second,
	 *         <code>false</code> else
	 */
	public boolean containedInCapTermT(CapabilityTermType contains,
			CapabilityTermType contained) {
		if (contains == null) {
			if (contained != null) {
				return false;
			}
			return true;
		}

		if (!contained.getHref().equals(contains.getHref())) {
			return false;
		}

		if (contains.getUsageRefList().size() > 0) {
			for (Object o : contains.getUsageRefList()) {
				refMappingCts.put(o.toString(), contains.getHref());// is Str
			}
		}

		if (contained.getUsageRefList().size() > 0) {
			for (Object o : contained.getUsageRefList()) {
				refMappingCts.put(o.toString(), contained.getHref());
			}
		}

		if (!containedInTermTL(contains.getTerm(), contained.getTerm())) {
			return false;
		}

		return true;
	}

	/**
	 * Tests whether the first object contains the seconds conditions.
	 * 
	 * @param contains -
	 *            to contain the conditions
	 * @param contained -
	 *            to be contained
	 * @return - <code>true</code> if first contains second,
	 *         <code>false</code> else
	 */
	public boolean containedInTermT(TermType contains, TermType contained) {
		if (contains == null) {
			if (contained != null) {
				return false;
			}
			return true;
		}

		if (!contained.getHref().contains(contains.getHref())) {
			return false;
		}

		if (!containedInTermTL(contains.getTerm(), contained.getTerm())) {
			return false;
		}

		return true;
	}

	/**
	 * Tests whether the first list contains the seconds conditions.
	 * 
	 * @param contains -
	 *            to contain the conditions
	 * @param contained -
	 *            to be contained
	 * @return - <code>true</code> if first contains second,
	 *         <code>false</code> else
	 */
	public boolean containedInTermTL(List<TermType> contains,
			List<TermType> contained) {
		if (contains.size() < 1) {
			return true;
		}

		if (contained.size() < 1) {
			return true;
		}

		for (TermType t : contained) {
			boolean isCont = false;
			Iterator<TermType> ctsIt = contains.iterator();
			while (!isCont && ctsIt.hasNext()) {
				TermType tt = ctsIt.next();
				if (containedInTermT(tt, t)) {
					isCont = true;
				}
			}
			if (!isCont) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Tests whether the first object contains the seconds conditions.
	 * 
	 * @param contains -
	 *            to contain the conditions
	 * @param contained -
	 *            to be contained
	 * @return - <code>true</code> if first contains second,
	 *         <code>false</code> else
	 */
	public boolean containedInUC(UsageConditions contains,
			UsageConditions contained) {
		if (contains == null) {
			if (contained != null) {
				return false;
			}
			return true;
		}

		if (!contains.getHref().equals(contained.getHref())) {
			return false;
		}

		String ctsUsageId = contains.getUsageID();
		String ctndUsageId = contained.getUsageID();
		if (ctsUsageId == null) {
			if (ctndUsageId != null) {
				return false;
			}
			return true;
		} else {
			if (ctndUsageId != null) {
				if (!refMappingCtnd.get(ctndUsageId).contains(
						refMappingCts.get(ctsUsageId))) {
					return false;
				}
			}
		}

		if (!containedInTermTL(contains.getTerm(), contained.getTerm())) {
			return false;
		}

		return true;
	}

}
