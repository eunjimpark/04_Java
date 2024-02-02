package edu.kh.oop.method;

import java.util.Scanner;

public class StudentService {
	
	private Scanner sc = new Scanner(System.in);
	
	public void displayMenu() {
		int input =0; //스캐너로 입력받은 메뉴번호를 저장할변수
		
		Student std1 =null;
		Student std2 =null;
	
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
0.프로그램종료						
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
			case 4: break;
			case 5: break;
			case 6: break;
			case 7: break;
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
	
	
	
	
	
	
	
	
	
	
}
