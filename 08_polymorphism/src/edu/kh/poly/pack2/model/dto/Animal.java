package edu.kh.poly.pack2.model.dto;

public abstract class Animal {
	//동물의 공통되노 필드/메서드 작성
	private String type;
	
	public Animal() {}
	
	public Animal(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type;
	}
	
	

	//부모클래스 애니ㅣ멀에서 eat과 sleep를 정의할수없음
	//->animal을 상속받는 자식 클래스에서 각자에게 맞춰 재정의하도록 강제화시킴
	public abstract void eat();
	public abstract void sleep();
	
	//->클래스 선언부에 abstract 추가!
	
	
	
	
}
