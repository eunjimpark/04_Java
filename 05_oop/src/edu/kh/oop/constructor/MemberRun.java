package edu.kh.oop.constructor;

public class MemberRun {
	
	public static void main(String[] args) {
	
		//회원객체 생성
		Member member1 = new Member();
		
		member1.inform();
		
		
		//memeber1이 참조하는 멤버객체의 필드값 셋팅
		member1.setMemberId("member01");
		member1.setMemberPw("pass01");
		member1.setMemberName("김회원");
		member1.setMemberAge(27);
		
		//멤버객체 하나더만들자
		Member member2 = new Member();
		
		member2.setMemberId("member02");
		member2.setMemberPw("비번이야");
		member2.setMemberName("김철수");
		member2.setMemberAge(22);
		
		System.out.println("[member1]");
		member1.inform();
		System.out.println("[member2]");
		member2.inform();
		
		
		
		
		//--------------------------------
		//매개변수 생성자를 이용해서 맴버객체 생성
		Member member3 = new Member("오늘", "우동", "먹으러갈까", 33);
		member3.inform();
	
		
		//프로그래밍언어에서 변수명 함수명 메서드명 중복허용X
		
	}

}
