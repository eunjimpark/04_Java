package edu.kh.oop.constructor;


//오버로딩 (과적)
//한클래스 내에 동일한 이름의 메서드를 여러개 작성하는 기법
//-같은이름의 메서드가 수행하는 기능은 기본적으로 같으나 전달받은 매개변수에
 //따라서 조금씩 동작이 달라야 하는 경우 상황별로 정의
//-오버로딩 조건
//1) 메서드이름은 똑같아야한다
//2)매개변수는 개수,타입,순서가 하나라도 달라야한다

public class Member {

	//필드 ==멤버변수
	//-클래스 변수 : 스태틱이붙은변수
	//인스턴스변수 ㅣ 스태틱이없는변수
	
	
	private String memberId;   // 아이디
	private String memberPw;   // 비밀번호
	private String memberName; // 이름
	private int    memberAge;  //나이
	
	//생성자: 객체생성시 필드초기화+특정기능수행하는일종의메서드
	//작성규칙
	//1)반환형없음
	//2)생성자 이름은 클래스명과 동일
	
	//기본생성자
	//-매개변수가없는형태
	//-생성자가 하나도 작성되지 않은 경우 컴파일러가 자동으로 추가
	public Member() {
		System.out.println("[기본] 생성자로 Member 객체 생성됨");
		
		//생성시 객체 초기화
		memberId="ID를 입력해 주세요";
		memberPw="PW를 입력해 주세요";
		memberName="이름을 입력해 주세요";
	}
	
	
	//매개변수 생성자
	//객체 생성시 매개변수로 전달된값을 생성된 객체 필드에 초기화는 용도
	public Member(String memberId, String memberPw, String memberName, int memberAge) {
		
		System.out.println("[매개변수] 생성자로 객체 생성됨");
		this.memberId=memberId;
		this.memberPw=memberPw;
		this.memberName=memberName;
		this.memberAge=memberAge;
		
	}
	
	
	
	// 오버로딩을 이용해서 생성자 만들기
	
	//매개 변수 개수가 다름
	public Member(String memberId) { 
		this.memberId = memberId;
	} 
	
	// 매개 변수 개수가 다름
	public Member(String memberId, String memberPw) {
		this.memberId = memberId;
		this.memberPw = memberPw;
	}
	
	
	// 매개 변수 타입이 다름
	public Member(int memberAge) {
		this.memberAge = memberAge;
	}
	
	// 매개 변수 타입이 다름
	public Member(String memberId, int memberAge) {
		this.memberId = memberId;
		this.memberAge = memberAge;
	}
	
	// 매개 변수 순서가 다름
	public Member(int memberAge, String memberId) {
		this.memberAge = memberAge;
		this.memberId  = memberId;
	}
	
	
	// Duplicate method Member(int, String) in type Member
	// -> Member(int, String) 생성자 중복
	// --> 오버로딩은 변수명이 아닌 자료형이 개수,순서,타입 중
	//		 하나라도 달라야 성립!
	//public Member(int memberAge, String memberPw) {}
	
	
	
	/* this() 생성자 */
	
	public Member(int memberAge, String memberId, String memberPw) {
		this.memberAge = memberAge;
		this.memberId  = memberId;
		this.memberPw  = memberPw;
	}
	
	
	
	
	
	
	//기능(메서드)
	
	//setter : 전달받은 매개변수를 현재 객체의 필드에 대입
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	
	
	//getter : 현재객체의 필드를 외부에서 얻어갈수 있게 반환
	public String getMemberId() {
		return memberId;
	}
	public String getMemberPW() {
		return memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public int getMemberAge() {
		return memberAge;
	}
	
	//현재 객체의 필드값을 한번에 출력
	public void inform() {
		System.out.println("-----------------------");
		System.out.println("memberId:" + memberId);
		System.out.println("memberPw:" + memberPw);
		System.out.println("memberName:" + memberName);
		System.out.println("memberAge:" + memberAge);
		System.out.println("-----------------------");
	}
		
		

	
	
	
	
	
	
	
	
	
	
	
}
