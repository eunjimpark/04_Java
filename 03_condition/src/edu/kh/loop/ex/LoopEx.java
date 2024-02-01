package edu.kh.loop.ex;

import java.util.Scanner;


public class LoopEx {
	
	Scanner sc = new Scanner(System.in);
	
	// 필드 (객체의 속성 == 객체의 변수)
	// java.util.Scanner

	

	/**
	 * 1 부터 10까지 출력하기
	 */
	public void method1() {
		
		for(int i = 1 ; i <= 10 ; i++ ) {
			System.out.println(i);
		}
	}
	
	
	
	
	/**
	 * 첫번재 입력받은 수부터 두번째 입력받은 수까지 1씩 증가하며출력하기*/
	public void method2() {
		System.out.println("입력 (1 2) : ");
		int input1 = sc.nextInt(); //첫번째입력
		int input2 = sc.nextInt(); //두번째입력
		
		for(int i=input1 ; i<=input2; i++) {
			System.out.println(i);
		}	
	}
	
	public void method3() {
		for(int i=10;i>=1;i--) {
			System.out.println(i);
		}
	}
	
	/**두수를 입력 받아  반복 출력하는 구문을 작성 
	 * 
	 * (첫번재 입력 A, 두번째 입력 B)
	 *
	 * 조건1. B가 A보다 큰경우 ->A~B까지 1씩증가하며 출력
	 * 조건2. A가 B보다 큰경우 ->A~B까지 1씩 감소하며 출력
	 * 조건3. A와 B가 같으면 -> "같은수입력됨 "출력
	 * */
	
	public void method4() {
		System.out.println("두수 입력 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a==b) {
			System.out.println("같은수 입력됨");
			return;
			}
		
		if(a<b){
			for(int i=a;i<=b;i++) {
				System.out.println(i);
		}
		}else {
			for(int i=a;i>=b;i--) {
				System.out.println(i);
			}
		}
	}
	
	
	/**
	 * 두 수를 입력 받아 1씩 증가하며 반복 출력하기
	 * 
	 * (첫 번째 입력 A, 두 번째 입력 B)
	 * 
	 * - 입력 받은 두 수 중
	 *   작은 값이 초기식 , 큰 값이 조건식에 사용되게 작성
	 *   (같은 경우는 초기식 A, 조건식 B)
	 *   
	 */
	
	public void method5(){
		System.out.println("두수 입력 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a==b) {
			System.out.println("같은수 입력됨");
			return;
			}
		
		if(a>b) {
			for(int i=b; i<=a ; i++) {
				System.out.println(i);
			}
		}else {
			for(int i=a; i<=b; i++) {
				System.out.println(i);
			}
		}
	}
		
		
		
		
		/**
		 * 최대, 최소값 구하기 V2 (Math)
		 */	
		public void method5b() {
			System.out.print("입력 (1 2) : ");
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int min = Math.min(a, b); // 두 수 중 작은 값을 반환
			int max = Math.max(a, b); // 두 수 중 큰   값을 반환
			
			for(int i=min ; i<=max ; i++) System.out.println(i);
		}
		
		
		/**
		 * 
		 * 
		 * */
		
		public void method5c() {
			System.out.println("입력 (1 2): ");
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(b>a) {
				int temp = a;
				a=b;
				b=temp;
				
			}
			
			for (int i=a; i<=b; i++) System.out.println(i);
		}
		

	/**
	 * 1부터 100사이 7의 배수의 갯수 세기*/
	public void method6() {
		int count =0;
		for(int i = 1 ; i<=100; i++) {
			if(i%7==0){
				count ++;
			}
		}
		System.out.println(count);
		
	}
	
	/**
	 * 1부터 100사이 정수중 3의배수의 갯수와
	 * 3의배수를 제욍한 수들의 합 출력*/
	public void method7() {
		int count=0;
		int total=0;
		for(int i = 1; i<=100; i++) {
			if (i%3==0) count++;
			else total+=i;
			}
		System.out.println("3의배수갯수"+count);
		System.out.println("나머지합"+total);
	}
	
	
	
	/**
	 * 구구단5단 출력하기*/
	public void method8() {
		int result;
		
		for(int i=1; i<10; i++) {
			result= i*5;
			System.out.println("5X"+i+"="+result);
		}
	}
	
	
	
	public void method8a() {
		System.out.println("단수 입력:");
		int a= sc.nextInt();
		
		int result;
		
		for(int i=1; i<10; i++) {
			result= i*a;
			System.out.println(a+"X"+i+"="+result);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	