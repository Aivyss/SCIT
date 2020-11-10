package cloneArrayList;

public class Main {

	public static void main(String[] args) {
		CloneArrayList<String> list = new CloneArrayList<>();
		
		list.add("안녕하세요.");
		list.add("반갑습니다.");
		
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		
		list.remove(0);
		System.out.println(list.size());
		System.out.println(list.get(0));
		list.set(0, "테스트");
		System.out.println(list.get(0));
		
	}

}
