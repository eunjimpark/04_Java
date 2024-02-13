package edu.kh.collection.pack4.model.service;

import java.util.ArrayList;
import java.util.List;

public class JavaAPIService {

	/* Wrapper Class
	 * 
	 * - wrap : 감싸다, 포장하다
	 * 
	 * - 기본 자료형을 객체로 감싸는 클래스
	 *   -> 기본 자료형의 객체화
	 *   
	 *   -> 왜? 컬렉션 처럼 객체만 취급하는 상황에서
	 *      기본 자료형도 취급 가능한 형태로 바꾸기 위해서
	 *   
	 *          
	 *              -->   Boxing
	 *   Unboxing  <--
	 *   
	 *   boolean   <-->   Boolean
	 *   byte      <-->   Byte
	 *   short     <-->   Short
	 *   int       <-->   Integer
	 *   long      <-->   Long
	 *   float     <-->   Float
	 *   double    <-->   Double
	 *   char      <-->   Character
	 *  
	 *  * Boxing, Unboxing을 자동으로 수행되도록 구현되어 있음
	 *   -> Auto Boxing, Auto Unboxing
	 *   
	 * 
	 *  + Wrapper Class를 이용해 객체화 되었을 때
	 *  추가적인 필드, 기능을 제공함
	 */
	
	public void method1() {
		int num1 = 100; //int
		
		Integer wrap1 = num1; //컴파일러가 오토박스 수행코드 추가
		
		int num2 = wrap1.intValue();//정수값 반환 (추천X)
		
		int num3 = wrap1;  //컴파일러가 오토언박싱 수행코드추가
		                   //wrap1->int(wrap1)에 저장된 값
		
		long num4 = 10_000_000_000L; //100억
		
		Long wrap2 = num4;
		long num5 =wrap2;
	
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1000);
		list.add(2000);
		list.add(3000);
	
		System.out.println(list.get(0) + list.get(1)+ list.get(2));
		
	}
	
	
	
	public void method2() {
		
		System.out.println("byte의 용량 : " + Byte.BYTES + "바이트");
		System.out.println("byte의 용량 : " + Byte.SIZE + "비트");
		System.out.println("byte의 최대값 : " + Byte.MAX_VALUE);
		System.out.println("byte의 최소값 : " + Byte.MIN_VALUE);
		
		// 실수형만 사용 가능
		System.out.println(Double.NaN);
		System.out.println(Double.NEGATIVE_INFINITY);
		System.out.println(Double.POSITIVE_INFINITY);

		System.out.println(Boolean.FALSE);
		System.out.println(Boolean.TRUE);
		
		
		// ---------------------------------------------------
		
		System.out.println("-------------------------------------");
		System.out.println("[String -> 기본 자료형 변환]");
		
		// HTML 연결 시(요청 데이터 처리) 많이 사용
		// ->  HTML에 관련된 모든 값은 String
		// 단, char(Character)는 별도로 존재하지 않음
		
		byte b = Byte.parseByte("1");
		short s = Short.parseShort("2");
		int i = Integer.parseInt("3"); // 중요
		long l = Long.parseLong("4L"); // 중요
		float f = Float.parseFloat("0.1");
		double d = Double.parseDouble("0.2"); // 중요
		boolean bool = Boolean.parseBoolean("true");
		
		System.out.println("변환 확인");
		
		System.out.println("-------------------------------------");
		System.out.println("[기본 자료형 -> String 변환]");
		
		// Wrapper Class를 이용하는 방법
		
		int test1 = 400;
		String change1 = Integer.valueOf(test1).toString();
		
		double test2 = 4.321;
		String change2 = Double.valueOf(test2).toString();
		
		
		//String 이어쓰기를 이용한 방법
		long test3 = 12345678910L;
		String change3 = test3+"";
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}