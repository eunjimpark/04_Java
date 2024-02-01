package edu.kh.oop.basic;

public class Account {

	
	private String name;
	String accountNumber;
	private long balance;
	private String password;
	
	//name 변수에 값을 셋팅하는 간접 접근 기능
	public void setName(String inputName) {

		name = inputName;
	}
	public String getName() { //void 는 안되
		return name;
	}

	//어카운트 넘버 값 세팅하는 간접접근기능
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	//어카운트 넘버 값을 반환하는 간접 접근기능
	public String getAccountNumber() {
		return accountNumber;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
	
	//밸런스값 반환하는 간접접근 기능

	public long getBalance() {
		return balance;
	}
	
	
	/**
	 * 전달 받은 금액을 balance에 누적한 후
	 * 현재 잔액을 콘솔에 출력
	 */
	public void deposit(long amount) {
		balance += amount;
		System.out.println(name + "의 현재 잔액 : " + balance);
	}
	
	
	
	public void withdraw(String pw, long amount) {
		
		if(!password.equals(pw)) { //다를경우
			System.out.println("비밀 번호 불일치");
			return;
		}
		//잔액부족
		if(amount>balance) {
			System.out.println("잔액부족");
			return;
		}
		balance -= amount;
		System.out.printf("%s계좌에서 %d원 출금\n",accountNumber,amount);
		System.out.println(name + "의 현재 잔액 : " + balance);
		
		
	}
	
	
	
	

}
