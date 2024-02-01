package edu.kh.loop.ex;

public class LoopEx3 {


		
		/**
		 * 문자열 한 글자씩 출력하기
		 */
		public void method1() {
			//문자열.charAt(인덱스) : 인덱스번째 문자 하나 얻어와 반환
			String str = "Hello World!!!";
			
			//문자열.lenght() : 문자열의 길이(메서드)
			for(int i=0; i<str.length(); i++) {
				System.out.println(str.charAt(i));
			}
		}


		
	
	
}
