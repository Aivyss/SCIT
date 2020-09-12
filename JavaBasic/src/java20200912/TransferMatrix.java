package java20200912;

import java.util.ArrayList;

public class TransferMatrix {
	
	public TransferMatrix() {
		
	}
	
	static public ArrayList<Object>[] genMatrix(double incAngle, double wavelength, double indexReal,
			double indexImagin, double thickness) {
		ComplexCalc cC = new ComplexCalc();
		ArrayList<Object>[] transferMatrix = new ArrayList[2];
		double[] effectivePathLength = new double[2]; // δ
		double[] simpler = new double[2];

		double[] i1 = new double[2];
		i1[0] = 0;
		i1[1] = 1;

		simpler[0] = indexReal * Math.cos(incAngle);
		simpler[1] = indexImagin * Math.cos(incAngle);
		effectivePathLength[0] = 2 * Math.PI * thickness * simpler[0] / wavelength;
		effectivePathLength[1] = 2 * Math.PI * thickness * simpler[1] / wavelength;

		transferMatrix[0].add(cC.cos(effectivePathLength));
		transferMatrix[1]
				.add(cC.multiply(cC.divide(i1, simpler), cC.sin(effectivePathLength)));
		transferMatrix[0]
				.add(cC.multiply(cC.multiply(i1, simpler), cC.sin(effectivePathLength)));
		transferMatrix[1].add(cC.cos(effectivePathLength));

		return transferMatrix;
	}

	static public ArrayList<Object>[] integrationMatrix(ArrayList<Object>[] matrix1, ArrayList<Object>[] matrix2) {
		ComplexCalc cC = new ComplexCalc();
		ArrayList<Object>[] integMatrix = new ArrayList[2];

		double[] aE = cC.multiply((double[]) matrix1[0].get(0), (double[]) matrix2[0].get(0));
		double[] bG = cC.multiply((double[]) matrix1[0].get(1), (double[]) matrix2[1].get(0));
		double[] aF = cC.multiply((double[]) matrix1[0].get(0), (double[]) matrix2[0].get(1));
		double[] bH = cC.multiply((double[]) matrix1[0].get(1), (double[]) matrix2[1].get(1));

		double[] cE = cC.multiply((double[]) matrix1[1].get(0), (double[]) matrix2[0].get(0));
		double[] dG = cC.multiply((double[]) matrix1[1].get(1), (double[]) matrix2[1].get(0));
		double[] cF = cC.multiply((double[]) matrix1[1].get(0), (double[]) matrix2[0].get(1));
		double[] dH = cC.multiply((double[]) matrix1[1].get(1), (double[]) matrix2[1].get(1));

		integMatrix[0].add(cC.add(aE, bG));
		integMatrix[0].add(cC.add(aF, bH));
		integMatrix[1].add(cC.add(cE, dG));
		integMatrix[1].add(cC.add(cF, dH));

		return integMatrix;
	}

	public static double[] result(ArrayList<Object>[] integMatrix, double wavelength, double incAngle, double realIndexS, double imaginIndexS , double realIndex0, double imaginIndex0) {
		ComplexCalc cC = new ComplexCalc();
		double[] simplerS = new double[2];
		double[] simpler0 = new double[2];
		double[] real2 = new double[2];
		real2[0] = 2;
		real2[1] = 0;
		
		simplerS[0] = realIndexS * Math.cos(incAngle);
		simplerS[1] = imaginIndexS * Math.cos(incAngle);
		simpler0[0] = realIndex0 * Math.cos(incAngle);
		simpler0[1] = imaginIndex0 * Math.cos(incAngle);
		
		double[] a = cC.multiply(simpler0, (double[]) integMatrix[0].get(0));
		double[] b = cC.multiply(cC.multiply(simpler0, simplerS), (double[]) integMatrix[0].get(1));
		double[] c = (double[]) integMatrix[1].get(0);
		double[] d = cC.multiply(simplerS, (double[]) integMatrix[1].get(1));
		
		double[] refFactor=cC.divide(cC.add(cC.add(cC.add(a, b), c), d), cC.add(cC.minus(cC.add(a, b), c), d));
		double[] transFactor = cC.divide(cC.multiply(real2, simpler0), cC.add(cC.minus(cC.add(a, b), c), d));
		
		double[] refTrans = new double[2];
		refTrans[0] = cC.multiply(refFactor, refFactor)[0];
		refTrans[1] = cC.multiply(transFactor, transFactor)[0];
		
		return refTrans;
	}
}
