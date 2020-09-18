package transferMatrix;

import java.math.BigDecimal;
import java.math.MathContext;

public class VersionUpTransferMatrix {
	
	public VersionUpTransferMatrix() {
		
	}

	public static BigDecimal[][] genMatrix(BigDecimal incAngle, BigDecimal wavelength, BigDecimal indexReal,
			BigDecimal indexImagin, BigDecimal thickness) {
		// [ imaginary part / real part ][ matrix index 11, 12, 21, 22, ]
		BigDecimal[][] transMat = new BigDecimal[2][4]; 
		BigDecimal[] effectivePathLength = new BigDecimal[2]; // δ
		BigDecimal[] simpler = new BigDecimal[2]; // p
		BigDecimal parameter = new BigDecimal("0.0026544187294");// new BigDecimal("1");
		BigDecimal temp1 = new BigDecimal(Double.toString(Math.cos(incAngle.doubleValue())));
		BigDecimal temp2 = new BigDecimal(Double.toString(2 * Math.PI));
		
		BigDecimal[] i1 = new BigDecimal[2];
		i1[0] = new BigDecimal("0");
		i1[1] = new BigDecimal("1");

		simpler[0] = indexReal.multiply(temp1);
		simpler[1] = indexImagin.multiply(temp1);
		effectivePathLength[0] = (((temp2.multiply(parameter)).multiply(thickness)).multiply(simpler[0])).divide(wavelength, MathContext.DECIMAL32); // length independent
		effectivePathLength[1] = (((temp2.multiply(parameter)).multiply(thickness)).multiply(simpler[1])).divide(wavelength, MathContext.DECIMAL32); // length independent

		transMat[0][0] = VersionUpComplexCalc.cos(effectivePathLength)[0];
		transMat[1][0] = VersionUpComplexCalc.cos(effectivePathLength)[1]; // m11
		transMat[0][1] = VersionUpComplexCalc.multiply(VersionUpComplexCalc.divide(i1, simpler), VersionUpComplexCalc.sin(effectivePathLength))[0];
		transMat[1][1] = VersionUpComplexCalc.multiply(VersionUpComplexCalc.divide(i1, simpler), VersionUpComplexCalc.sin(effectivePathLength))[1]; // m12
		transMat[0][2] = VersionUpComplexCalc.multiply(VersionUpComplexCalc.multiply(i1, simpler), VersionUpComplexCalc.sin(effectivePathLength))[0];
		transMat[1][2] = VersionUpComplexCalc.multiply(VersionUpComplexCalc.multiply(i1, simpler), VersionUpComplexCalc.sin(effectivePathLength))[1]; // m21
		transMat[0][3] = VersionUpComplexCalc.cos(effectivePathLength)[0];
		transMat[1][3] = VersionUpComplexCalc.cos(effectivePathLength)[1]; // m22

		return transMat; // length independent
	}

	public static BigDecimal[][] integMatrix(BigDecimal[][] matrix1, BigDecimal[][] matrix2) {
		BigDecimal[][] integMatrix = new BigDecimal[2][4];
		
		BigDecimal[] m11 = VersionUpComplexCalc.add(matrix1[0][0], BigDecimal.ZERO, BigDecimal.ZERO, matrix1[1][0]);
		BigDecimal[] m12 = VersionUpComplexCalc.add(matrix1[0][1], BigDecimal.ZERO, BigDecimal.ZERO, matrix1[1][1]);
		BigDecimal[] m21 = VersionUpComplexCalc.add(matrix1[0][2], BigDecimal.ZERO, BigDecimal.ZERO, matrix1[1][2]);
		BigDecimal[] m22 = VersionUpComplexCalc.add(matrix1[0][3], BigDecimal.ZERO, BigDecimal.ZERO, matrix1[1][3]);
		
		BigDecimal[] n11 = VersionUpComplexCalc.add(matrix2[0][0], BigDecimal.ZERO, BigDecimal.ZERO, matrix2[1][0]);
		BigDecimal[] n12 = VersionUpComplexCalc.add(matrix2[0][1], BigDecimal.ZERO, BigDecimal.ZERO, matrix2[1][1]);
		BigDecimal[] n21 = VersionUpComplexCalc.add(matrix2[0][2], BigDecimal.ZERO, BigDecimal.ZERO, matrix2[1][2]);
		BigDecimal[] n22 = VersionUpComplexCalc.add(matrix2[0][3], BigDecimal.ZERO, BigDecimal.ZERO, matrix2[1][3]);

		BigDecimal[] m11n11 = VersionUpComplexCalc.multiply(m11, n11);
		BigDecimal[] m12n21 = VersionUpComplexCalc.multiply(m12, n21);
		//
		BigDecimal[] m11n12 = VersionUpComplexCalc.multiply(m11, n12);
		BigDecimal[] m12n22 = VersionUpComplexCalc.multiply(m12, n22);
		//
		BigDecimal[] m21n11 = VersionUpComplexCalc.multiply(m21, n11);
		BigDecimal[] m22n21 = VersionUpComplexCalc.multiply(m22, n21);
		//
		BigDecimal[] m21n12 = VersionUpComplexCalc.multiply(m21, n12);
		BigDecimal[] m22n22 = VersionUpComplexCalc.multiply(m22, n22);
		
		integMatrix[0][0] = m11n11[0].add(m12n21[0]);
		integMatrix[1][0] = m11n11[1].add(m12n21[1]); // m'11
		
		integMatrix[0][1] = m11n12[0].add(m12n22[0]);
		integMatrix[1][1] = m11n12[1].add(m12n22[1]); // m'12
		
		integMatrix[0][2] = m21n11[0].add(m22n21[0]);
		integMatrix[1][2] = m22n21[1].add(m22n21[1]); // m'21
		
		integMatrix[0][3] = m21n12[0].add(m22n22[0]);
		integMatrix[1][3] = m21n12[1].add(m22n22[1]); // m'22
		
		return integMatrix;
	}

	public static BigDecimal[] result(BigDecimal[][] integMatrix, BigDecimal wavelength, BigDecimal incAngle, BigDecimal realIndexS, BigDecimal imaginIndexS , BigDecimal realIndex0, BigDecimal imaginIndex0, BigDecimal eField, BigDecimal hField) {
		/*
		BigDecimal[] m11 = VersionUpComplexCalc.add(integMatrix[0][0], BigDecimal.ZERO, BigDecimal.ZERO, integMatrix[1][0]);
		BigDecimal[] m12 = VersionUpComplexCalc.add(integMatrix[0][1], BigDecimal.ZERO, BigDecimal.ZERO, integMatrix[1][1]);
		BigDecimal[] m21 = VersionUpComplexCalc.add(integMatrix[0][2], BigDecimal.ZERO, BigDecimal.ZERO, integMatrix[1][2]);
		BigDecimal[] m22 = VersionUpComplexCalc.add(integMatrix[0][3], BigDecimal.ZERO, BigDecimal.ZERO, integMatrix[1][3]);
		
		BigDecimal[] eFieldI = VersionUpComplexCalc.add(VersionUpComplexCalc.multiply(m11[0], m11[1], eField, BigDecimal.ZERO), VersionUpComplexCalc.multiply(m12[0], m12[1], hField, BigDecimal.ZERO));
		BigDecimal[] hFieldI = VersionUpComplexCalc.add(VersionUpComplexCalc.multiply(m21[0], m21[1], eField, BigDecimal.ZERO), VersionUpComplexCalc.multiply(m22[0], m22[1], hField, BigDecimal.ZERO));
		
		BigDecimal negative = new BigDecimal("-1");
		
		BigDecimal[] transFactor = VersionUpComplexCalc.divide(eFieldI[0], eFieldI[1], eField, BigDecimal.ZERO);
		BigDecimal[] output = VersionUpComplexCalc.multiply(transFactor[0], transFactor[1], transFactor[0], transFactor[1].multiply(negative));
		*/
		
		BigDecimal[] simplerS = new BigDecimal[2];
		BigDecimal[] simpler0 = new BigDecimal[2];
		BigDecimal[] real2 = new BigDecimal[2];
		BigDecimal parameter = new BigDecimal("0.0026544187294");//new BigDecimal("1"); 
		BigDecimal temp1 = new BigDecimal(Double.toString(Math.cos(incAngle.doubleValue())));
		BigDecimal negative = new BigDecimal("-1");
		
		real2[0] = new BigDecimal("2");
		real2[1] = new BigDecimal("0");
		
		simplerS[0] = (parameter.multiply(realIndexS)).multiply(temp1);
		simplerS[1] = (parameter.multiply(imaginIndexS)).multiply(temp1);
		simpler0[0] = (parameter.multiply(realIndex0)).multiply(temp1);
		simpler0[1] = (parameter.multiply(imaginIndex0)).multiply(temp1);
		
		BigDecimal[] a = VersionUpComplexCalc.multiply(simpler0[0], simpler0[1], integMatrix[0][0], integMatrix[1][0]);
		BigDecimal[] b = VersionUpComplexCalc.multiply(VersionUpComplexCalc.multiply(simpler0, simplerS)[0], VersionUpComplexCalc.multiply(simpler0, simplerS)[1], integMatrix[0][1], integMatrix[1][1]);
		BigDecimal[] c = {integMatrix[0][2], integMatrix[1][2]};
		BigDecimal[] d = VersionUpComplexCalc.multiply(simplerS[0], simplerS[1], integMatrix[0][3], integMatrix[1][3]);

		
		BigDecimal[] refFactor=VersionUpComplexCalc.divide(VersionUpComplexCalc.subtract(VersionUpComplexCalc.subtract(VersionUpComplexCalc.add(a, b), c), d), VersionUpComplexCalc.add(VersionUpComplexCalc.add(VersionUpComplexCalc.add(a, b), c), d));
		BigDecimal[] transFactor = VersionUpComplexCalc.divide(VersionUpComplexCalc.multiply(real2, simpler0), VersionUpComplexCalc.add(VersionUpComplexCalc.add(VersionUpComplexCalc.add(a, b), c), d));
		
		BigDecimal[] refTrans = new BigDecimal[2];
		refTrans[0] = VersionUpComplexCalc.multiply(refFactor[0], refFactor[1], refFactor[0], refFactor[1].multiply(negative))[0];
		refTrans[1] = VersionUpComplexCalc.multiply(transFactor[0], transFactor[1], transFactor[0], transFactor[1].multiply(negative))[0];
		
		return refTrans;
	}
}
