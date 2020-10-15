package com.Java8.InterfaceDefaultMethod;

public class MainApplication {

	public static void main(String[] args) {
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a*100);
			}
		};
		formula.calculate(100);
		formula.sqrt(16);
	}
}
