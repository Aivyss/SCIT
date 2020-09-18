package transferMatrix;

public class TransferMatrix {
	
	public TransferMatrix() {
		
	}

	public static double[][] genMatrix(double incAngle, double wavelength, double indexReal,
			double indexImagin, double thickness) {
		// [ imaginary part / real part ][ matrix index 11, 12, 21, 22, ]
		double[][] transMat = new double[2][4]; 
		double[] effectivePathLength = new double[2]; // δ
		double[] simpler = new double[2]; // p
		double parameter = 0.0026544187294;
		
		double[] i1 = new double[2];
		i1[0] = 0;
		i1[1] = 1;

		simpler[0] = indexReal * Math.cos(incAngle);
		simpler[1] = indexImagin * Math.cos(incAngle);
		effectivePathLength[0] = 2 * Math.PI * parameter * thickness * simpler[0] / wavelength; // length independent
		effectivePathLength[1] = 2 * Math.PI * parameter * thickness * simpler[1] / wavelength; // length independent

		transMat[0][0] = ComplexCalc.cos(effectivePathLength)[0];
		transMat[1][0] = ComplexCalc.cos(effectivePathLength)[1]; // m11
		transMat[0][1] = ComplexCalc.multiply(ComplexCalc.divide(i1, simpler), ComplexCalc.sin(effectivePathLength))[0];
		transMat[1][1] = ComplexCalc.multiply(ComplexCalc.divide(i1, simpler), ComplexCalc.sin(effectivePathLength))[1]; // m12
		transMat[0][2] = ComplexCalc.multiply(ComplexCalc.multiply(i1, simpler), ComplexCalc.sin(effectivePathLength))[0];
		transMat[1][2] = ComplexCalc.multiply(ComplexCalc.multiply(i1, simpler), ComplexCalc.sin(effectivePathLength))[1]; // m21
		transMat[0][3] = ComplexCalc.cos(effectivePathLength)[0];
		transMat[1][3] = ComplexCalc.cos(effectivePathLength)[1]; // m22

		return transMat; // length independent
	}

	public static double[][] integMatrix(double[][] matrix1, double[][] matrix2) {
		double[][] integMatrix = new double[2][4];
		
		double[] m11 = ComplexCalc.add(matrix1[0][0], 0, 0, matrix1[1][0]);
		double[] m12 = ComplexCalc.add(matrix1[0][1], 0, 0, matrix1[1][1]);
		double[] m21 = ComplexCalc.add(matrix1[0][2], 0, 0, matrix1[1][2]);
		double[] m22 = ComplexCalc.add(matrix1[0][3], 0, 0, matrix1[1][3]);
		
		double[] n11 = ComplexCalc.add(matrix2[0][0], 0, 0, matrix2[1][0]);
		double[] n12 = ComplexCalc.add(matrix2[0][1], 0, 0, matrix2[1][1]);
		double[] n21 = ComplexCalc.add(matrix2[0][2], 0, 0, matrix2[1][2]);
		double[] n22 = ComplexCalc.add(matrix2[0][3], 0, 0, matrix2[1][3]);

		double[] m11n11 = ComplexCalc.multiply(m11, n11);
		double[] m12n21 = ComplexCalc.multiply(m12, n21);
		//
		double[] m11n12 = ComplexCalc.multiply(m11, n12);
		double[] m12n22 = ComplexCalc.multiply(m12, n22);
		//
		double[] m21n11 = ComplexCalc.multiply(m21, n11);
		double[] m22n21 = ComplexCalc.multiply(m22, n21);
		//
		double[] m21n12 = ComplexCalc.multiply(m21, n12);
		double[] m22n22 = ComplexCalc.multiply(m22, n22);
		
		integMatrix[0][0] = m11n11[0]+m12n21[0];
		integMatrix[1][0] = m11n11[1]+m12n21[1]; // m'11
		
		integMatrix[0][1] = m11n12[0]+m12n22[0];
		integMatrix[1][1] = m11n12[1]+m12n22[1]; // m'12
		
		integMatrix[0][2] = m21n11[0]+m22n21[0];
		integMatrix[1][2] = m22n21[1]+m22n21[1]; // m'21
		
		integMatrix[0][3] = m21n12[0]+m22n22[0];
		integMatrix[1][3] = m21n12[1]+m22n22[1]; // m'22
		
		return integMatrix;
	}

	public static double[] result(double[][] integMatrix, double wavelength, double incAngle, double realIndexS, double imaginIndexS , double realIndex0, double imaginIndex0) {
		double[] simplerS = new double[2];
		double[] simpler0 = new double[2];
		double[] real2 = new double[2];
		double parameter = 0.0026544187294;
		
		real2[0] = 2;
		real2[1] = 0;
		
		simplerS[0] = parameter*realIndexS * Math.cos(incAngle);
		simplerS[1] = parameter*imaginIndexS * Math.cos(incAngle);
		simpler0[0] = parameter*realIndex0 * Math.cos(incAngle);
		simpler0[1] = parameter*imaginIndex0 * Math.cos(incAngle);
		
		double[] a = ComplexCalc.multiply(simpler0[0], simpler0[1], integMatrix[0][0], integMatrix[1][0]);
		double[] b = ComplexCalc.multiply(ComplexCalc.multiply(simpler0, simplerS)[0], ComplexCalc.multiply(simpler0, simplerS)[1], integMatrix[0][1], integMatrix[1][1]);
		double[] c = {integMatrix[0][2], integMatrix[1][2]};
		double[] d = ComplexCalc.multiply(simplerS[0], simplerS[1], integMatrix[0][3], integMatrix[1][3]);

		
		double[] refFactor=ComplexCalc.divide(ComplexCalc.minus(ComplexCalc.minus(ComplexCalc.add(a, b), c), d), ComplexCalc.add(ComplexCalc.add(ComplexCalc.add(a, b), c), d));
		double[] transFactor = ComplexCalc.divide(ComplexCalc.multiply(real2, simpler0), ComplexCalc.add(ComplexCalc.add(ComplexCalc.add(a, b), c), d));
		
		double[] refTrans = new double[2];
		refTrans[0] = ComplexCalc.multiply(refFactor[0], refFactor[1], refFactor[0], -refFactor[1])[0];
		refTrans[1] = ComplexCalc.multiply(transFactor[0], transFactor[1], transFactor[0], -transFactor[1])[0];
		
		return refTrans;
		// return refTrans;
	}
}
