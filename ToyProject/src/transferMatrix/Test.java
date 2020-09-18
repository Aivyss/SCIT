package transferMatrix;

public class Test {
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
				double[][] iTO1 = genMatrix(incAngle, wavelength, indexRealITO, indexImaginITO, thicknessITO1);
				double[][] iTO3 = genMatrix(incAngle, wavelength, indexRealITO, indexImaginITO, thicknessITO3);
				double[][] ag2 =genMatrix(incAngle, wavelength, indexRealAg, indexImaginAg, thicknessAg2);
				double[][] integMatrix = integMatrix(iTO1, integMatrix(ag2, iTO3));
				// incAngle, wavelength, indexReal, indexImagin, thickness

				
				// Result
				// integMatrix, wavelength, incAngle, realIndexS imaginIndexS, realIndex0, imaginIndex0
				double[] result = result(integMatrix, wavelength, incAngle, realIndexS, imaginIndexS, realIndex0, imaginIndex0);
				
				// Print
				System.out.println(result[0]);
				System.out.println(result[1]);
	} // main method end
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	static double[] add(double real1, double imagin1, double real2, double imagin2) {
		double real = real1 + real2;
		double imagin = imagin1 + imagin2;

		double[] complex = new double[2];
		complex[0] = real;
		complex[1] = imagin;

		return complex;
	}

	static double[] add(double[] complex1, double[] complex2) {
		double real = complex1[0] + complex2[0];
		double imagin = complex1[1] + complex2[1];

		double[] complex = new double[2];
		complex[0] = real;
		complex[1] = imagin;

		return complex;
	}

	static double[] minus(double real1, double imagin1, double real2, double imagin2) {
		double real = real1 - real2;
		double imagin = imagin1 - imagin2;

		double[] complex = new double[2];
		complex[0] = real;
		complex[1] = imagin;

		return complex;
	}

	static double[] minus(double[] complex1, double[] complex2) {
		double real = complex1[0] - complex2[0];
		double imagin = complex1[1] - complex2[1];

		double[] complex = new double[2];
		complex[0] = real;
		complex[1] = imagin;

		return complex;
	}

	static double[] multiply(double real1, double imagin1, double real2, double imagin2) {
		double real = real1 * real2 - imagin1 * imagin2;
		double imagin = real1 * imagin2 + real2 * imagin1;

		double[] complex = new double[2];
		complex[0] = real;
		complex[1] = imagin;

		return complex;
	}

	static double[] multiply(double[] complex1, double[] complex2) {
		double real = complex1[0] * complex2[0] - complex1[1] * complex2[1];
		double imagin = complex1[0] * complex2[1] + complex1[1] * complex2[0];

		double[] complex = new double[2];
		complex[0] = real;
		complex[1] = imagin;

		return complex;
	}

	static double[] divide(double real1, double imagin1, double real2, double imagin2) {
		double[] denomi = new double[2];
		double[] numer = new double[2];
		double real;
		double imagin;

		denomi = multiply(real2, imagin2, real2, -imagin2);
		numer = multiply(real2, -imagin2, real1, imagin1);

		real = numer[0] / denomi[0];
		imagin = numer[1] / denomi[0];

		double[] complex = new double[2];
		complex[0] = real;
		complex[1] = imagin;

		return complex;
	}

	static double[] divide(double[] complex1, double[] complex2) {
		double[] denomi = new double[2];
		double[] numer = new double[2];
		double real;
		double imagin;

		denomi = multiply(complex2[0], complex2[1], complex2[0], -complex2[1]);
		numer = multiply(complex1[0], complex1[1], complex2[0], -complex2[1]);

		real = numer[0] / denomi[0];
		imagin = numer[1] / denomi[0];

		double[] complex = new double[2];
		complex[0] = real;
		complex[1] = imagin;

		return complex;
	}

	static double[] sin(double real, double imagin) { // complex angle
		double[] output = new double[2];
		double[] i2 = new double[2];
		i2[0] = 0;
		i2[1] = 2;

		output = divide(minus(Math.exp(-imagin) * Math.cos(real), Math.exp(-imagin) * Math.sin(real),
				Math.exp(imagin) * Math.cos(-real), Math.exp(imagin) * Math.sin(-real)),i2);

		return output;
	}
	
	static double[] sin(double[] angle) { // complex angle array
		double real = angle[0];
		double imagin = angle[1];
		double[] i2 = new double[2];
		i2[0] = 0;
		i2[1] = 2;
		
		double[] output = new double[2];
		output = divide(minus(Math.exp(-imagin) * Math.cos(real), Math.exp(-imagin) * Math.sin(real),
				Math.exp(imagin) * Math.cos(-real), Math.exp(imagin) * Math.sin(-real)),i2);

		return output;
	}
	
	static double[] cos(double real, double imagin) { // complex angle
		double[] output = new double[2];
		double[] r2 = new double[2];
		r2[0] = 2;
		r2[1] = 0;

		output = divide(add(Math.exp(-imagin) * Math.cos(real), Math.exp(-imagin) * Math.sin(real),
				Math.exp(imagin) * Math.cos(-real), Math.exp(imagin) * Math.sin(-real)), r2);

		return output;
	}
	
	static double[] cos(double[] angle) { // complex angle array
		double real = angle[0];
		double imagin = angle[1];
		double[] r2 = new double[2];
		r2[0] = 2;
		r2[1] = 0;

		double[] output = new double[2];
		output = divide(add(Math.exp(-imagin) * Math.cos(real), Math.exp(-imagin) * Math.sin(real),
				Math.exp(imagin) * Math.cos(-real), Math.exp(imagin) * Math.sin(-real)), r2);

		return output;
	}

	static String display(double[] complex) {
		String real = Double.toString(complex[0]);
		String imagin = Double.toString(complex[1]);
		String output = real + "+" + imagin + "i";

		return output;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////

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

		transMat[0][0] = cos(effectivePathLength)[0];
		transMat[1][0] = cos(effectivePathLength)[1]; // m11
		transMat[0][1] = multiply(divide(i1, simpler), sin(effectivePathLength))[0];
		transMat[1][1] = multiply(divide(i1, simpler), sin(effectivePathLength))[1]; // m12
		transMat[0][2] = multiply(multiply(i1, simpler), sin(effectivePathLength))[0];
		transMat[1][2] = multiply(multiply(i1, simpler), sin(effectivePathLength))[1]; // m21
		transMat[0][3] = cos(effectivePathLength)[0];
		transMat[1][3] = cos(effectivePathLength)[1]; // m22

		return transMat; // length independent
	}

	public static double[][] integMatrix(double[][] matrix1, double[][] matrix2) {
		double[][] integMatrix = new double[2][4];
		
		double[] m11 = add(matrix1[0][0], 0, 0, matrix1[1][0]);
		double[] m12 = add(matrix1[0][1], 0, 0, matrix1[1][1]);
		double[] m21 = add(matrix1[0][2], 0, 0, matrix1[1][2]);
		double[] m22 = add(matrix1[0][3], 0, 0, matrix1[1][3]);
		
		double[] n11 = add(matrix2[0][0], 0, 0, matrix2[1][0]);
		double[] n12 = add(matrix2[0][1], 0, 0, matrix2[1][1]);
		double[] n21 = add(matrix2[0][2], 0, 0, matrix2[1][2]);
		double[] n22 = add(matrix2[0][3], 0, 0, matrix2[1][3]);

		double[] m11n11 = multiply(m11, n11);
		double[] m12n21 = multiply(m12, n21);
		//
		double[] m11n12 = multiply(m11, n12);
		double[] m12n22 = multiply(m12, n22);
		//
		double[] m21n11 = multiply(m21, n11);
		double[] m22n21 = multiply(m22, n21);
		//
		double[] m21n12 = multiply(m21, n12);
		double[] m22n22 = multiply(m22, n22);
		
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
		
		double[] a = multiply(simpler0[0], simpler0[1], integMatrix[0][0], integMatrix[1][0]);
		double[] b = multiply(multiply(simpler0, simplerS)[0], multiply(simpler0, simplerS)[1], integMatrix[0][1], integMatrix[1][1]);
		double[] c = {integMatrix[0][2], integMatrix[1][2]};
		double[] d = multiply(simplerS[0], simplerS[1], integMatrix[0][3], integMatrix[1][3]);

		
		double[] refFactor=divide(minus(minus(add(a, b), c), d), add(add(add(a, b), c), d));
		double[] transFactor = divide(multiply(real2, simpler0), add(add(add(a, b), c), d));
		
		double[] refTrans = new double[2];
		refTrans[0] = multiply(refFactor[0], refFactor[1], refFactor[0], -refFactor[1])[0];
		refTrans[1] = multiply(transFactor[0], transFactor[1], transFactor[0], -transFactor[1])[0];
		
		return refTrans;
		// return refTrans;
	}
}
