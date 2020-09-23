package java20200923;

import java.math.BigDecimal;
import java.math.MathContext;

public class ComplexCalc {
	
	// Constructor
	public ComplexCalc() { 

	}
	
/*
 * -----------------
 * 
 * Add method returns the summation of two complex number
 * complex 1 + complex 2
 * You can also input real value. Just input a = a + 0*i (a is real value)
 * 
 * ----------------
 */
	public static BigDecimal[] add(BigDecimal real1, BigDecimal imagin1, BigDecimal real2, BigDecimal imagin2) {
		BigDecimal[] complex = new BigDecimal[2];
		complex[0] = real1.add(real2);
		complex[1] = imagin1.add(imagin2);

		return complex;
	}

	public static BigDecimal[] add(BigDecimal[] complex1, BigDecimal[] complex2) {
		BigDecimal[] complex = new BigDecimal[2];
		complex[0] = complex1[0].add(complex2[0]);
		complex[1] = complex1[1].add(complex2[1]);

		return complex;
	}

/*
 * -----------------
 * 
 * subtract method returns the subtraction of two complex number.
 * complex 1 - complex 2
 * You can also input real value. Just input a = a + 0*i (a is real value)
 * 
 * ----------------
 */
	public static BigDecimal[] subtract(BigDecimal real1, BigDecimal imagin1, BigDecimal real2, BigDecimal imagin2) {
		BigDecimal[] complex = new BigDecimal[2];
		complex[0] = real1.subtract(real2);
		complex[1] = imagin1.subtract(imagin2);

		return complex;
	}

	public static BigDecimal[] subtract(BigDecimal[] complex1, BigDecimal[] complex2) {
		BigDecimal[] complex = new BigDecimal[2];
		complex[0] = complex1[0].subtract(complex2[0]);
		complex[1] = complex1[1].subtract(complex2[1]);

		return complex;
	}
	
/*
 * -----------------
 * 
 * multiply method returns the multiply result of two complex number.
 * complex 1 * complex 2
 * You can also input real value. Just input a = a + 0*i (a is real value)
 * 
 * ----------------
 */
	public static BigDecimal[] multiply(BigDecimal real1, BigDecimal imagin1, BigDecimal real2, BigDecimal imagin2) {
		BigDecimal[] complex = new BigDecimal[2];
		complex[0] = (real1.multiply(real2)).subtract(imagin1.multiply(imagin2));
		complex[1] = (real1.multiply(imagin2)).add(real2.multiply(imagin1));

		return complex;
	}

	public static BigDecimal[] multiply(BigDecimal[] complex1, BigDecimal[] complex2) {
		BigDecimal[] complex = new BigDecimal[2];
		complex[0] = (complex1[0].multiply(complex2[0])).subtract(complex1[1].multiply(complex2[1]));
		complex[1] = (complex1[0].multiply(complex2[1])).add(complex1[1].multiply(complex2[0]));

		return complex;
	}
	
/*
 * -----------------
 * 
 * divide method returns the divide result of two complex number.
 * complex 1 / complex 2
 * You can also input real value. Just input a = a + 0*i (a is real value)
 * 
 * ----------------
 */
	public static BigDecimal[] divide(BigDecimal real1, BigDecimal imagin1, BigDecimal real2, BigDecimal imagin2) {
		BigDecimal[] denomi = new BigDecimal[2];
		BigDecimal[] numer = new BigDecimal[2];
		BigDecimal negative = new BigDecimal("-1");

		denomi = multiply(real2, imagin2, real2, imagin2.multiply(negative));
		numer = multiply(real2, imagin2.multiply(negative), real1, imagin1);

		BigDecimal[] complex = new BigDecimal[2];
		complex[0] = numer[0].divide(denomi[0], MathContext.DECIMAL32);
		complex[1] = numer[1].divide(denomi[0], MathContext.DECIMAL32);

		return complex;
	}

	public static BigDecimal[] divide(BigDecimal[] complex1, BigDecimal[] complex2) {
		BigDecimal negative = new BigDecimal("-1");
		BigDecimal[] denomi = new BigDecimal[2];
		BigDecimal[] numer = new BigDecimal[2];

		denomi = multiply(complex2[0], complex2[1], complex2[0], complex2[1].multiply(negative));
		numer = multiply(complex1[0], complex1[1], complex2[0], complex2[1].multiply(negative));

		BigDecimal[] complex = new BigDecimal[2];
		complex[0] = numer[0].divide(denomi[0], MathContext.DECIMAL32);
		complex[1] = numer[1].divide(denomi[0], MathContext.DECIMAL32);

		return complex;
	}
	
/*
 * -----------------
 * 
 * sin method returns sin value of complex number.
 * result : sin(complex) 
 * You can also input real value. Just input a = a + 0*i (a is real value)
 * 
 * ----------------
 */
	public static BigDecimal[] sin(BigDecimal real, BigDecimal imagin) { // complex angle
		BigDecimal[] i2 = new BigDecimal[2];
		BigDecimal negative = new BigDecimal("-1");
		i2[0] = new BigDecimal("0");
		i2[1] = new BigDecimal("2");

		BigDecimal tempA = new BigDecimal(Double.toString(Math.exp((negative.multiply(imagin)).doubleValue())));
		BigDecimal tempB = new BigDecimal(Double.toString(Math.cos(real.doubleValue())));
		BigDecimal tempC = new BigDecimal(Double.toString(Math.exp((negative.multiply(imagin).doubleValue()))));
		BigDecimal tempD = new BigDecimal(Double.toString(Math.sin(real.doubleValue())));
		BigDecimal tempE = new BigDecimal(Double.toString(Math.exp(imagin.doubleValue())));
		BigDecimal tempF = new BigDecimal(Double.toString(Math.cos(real.doubleValue())));
		BigDecimal tempG = new BigDecimal(Double.toString(Math.exp(imagin.doubleValue())));
		BigDecimal tempH = new BigDecimal(Double.toString((-1) * Math.sin(real.doubleValue())));

		return divide(
				subtract(tempA.multiply(tempB), tempC.multiply(tempD), tempE.multiply(tempF), tempG.multiply(tempH)),
				i2);
	}

	public static BigDecimal[] sin(BigDecimal[] angle) { // complex angle array
		BigDecimal real = angle[0];
		BigDecimal imagin = angle[1];
		BigDecimal negative = new BigDecimal("-1");
		BigDecimal[] i2 = new BigDecimal[2];
		i2[0] = new BigDecimal("0");
		i2[1] = new BigDecimal("2");

		BigDecimal tempA = new BigDecimal(Double.toString(Math.exp((negative.multiply(imagin)).doubleValue())));
		BigDecimal tempB = new BigDecimal(Double.toString(Math.cos(real.doubleValue())));
		BigDecimal tempC = new BigDecimal(Double.toString(Math.exp((negative.multiply(imagin)).doubleValue())));
		BigDecimal tempD = new BigDecimal(Double.toString(Math.sin(real.doubleValue())));
		BigDecimal tempE = new BigDecimal(Double.toString(Math.exp(imagin.doubleValue())));
		BigDecimal tempF = new BigDecimal(Double.toString(Math.cos(real.doubleValue())));
		BigDecimal tempG = new BigDecimal(Double.toString(Math.exp(imagin.doubleValue())));
		BigDecimal tempH = new BigDecimal(Double.toString(((-1) * Math.sin(real.doubleValue()))));

		return divide(
				subtract(tempA.multiply(tempB), tempC.multiply(tempD), tempE.multiply(tempF), tempG.multiply(tempH)),
				i2);
	}
	
/*
 * -----------------
 * 
 * cos method returns cos value of complex number.
 * result : cos(complex) 
 * You can also input real value. Just input a = a + 0*i (a is real value)
 * 
 * ----------------
 */
	public static BigDecimal[] cos(BigDecimal real, BigDecimal imagin) { // complex angle
		BigDecimal[] r2 = new BigDecimal[2];
		r2[0] = new BigDecimal("2");
		r2[1] = new BigDecimal("0");

		BigDecimal tempA = new BigDecimal(Double.toString(Math.exp(-imagin.doubleValue())));
		BigDecimal tempB = new BigDecimal(Double.toString(Math.cos(real.doubleValue())));
		BigDecimal tempC = new BigDecimal(Double.toString(Math.exp(-imagin.doubleValue())));
		BigDecimal tempD = new BigDecimal(Double.toString(Math.sin(real.doubleValue())));
		BigDecimal tempE = new BigDecimal(Double.toString(Math.exp(imagin.doubleValue())));
		BigDecimal tempF = new BigDecimal(Double.toString(Math.cos(real.doubleValue())));
		BigDecimal tempG = new BigDecimal(Double.toString(Math.exp(imagin.doubleValue())));
		BigDecimal tempH = new BigDecimal(Double.toString((-1) * Math.sin(real.doubleValue())));

		return divide(add(tempA.multiply(tempB), tempC.multiply(tempD), tempE.multiply(tempF), tempG.multiply(tempH)),
				r2);
	}

	public static BigDecimal[] cos(BigDecimal[] angle) { // complex angle array
		BigDecimal real = angle[0];
		BigDecimal imagin = angle[1];
		BigDecimal[] r2 = new BigDecimal[2];

		r2[0] = new BigDecimal("2");
		r2[1] = new BigDecimal("0");

		BigDecimal tempA = new BigDecimal(Double.toString(Math.exp(-imagin.doubleValue())));
		BigDecimal tempB = new BigDecimal(Double.toString(Math.cos(real.doubleValue())));
		BigDecimal tempC = new BigDecimal(Double.toString(Math.exp(-imagin.doubleValue())));
		BigDecimal tempD = new BigDecimal(Double.toString(Math.sin(real.doubleValue())));
		BigDecimal tempE = new BigDecimal(Double.toString(Math.exp(imagin.doubleValue())));
		BigDecimal tempF = new BigDecimal(Double.toString(Math.cos(-real.doubleValue())));
		BigDecimal tempG = new BigDecimal(Double.toString(Math.exp(imagin.doubleValue())));
		BigDecimal tempH = new BigDecimal(Double.toString(Math.sin(-real.doubleValue())));

		return divide(add(tempA.multiply(tempB), tempC.multiply(tempD), tempE.multiply(tempF), tempG.multiply(tempH)),
				r2);
	}
	
/*
 * -----------------
 * 
 * log method returns log value of complex number.
 * log_a (b) (a and b are complex number) 
 * You can also input real value. Just input a = a + 0*i (a is real value)
 * 
 * ----------------
 */
	// log Method
	public static BigDecimal[] log(BigDecimal[] a, BigDecimal[] b) { // log_a (b)
		BigDecimal[] up = new BigDecimal[2];
		BigDecimal[] down = new BigDecimal[2];

		up[0] = new BigDecimal(
				Double.toString((0.5 * Math.log10((b[0].multiply(b[0]).add(b[1].multiply(b[1])).doubleValue())))));
		BigDecimal angleB = new BigDecimal(Double.toString(Math
				.acos(b[0].doubleValue() / Math.sqrt((b[0].multiply(b[0]).add(b[1].multiply(b[1]))).doubleValue()))));
		up[1] = angleB;

		down[0] = new BigDecimal(
				Double.toString((0.5 * Math.log10((a[0].multiply(a[0]).add(a[1].multiply(a[1])).doubleValue())))));
		// double test =
		// a[0].doubleValue()/Math.sqrt((a[0].multiply(a[0]).add(a[1].multiply(a[1]))).doubleValue());
		BigDecimal angleA = new BigDecimal(Double.toString(Math
				.acos(a[0].doubleValue() / Math.sqrt((a[0].multiply(a[0]).add(a[1].multiply(a[1]))).doubleValue()))));
		down[1] = angleA;

		return divide(up, down);
	}
}
