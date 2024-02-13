package edu.kh.poly.pack3.run;

import edu.kh.poly.pack3.model.dto.Calculator;
import edu.kh.poly.pack3.model.dto.Machine;
import edu.kh.poly.pack3.model.dto.PEJCalculator;

public class CalculatorRun {
	public static void main(String[] args) {
		
		Calculator cal= new PEJCalculator();
		//인터페이스의 장점: 상속받은 클래스들의 형태가 똑같거나 비슷하기 때문에
		//코드 유지 보수시 참조하는 객체만 변경하면 유지보수가 완료된다
		
		System.out.println(cal.plus(1, 2));
		System.out.println(cal.minus(7, 2));
		System.out.println(cal.pow(2, 5));
		System.out.println(cal.sum(1,2,3,4,5,6));
		
		Machine machine = (Machine)cal;
		machine.powerOn();
		machine.powerOff();
		
	}

}
