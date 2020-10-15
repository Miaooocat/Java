package com.Java8.LambdaExpression.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MainApplication {
	public static void main(String[] args) {
		
		// Sorting method in prior version
		List<String> names = Arrays.asList("Peter","Anna","Mike","Xenia");
		Collections.sort(names,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo (o2);
			}
		});
		
		// Sorting method with Lambder 
		Collections.sort(names, (String a,String b) -> {
			return b.compareTo(a);
		});
		
		// Java allows to skip return type and {}
		Collections.sort(names, (String a, String b) -> b.compareTo(a));
		
		// Java allows to skip return type 
		names.sort((a, b) -> b.compareTo(a));
	}
}
