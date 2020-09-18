package transferMatrix;

import java.math.BigDecimal;
import java.math.MathContext;

public class VersionUpMatrixMain {
	public static void main(String[] args) {
		// Light information
		BigDecimal eField = new BigDecimal("300000000");
		BigDecimal permitivity = new BigDecimal(Double.toString((4*Math.PI*10000000)));
		BigDecimal hField = eField.divide(permitivity, MathContext.DECIMAL32);
		
		BigDecimal incAngle = new BigDecimal("0");
		BigDecimal wavelength = new BigDecimal("0.000000450");

		// Sandwich Layer information
		BigDecimal indexRealITO = new BigDecimal("1");
		BigDecimal indexImaginITO = new BigDecimal("0");
		BigDecimal thicknessITO1 = new BigDecimal("0.00000100");
		BigDecimal thicknessITO3 = new BigDecimal("0.00000035");

		// Metal information
		BigDecimal indexRealAg = new BigDecimal("1");
		BigDecimal indexImaginAg = new BigDecimal("0");
		BigDecimal thicknessAg2 = new BigDecimal("0.000000005");

		// Boundary Informations
		BigDecimal realIndexS = new BigDecimal("1");
		BigDecimal imaginIndexS = new BigDecimal("0");
		BigDecimal realIndex0 = new BigDecimal("1");
		BigDecimal imaginIndex0 = new BigDecimal("0");

		// Generating Matrix
		BigDecimal[][] iTO1 = VersionUpTransferMatrix.genMatrix(incAngle, wavelength, indexRealITO, indexImaginITO,
				thicknessITO1);
		BigDecimal[][] iTO3 = VersionUpTransferMatrix.genMatrix(incAngle, wavelength, indexRealITO, indexImaginITO,
				thicknessITO3);
		BigDecimal[][] ag2 = VersionUpTransferMatrix.genMatrix(incAngle, wavelength, indexRealAg, indexImaginAg,
				thicknessAg2);
		BigDecimal[][] integMatrix = VersionUpTransferMatrix.integMatrix(iTO1,
				VersionUpTransferMatrix.integMatrix(ag2, iTO3));
		// incAngle, wavelength, indexReal, indexImagin, thickness

		// Result
		// VersionUpTransferMatrix.integMatrix, wavelength, incAngle, realIndexS
		// imaginIndexS, realIndex0, imaginIndex0
		BigDecimal[] result = VersionUpTransferMatrix.result(integMatrix, wavelength, incAngle, realIndexS, imaginIndexS, realIndex0, imaginIndex0, eField, hField);

		// Print
		System.out.println(result[1].doubleValue());
	} // main method end
}
