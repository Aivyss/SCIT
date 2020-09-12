package java20200912;

import java.util.ArrayList;

public class MatrixMain {

	public static void main(String[] args) {
		// Light information
		double eField = 30.0;
		double hField = 30.0/100;
		double incAngle = 0.0;
		double wavelength = 0.000000000450;
		
		// Sandwitch Layer information
		double indexRealITO = 2.06;
		double indexImaginITO = 0.014;
		double thicknessITO1 = 0.00000000034;
		double thicknessITO3 = 0.00000000034;
		
		// Metal information
		double indexRealAg = 0.04;
		double indexImaginAg = 2.65;
		double thicknessAg2 = 0.0000000003;
		
		// Boundary Informations
		double realIndexS = 2.5;
		double imaginIndexS = 0.0;
		double realIndex0 = 1.0;
		double imaginIndex0 = 0;
		
		// Container ArrayLists
		ArrayList<Object>[] iTO1 = new ArrayList[2];
		ArrayList<Object>[] iTO3 = new ArrayList[2];
		ArrayList<Object>[] ag2 = new ArrayList[2];
		ArrayList<Object>[] integMatrix = new ArrayList[2];
		
		
		// Generating Matrix
		// incAngle, wavelength, indexReal, indexImagin, thickness
		TransferMatrix trM = new TransferMatrix();
		iTO1 = trM.genMatrix(incAngle, wavelength, indexRealITO, indexImaginITO, thicknessITO1);
		ag2 = trM.genMatrix(incAngle, wavelength, indexRealITO, indexImaginITO, thicknessAg2);
		iTO3 = trM.genMatrix(incAngle, wavelength, indexRealITO, indexImaginITO, thicknessITO3);
		
		// Integration
		integMatrix = trM.integrationMatrix(iTO3, trM.integrationMatrix(iTO1, ag2));
		
		// Result
		// integMatrix, wavelength, incAngle, realIndexS imaginIndexS, realIndex0, imaginIndex0
		double[] result = trM.result(integMatrix, wavelength, incAngle, realIndexS, imaginIndexS, realIndex0, imaginIndex0);
		
		// Print
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}
