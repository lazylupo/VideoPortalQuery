package de.uop.dimis.air.backendManagement.tools;

/**
 * Class containing all the constants needed for the project.
 * 
 * @author yakimov
 */
public abstract class Constants {
	/**
	 * constant for the default key
	 */
	public static final String DEFAULT = "default";
	/**
	 * default expected namespace
	 */
	public static final String DEFAULT_NAME_PREFIX = "urn:mpeg:mpqf:2008:CS:full";
	/**
	 * Query By Media url
	 */
	public static final String QUERY_BY_MEDIA = "100.3.6.1";
	/**
	 * Query By Description url
	 */
	public static final String QUERY_BY_DESCRIPTION = "100.3.6.2";
	/**
	 * Query By Free Text url
	 */
	public static final String QUERY_BY_FREE_TEXT = "100.3.6.3";
	/**
	 * Query By X Query url
	 */
	public static final String QUERY_BY_X_QUERY = "100.3.6.4";
	/**
	 * Query By Relevance url
	 */
	public static final String QUERY_BY_RELEVANCE_FEEDBACK = "100.3.6.5";
	/**
	 * Query By Feature Range url
	 */
	public static final String QUERY_BY_FEATURE_RANGE = "100.3.6.6";
	/**
	 * Spatial Query url
	 */
	public static final String SPATIAL_QUERY = "100.3.6.7";
	/**
	 * Temporal Query url
	 */
	public static final String TEMPORAL_QUERY = "100.3.6.8";
	/**
	 * Temporal Query url
	 *
	public static final String REGIONOFINTEREST_QUERY = "100.3.6.9";
	 */
	/**
	 * Temporal Query url
	 */
	public static final String SPARQL_QUERY = "100.3.6.10";
	
	/**
	 * indicates success
	 */
	public static final String STAT_SUCC_CODE = "001";
	/**
	 * indicates success - "Query was successful"
	 */
	public static final String STAT_SUCC = "Query was successful";

	/**
	 * Warning code for "Server resource busy"
	 */
	public static final String WA_BUSY_CODE = "101";
	/**
	 * Warning "Server resource busy"
	 */
	public static final String WA_BUSY = "Server resource busy";

	public static final String WA_IDLONG_CODE = "102";
	public static final String WA_IDLONG = "Identifier is too long";

	public static final String WA_MANYRES_CODE = "103";
	public static final String WA_MANYRES = "Too many query results";

	public static final String WA_MANYEXPR_CODE = "104";
	public static final String WA_MANYEXPR = "Too many group-by/sort-by expressions";

	public static final String WA_VALNULL_CODE = "105";
	public static final String WA_VALNULL = "Value of requested filed is NULL";

	public static final String EXC_NODATA_CODE = "201";
	public static final String EXC_NODATA = "No data found";

	public static final String EXC_ERRPROC_CODE = "202";
	public static final String EXC_ERRPROC = "Error while processing the request";

	public static final String EXC_UNIMFEAT_CODE = "203";
	public static final String EXC_UNIMFEAT = "Unimplemented feature";

	public static final String EXC_NOCONN_CODE = "204";
	public static final String EXC_NOCONN = "Cannot connect to the service";

	public static final String EXC_CONNLOST_CODE = "205";
	public static final String EXC_CONNLOST = "Cannection lost contact";

	public static final String EXC_FATERR_CODE = "206";
	public static final String EXC_FATERR = "The server session terminated by fatal error";

	public static final String EXC_LONGREQ_CODE = "207";
	public static final String EXC_LONGREQ = "Request string is too long";

	public static final String EXC_REQNOSUPP_CODE = "208";
	public static final String EXC_REQNOSUPP = "Request not suppported in this configuration";

	public static final String EXC_RESNOSUPP_CODE = "209";
	public static final String EXC_RESNOSUPP = "Resource type not supported";

	public static final String EXC_QTNOSUPP_CODE = "210";
	public static final String EXC_QTNOSUPP = "Query type not supported";

	public static final String EXC_EXPNOSUPP_CODE = "211";
	public static final String EXC_EXPNOSUPP = "Expression type not supported";

	public static final String EXC_TLIM_CODE = "212";
	public static final String EXC_TLIM = "Time limit exceeded - query aborted";

	public static final String EXC_TOUT_CODE = "213";
	public static final String EXC_TOUT = "Timeout occurred while waiting for a resource";

	public static final String EXC_ATTSTR_CODE = "214";
	public static final String EXC_ATTSTR = "Missing or invalid value for attribute string";

	public static final String EXC_INVATTSTR_CODE = "215";
	public static final String EXC_INVATTSTR = "Invalid attribute string";

	public static final String EXC_STRNULL_CODE = "216";
	public static final String EXC_STRNULL = "Value of string is null";

	public static final String EXC_STRLONG_CODE = "217";
	public static final String EXC_STRLONG = "Value of attribute string is too long";

	public static final String EXC_INVSTR_CODE = "218";
	public static final String EXC_INVSTR = "Invalid value string for parameter string";

	public static final String EXC_INVPATH_CODE = "219";
	public static final String EXC_INVPATH = "Invalid path string";

	public static final String EXC_QSYNTAX_CODE = "220";
	public static final String EXC_QSYNTAX = "Query syntax error";

	public static final String EXC_STRNOEX_CODE = "221";
	public static final String EXC_STRNOEX = "Element/attribute string does not exist";

	public static final String EXC_INVVAL_CODE = "222";
	public static final String EXC_INVVAL = "Invalid number of values specified";

	public static final String EXC_NAMERES_CODE = "223";
	public static final String EXC_NAMERES = "Thise name is currently reserved for use by system";

	public static final String EXC_OBSFEAT_CODE = "224";
	public static final String EXC_OBSFEAT = "Obsolete feature";

	public static final String EXC_CANNOLOC_CODE = "225";
	public static final String EXC_CANNOLOC = "Cannot locate speified resource";

	public static final String EXC_RESIZEEXC_CODE = "226";
	public static final String EXC_RESIZEEXC = "Resource size limit was exceeded";

	public static final String EXC_ILLDT_CODE = "227";
	public static final String EXC_ILLDT = "Illegal DateTime found";

	public static final String EXC_INVDT_CODE = "228";
	public static final String EXC_INVDT = "Invalid length for DATE or NUMBER bin variable";

	public static final String EXC_ZERODIV_CODE = "229";
	public static final String EXC_ZERODIV = "Zero divide error";

	public static final String EXC_NUMOVERF_CODE = "230";
	public static final String EXC_NUMOVERF = "Numeric overflow";

	public static final String EXC_UNUPPCHA_CODE = "231";
	public static final String EXC_UNUPPCHA = "Unsupported character set";

	public static final String EXC_INVCHA_CODE = "232";
	public static final String EXC_INVCHA = "Invalid character";

	public static final String EXC_NONNUM_CODE = "233";
	public static final String EXC_NONNUM = "A non-numeric character found where a numeric exspected";

	public static final String EXC_NONALPH_CODE = "234";
	public static final String EXC_NONALPH = "A non-alphabetic character found where an alphabetic expected"; 

}