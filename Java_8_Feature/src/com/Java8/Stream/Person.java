package com.Java8.Stream;

public class Person {
	private String name;
	private int height;
	private int age;
	
	public Person(String name, int age, int height) {
		super();
		this.name = name;
		this.height = height;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + ", age=" + age + "]";
	}
	
	
}
