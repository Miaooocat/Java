package com.Java8.Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");

		// Filter
		stringCollection
		.stream()
		.filter((s) -> s.startsWith("a"))
		.forEach(System.out::println);

		// Collectors.toList（）  Convert a stream to a list
		List<Person> personList = Stream.of(new Person("Simon", 22, 175),
				new Person("Tom", 40, 180),
				new Person("Jim", 50, 185)).collect(Collectors.toList());
		System.out.println(personList);


		// Filter 用boolean statement 过滤了一个Stream
		List<Person> list = personList.stream()
				.filter(stu -> stu.getHeight() < 180)
				.collect(Collectors.toList());
		System.out.println(list);

		// Map 提供转化功能    
		List<String> names = personList.stream().map(person -> person.getName())
				.collect(Collectors.toList());
		System.out.println(names);

		// flatMap 将多个Stream合并为一个Stream

		List<Person> newList = new ArrayList<>(3);
		newList.add(new Person("Tim", 22, 175));
		newList.add(new Person("James", 40, 180));

		List<Person> combinedPersonList = Stream.of(personList,newList)
				.flatMap(persons -> persons.stream()).collect(Collectors.toList());
		System.out.println(combinedPersonList);
		// Max and mini
		combinedPersonList.stream()
		.max(Comparator.comparing(person -> person.getAge())).ifPresent(System.out::println);;
		combinedPersonList.stream()
		.min(Comparator.comparing(person -> person.getAge())).ifPresent(System.out::println);

		long count = combinedPersonList.stream().filter(s1 -> s1.getAge() < 45).count();
		System.out.println(count);

		// Reduce Example 1 
		Integer reduce = Stream.of(1, 2, 3, 4).reduce(0, (acc, x) -> acc+ x);
		System.out.println(reduce);

		// Reduce Example 2
		OptionalInt reduced1 =
				IntStream.range(0, 10)
				.reduce((a, b) -> a + b);
		System.out.println(reduced1.getAsInt());

		int reduced2 =
				IntStream.range(0, 10)
				.reduce(7, (a, b) -> a + b);
		System.out.println(reduced2);


	}
}
