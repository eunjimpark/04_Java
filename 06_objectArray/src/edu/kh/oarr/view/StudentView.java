package edu.kh.oarr.view;

import java.util.Scanner;

import edu.kh.oarr.model.dto.Student;
import edu.kh.oarr.model.service.StudentService;

//입력,출력을 담당하는 클래스(객체의 속성,기능정의)
public class StudentView {

	//필드(객체의 속성 , 멤버변수)
	
	//static이 붙은 필드 ==틀래스변수
	//static이 없는 필드 ==인스턴스변수
	private Scanner sc = new Scanner(System.in);
	private StudentService service = new StudentService();
	
	//메뉴표시기능
	public void displayMenu() {
		
		int input = 0 ; //메뉴번호 입력받을 변수
		do {
			System.out.println("\n----- 학생 관리 프로그램 -----");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 1명 정보 조회(인덱스)");
			System.out.println("4. 학생 이름으로 조회");
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
			System.out.println("7. 평균 최고점, 최저점 학생");
			System.out.println("0. 종료");
			
			System.out.print("메뉴선택 >>");
			input = sc.nextInt();
			
			switch(input) {
			case 1 : addStudent(); break;
			
			case 2 : selectAll(); break;
			
			case 3 : selectIndex(); break;
			
			case 4 : selectName(); break;
			
			case 5 : updateStudent(); break;
			
			case 6 : selectScore(); break;
			
			case 7 : selectMaxMin(); break;
			
			case 0 : System.out.println("[[프로그램 종료]]"); break;
			
			default : System.out.println("[[잘못 입력]]");
			}
			
		}while(input !=0);
		
	}
	
	private void addStudent() {
		System.out.println("\n ----학생 추가 ----");
		
		System.out.print("학번 :");
		String studentNumber = sc.next();
		
		System.out.print("이름 :");
		String name = sc.next();
		
		System.out.print("성별(M/F) :");
		char gender = sc.next().toUpperCase().charAt(0);
		
		//문자열.toUpperCase() : 영어 대문자로 변경
		//학생 추가 Service 메서드 호출 후 결과 반환 받기
		boolean result = service.addStudent(new Student(studentNumber, name, gender));
		
		if(result) {
			System.out.println(name+ "학생이 추가 되었습니다");
		}else {
			System.out.println("학생을 더이상 추가할수 없습니다");
		}
	
	}
	
	
	//등록된학생 전체출력
	private void selectAll() {
		System.out.println("\n----학생 전체 조회----");
		
		Student[] studentList = service.getStudents();
		
		for(int i=0; i<studentList.length ; i++) {
			
			//학생이 없는 인덱스인 경우 반복 종료
			if(studentList[i]==null) break;
			
			System.out.println(i+"번째 인덱스\n"+studentList[i].toString());
			System.out.println();
		}
	}
		
	
	
	private void selectIndex() {
		System.out.println("---학생 1명 정보조회(index검색)---");
		System.out.println("인덱스 입력 :");
		int index = sc.nextInt(); 
		
		//서비스로 인덱스전달후 일치하는 학생이 있으면 반환받기
		Student std= service.selectIndex(index);
		
		if(std ==null) System.out.println("해당인덱스에 학생이 존재하지않아요");
		else {         
			System.out.println("학번 : "+std.getStudentNumber());
			
			String temp = null;
			if(std.getGender()=='F') temp = "여성";
			else                     temp = "남성";
			
			System.out.println("성별 :" +temp);
			
			System.out.println("이름 :" + std.getName());
			
			System.out.println("-----점수-----");
			System.out.println("HTML : " +std.getHtml());
			System.out.println("CSS : " +std.getCss());
			System.out.println("Js : " +std.getJs());
			System.out.println("Java : " +std.getJava());
		}
	}
	
	
	
	
	//이름으로 학생조회
	private void selectName() {
		System.out.println("\n -----이름으로 학생 조회 -----");
		System.out.print("이름 입력:");
		String name = sc.next();
		
		Student std = service.selectName(name);	
		
		if(std == null) 
			System.out.println("같은 이름의 학생이 존재하지 않습니다");
		
		else {
			System.out.println("학번 : " + std.getStudentNumber());
			
			String temp = null;
			if(std.getGender() == 'F' ) temp = "여성";
			else											  temp = "남성";
			
			System.out.println("성별 : " + temp);
			System.out.println("이름 : " + std.getName());		
			System.out.println("----- 점수 -----");
			System.out.println("HTML : " + std.getHtml());
			System.out.println("CSS  : " + std.getCss());
			System.out.println("Js   : " + std.getJs());
			System.out.println("Java : " + std.getJava());
		}
	}
	

	
	
	//인덱스 먼저 입력받아 해당 인덱스에 학생이 존재하면 점수를 입력받아 수정
	private void updateStudent() {
		System.out.println("\n -----학생 정보 수정(점수)-----");
		
		System.out.print("수정할 학생의 인덱스 번호 입력 : ");
		int index = sc.nextInt();
			
		Student std = service.selectIndex(index);
		
		if(service.selectIndex(index) ==null) {
			System.out.println("해당인덱스에 학생이 존재하지않아요");			
			return;
		}
			System.out.print("HTML,CSS,Js,Java 순서로 입력:");
			std.setHtml(sc.nextInt());
			std.setCss(sc.nextInt());
			std.setJs(sc.nextInt());
			std.setJava(sc.nextInt());
			System.out.println("수정 완료");
	}
	
	
	
	
	//각각 의 점수조회 합계와 평균조회
	private void selectScore() {
		System.out.println("\n-----학생 점수 조회 -----");
		
		System.out.print("조회할 학생의 인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		Student std = service.selectIndex(index);
		
		if(service.selectIndex(index) ==null) {
			System.out.println("해당인덱스에 학생이 존재하지않아요");			
			return;
		}
		else {		
			String str = service.selectScore(index);
			System.out.println(str);
		}
	}
	
	
	
	
	
	//평균 최고점,최저점 학생 조회하기
	private void selectMaxMin() {
		System.out.println("\n-----평균 최고점, 최저점 학생 조회하기 -----");
		
		String result = service.selectMaxMin();
		
		System.out.println(result);
	}
	
	
	
	
	
	
	
}
	

