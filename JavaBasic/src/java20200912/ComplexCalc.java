package java20200912;

public class ComplexCalc {
	public ComplexCalc() { // Constructor
		
	}
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

		denomi = multiply(real2, imagin2, real2, imagin2);
		numer = multiply(real2, imagin2, real1, imagin1);

		real = numer[0] / denomi[0];
		imagin = numer[1] / denomi[0];

		double[] complex = new double[2];
		complex[0] = real;
		complex[1] = imagin;

		return complex;
	}

	static 	double[] divide(double[] complex1, double[] complex2) {
		double[] denomi = new double[2];
		double[] numer = new double[2];
		double real;
		double imagin;

		denomi = multiply(complex2, complex2);
		numer = multiply(complex1, complex2);

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
}
