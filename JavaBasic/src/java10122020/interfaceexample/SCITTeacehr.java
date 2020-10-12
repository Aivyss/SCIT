package java10122020.interfaceexample;

import java.util.ArrayList;
import java.util.Scanner;

public class SCITTeacehr implements Human, Teacher {
	private ArrayList<String> list = new ArrayList<String>();

	@Override
	public String teaching() {
		String str = "1+1=2";
		return str;
	}

	@Override
	public String consult() {
		String str = "Don't give up guy.";
		return str;
	}

	@Override
	public void eat() {
		
	}

	@Override
	public void see() {
		Scanner sc = new Scanner(System.in);
		list.add(sc.nextLine());	
	}

	@Override
	public void sleep() {
		System.exit(0);
	}
	
}
