package com.icmaster.ict.vo;

import lombok.Data;

@Data
public class Person {
	private String name;
	private int age;
	private String address;
	private boolean gender;
	private String[] hobby;
	
	// 롬복은 게터 게터 toString 생성자까지 해줌
}