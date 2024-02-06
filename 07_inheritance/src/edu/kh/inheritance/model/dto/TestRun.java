package edu.kh.inheritance.model.dto;

public class TestRun {
	
	public static void main(String[] args) {
		//부모객체 Parent 생성
		
		Parent p1 = new Parent(); //기본생성자
		Parent p2 = new Parent("김","서울시어딘가",2000,"G80");
		
		System.out.println("----------------------------------");
		Child1 c1 =new Child1();
		
		//Child1 자식의기능
		c1.setComputer("삼성 갤럭시북4");
	
		//child1 내부에 생성된 parent의 기능
		String str1= c1.inform();
		System.out.println("str1:"+str1);
		
		String str2 = c1.informChild1();
		System.out.println("str2: "+str2);
		
		
		
		System.out.println("----------------------------------");
		
		// Child1 매개 변수 생성자를 이용해서 객체 생성
		Child1 c2 = new Child1("2024 LG GRAM");
		String str3 = c2.informChild1();
		System.out.println("str3:"+str3);
		
		System.out.println("----------------------------------");
		
		// Child2 객체 생성 (매개 변수 생성자 이용)
		Child2 c3 = new Child2("최","서울시강남구",999_999_999,"벤츠","아이폰15");
		
		String str4 = c3.informChild2();
		System.out.println("str4 : " + str4);
		
		
		System.out.println("======================================");
		System.out.println("======================================");
		System.out.println("======================================");
		
		
		System.out.println("[상속을 이용해소 공통된 규약 설정])");
				
		Child1 ch1 = new Child1();
		Child2 ch2 = new Child2();
		
		
		ch1.testMethod();
		ch2.testMethod();
		
		
		
		//오버라이딩확인하기
		
		System.out.println("-----오버라이딩-----");
		System.out.println(ch1.introduce());
		System.out.println(ch2.introduce());
		
		
		
		
		System.out.println("----- toString() 오버라이딩() -----");
		
		System.out.println(p1.toString());
		System.out.println(ch1.toString());
		System.out.println(ch2.toString());
		
		
		
		

		
	}

}
