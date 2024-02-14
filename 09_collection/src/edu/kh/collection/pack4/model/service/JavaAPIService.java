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
		//->코드는 짧지만 효율이 구림
		long test3 = 12345678910L;
		String change3 = test3+"";
	}
	
	public void method3() {
		
		String str = "hello";
		System.out.println(str);
		System.out.println(System.identityHashCode(str)); //주소값을 이용해서만든 해쉬코드
		
		str = "world";
		System.out.println(str);
		
		str += "!!!";
		System.out.println(str);
		
		
	}
	
	
	
	public void method4() {
		
		String temp1 = "Hello!!";
		String temp2 = "Hello!!";
		
		System.out.println(System.identityHashCode(temp1));
		System.out.println(System.identityHashCode(temp2));
		
		// 같음을 비교
		System.out.println("저장된 값 비교 : " + temp1.equals(temp2) );
		
		//변수에 저장된 값(주소)비교
		System.out.println("주소를 비교 : " + temp1==temp2 );
	}
	
	
	public void method5() {
		
		String temp1 = "abcd"; //리터럴로생성
		String temp2 = new String("abcd");
		String temp3 = new String("abcd");
		
		System.out.println("temp1 : " + System.identityHashCode(temp1));
		System.out.println("temp2 : " + System.identityHashCode(temp2));
		System.out.println("temp3 : " + System.identityHashCode(temp3));
		
		//셋다 주소가 다름 ==abcd를 재활용 X
		//값은 전부 같지만 전부 다른객체 
		
	}
	
	
	public void method6() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("오늘점심은");
		sb.append("무엇을 먹을까요?");
		
		sb.insert(0, "2월14일");
		System.out.println(System.identityHashCode(sb));
		
		// identityHashCode 값이 일정함 
		// == 참조하는 객체가 변하지 않음
		// == 객체 내에 값만 수정되고 있다 == 가변성 
		
		
		
		System.out.println(sb);
		
		//StringBuilder ->String 변환
		
		String temp = sb.toString(); //객체에 저장된 필드를 문자열로 반환
		
		//String[] 문자열.split("구분자")
		//-문자열을 "구분자"를 기준으로 쪼개어 String[]로 반환
		
		String[] arr= temp.split(" ");
		
		for(String str: arr) {
			System.out.println(str);
		}
	
	
	}
	
	
	
	
	
	
}