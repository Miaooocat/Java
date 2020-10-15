package com.MethodConstructorReference;

public interface PersonFactory <P extends Person> {
	P create(String firstName, String lastName);
}
