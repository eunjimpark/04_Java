package edu.kh.collection.pack2.model.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.pack2.model.dto.Person;

public class SetService {
	
	/*Set 집합
	 * -기본적으로 순서를 유지하지 않음
	 * -중복데이터 저장X (같은거들어오면 덮어쓰기)
	 *
	 *Set 인터페이스의 자식클래스
	 *1.HashSet :처리속도가 빠름
	 *2.LinkedHashSet : 순서를 유지하는 set
	 *3.TreeSet : 자동정렬가능
	 * */
	
/*해쉬셋 사용법
 * 사용조건1 객체에 이퀄스가 오버라이딩되어있어야함
 * 사용조건2 객체에 해쉬코드 오버라이딩 되어 있어야함
 * 
 * */
	
	public void method1() {
		
		//HashSet 객체 생성
		Set<String> set = new HashSet<String>();  //다형성 업캐스팅
		
		
		//1. boolean add(E e)추가
		set.add("네이버");
		set.add("카카오");
		set.add("라인");
		set.add("쿠팡");
		set.add("배달의민족");
		set.add("당근마켓");
		set.add("토스");
		set.add("직방");
		set.add("야놀자");
		
		System.out.println(set);
		
		
		// 중복 저장 확인  -> 중복 저장 X
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		
		System.out.println(set);
		
		
		// null : 참조하는 객체가 없음
		
		// null도 중복 X 확인
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		
		System.out.println(set); // null 1회 출력
		
		
		
		// 2. int size() : Set에 저장된 객체의 수 반환
		System.out.println("set.size() : " + set.size());
		
		//3. voolean remove(e)
		//전달받은 e를 set에서 제거 제거성공 true ,없으면 false
		
		System.out.println(set.remove("배달의민족"));
		System.out.println(set.remove("유플러스"));
		System.out.println(set);
		
		
		//4. boolean contains(e):전달받은 e가 이쓰면 트루없으면 페일
		System.out.println("쿠팡있는지확인");
		System.out.println(set.contains("쿠팡"));
		System.out.println(set.contains("삼성"));
		
		
		//5.void clear() :set에 저장된 내용모두삭제
		set.clear();
		
		//6.boolean isEmpty() : 비어있으면트루 아니면 펄스
		System.out.println("비어있음?" + set.isEmpty());
	}
	
	
	
	public void method2() {
		
		Set<String> set = new HashSet<String>();
		
		set.add("몽쉘");
		set.add("꼬북칩");
		set.add("쿠쿠다스");
		set.add("빈츠");
		set.add("포카칩");
		
		// 1. Iterator(반복자)
		// - 컬렉션 객체에 저장된 요소를 
		//   하나씩 순차 접근 하는 객체
		
		Iterator<String> it = set.iterator();
		
		// boolean Iterator.hasNext()  : 
		// 다음 순차 접근할 요소가 있으면 true, 없으면 false
		
		while(it.hasNext()) {
			// 다음 요소가 있으면 반복, 없으면 멈춤
			
			// E Iterator.next() : 다음 요소를 꺼내와 반환
			String temp = it.next();
			System.out.println(temp);
		}
		
		
		System.out.println("---------------------------");
		System.out.println("[List로 변환]");
		
		// Set에 저장된 객체를 이용해서 List를 생성
		List<String> list = new ArrayList<String>(set);
		
		// 일반 for문
		for(int i=0 ; i < list.size() ; i++ ) {
			System.out.println( list.get(i) );
		}
		
		System.out.println("--------------------");
		System.out.println("[향상된 for문]");
		
		for(String snack : set) {
			System.out.println(snack);
		}
		
	}
	
	
	
	public void method3() {
		Person p1 = new Person("홍길동",25,'남');
		Person p2 = new Person("홍길동",25,'남');
		Person p3 = new Person("홍길동",30,'남');
		Person p4 = new Person("김길순",20,'여');
		
		// hashCode() : 객체 식별 번호(정수)
		// - 같은 필드 값을 가진 객체는 번호가 같다!!
		System.out.println("p1 : " + p1.hashCode());
		System.out.println("p2 : " + p2.hashCode());
		System.out.println("p3 : " + p3.hashCode());
		System.out.println("p4 : " + p4.hashCode());
		
		// A.equals(B) : A와 B가 가지고 있는 필드 값이 같다면 true
		System.out.println("p1.equals(p2) : " + p1.equals(p2));
		System.out.println("p1.equals(p3) : " + p1.equals(p3));
		
		//Set 중복 제거 확인
		 Set<Person> personSet =new HashSet<Person>();
			personSet.add(p1);
			personSet.add(p2);
			personSet.add(p3);
			personSet.add(p4);
			
			System.out.println("-------------------------------------");
			for(Person p : personSet) {
				System.out.println(p);
			}
			
			// ********************************************************
			// Hash 라는 단어가 포함된 컬렉션 이용 시
			// hashCode(), equals() 오버라이딩 필수적으로 진행!!!
			// *************************************************
			
			
			
		 
		
		
		
		
		
		
		
	}
	
	
	
	public void method4() {
		//난수 생성
		
		
		Random random = new Random();
		
		Set<Integer> lotto = new TreeSet<Integer>();
		
		while(lotto.size()<6) {
			lotto.add(random.nextInt(45)+1);
		}
		System.out.println(lotto);
		
	}
	
	
	public void lottoNumberGenerator() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("금액 입력 : ");
		int amount = sc.nextInt();
		
		Random random = new Random();
		
		// 생성된 로또 번호 묶음을 저장할 List
		List<Set<Integer>> lottoList = new ArrayList<Set<Integer>>();
		
		for(int i=0, end = amount/1000 ; i < end ; i++) {
			
			// for문 반복될 때 마다 새로운 Set 객체를 생성
			Set<Integer> lotto = new TreeSet<Integer>(); 
			
			while(lotto.size() < 6) {
				lotto.add( random.nextInt(45) + 1 ); // 1 ~ 45 사이 난수 추가
			}
			
			lottoList.add(lotto); // List에 Set 추가(담기)
			// -> 반복 시 마다 
			// List 각 인덱스에 서로 다른 Set 참조 주소가 저장된다!
		}
		
		// 출력용 반복문
		for(int i=0 , size = lottoList.size() ; i< size ; i++) {
			System.out.println((i+1) + "회 : " + lottoList.get(i));
		}
		
		
	}
	
	
	
	
	
	
	
}
