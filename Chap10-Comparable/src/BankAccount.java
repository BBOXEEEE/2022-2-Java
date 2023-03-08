/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * BankAccount 클래스: 10장 Comparable의 추가
 */
public class BankAccount implements Comparable<BankAccount>{
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
	
	// 실제 balance는 항상 양수이므로 balance-o.balance 과정에서
	// 오버플로우가 발생할 수 없음. Integer.compare 사용 불필요
	@Override
	public int compareTo(BankAccount o) {
		return balance-o.balance;
		//return Integer.compare(balance, o.balance);
	}
}
