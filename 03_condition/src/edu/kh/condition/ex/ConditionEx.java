package edu.kh.condition.ex;

import java.util.Scanner;
/**
 * 조건문 기능용 클래스*/

public class ConditionEx {
	
	//필드(== 객체의 속성 ==객체가 가지고있는 값/변수)
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 나이를 입력 받아 19세 이상은 성인, 미만은 성인이 아닙니다.*/
	public void method1() {
		System.out.print("나이 입력: ");
		int age = sc.nextInt();
		
		if(age>=19) {
			System.out.println("성인");
		}else {
			System.out.println("성인이 아닙니다");
		}
	}

	/**
	 * 나이를 입력받아 13세 이하면 "어린이" 13세 초과면 19세 미만 "청소년"
	 * 19세 이상 "성인"
	 * */
	public void method2(){
		System.out.println("나이 입력:");
		int age = sc.nextInt();
		
		if(age>18) {
			System.out.println("성인");
		}else if(age<=18 && age > 13) {
			System.out.println("청소년");
		}else {
			System.out.println("어린이");
		}		
	}
	
	/**
	 * 달(월)을 입력 받아 해당 계절 출력하기
	 * <ul>
	 * 	<li>봄   : 3,4,5</li>
	 * 	<li>여름 : 6,7,8</li>
	 * 	<li>가을 : 9,10,11</li>
	 * 	<li>겨울 : 12,1,2</li>
	 * 	<li>그 외: 잘못입력</li>
	 * </ul>
	 */
	
	public void method3() {
		System.out.println("월 입력");
		int mont = sc.nextInt();
		
		if(mont>=3 && mont<6) {
			System.out.println("봄");
		}else if(mont>=6 && mont< 9) {
			System.out.println("여름");
		}else if(mont>=9 && mont <12) {
			System.out.println("가을");
		}else if( mont<3 && mont>=1) {
			System.out.println("겨울");
		}else if(mont ==12) {
			System.out.println("겨울");
		}else {
			System.out.println("잘못입력");
		}		
	}
	
	
	public void method3a() {
		System.out.print("월 입력:");
		int month= sc.nextInt();
		
		String result;
		
		if(0<month && month<3)  result="겨울";
		else if(month < 6)      result="봄";		
		else if(month < 9)      result="여름";
		else if(month < 12)     result="가을";
		else if(month ==12)     result="겨을";
		else                    result="잘못 입력";
		
		System.out.println(result);	
	}
	
	
	public void method3c() {
		System.out.print("달(월) 입력 : ");
		int month = sc.nextInt();
		
		String result;
		
		switch(month) {
//			case 3:  case 4: case 5: result="봄"; break;
			case 3, 4, 5: result="봄"; break; //month가 3,4,5인 경우
			case 6, 7, 8: result="여름"; break; //month가 6,7,8인 경우
			case 9, 10, 11: result="가을"; break; //month가 9,10,11인 경우
			case 12, 1, 2: result="겨울"; break; //month가 12,1,2인 경우
			default : result="잘못 입력";
		}
		System.out.println(result);
	}
	
	
	/**
	 * P/F판별하기
	 * <pre>
	 * 중간고사,기말고사, 과제 점수를 입력받아
	 * 총점 60점 이상일 경우 PASS, 아니면 FAIL
	 * 
	 * -중간고사(40%), 기말고사(50%) , 과제(10%)
	 * -각각 100점 만점
	 * 
	 * +PASS인 경우
	 *  90점이상 A
	 *  80점이상 B
	 *  70점이상 C
	 *  60점이상 D
	 *  </pre>
	 * */
	public void method4() {
		System.out.print("중간고사점수 입력 :");
		int mid = sc.nextInt();
		System.out.print("기말고사점수 입력 :");
		int las = sc.nextInt();
		System.out.print("과제점수 입력 :");
		int hmw = sc.nextInt();
		
		double total;
		total = (mid*0.4) + (las*0.5) + (hmw*0.1);
		

		if(mid<0 || las<0|| hmw<0 ||mid>100 || las>100 ||hmw>100) {
			System.out.println("점수를 잘못입력하셨습니다");
			return;
		}
		
		String result; 
		String grade;
		
		if(total<60) {
			result = "FAIL"; 
			grade ="-";
			
		}else {
			result = "PASS"; 
			if(total>=90)      grade ="A";
			else if(total>=80) grade ="B";
			else if(total>=70) grade ="C";
			else               grade ="D";
		}
		
		System.out.println("총점 : " +total);
		System.out.printf(result+"/"+grade);

	}
	
/**
 * <pre>
 * 국어,영어,수학,사탐,과탐점수를 입력받아 
 * 40점 미만과목이 있으면 FAIL 평균이 60점 미만인경우도 FAIL
 * 1)40점 미만 과목이 존재하는 경우
 * FAIL[40점미만 과목: 국어]
 * 2)평균이 60점 미만인 경우
 * FAIL [점수: 50.4 (평균미달)]
 * 3) 패스인경우
 * PASS[점수 : 83.4 /100]
 * 
 * </pre>
 * 
 * */
	public void method5() {
		System.out.print("국어점수입력 :");
		int kor = sc.nextInt();
		System.out.print("영어점수입력 :");
		int eng = sc.nextInt();
		System.out.print("수학점수입력 :");
		int mat = sc.nextInt();
		System.out.print("사탐점수입력 :");
		int soc = sc.nextInt();
		System.out.print("과탐점수입력 :");
		int sci = sc.nextInt();
		
	
		double total;
		total = (kor+eng+mat+soc+sci)/5;
		String miman="";
		
		if(total<60) {
			System.out.printf("FAIL[점수:"+total+"(평균미달)]");
			
		}else {
			if(kor<40){
				miman += "국어";
				}		
			if(eng<40){
				miman += "영어";
			 }
			if(mat<40){	
				miman += "수학";
			 }
			if(soc<40){
				miman += "사탐";
			 }
			if(sci<40){
				miman += "과탐";
			 }
			
	 	if(miman==null) {
			System.out.printf("PASS[점수:"+total+"/100]");
	 	} else {
			System.out.println("FAIL [40점 미만 과목 :"+miman+"]");		
	 	}	
	
		}
	}
}
