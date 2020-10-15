package com.MethodConstructorReference;

import com.Java8.FunctionalInterface.Converter;

public class MainApplication {
	
	public static void main() {
		Something something = new Something();
		Converter<String,String> converter = something::startsWith;
		String converted = converter.convert("Java");
		System.out.println(converted);
	}
}
