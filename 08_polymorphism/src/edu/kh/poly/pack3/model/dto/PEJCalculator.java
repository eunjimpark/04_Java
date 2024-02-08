package edu.kh.poly.pack3.model.dto;

//인터페이스는 다중 상속이 가능하다

public class PEJCalculator implements Calculator, Machine {
	
	public static final double PI = 3.14;
	int MAX_NUM = 100_000_000; // 최대값
	public int MIN_NUM = -100_000_000; // 최소값
	
	
	@Override
	public int plus(int a, int b) {
		return a+b;
	}

	@Override
	public int minus(int a, int b) {
		return a-b;
	}

	@Override
	public int multi(int a, int b) {
		return a*b;
	}

	@Override
	public double div(int a, int b) {
		if(b==0) return 0.0;
		return (double)a/b;
	}

	@Override
	public int mod(int a, int b) {
		return a%b;
	}

	@Override
	public int sum(int... numbers) {
		int result = 0;
		 for(int i =0; i<=numbers.length; i++) {
			 result +=i;
		 }
		
		return result;
	}

	@Override
	public double areaOfCircle(double r) {
		return 2*PI*r;
	}

	@Override
	public boolean rangeCheck(int num) {
		if(MAX_NUM>=num && MIN_NUM<=num) return true;
		else  return false;
	}

	@Override
	public int pow(int a, int x) {
		int result=1;
		for(int i =1;  i<=x;i++) {
			result=result*a;
		}
		return result;
	}

	@Override
	public String toBinary(int num) {
		return Integer.toBinaryString(num);
	}

	@Override
	public String toHexadecimal(int num) {
		return Integer.toHexString(num);
	}

	@Override
	public void powerOn() {
		System.out.println("은지계산기켜짐");
	}

	@Override
	public void powerOff() {
		System.out.println("은지계산기꺼짐");
	}

	
}
