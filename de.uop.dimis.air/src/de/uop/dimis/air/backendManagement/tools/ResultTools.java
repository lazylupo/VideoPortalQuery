package de.uop.dimis.air.backendManagement.tools;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import de.uop.dimis.air.backendManagement.datasets.SingleResultContainer;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.internalObjects.mpqf.OutputQueryType;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType.Query;

/**
 * Contains methods useful for working with search results.
 * 
 * @author yakimov
 */
public abstract class ResultTools {

	/**
	 * Builds the results of the given map into an {@link MpegQueryType}.
	 * 
	 * @param singlRsts -
	 *            map containing the results
	 * @return - results builded into a {@link MpegQueryType}
	 */
	public static MpegQueryType buildMap(
			Collection<SingleResultContainer> singlRsts) {

		MpegQueryType mpq = MpqBuilder.buildStsMPQF(Constants.STAT_SUCC_CODE,
				Constants.STAT_SUCC);
		mpq.setQuery(new Query());
		mpq.getQuery().setOutput(new OutputQueryType());
		List<List<ResultItemType>> allRes = new LinkedList<List<ResultItemType>>();
		int resSize = 0;
		for (SingleResultContainer singRst : singlRsts) {
			MpegQueryType resMpq = singRst.getValue();
			if (resMpq != null && resMpq.getQuery() != null
					&& resMpq.getQuery().getOutput() != null
					&& resMpq.getQuery().getOutput().getResultItem().size() > 0) {

				allRes.add((resMpq.getQuery().getOutput().getResultItem()));
				resSize = resSize
						+ resMpq.getQuery().getOutput().getResultItem().size();
			}
		}

		while (mpq.getQuery().getOutput().getResultItem().size() < resSize) {
			for (List<ResultItemType> res : allRes) {
				if (res.size() > 0) {
					ResultItemType rT = res.remove(0);
					mpq.getQuery().getOutput().getResultItem().add(rT);
				}
			}
		}

		return mpq;
	}
}
