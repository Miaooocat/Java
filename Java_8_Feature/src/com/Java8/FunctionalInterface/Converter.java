package com.Java8.FunctionalInterface;

@FunctionalInterface
public interface Converter<F,T> {
	T convert (F from);
}
