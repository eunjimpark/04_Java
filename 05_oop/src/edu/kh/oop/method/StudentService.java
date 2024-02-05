package edu.kh.oop.method;

import java.util.Scanner;

public class StudentService {
	
	private Scanner sc = new Scanner(System.in);
	
	public void displayMenu() {
		int input =0; //스캐너로 입력받은 메뉴번호를 저장할변수
		
		Student std1 =new Student("홍길동","112233", '남');
		Student std2 =new Student("박은지","1233", '여');
	
		do {
			
			System.out.println("""
					
====학생 관리 프로그램====
1. 학생 등록
2. 학생 정보 확인
3. 학생 이름 수정
4. Java 공부하기
5. HTML 공부하기
6. Java 역량 비교하기
7. HTML 역량 비교하기
0. 프로그램종료						
					""");
			
			System.out.println("메뉴 선택 >>");
			input = sc.nextInt();
			
			switch(input) {
			
			case 1: 
				System.out.println("학생을 등록할 변수 선택(1:std1/2:Std2):");
				int select = sc.nextInt();
				if(select ==1) std1=createStudent();
				else           std2=createStudent();
			break;
				
			case 2: 
				System.out.println("정보를 조회할 학생 선택 선택(1:std1/2:Std2):");
				String text = null; //학생정보가 담긴 문자열을 저장할 변수
				if(sc.nextInt()==1) text = studentInform(std1); 
				else                text = studentInform(std2);
				System.out.println(text);
			break;
				
			case 3: 
				System.out.println("이름을 수정할 학생선택(1/2):");
				if(sc.nextInt()==1) updateStudentName(std1);
				else                updateStudentName(std2);
			break;
			
			case 4:
				System.out.println("자바공부할 학생선택(1/2):");
				if(sc.nextInt()==1) updateJava(std1);
				else                updateJava(std2);
			break;
			
			case 5:
				System.out.println("HTML공부할 학생선택(1/2):");
				if(sc.nextInt()==1) updateHtml(std1);
				else                updateHtml(std2);
			break;
				
			case 6: 
				String result = compareJava(std1,std2);
				System.out.println(result);
			break;
				
			case 7:
				String result1 = compareHtml(std1,std2);
				System.out.println(result1);
				break;
			case 0: System.out.println("======프로그램 종료====="); break;
			default : 
			}
			
			
		}while(input !=0);
	}

	
	
	/**학생 정보를 입력받아 생성된 student객체를 반환
	 * @return  생성된 학생객체 주소
	 */
	private Student createStudent() {
		System.out.println("이름 : ");
		String name = sc.next();
		
		System.out.println("학번 : ");
		String studentNumber = sc.next();
		
		System.out.println("성별(남/여):");
		char gender =sc.next().charAt(0);
		
		return new Student(name, studentNumber, gender);
	}
	
	
	private String studentInform(Student s) { 
		// String.format("패턴", 변수)
		// - 패턴 모양의 문자열을 반환하는 String 메서드
		
		return String.format("%s / %s / %c / %s / %d / %d",
				Student.shcoolName, s.getStudentNumber(), s.getgender(),
				s.getName(), s.getJava(), s.getHtml());
	}
	
	

	private void updateStudentName(Student s) {
		System.out.println("수정할 학생이름 : ");
		String newName = sc.next();
		
		String beforeName = s.getName();
		s.setName(newName);
		
		System.out.println("학생 이름이 수정되었습니다");
		System.out.printf("%s->%s \n",beforeName, newName);
	}
	
	
	private void updateJava(Student s) {
		System.out.println("증가 또는 감소한 Java 역량 입력(정수):");
		
		int input = sc.nextInt();
		
		int before = s.getJava();
		
		s.setJava(before + input);
	
		//점수가 최대/최소 값을 넘지못하게 처리
		if(s.getJava() > Student.MAX_VALUE) s.setJava(Student.MAX_VALUE);
		if(s.getJava() < Student.MIN_VALUE) s.setJava(Student.MIN_VALUE);
		
		System.out.println("자바역량 수정 완료");
		System.out.printf("%d -> %d(%d)\n", before, s.getJava(), input);
	}
	
	
	private void updateHtml(Student s) {
		System.out.println("증가 또는 감소한 HTML 역량 입력(정수):");
		
		int input = sc.nextInt();
		
		int before = s.getHtml();
		
		s.setHtml(before + input);
	
		//점수가 최대/최소 값을 넘지못하게 처리
		if(s.getHtml() > Student.MAX_VALUE) s.setHtml(Student.MAX_VALUE);
		if(s.getHtml() < Student.MIN_VALUE) s.setHtml(Student.MIN_VALUE);
		
		System.out.println("HTML역량 수정 완료");
		System.out.printf("%d -> %d(%d)\n", before, s.getHtml(), input);
	}
	
	
	
	/** 매개변수로 전달받은 두 학생의 자바점수를 비교
	 * @param s1
	 * @param s2
	 * @return
	 */
	private String compareJava(Student s1, Student s2) {

		//전달받은 s1이 참조하는 Student 객체가 없을 경우 
		if(s1 == null) {
			return "첫번째 학생이 등록되지 않았습니다.";
			}
		if(s2 == null) {
			return "두째 학생이 등록되지 않았습니다.";
		}
		String result = String.format("std1 : %d / std2 : %d \n",s1.getJava(),s2.getJava());
		
		//두학생의 점수 비교
		if(s1.getJava() > s2.getJava()) {
			return result + "std1의 점수가 더 높습니다";
		}
		if(s1.getJava() < s2.getJava()) {
			return result +  "std2의 점수가 더 높습니다";
		}
		
		return result + "점수가 같습니다";
		
	}
	
	
	private String compareHtml(Student s1, Student s2) {

		//전달받은 s1이 참조하는 Student 객체가 없을 경우 
		if(s1 == null) {
			return "첫번째 학생이 등록되지 않았습니다.";
			}
		if(s2 == null) {
			return "두째 학생이 등록되지 않았습니다.";
		}
		String result = String.format("std1 : %d / std2 : %d \n",s1.getHtml(),s2.getHtml());
		
		//두학생의 점수 비교
		if(s1.getHtml() > s2.getHtml()) {
			return result + "std1의 점수가 더 높습니다";
		}
		if(s1.getHtml() < s2.getHtml()) {
			return result +  "std2의 점수가 더 높습니다";
		}
		
		return result + "점수가 같습니다";
		
	}
	
	
	
	
	
	
	
}
