package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx1 {

	Scanner sc =new Scanner(System.in);
	
	/**
	 * 배열 (자료구조)
	 * 
	 * -자바에서의 배열
	 * ->같은 자료형의 변수를 하나의 묶음으로 다루는 것
	 * 
	 * -생성된 배열의 요소는 index를 이용해서 구분
	 * 
	 * -생성된 배열을 활용하기 위해서는 배열을 참조하는 참조형변수를 이용한다
	 * 
	 * [참조형 변수]
	 * -주소를 저장하는 변수
	 * -변수 사용시 저장된 주소로 찾아가서 그곳에 위치한 배열이나 객체를 참조함
	 * 
	 * -기본 자료형 8개를 제욍한 나머지는 모두 참조형 변수이다
	 * */
	
	
	/*
	 * 배열 선언,할당,초기화*/
	public void method1() {
		
		int num; //변수선언
		//stack영역에 int 자료형을 저장할수있는 변수를 생성하고
		//그 변수의 이름을 num으로 지정
		
		int[] arr; //배열선언
		
		//배열할당
		arr = new int[4];
		
		//배열 초기화
		//1)초기화 전 - >0이 대입되어있는지확인
		System.out.println("초기화 전");
		
		//디버그 : 프로그램 수행중 특정시점에 어떤값을 지니고 있는지 확인
		
		
		//2)인덱스를 이용한 초기화
		arr[0] = 100;
		arr[1] =2000;
		arr[2] =9;
		arr[3]= 7777;
		
		System.out.println("초기화 후");
		
/*[이클립스 디버그 모드 사용방법]
 * 
 * 1)확인하고싶은 코드 다음줄에 break point 추가
 * 
 * 2)debug 모드로 실행 (벌레 아이콘 또는 F11)
 * 
 * 3)debug 화면으로 switch
 * 
 * 4)resume F8 키를 눌러가며 순서대로 확인*/		
	}
	
	
	/*정수 4개를 입력받아
	 * 배열에 차례대로 대입후 결과를 디버그 모드로 확인*/
	public void method2() {
		
		//배열 선언+할당
		int[] arr =  new int[4];
		//참조형 변수
		
		for(int i =0 ; i<arr.length ; i++) {
			System.out.println(i+"번째 인덱스:");
			
			arr[i] = sc.nextInt(); //i번째 인덱스 요소에 입력값 대입
		}
		//해당구문 수행전 break point를 작성해서 멈춤
		System.out.println("결과 확인");
	}
	
	
	
	
	/*배열 선언과 동시에 초기화*/
	public void method3() {
		//과목이 작성되어있는 배열 생성
		String[] subjects = {"java","HTML","CSS","JavaScript"};
		
		for (int i=3 ; i>=0; i--) {
			System.out.printf("subjects[%d]: %s \n", i, subjects[i]);
		}
	}
	
	
	
	
	
	/**
	 * 길이를 입력 받아 
	 * 입력 받은 길이 만큼의 배열을 생성(할당) 한 후
	 * 모든 인덱스 요소에 0부터 배열 길이 미만의 난수를 대입
	 */
	public void method4() {
		
		// 길이를 입력 받아 
		System.out.print("배열 길이 : ");
		int len = sc.nextInt();
		
		// 입력 받은 길이 만큼의 배열을 생성(할당) 한 후
		int[] randoms = new int[len];
		
		
		// 모든 인덱스 요소에 0부터 배열 길이 미만의 난수를 대입
		for(int i = 0 ; i < randoms.length ; i++) {
			
			randoms[i]=(int)(Math.random()* len);
			             //double- >int 강제 형변환 데이터손실을 이용한 소수점제거
			
		}
		
	//Arrays.toString(배열참조변수)
		//->배열에 모든 요소를 [a,b,c] 형태 문자열로 반환
		System.out.println(randoms);
		System.out.println(Arrays.toString(randoms));
	}
	

	
	
	
	
	
	
	
	
	
}
