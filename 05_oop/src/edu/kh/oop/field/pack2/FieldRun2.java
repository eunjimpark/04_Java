package edu.kh.oop.field.pack2;


import edu.kh.oop.field.pack1.FieldTest1;

public class FieldRun2 extends FieldTest1{ //상속구문
	
	
	public static void main(String[] args) {
		//FieldTest1 객체생성
		FieldTest1 f1 =new FieldTest1();
		
		
		System.out.println( f1.publicValue ); // 어디서든 접근 가능
		
		//System.out.println( f1.protectedValue ); // 같은 패키지 + 상속 X
		
		//System.out.println( f1.defaultValue);   //같은패키지X
		
		//System.out.println( f1.privateValue);   //같은클래스X
	 	
	}

	
	public void method1() {
		System.out.println(protectedValue);
	}
}
