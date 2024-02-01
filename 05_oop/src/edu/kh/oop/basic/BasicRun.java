package edu.kh.oop.basic;

public class BasicRun {

	public static void main(String[] args) {
		
		//국민객체생성 == 국민클래스의 내용대로 heap영역에 할당
		
		Nation n1 = new Nation();
		
		n1.name = "홍길동";
		n1.age  = 34;
		n1.gender = '남';
		
		System.out.printf("이름은 %s이고, %d세 %c성입니다\n", n1.name ,n1.age, n1.gender);
		
		Nation n2 =new Nation(); 
		//네이션객체 참조변수n2에 
		//힙영역에 네이션 클래스를 이용해 생성된 객체의 주소를 대입
		
		n2.name = "신짱구";
		n2.age = 5;
		n2.gender='남';
		
		n2.introduce();
		
		
		Nation n3 =new Nation(); 
		n3.name= "봉미선";
		n3.age = 29;
		n3.gender = '여';
		
		n3.introduce();
		
		n1.납세의의무();
		n2.납세의의무();
		n3.납세의의무();
		
		
		
		System.out.println("객체 생성 확인");
	}
}
