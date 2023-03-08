/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * BankAccount 클래스: 5장 예외처리 연습
 * 은행 계좌>> 상태: 잔액, 행위: 입금, 인출, 잔액조회
 * 입금, 인출의 예외적 상황 처리
 */
public class BankAccount {
	private int balance = 0;
	public BankAccount() {}
	public BankAccount(int amount) {
		deposit(amount);
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amount) {
		if(amount<=0 || balance>Integer.MAX_VALUE-amount) 
			throw new IllegalArgumentException("음수/0 입금 또는 오버플로우");
		else balance += amount;
	}
	
	public void withdraw(int amount) throws InsufficientFundException {
		if(amount<=0) 
			throw new IllegalArgumentException("음수/0 인출");
		else if(amount>balance) 
			throw new InsufficientFundException("잔액 부족: "+(amount-balance)+" 부족액");
		else balance -= amount;
	}
}
