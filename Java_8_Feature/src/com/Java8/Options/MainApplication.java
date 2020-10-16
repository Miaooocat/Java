package com.Java8.Options;

import java.util.Optional;
import java.util.function.Supplier;

public class MainApplication {
	void main() {
		
		// Traditional method
		Outer outer = new Outer();
		if (outer != null && outer.nested != null && outer.nested.inner != null) {
		    System.out.println(outer.nested.inner.foo);
		}
		
		// Option method
		Optional.of(new Outer())
	    .map(Outer::getNested)
	    .map(Nested::getInner)
	    .map(Inner::getFoo)
	    .ifPresent(System.out::println);
		
		// use Supplier to achieve the same behavior 
		Outer obj = new Outer();
		resolve(() -> obj.getNested().getInner().getFoo())
		    .ifPresent(System.out::println);
		
		
	}

	private static <T> Optional<T> resolve(Supplier<T> resolver) {
	    try {
	        T result = resolver.get();
	        return Optional.ofNullable(result);
	    }
	    catch (NullPointerException e) {
	        return Optional.empty();
	    }
	}
}
