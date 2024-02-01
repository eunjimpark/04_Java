package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	
	Scanner sc = new Scanner(System.in);
	
	
	//실습문제1
	public void practice1() {
		
		int[] arr = new int[9];
		int sum=0;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
	
			if(i%2==0) {
				sum += arr[i];
			}
			System.out.print( arr[i] );
		}	
		System.out.println();
		System.out.println("짝수번째 인덱스 합:"+sum);
	}


	
	
	//실습문제2
	public void practice2() {
		
		int[] arr = new int[9];
		int sum=0;
		int x=9;
		
		for(int i=0; i<arr.length; i++) {
			
				arr[i] = x;
				x--;
				
				if(i%2!=0) {
					sum += arr[i];
				}
				System.out.print(arr[i]);
		}
		

		System.out.println();
		System.out.println(sum);
		//System.out.println("홀수번째 인덱스 합:"+sum);
	}


	//실습문제3
	public void practice3() {
		
		System.out.print("양의 정수 : ");
		int len = sc.nextInt();
		
		int[] arr = new int[len];
		
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = i+1;
			System.out.print(arr[i]+" ");
		}
	}
	
	
	
	//실습문제4
	public void practice4() {
		
		int[] arr = new int[5];
		for(int i=0; i<arr.length; i++) {
			System.out.printf("입력 %d :",i);
			arr[i] = sc.nextInt();
		}
		System.out.print("검색할 값 :");
		int searchValue = sc.nextInt();
		
		//배열검색
		for(int i=0; i<arr.length ; i++) {
			//i번째 인덱스 요소값이 서치벨류와 같은경우
			if(arr[i] == searchValue) {
				System.out.println("인덱스 : "+ i);
				return;
			}
		}
		System.out.println("일치하는 값이 존재하지 않습니다");
	}
	
	
	
	
	//실습문제5
	public void practice5() {
		System.out.print("정수입력 : ");
		int len = sc.nextInt();
		
		int[] arr = new int[len];
		
		for(int i=0 ;  i<arr.length ; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 :",i);
			arr[i]= sc.nextInt();
		}
		
		int sum =0;
		
		for(int i=0 ; i<arr.length; i++) {
			System.out.print(arr[i]+ " ");
			
			sum += arr[i];
		}
		System.out.println("\n 총합 : "  +sum);
	}
	
	
	
	//실습문제6
	public void practice6() {
		char[] arr =new char[14];
		
		System.out.print("주민등록번호 (-포함) : ");
		String input = sc.nextLine();
		
		for(int i=0; i<input .length(); i++) {
			
			//성별부분 전까지는그대로 배열에 대입
			if(i<=7)  arr[i]=input.charAt(i);
			//성별부분 이후에는 모두 *대입
			else      arr[i]='*';
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
	
	
	
	//실습문제7
	public void practice7() {
		
		// while문으로 조건에 맞는 수가 입력 될 때 까지 반복
		// + break
		
		// 배열 요소에 대입되는 숫자는 count 값을 ++, -- 를 이용해 제어
		int len = 0;
		while(true) { //무한루프
			//"3이상의 홀수가 입력될때까지 무한반복"
			System.out.print("정수:");
			len = sc.nextInt();
			
			//입력 받은 정수가 3이상의 홀수인경우 반복종료
			if(len>=3 && len%2==1) {
				break;
			}
			
			//if문 수행X
			System.out.println("다시입력하세요");
		}
		//입력받은 정수 크기 만큼 배열 선언, 할당
		int[] arr = new int[len];
		int count =0;
		
		for(int i =0 ; i<len ; i++) {			
			if(i<=len/2)  count++;
			else          count--;
			
			arr[i] =count; 
		}
		//배열 내 요소를 [1,2,3]형식의 문자열로 만들어 반환
		System.out.println(Arrays.toString(arr));
	}
	
	
	
	//실습문제8
	public void practice8() {
		int[] randoms =new int[10];
		
		String str= ""; //빈문자열
		
		for(int i =0; i<randoms.length; i++) {
			randoms[i]=(int)(Math.random()*10+1);
			
			str += randoms[i]+ " ";
		}
		System.out.print("\n 발생한 난수:" +str);
	}
	
	
	
	//실습문제9
	public void practice9() {
		int[] randoms =new int[10];
		
		String str= ""; //빈문자열
		
		int max=0;
		int min=0;
		
		for(int i =0; i<randoms.length; i++) {
			randoms[i]=(int)(Math.random()*10+1);
			
			str += randoms[i]+ " ";
			
			if(i==0) { //첫반복
				max = randoms[i];
				min = randoms[i];
				continue;
			}
			
			//첫반복이 아닌경우
			if(randoms[i]>max) max = randoms[i];
			if(randoms[i]<min) min = randoms[i];
		}
		
		System.out.println("발생한 난수:" +str);
		System.out.println("최대값:" +max);
		System.out.println("최소값:" +min);
	}
	
	
	//실습문제10
	public void practice10() {
		int[] randoms =new int[10];
		
		String str= ""; //빈문자열
		//난수생성
		for(int i =0; i<randoms.length; i++) {
			randoms[i]=(int)(Math.random()*10+1);
			//중복검사 방법
			for(int x=0; x<i;x++) {
				if(randoms[i]==randoms[x]) {
					i--;
					break;
				}
			}
		}
		
		//출력구문
		for(int i =0; i<randoms.length; i++) {
			str += randoms[i]+ " ";
		}
		
		System.out.print("\n 발생한 난수:" +str);
	}
	
	
	
	
	
	
	
	//실습문제11
	public void practice11() {
		int[] lotto =new int[6];
		
		//난수생성
		for(int i =0; i<lotto.length; i++) {
			lotto[i]=(int)(Math.random()*45+1);
			//중복검사 방법
			for(int x=0; x<i;x++) {
				if(lotto[i]==lotto[x]) {
					i--;
					break;
				}
			}
		}
		//오름차순정렬
		for(int i=0; i<lotto.length -1 ; i++) {
			for(int x=1+1; x<lotto.length ; x++) {
				if(lotto[i]>lotto[x]) {   //스왑
					int temp = lotto[i];
					lotto[i]=lotto[x];
					lotto[x]=temp;
				}
			}
		}
				System.out.print(Arrays.toString(lotto));
	}
	
	
	//ARrays.sort(lotto);  //배열 오름차순 정렬기능
	
	
	
	
	
	
}
