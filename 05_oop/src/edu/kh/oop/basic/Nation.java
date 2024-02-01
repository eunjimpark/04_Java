package edu.kh.oop.basic;



//클래스 : 객체가 가져야할 속성,기능을 글로작성해둔 문서	
public class Nation {
	

	String name;
	int age;
	char gender;
	String juminNumber;
	String tel;
	String address;
	
	public void speakKorean() {
		System.out.println("가나다라 한국어 가능");
	}
	public void welfare() {
		System.out.println("우리나라에서 제공하는 복지를 누릴수 있음");
	}
	public void 납세의의무() {
		
		//만 19세이상 성인만 세금을 내는 경우
		if(age>=19) {
			System.out.printf("%s 님은 세금 납부 대상자입니다\n",name);
		}else {
			System.out.printf("%s 님은 %d세 미성년자로 세금납부안해도대여\n", name, age);
		}
	}
	public void introduce() {
		System.out.printf("이름은 %s이고, %d세 %c성 입니다\n", name, age, gender);
	}
	

	
}
