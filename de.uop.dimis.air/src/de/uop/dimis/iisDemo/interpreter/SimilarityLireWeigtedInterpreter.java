package de.uop.dimis.iisDemo.interpreter;

import dataSources.WeightedLiREDataSource;
import dataSources._ResultTuple;
import de.uop.dimis.air.backendManagement.tools.MpqBuilder;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.internalObjects.mpqf.OutputQueryType;
import de.uop.dimis.air.internalObjects.mpqf.QueryByMedia;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.MediaResource;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.Thumbnail;
import de.uop.dimis.air.searchInterface.SearchInterface;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * @author stegmai
 */
public class SimilarityLireWeigtedInterpreter implements SearchInterface {

	private static final String dataDir = "c:/LIREDataFolder/";
        private static final int numResults = 32;

	@Override
	public MpegQueryType execute(MpegQueryType qry) {

		byte[] imgBytes = ((QueryByMedia) qry.getQuery().getInput()
				.getQueryCondition().getCondition()).getMediaResource()
				.getMediaResource().getInlineMedia().getMediaData64();
		File file = new File("inputImage.jpeg");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);

			fos.write(imgBytes);
			fos.close();
		} catch (IOException ex) {
			Logger.getLogger(SimilarityLireWeigtedInterpreter.class.getName()).log(Level.SEVERE, null, ex);
		}

		WeightedLiREDataSource a = new WeightedLiREDataSource(dataDir, 0.2,
				0.2, 0.6);
		LinkedList<_ResultTuple> RT = new LinkedList<_ResultTuple>(a.searchFor(
				"inputImage.jpeg", numResults));

		MpegQueryType mpq = MpqBuilder.buildResultMPQF();

		if (mpq.getQuery().getOutput() == null) {
			mpq.getQuery().setOutput(new OutputQueryType());
		}

		List<ResultItemType> resultItmes = mpq.getQuery().getOutput()
				.getResultItem();

		String repository = "www.semanticmetadata.net/lire/";

		for (int i = 1; i <= RT.size(); i++) {
			ResultItemType rIt = new ResultItemType();
			rIt.setOriginID(repository);
			rIt.setRecordNumber(BigInteger.valueOf(i));

			List<Thumbnail> thumbs = rIt.getThumbnail();
			Thumbnail thumb = new Thumbnail();
            thumb.setFromREF(repository);
			thumb.setValue("http://localhost/iisdemo/thumb-" + RT.get(i - 1).getImagePath().substring(RT.get(i - 1).getImagePath().indexOf('-')+1));
			thumbs.add(thumb);

			List<MediaResource> resources = rIt.getMediaResource();
			MediaResource res = new MediaResource();
            res.setFromREF(repository);
			res.setValue("http://localhost/iisdemo/medium-" + RT.get(i - 1).getImagePath().substring(RT.get(i - 1).getImagePath().indexOf('-')+1));
			resources.add(res);

			resultItmes.add(rIt);
		}

		return mpq;
	}

}
