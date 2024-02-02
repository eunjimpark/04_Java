package edu.kh.oop.field.pack1;

public class FieldTest1 {

	//작성법
	//[접근제한자][예약어]자료형 변수명 [=초기값];
	
	//접근제한자별 필드 선언;
	public    int publicValue    = 10;
	protected int protectedValue = 20;
	          int defaultValue   = 30;
	private   int privateValue   = 40;
	
	public void method1() {
		System.out.println(publicValue);
		System.out.println(protectedValue);
		System.out.println(defaultValue);
		System.out.println(privateValue);
		//모든 접근 제한자 다 가능
		
		
	}
	
}
