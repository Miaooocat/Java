package com.Java8.FunctionalInterface;

public class MainApplication {
	
	public static void main(String[] args) {
		Converter<String, Integer> converter = from -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);
		
		
		converter = Integer::valueOf;
		converted = converter.convert("123");
		System.out.println(converted);   // 123
	}	
}
