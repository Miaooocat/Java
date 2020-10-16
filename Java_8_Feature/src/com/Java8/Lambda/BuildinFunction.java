package com.Java8.Lambda;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BuildinFunction {
    @FunctionalInterface
    interface Fun {
        void foo();
    }
    
    public static void main(String[] args) throws Exception {

        // Predicates Example 1
    	// 
        Predicate<String> predicateEmptyString = (s) -> s.length() > 0;

        predicateEmptyString.test("foo");              // true
        predicateEmptyString.negate().test("foo");     // false
        
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        // Predicates Example 2
        Predicate<Integer> predicateLargerthan185 = x -> x > 185;
        int length = 200;
        System.out.println(
        		predicateLargerthan185.test(length)
        		);
        
        
        // Functions Example 1
        Function<String, Integer> toInteger = Integer::valueOf;
        toInteger.apply("123");
        
        // Functions Example 2
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        backToString.apply("123");     // "123"

        // Functions Example 3
        Function<Person, String> function = Person::getFirstName;
        System.out.println(
        		function.apply(new Person("John", "Doe"))
        		);

        // Suppliers Example 1
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();   // It will return a new Person object
        
        // Suppliers Example 2
        Supplier<Integer> supplier =
                () -> Integer.valueOf(BigDecimal.TEN.toString());
            System.out.println(supplier.get());


        // Consumers Example 1
        // consumers.accept() will take the input value, and execute the predefine the method
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));
        
        // Consumers Example 2
        Consumer<String> consumer = System.out::println;
        consumer.accept("Print this line");


        // Comparators Example 1
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        comparator.compare(p1, p2);             // > 0
        comparator.reversed().compare(p1, p2);  // < 0

        // UnaryOperator Example 1
        UnaryOperator<Boolean> unaryOperator = uglily -> !uglily;
        Boolean apply2 = unaryOperator.apply(true);
        System.out.println(apply2);
        
        
        // BinaryOperator Example 1
        BinaryOperator<Integer> operator = (x, y) -> x * y;
        Integer integer = operator.apply(2, 3);
        System.out.println(integer);
        
        
        // Runnable Example 1
        Runnable runnable = () -> System.out.println(UUID.randomUUID());
        runnable.run();


        // Callable Example 1
        Callable<UUID> callable = UUID::randomUUID;
        callable.call();
        
        
    }
}
