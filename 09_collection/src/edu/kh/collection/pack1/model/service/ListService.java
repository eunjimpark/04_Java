package edu.kh.collection.pack1.model.service;

import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;

import edu.kh.collection.pack1.model.dto.Book;

//컬렉션 : 자바에서 자료구조를 만들어서 모아둔것

//특징
//1) 크기 제한없음
//2) 추가 수정 삭제 검색 등 다양한 기능 구현
//3) 객체만 저장 가능

public class ListService {
	
	//List 자료를 순차적으로 나열한 자료 구조 (배열비슷)
	
	//리스트 사용해보기
	public void method1() {
		//리스트 객체 생성
		//-리스트(인터페이스)->객체생성불가 - >다형성이용->ARrayList클래스 리스트의후손
		List list = new ArrayList(3); //3칸짜리생성
		
		//반환형 메서드명 (매개변수)
		
		//E(Element) : 요소를 뜻하는 상징적인 글자(자료형X) 
		//             ==Object,STring, Student등 자료형 가리지않고 들어갈수 있다
		//1. boolean add(E e) : 마지막 요소로 추가
		
		list.add("아무거나");
		list.add(new Object());
		list.add(123123);
		
		list.add(3.123123); //크기
		list.add(false);
		
		System.out.println(list);
		
		System.out.println("저장된 개수:" + list.size());
		
		for(int i=0; i<list.size();i++) {
			System.out.printf("%d번째 인덱스 : " , i);
			System.out.println(list.get(i));
			
			//list의 i번째 요소가 String인 경우
			if(list.get(i) instanceof String) {
				System.out.println("[String 자료형 입니다]\n");
				continue;
			}
			
			//List의 i번째 요소가 int(->Integer변환)인 경우 
			if(list.get(i) instanceof Integer) {
				System.out.println("***Integer자료형입니다***");
				continue;
			}
			
			//List의 i번째 요소가 double(->Double)인 경우
			if(list.get(i) instanceof Double) {
				Double d = (Double)list.get(i);  //다운캐스팅
				
				System.out.println("Double의 바이트 크기 : " + d.BYTES + "\n");
			}
			
			// Object 타입은 아무거나 다 참조할 수 있다!!!
			Object[] test = new Object[5]; // 다형성 (업캐스팅)
			test[0] = "아무거나";
			test[1] = 123123;
			test[2] = new Object();
			test[3] = 3.123123;			
		}
	}
	
	public void method2() {
		
		//컬렉션의 장점 중 "여러타입 저장가능"이 코드길이를 늘리는 주범!!!
		//->타입을 하나로 제한 
		
		//String타입으로 제한된 어레이리스트객체 생성
		List<String> strList = new ArrayList<String>();
		
		//제네릭의 타입 제한 확인 
		strList.add("닭갈비");
		strList.add("치킨");
		strList.add("보쌈");
		//strList.add(123); //String이 아니라서 에러
		strList.add("족발");
		strList.add("카레");
		strList.add("버거");
		
		for(int i=0; i<strList.size();i++) {
			String foodName = strList.get(i);
			System.out.println(foodName);
		}
		
		strList.add(1, "찜닭");
		

		
		//4.Stromg toString() : List에 저장된 모든 요소 문자열로 반환
		//System.out.println(strList.toString());
		System.out.println(strList);
		
		//5. E set(int index, E e) : 
		//index번째 요소를 e로 수정 ->수정전 요소가 반환
		String before = strList.set(2, "양념치킨");
		System.out.println("수정전 : "+ before);
		System.out.println("수정후 : "+ strList.get(2));
		System.out.println(strList);
		
		
		
		//int indexOF(E e)
		//List내부에 e와 같은 요소가 있으면 해당 인덱스 없으면 -1반환
		System.out.println(strList.indexOf("보쌈"));
		System.out.println(strList.indexOf("막국수"));

		//7. boolean contains(E e)
		//List 내부에 e와 같은 요소가 있으면 true , 없으면 false
		System.out.println(strList.contains("보쌈"));
		System.out.println(strList.contains("막국수"));

		//8. E remove(int index)
		//index 번쨰 요소를 제게 (추출!!)
		String target = strList.remove(0); //0번인덱스요소 제거
		
		System.out.println("제거된 요소 : " + target);
		System.out.println(strList);
	}


	public void bookManage() {
		
		List<Book> bookList = new ArrayList<Book>();
		Scanner sc = new Scanner(System.in);
		
		int input = 0; //메뉴번호 입력

		do {
			System.out.println("----도서관리프로그램 ----");
			System.out.println("1.추가");
			System.out.println("2.전체조회");
			System.out.println("3.index로 조회");
			System.out.println("4.수정");
			System.out.println("5.제거");
			System.out.println("0.종료");
			
			
			System.out.print("메뉴 번호 입력 >>>");
			
			input = sc.nextInt();
			
			sc.nextLine();
			
			switch(input) {
				case 1:
					System.out.print("제목입력:");
					String title = sc.nextLine();
					
					System.out.print("저자입력:");
					String writer = sc.nextLine();	
					
					System.out.print("가격입력:");
					int price = sc.nextInt();
					
					if(bookList.add(new Book(title,writer,price) ) ) {
						System.out.println("추가성공!");
					}
					break;
					
				case 2:
					System.out.println("\n---전체조회---\n"); 
					for(Book b :bookList) System.out.println(b);
					break;
					
				case 3: 
					System.out.print("조회할 책의 인덱스 선택:"); 
					 int index = sc.nextInt();
					 if(index>=0 && index<bookList.size()) {
						 System.out.println(bookList.get(index));
					 }else {
						 System.out.println("잘못입력했다 이짜식아");
					 }
					break;
					
				case 4:
					System.out.println("\n책수정\n");
					
					System.out.print("수정할 인덱스 번호:");
					index = sc.nextInt();
					sc.nextLine(); //버퍼 개행문자 제거
					
					System.out.print("수정할 책 제목:");
					title = sc.nextLine();
					
					System.out.print("수정할 책 저자:");
					writer = sc.nextLine();
					
					System.out.print("수정할 책 가격:");
					price = sc.nextInt();
		
					Book after = new Book(title, writer, price); //새책
					Book before = bookList.set(index, after); //책바꾸고 이전책 추출
					
					System.out.println("전:"+before);
					System.out.println("후:"+after);
					break;
					
				case 5: 
					System.out.println("\n책제거\n");
					
					System.out.print("제거할 인덱스 번호:");
					index = sc.nextInt();
					
					Book target = bookList.remove(index);
					
					System.out.println("제거된책:"+target);
					break;
				
				case 0: System.out.println("\n종료\n"); break;
				
				default :  System.out.println("\n[잘못입력]\n");

			}
		}while(input !=0);
		
	}

	
	
	
	
}
