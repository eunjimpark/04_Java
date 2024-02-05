package edu.kh.oarr.model.service;

import java.util.Random;

import edu.kh.oarr.model.dto.Student;
//service클래스 : 기능제공클래스
//->입력,출력빼고 나머지
public class StudentService {
	
	private Student[] students = new Student[10];
	
	public StudentService() {
		
		//학생 객체 배열 students에 샘플 학생 3명 추가
		students[0] = new Student("240001","최미영", 'F');
		students[1] = new Student("240002","홍길동", 'M');
		students[2] = new Student("240003","신짱구", 'M');
		
		// students[3~9] == null
		
		
		
		// 자바에서 제공하는 난수 생성 객체
		Random random = new Random();
		
		// 샘플 학생 점수 초기화
		for(int i=0 ; i<students.length ; i++) { // 10바퀴
			
			// i번째 인덱스에 참조하는 학생이 없으면 반복 종료
			if(students[i] == null) break;
			
			// random.nextInt(101) : 0 이상 101 미만 정수형 난수 생성
			
			students[i].setHtml( random.nextInt(101) );
			students[i].setCss( random.nextInt(101) );
			students[i].setJs( random.nextInt(101) );
			students[i].setJava( random.nextInt(101) );
			
		}
	}
	
	
	/** 전달받은 학생 객체(주소)를 students 객체배열에서 빈칸(null)에 대입
	 * 
	 * @param newStd: 전달 받은 학생
	 * 
	 * @return 대입성공시 true, 실패시(==꽉찼을때) false
	 */
	public boolean addStudent(Student newStd) {
		
		for(int i=0 ;  i<students.length ; i++) {
			if(students[i]==null) {
				students[i] = newStd;
				return true;
			}
		}
		return false;
	}
	
	
	/** 학생 객체 배열 참조 주소 반환
	 * @return students (주소)
	 */
	public Student[] getStudents() {
		return students;
	}
	
	
	/**학생 1명 정보 조회(index 검색)
	 * @param index
	 * @return 조회된 학생 또는 null
	 */
	public Student selectIndex(int index) {
		
		if(index < 0 || index >= students.length) {
			return null;
		}
		return students[index];
	}

	
	/** 이름이 일치하는 학생 조회
	 * @param name 입력받은 이름
	 * @return 일치하는 학생 정보 또는 null
	 */
	public Student selectName(String name) {

		for(Student s : students) {
			if(s==null) {
				break;
			}
			if(s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}
	
	
	
	
	
	/** 학생 점수 조회
	 * @param index
	 * @return 학생 점수가 기록된 문자열
	 */
	public String selectScore(int index) {
		
		int html = students[index].getHtml();
		int css = students[index].getCss();
		int js = students[index].getJs();
		int java = students[index].getJava();
		
	  int sum = html + css+ js + java; 
	  double avg = sum/4.0;
	  
	  String str = String.format("HTML(%d) CSS(%d) JS(%d) Java(%d) \n",
	  		html,css,js,java);
	  str +="\n합계 : "+sum;
	  str +="\n평균 : "+avg;
	  
	  return str;
	  
	 	}
	
	
	
	
	/** 평균 최고점/최저점 구하기
	 * @return 
	 */
	public String selectMaxMin() {
		
		Student maxStudent = null; //최고점학생
		Student minStudent = null; //최저점학생
		
		double maxAvg =0.0;
		double minAvg =0.0;
		
		for(Student s : students) {
			if(s == null)  break;  //학생이 없으면 반복 종료
			
			int sum = s.getHtml() + s.getCss() +s.getJs() + s.getJava();
			double avg = sum /4.0;
			
			if(maxAvg ==0.0) { //첫번째 바퀴
				maxStudent = s;
				minStudent = s;
				maxAvg = avg;
				minAvg = avg;	
				continue;
			}
			
			if(maxAvg <avg) { 
				maxAvg=avg;
				maxStudent = s;
			}
			
			if(minAvg > avg) {
				minAvg = avg;
				minStudent = s;
			}		
		}
		
	 return String.format("최고점 : %s (%.1f)\n" + "최저점 : %s (%.1f)\n",
			 maxStudent.getName(), maxAvg, minStudent.getName(), minAvg);
	}
	
	
	
	
	
}



