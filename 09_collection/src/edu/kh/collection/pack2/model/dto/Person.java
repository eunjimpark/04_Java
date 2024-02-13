package edu.kh.collection.pack2.model.dto;

import java.util.Objects;

public class Person {
	
	private String name;
	private int age;
	private char gender;
	
	public Person() { }
	

	public Person(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	// 객체가 같다(동일, 동등)를 어떻게 비교할까??
	// - 동일 : 가르키고 있는 것이 같다
	// - 동등 : 값이 같음
	
	
	
	// 동일 비교 : Object.hashCode() 메서드 오버라이딩
	
	// hash 함수 : 값을 넣으면 같은 길이의 문자열이 반환되는 함수
	// ex) 123       -> qwerty
	//     abcdefghi -> asdfgh
	// (암호화에 많이 사용)
	
	// hashCode() : 객체별 식별 코드(객체를 구분하는 정수 값) 반환
	// (비슷한 예 : 주민등록번호, 학번..
	
	@Override
	public int hashCode() {
		//return name.hashCode() +age*31 +gender*31;
		
		return Objects.hash(name, age, gender);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		
		if(obj == null) return false; // null 비교 불가
		
		if(obj == this) return true; // 비교 대상이 현재 객체
		
		if(!(obj instanceof Person)) return false;
		
		
		//다운캐스팅
		Person other = (Person)obj;
		
		return  name.equals(other.name)&& age==other.age && gender ==other.gender ;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
