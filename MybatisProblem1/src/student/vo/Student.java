package student.vo;

/**
 * 개인 정보를 저장할 VO 클래스
 */
public class Student {
	// Member variables
	private String id;				//학번
	private String name;			//이름
	private int kor;				//국어점수
	private int eng;				//영어점수
	private int mat;				//수학점수
	private double avg = 0;				//평균점수
	
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
