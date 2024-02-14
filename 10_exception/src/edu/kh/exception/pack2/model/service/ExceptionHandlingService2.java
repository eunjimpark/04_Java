package edu.kh.exception.pack2.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.annotation.processing.SupportedSourceVersion;

import edu.kh.exception.pack3.model.exception.MoreThanAHundredException;

public class ExceptionHandlingService2 {

	/* finally : 마지막에 반드시 수행하는 구문
	 * 
	 * - try 구문에서 예외 발생 여부와 관계 없이
	 *   무조건 수행해야되는 구문을 작성
	 * 
	 * -  try ~ catch ~ finally  또는 try ~ finally
	 */
	
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * finally 확인하기
	 */
	public void method1() {
		
		System.out.println("1. 정상 수행/ 2.강제 예외 발생");
		
		int input = sc.nextInt();
		
		try {
			if(input==1) System.out.println("[정상수행]");
			else              new RuntimeException();
		}catch(Exception e) {
			System.out.println("캐치문 수행됨");
			
		} finally {
			//try예외 발생 여부 관계없이 무조건 수행
			System.out.println("****무조건수행****");
		}
		
	}
	
	
	public void method2() {
		
		Scanner scan = new Scanner(System.in);
		
		// Resource leak: 'scan' is never closed
		// -> 프로그램 수행 후 scan이 메모리에 남아있어 
		//    메모리 누수(쓸때 없는 메모리 차지) 발생
		
		//  [해결 방법]
		
		System.out.print("정수 입력 : ");
		try {
			int input = scan.nextInt();
			System.out.println("입력한 정수 *10 : " + (input *10));
			
		}catch(InputMismatchException e) {
			System.out.println("잘못입력함");	
		}finally {
			if(scan !=null) {
				scan.close();
			}
		}
	}
	
	
	
	
	
	
	
	/** BufferedReader를 이용해서 문자열 입력 받기
	 * @return 입력 받은 문자열
	 */
	public String inputString() throws IOException{
		
		// throws IOException : 
		//  현재 메서드에서 발생할 수 있는(던져질 수 있는) IOException을 
		//  현재 메서드를 호출한 곳으로 던져서
		//  상황에 맞게 별도로 처리하게 함
		
		BufferedReader br 
			= new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		
		// System.in은 한 번 닫으면 재사용 불가!!!
		//br.close(); // 사용 끝난 br 객체 메모리 반환(제거)
		
		return str;
	}
	
	
	
	/**
	 * 사용자 정의 예외 사용
	 */
	public void method5() {
		
		try {
			System.out.println("[두 정수를 입력 받아 합계출력하기]");
			
			System.out.println("정수 1 : ");
			int number1 = Integer.parseInt(inputString());
			
			System.out.println("정수 2 : ");
			int number2 = Integer.parseInt(inputString());
			
			int result = number1+number2;
			
			if(result> 100) {
				throw new MoreThanAHundredException();
			}
			
		}catch (IOException e) {
			
			System.out.println("IOException 처리");

		}catch(NumberFormatException e) {
			System.out.println("잘못입력");
			
		}catch(MoreThanAHundredException e) {
			
		}
		
		
	}
	
	
	
	
	
	
	
	/**
	 *  throws : 메서드 내부에서 발생된 예외를
	 *           호출한 곳으로 던짐
	 *  
	 *  throw  : 예외 객체를 현재 위치에서 던짐 (예외 강제 발생)
	 */
	
	public void method4() {
		// inputString() 메서드를 이용해서
		// 문자열을 두 번 입력 받아 
		// 하나로 합쳐서 출력하기
		
		try {
			System.out.print("첫 번째 문자열 입력 : ");
			String str1 = inputString(); 
			// inputString() 호출 -> throws IOException
			// -> 호출한 곳에서 처리하겠다 
			// -> 예외 처리 코드(try-catch, throws) 작성
			
			System.out.print("두 번째 문자열 입력 : ");
			String str2 = inputString(); 
			
			//System.out.println(str1 + str2); // 효율 별로....
			
			StringBuilder sb = new StringBuilder();
			sb.append(str1);
			sb.append(str2);
			
			System.out.println(sb.toString());
			
			
			
		} catch(IOException e) {
			System.out.println("IOException 잡아서 처리함");
		}
	}
		
	
	
	
	
	
	
}
