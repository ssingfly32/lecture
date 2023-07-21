package ksh;

import lib.Calculator;

public class CalcImpl extends Calculator {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int subtract(int a, int b) {
		return a-b;
	}

	@Override
	public long multiple(int a, int b) {
		return (long)a*b;
	}

	@Override
	public double divide(int a, int b) {
		return (double)a/b;
	}

}
