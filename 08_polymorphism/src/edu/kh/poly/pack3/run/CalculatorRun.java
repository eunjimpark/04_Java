package edu.kh.poly.pack3.run;

import edu.kh.poly.pack3.model.dto.Calculator;
import edu.kh.poly.pack3.model.dto.PEJCalculator;

public class CalculatorRun {
	public static void main(String[] args) {
		
		Calculator cal= new PEJCalculator();
		
		System.out.println(cal.plus(1, 2));
		System.out.println(cal.minus(7, 2));
		System.out.println(cal.pow(2, 5));
		System.out.println(cal.sum(1,2,3,4,5,6));
	}

}
