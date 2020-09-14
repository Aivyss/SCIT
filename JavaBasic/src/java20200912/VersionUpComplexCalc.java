package java20200912;

import java.math.BigDecimal;
import java.math.MathContext;

public class VersionUpComplexCalc {
		public VersionUpComplexCalc() { // Constructor
			
		}
		
		static BigDecimal[] add(BigDecimal real1, BigDecimal imagin1, BigDecimal real2, BigDecimal imagin2) {
			BigDecimal[] complex = new BigDecimal[2];
			complex[0] = real1.add(real2);
			complex[1] = imagin1.add(imagin2);

			return complex;
		}

		static BigDecimal[] add(BigDecimal[] complex1, BigDecimal[] complex2) {
			BigDecimal[] complex = new BigDecimal[2];
			complex[0] = complex1[0].add(complex2[0]);
			complex[1] = complex1[1].add(complex2[1]);

			return complex;
		}

		static BigDecimal[] subtract(BigDecimal real1, BigDecimal imagin1, BigDecimal real2, BigDecimal imagin2) {
			BigDecimal[] complex = new BigDecimal[2];
			complex[0] = real1.subtract(real2);
			complex[1] = imagin1.subtract(imagin2);

			return complex;
		}

		static BigDecimal[] subtract(BigDecimal[] complex1, BigDecimal[] complex2) {
			BigDecimal[] complex = new BigDecimal[2];
			complex[0] = complex1[0].subtract(complex2[0]);
			complex[1] = complex1[1].subtract(complex2[1]);

			return complex;
		}

		static BigDecimal[] multiply(BigDecimal real1, BigDecimal imagin1, BigDecimal real2, BigDecimal imagin2) {
			BigDecimal[] complex = new BigDecimal[2];
			complex[0] = (real1.multiply(real2)).subtract(imagin1.multiply(imagin2));
			complex[1] = (real1.multiply(imagin2)).add(real2.multiply(imagin1));

			return complex;
		}

		static BigDecimal[] multiply(BigDecimal[] complex1, BigDecimal[] complex2) {
			BigDecimal[] complex = new BigDecimal[2];
			complex[0] = (complex1[0].multiply(complex2[0])).subtract(complex1[1].multiply(complex2[1]));
			complex[1] = (complex1[0].multiply(complex2[1])).add(complex1[1].multiply(complex2[0]));

			return complex;
		}

		static BigDecimal[] divide(BigDecimal real1, BigDecimal imagin1, BigDecimal real2, BigDecimal imagin2) {
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

		static BigDecimal[] divide(BigDecimal[] complex1, BigDecimal[] complex2) {
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

		static BigDecimal[] sin(BigDecimal real, BigDecimal imagin) { // complex angle
			BigDecimal[] output = new BigDecimal[2];
			BigDecimal[] i2 = new BigDecimal[2];
			BigDecimal negative = new BigDecimal("-1");
			i2[0]= new BigDecimal("0");
			i2[1] = new BigDecimal("2");
			
			BigDecimal tempA = new BigDecimal(Double.toString(Math.exp((negative.multiply(imagin)).doubleValue())));
			BigDecimal tempB = new BigDecimal(Double.toString(Math.cos(real.doubleValue())));
			BigDecimal tempC = new BigDecimal(Double.toString(Math.exp((negative.multiply(imagin).doubleValue()))));
			BigDecimal tempD = new BigDecimal(Double.toString(Math.sin(real.doubleValue())));
			BigDecimal tempE = new BigDecimal(Double.toString(Math.exp(imagin.doubleValue())));
			BigDecimal tempF = new BigDecimal(Double.toString(Math.cos(real.doubleValue())));
			BigDecimal tempG = new BigDecimal(Double.toString(Math.exp(imagin.doubleValue())));
			BigDecimal tempH = new BigDecimal(Double.toString((-1)*Math.sin(real.doubleValue())));
			
			output = divide(subtract(tempA.multiply(tempB), tempC.multiply(tempD), tempE.multiply(tempF), tempG.multiply(tempH)),i2);

			return output;
		}
		
		static BigDecimal[] sin(BigDecimal[] angle) { // complex angle array
			BigDecimal real = angle[0];
			BigDecimal imagin = angle[1];
			BigDecimal negative = new BigDecimal("-1");
			BigDecimal[] i2 = new BigDecimal[2];
			i2[0] = new BigDecimal("0");
			i2[1] = new BigDecimal("2");
			BigDecimal[] output = new BigDecimal[2];
			
			BigDecimal tempA = new BigDecimal(Double.toString(Math.exp((negative.multiply(imagin)).doubleValue())));
			BigDecimal tempB = new BigDecimal(Double.toString(Math.cos(real.doubleValue())));
			BigDecimal tempC = new BigDecimal(Double.toString(Math.exp((negative.multiply(imagin)).doubleValue())));
			BigDecimal tempD = new BigDecimal(Double.toString(Math.sin(real.doubleValue())));
			BigDecimal tempE = new BigDecimal(Double.toString(Math.exp(imagin.doubleValue())));
			BigDecimal tempF = new BigDecimal(Double.toString(Math.cos(real.doubleValue())));
			BigDecimal tempG = new BigDecimal(Double.toString(Math.exp(imagin.doubleValue())));
			BigDecimal tempH = new BigDecimal(Double.toString(((-1)*Math.sin(real.doubleValue()))));
			
			output = divide(subtract(tempA.multiply(tempB), tempC.multiply(tempD), tempE.multiply(tempF), tempG.multiply(tempH)),i2);

			return output;
		}
		
		static BigDecimal[] cos(BigDecimal real, BigDecimal imagin) { // complex angle
			BigDecimal[] output = new BigDecimal[2];
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
			BigDecimal tempH = new BigDecimal(Double.toString((-1)*Math.sin(real.doubleValue())));

			output = divide(add(tempA.multiply(tempB), tempC.multiply(tempD), tempE.multiply(tempF), tempG.multiply(tempH)),r2);

			return output;
		}
		
		static BigDecimal[] cos(BigDecimal[] angle) { // complex angle array
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
			
			BigDecimal[] output = new BigDecimal[2];
			output = divide(add(tempA.multiply(tempB), tempC.multiply(tempD), tempE.multiply(tempF), tempG.multiply(tempH)),r2);

			return output;
		}
	}
