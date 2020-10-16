package com.Java8.Lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Sort {
	public static void main(String[] args) {
		

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		// Traditional approach
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println("Traditional approach" + names);
        
        
        names = Arrays.asList("peter", "anna", "mike", "xenia");
        // Equivalent Lambda approach
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        System.out.println("Lambda approach" + names);
        
        names = Arrays.asList("peter", "anna", "mike", "xenia");
        // Lambda approach that ignore the return type
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        System.out.println("Lambda approach" + names);
        
        names = Arrays.asList("peter", "anna", "mike", "xenia");
        // Lambda approach with type automatically defined
        Collections.sort(names, (a, b) -> b.compareTo(a));
        System.out.println("Lambda approach with type automatically defined" + names);

        names = Arrays.asList("peter", "anna", "mike", "xenia");
        names.sort(Collections.reverseOrder());
        System.out.println(names);


        List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");
        names2.sort(Comparator.nullsLast(String::compareTo));
        System.out.println(names2);
        

        List<String> names3 = null;
        Optional.ofNullable(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));
        System.out.println(names3);
    }

}
