package edu.kh.oop.basic;

public class AccountRun {
	
	public static void main(String[] args) {
		
		
		//Account 객체 생성
		Account a1 = new Account();

		
		//a1.accountNumber = "1";
		//a1.name = "홍길동";
		//a1.balance;           직접접근안됨
		
		
		//간접 접근방법
		a1.setName("신형만");
		
		//간저 접근 기능을 이용해서 객체의 속성을 얻어와 출력
	
		
		String name1 = a1.getName();
		System.out.println(name1);
		
		
		a1.setAccountNumber("1234-56-7890");
		a1.setPassword("7890");
		
		Account a2 = new Account();
		a2.setName("신짱아");
		a2.setAccountNumber("111-222-333");
		a2.setPassword("7777");
		
		// 각 계좌에 입금
		a1.deposit(1000000L);
		a1.deposit(2345L);
		
		a2.deposit(50000L);
		a2.deposit(30000L);
		
		//각 계좌에서 출금 
		a1.withdraw("1324",2000000); //비번틀림
		a1.withdraw("7890",2000000); //잔액부족
		a1.withdraw("7890",50000);  //출금성공
		
	}

}
