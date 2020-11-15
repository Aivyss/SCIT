package student.vo;

/**
 * 개인 정보를 저장할 VO 클래스
 */
public class Student {
	// Member variables
	private String id;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private double avg = 0;
	
	/**
	 * 마이바티스 셀렉트를 불러오기 위해서는 디폴트 생성자가 있어야함.
	 */
	public Student() {
		/**
		 * 아마 마이바티스는 텅빈 객체에 get set을 이용해서 객체의 멤버변수를
		 * 채우는데 매개변수를 요구하는 생성자를 새롭게 정의해버리면 
		 * 텅 빈 객체를 생성할 수 없으니 나타나는 문제로 보임.
		 */
	}
	
	/**
	 * 생성자
	 */
	public Student(String id, String name, int kor, int eng, int mat) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.avg = 1.0*(kor+eng+mat)/3;
	}
	
	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public double getAvg() {
		avg = 1.0*(kor+eng+mat)/3;
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	@Override
	public String toString() {
		return id+"\t"+name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+getAvg();
	}
}
