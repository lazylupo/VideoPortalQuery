package de.uop.dimis.air.backendManagement.tools;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import de.uop.dimis.air.internalObjects.mpqf.InformationType;
import de.uop.dimis.air.internalObjects.mpqf.InputManagementType;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.internalObjects.mpqf.OutputManagementType;
import de.uop.dimis.air.internalObjects.mpqf.OutputQueryType;
import de.uop.dimis.air.internalObjects.mpqf.SystemMessageType;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType.Query;

/**
 * An abstract class for static building of {@link MpegQueryType} objects with
 * selected properties.
 * 
 * @author yakimov
 */
public abstract class MpqBuilder {

	/**
	 * Builds an empty {@link MpegQueryType} object, containing only the mpqfId
	 * 
	 * @return - the builded {@link MpegQueryType}
	 */
	public static MpegQueryType buildCoreMPQF() {
		MpegQueryType resp = new MpegQueryType();
		String id = UUID.randomUUID().toString();
		resp.setMpqfID(id);
		return resp;
	}

	/**
	 * Builds a {@link MpegQueryType} with the specified Exception message.
	 * 
	 * @param excCode -
	 *            the exception code to use (must be a string representation of
	 *            an positive integer)
	 * @param excMsg -
	 *            the exception text
	 * @return - the builded {@link MpegQueryType}
	 */
	public static MpegQueryType buildExcMPQF(String excCode, String excMsg) {
		MpegQueryType resp = buildSysMesMPQF();
		List<InformationType> exs = resp.getManagement().getOutput()
				.getSystemMessage().getException();
		InformationType inf = new InformationType();
		inf.setCode(new BigInteger(excCode));
		inf.setDescription(excMsg);
		exs.add(inf);
		return resp;
	}

	/**
	 * Returns an empty {@link MpegQueryType} with Management.Input
	 * 
	 * @return - an empty {@link MpegQueryType} with Management.Input
	 */
	public static MpegQueryType buildMangmInMPQF() {
		MpegQueryType resp = buildCoreMPQF();
		resp.setManagement(new MpegQueryType.Management());
		resp.getManagement().setInput(new InputManagementType());
		return resp;
	}

	/**
	 * Builds a {@link MpegQueryType} with Management.Output
	 * 
	 * @return - {@link MpegQueryType} with Management.Output
	 */
	public static MpegQueryType buildMangmOutMPQF() {
		MpegQueryType mpq = new MpegQueryType();
		mpq.setManagement(new MpegQueryType.Management());
		mpq.getManagement().setOutput(new OutputManagementType());
		return mpq;
	}

	/**
	 * Builds a {@link MpegQueryType} ready for setting results into.
	 * 
	 * @return - {@link MpegQueryType} ready for setting results into
	 */
	public static MpegQueryType buildResultMPQF() {
		MpegQueryType mpq = buildStsMPQF(Constants.STAT_SUCC_CODE,
				Constants.STAT_SUCC);
		mpq.setQuery(new Query());
		mpq.getQuery().setOutput(new OutputQueryType());
		return mpq;
	}

	/**
	 * Builds a {@link MpegQueryType} object with a specified system message.
	 * 
	 * @param stsCode -
	 *            code for the system message
	 * @param stsMsg -
	 *            the description of the system message
	 * @return - {@link MpegQueryType} object containinig the system message
	 */
	public static MpegQueryType buildStsMPQF(String stsCode, String stsMsg) {
		MpegQueryType resp = buildSysMesMPQF();
		List<InformationType> exs = resp.getManagement().getOutput()
				.getSystemMessage().getStatus();
		InformationType inf = new InformationType();
		inf.setCode(new BigInteger(stsCode));
		inf.setDescription(stsMsg);
		exs.add(inf);
		return resp;
	}
	
	/**
	 * Builds an empty {@link MpegQueryType} object with (empty)
	 * {@link SystemMessageType}
	 * 
	 * @return - the builded {@link MpegQueryType}
	 */
	public static MpegQueryType buildSysMesMPQF() {
		MpegQueryType resp = buildMangmOutMPQF();
		resp.getManagement().getOutput().setSystemMessage(
				new SystemMessageType());
		resp.getManagement().getOutput().getSystemMessage();
		return resp;
	}

	/**
	 * Builds a {@link MpegQueryType} with the specified Warning message.
	 * 
	 * @param warnCode -
	 *            warning code to use
	 * @param warnMsg -
	 *            warning text
	 * @return - the builded {@link MpegQueryType}
	 */
	public static MpegQueryType buildWarnMPQF(String warnCode, String warnMsg) {
		MpegQueryType resp = buildSysMesMPQF();
		List<InformationType> exs = resp.getManagement().getOutput()
				.getSystemMessage().getWarning();
		InformationType inf = new InformationType();
		inf.setCode(new BigInteger(warnCode));
		inf.setDescription(warnMsg);
		exs.add(inf);
		return resp;
	}

}