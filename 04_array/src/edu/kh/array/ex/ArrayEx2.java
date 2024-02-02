package edu.kh.array.ex;

import java.util.Arrays;

public class ArrayEx2 {
	
	
	//얕은복사
	public void method1() {
		
		int[] arr1= {100,200,300,400};
		
		int[] arr2 = arr1;
		
		System.out.println("arr1:"+ Arrays.toString(arr1));
		System.out.println("arr2:"+ Arrays.toString(arr2));
		
		//서로다른 변수를 이용해서 값 변경
		arr1[0] =1234;
		arr2[1] = 9876;
		
		System.out.println("---------------------------------");
		System.out.println("arr1:"+ Arrays.toString(arr1));
		System.out.println("arr2:"+ Arrays.toString(arr2));
	}

	//깊은복사 :값을똑같이복사한 배열 
	public void method2() {
		
		int[] arr1 = {10,20,30,40,50}; //원본배열
		//값을 복사할 배열 (깊은 복사)
		int[] arr2 = new int[arr1.length];
		int[] arr3 = new int[arr1.length];
		
		//깊은복사 방법1
		for(int i=0 ;  i<arr1.length ; i++) {
			arr2[i]=arr1[i];
		}
		
		//깊은복사 방법2 : system.arraycopy()
		//(원본배열명,원본복사시작인덱스,복사배열명, 복사배열의 삽입시작인덱스, 복사길이)
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		
		System.out.println("arr1:"+Arrays.toString(arr1));
		System.out.println("arr2:"+Arrays.toString(arr2));
		System.out.println("arr3:"+Arrays.toString(arr3));	
		
		
		//모든 배열의 0번 인덱스 값을 변경
		
		arr1[0]=999;
		arr2[0]=888;
		arr3[0]=777;
		
		
		System.out.println("arr1:"+Arrays.toString(arr1));
		System.out.println("arr2:"+Arrays.toString(arr2));
		System.out.println("arr3:"+Arrays.toString(arr3));	
	}

	
	
	//2차원배열
	public void method3() {
		//2차원배열 선언
		int[][] arr = new int[2][3]; //3칸짜리 1차원배열 2개
		
		//2차원 배열 초기화
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[0][2] = 30;

		arr[1][0] = 40;
		arr[1][1] = 50;
		arr[1][2] = 60;
		
		//2차원 배열 모든요소내 순차접근
		for(int row = 0; row<arr.length ; row++) {
	
			for(int col = 0; col <arr[row].length ; col++) {	
				System.out.print(arr[row][col] + " "); //요소출력
			}
			
			System.out.println(); //줄바꿈
		}
	}
	
	
	
	
	
	
}
