package de.uop.dimis.air.mpqfManagement.testing;

import java.math.BigInteger;

import de.uop.dimis.air.backendManagement.tools.MpqBuilder;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType;
import de.uop.dimis.air.searchInterface.SearchInterface;

public class TestDB implements SearchInterface{

	public MpegQueryType execute(MpegQueryType arg0) {
		long a = System.currentTimeMillis();
		MpegQueryType mpq = MpqBuilder.buildResultMPQF();
		for (int i = 0; i < 10; i++) {
			ResultItemType rIt = new ResultItemType();
			rIt.setOriginID("http://www.lalala.com/result" + i + ".jpg");
			rIt.setRecordNumber(BigInteger.valueOf(i));
			mpq.getQuery().getOutput().getResultItem().add(rIt);
		}
		long b = System.currentTimeMillis();
		
		System.out.println("zeit " + (b-a));
		
		return mpq;
	}
}
