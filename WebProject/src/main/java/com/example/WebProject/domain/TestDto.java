package com.example.WebProject.domain;

public class TestDto {
	
	private int age;
	private String name;
	
	public  TestDto() {
		super();
	}
	public TestDto(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
