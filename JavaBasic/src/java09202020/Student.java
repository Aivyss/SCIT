package java09202020;

public class Student {
	
	String name;
	int kor;
	int eng;
	int mat;
	int sum;
	double avg;
	
	public Student() {// Constructor
		
	}
	
	// setter complete set
	public void setName(String name) {
		this.name= name;
	}
	public void setKor(int kor) {
		this.kor= kor;
	}
	public void setEng(int eng) {
		this.eng= eng;
	}
	public void setMat(int mat) {
		this.mat= mat;
	}
	
	// getter complete set
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMat() {
		return mat;
	}	
	public int getSum() {
		sum = kor+eng+mat;
		return sum;
	}	
	public double getAvg() {
		avg = 1.0*(kor+eng+mat)/3;
		return avg;
	}	
}
