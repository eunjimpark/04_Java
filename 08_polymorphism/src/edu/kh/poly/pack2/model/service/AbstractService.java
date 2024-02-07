package edu.kh.poly.pack2.model.service;

import edu.kh.poly.pack2.model.dto.Animal;
import edu.kh.poly.pack2.model.dto.Dog;
import edu.kh.poly.pack2.model.dto.Snake;


public class AbstractService {

	//추상클래스는 진짜 객체로 못만들까?
	public void method1() {
		//Animal a = new Animal();
	}
	
	
	//추상클래스를 상속받은 클래스를 이용해 객체생성 
	//+다형성 업캐스팅, 동적 바인딩 + 객체배열
	public void method2() {
		//추상클래스는 객체생성은 안되지만 부모타입의 참조변수 역할은 할수있다
		Animal a1 = new Dog("포유류",false);
		Animal a2 = new Snake("파충류",true);
		
		//동적바인딩에인해 자식 객체 내 부모 추상 메서드가 호출될인은 절대로없다
		
		
		Animal a3 = new Dog("포유류",true);
		Animal a4 = new Snake("파충류",false);
		
		Animal[] arr = {a1,a2,a3,a4};
		
		
		//향상되노 포문 + 동적바인딩 
		for(Animal a : arr) {
			System.out.println("------------------------------------");
			
			// 아래 구문들 모두 동적 바인딩 수행
			System.out.println(a.toString());
			a.eat();
			a.sleep();
		}

		
	}
	
	

}
