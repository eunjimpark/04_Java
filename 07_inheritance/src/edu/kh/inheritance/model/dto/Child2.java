package edu.kh.inheritance.model.dto;

import edu.kh.inheritance.model.dto.Parent;

public class Child2 extends Parent {

	private String smartPhone;

	public Child2() {
		super();

		System.out.println("Child2 기본 생성자");

	}

	public Child2(String lastName, String address, int money, String car, String smartPhone) {
			
			super(lastName, address, money, car);
			this.smartPhone = smartPhone;
			System.out.println("child2 매개변수 생성자로 객체 생성");
	}
			
	public String getSmartPhone() {
		return smartPhone;
	}

	public void setSmartPhone(String smartPhone) {
		this.smartPhone = smartPhone;
	}

	public String informChild2() {
		return inform() + " / " + smartPhone;
	}
	
	
	//부모로부터 상속받은 introduce()메서드 오버라이딩 하기
	
	public String introduce() {
		return "Child2 입니다+super.introduce()";
	}
	
	
	//toString 오버라이딩
	@Override
	public String toString() {
		return super.toString() + "\nChild2:" + smartPhone;
	}
	
	
	
}
