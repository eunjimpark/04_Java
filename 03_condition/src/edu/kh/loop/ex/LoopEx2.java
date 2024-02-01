package edu.kh.loop.ex;

import java.util.Scanner;

public class LoopEx2 {

	Scanner sc = new Scanner(System.in);
	
	/**
	 * <pre>
	 * 다음모양 출력하기
	 * 1234
	 * 1234
	 * 1234
	 * </pre>
	 * */
	public void method1() {
		
		for(int x=3 ; x>=1 ; x--) { // 3번 반복
			
			for(int i=1 ; i<=4 ; i++) { // 1234 출력
				System.out.print(i);
			}
			System.out.println(); //줄바꿈	
		}
	}
	
	
	/**
	 * 다음모양 출력하기
	 * 4321
	 * 4321
	 * 4321
	 * */
	public void method2() {
		
		for(int x=2 ; x>=1 ; x--) { // 2번 반복
			
			for(int i=4 ; i>=1 ; i--) { // 4321 출력
				System.out.print(i);
			}
			System.out.println(); //줄바꿈	
		}
	}
	
	
	/**
	 * <pre>
	 * 다음 모양 출력 하기
	 * 
	 * (0,0) (0,1) (0,2)
	 * (1,0) (1,1) (1,2)
	 * (2,0) (2,1) (2,2)
	 * 
	 * </pre>
	 */
	public void method3() {
		for(int x=0; x<3 ; x++) {
		
		for(int i=0; i<3 ;i++) {
			System.out.printf("(%d,%d)",x,i);
		}
		System.out.println(); //줄바꿈
		}
	}
	
	
	/**<pre>
	 * 다음 모양 출력 하기
	 * 
	 * (2,2) (2,1) (2,0)
	 * (1,2) (1,1) (1,0)
	 * (0,2) (0,1) (0,0)
	 * </pre>
	 */
	public void method4() {
		for(int x=2; x>=0 ; x--) {
			
		for(int i=2; i>=0 ;i--) {
			System.out.printf("(%d,%d)",x,i);
		}
		System.out.println(); //줄바꿈
		}
	}
	
	
	
	
	/**
	 * 2단 부터 9단까지 모두 출력
	 * 
	 * 2x1= 2  2x2= 4  2x3= 6 ... 2x9=18
	 * 3x1= 3  3x2= 6  3x3= 9 ... 3x9=27
	 * ...
	 * 9x1= 9  9x2=18  9x3=27 ... 9x9=81
	 */
	public void method5() {
		
		int result;
		
		
		for(int x=2; x<=9; x++) {
			for(int i=1; i<=9; i++) {
				result=i*x;
				System.out.printf(" %2dx%d=%2d ",x,i,result);
			}
			System.out.println();
		}
		
	}
	
	
	
	
	/**
	 * 입력 받은 단 부터 9단까지 구구단 출력하기
	 * 
	 * 단, 입력 값이 2~9 사이가 아니면 "잘못 입력" 출력
	 */
	public void method6() {
		
		System.out.println("단 입력(2~9사이):");
		int a= sc.nextInt();
	
		if(a<2||a>9) { 
			System.out.println("잘못 입력");
			return;
			}
		
		int result;
		
		for(int x=a; x<=9; x++) {
			System.out.printf("=====%d단=====",x);
			System.out.println();
			for(int i=1; i<=9; i++) {
				result=i*x;
				System.out.printf(" %2d x %d = %2d ",x,i,result);
				System.out.println();
			}
		}
		
	}
	
	
	
	
	/**<pre>
	 * 1 2 3
	 * 4 5 6
	 * 7 8 9
	 * </pre>
	 */
	public void method7() {
		
		int count=1;
		
		for(int row=0; row<3; row++) { //3행 반복
			for(int col=0; col<3; col++) {
				System.out.print(count++ +"");
			}
			System.out.println();
		}
	}


	
	/**<pre>
  ####
  ####
  ####
  ####
 </pre>
*/
public void method8() {

	for(int row=0; row<4; row++) {
		for(int col=0; col<4; col++) {
			System.out.print("*");	
		}
		System.out.println();
	}
}




	
/** <pre>
 * 
 *    *
 *    **
 *    ***
 *    ****
 * 
 * </pre>
 */
public void method9() {
	
	for(int row=1; row<=4; row++) {
		for(int col=row; col>=1; col--) {
			System.out.print("*");	
		}
		System.out.println();
	}
}


/** <pre>
 * 
 *    ****
 *    ***
 *    **
 *    *
 * 
 * </pre>
 */
public void method10() {
	
	for(int row=4; row>=1; row--) {
		for(int col=row; col>=1; col--) {
			System.out.print("*");	
		}
		System.out.println();
		
	}
	
}




	
	
	
	
	
	
	
	
	
}
