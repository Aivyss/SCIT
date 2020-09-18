package transferMatrix;

public class MatrixMain {
	public static void main(String[] args) {
		// Light information
				double incAngle = 0.0;
				double wavelength = 450*1000; // pm scale
				
				// Sandwich Layer information
				double indexRealITO = 2.06;
				double indexImaginITO = 0.0;
				double thicknessITO1 = 50*1000;
				double thicknessITO3 = 100*1000;
				
				// Metal information
				double indexRealAg = 0.0;
				double indexImaginAg = 2.65;
				double thicknessAg2 = 6*1000;
				
				// Boundary Informations
				double realIndexS = 2.5;
				double imaginIndexS = 0.0;
				double realIndex0 = 1.0;
				double imaginIndex0 = 0;
						
				// Generating Matrix
				double[][] iTO1 = TransferMatrix.genMatrix(incAngle, wavelength, indexRealITO, indexImaginITO, thicknessITO1);
				double[][] iTO3 = TransferMatrix.genMatrix(incAngle, wavelength, indexRealITO, indexImaginITO, thicknessITO3);
				double[][] ag2 =TransferMatrix.genMatrix(incAngle, wavelength, indexRealAg, indexImaginAg, thicknessAg2);
				double[][] integMatrix = TransferMatrix.integMatrix(iTO1, TransferMatrix.integMatrix(ag2, iTO3));
				// incAngle, wavelength, indexReal, indexImagin, thickness

				
				// Result
				// TransferMatrix.integMatrix, wavelength, incAngle, realIndexS imaginIndexS, realIndex0, imaginIndex0
				double[] result = TransferMatrix.result(integMatrix, wavelength, incAngle, realIndexS, imaginIndexS, realIndex0, imaginIndex0);
				
				// Print
				System.out.println(result[0]);
				System.out.println(result[1]);
	} // main method end
}
