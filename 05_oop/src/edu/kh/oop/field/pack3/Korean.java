package edu.kh.oop.field.pack3;

public class Korean {
	
	//스테틱이 붙은 필드는 프로그램실행시 스테틱 메모리영역에 할당
	public static int nationalCode = 82;
	
	private String name;
	private String id;
	
	public void setName(String name) {
		this.name = name;
		//매개변수로 전달받은 네임을 현재 객체의 네임필드에 대입
		
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	//void 는 반환하는거없다
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	
	static {
		nationalCode = 10;
	}

	
	
	
}

	
	
	

