/**
 * BankAccount.java
 * @version 2022년 9월 
 * @author 2019136056 박세현 
 * BankAccount 클래스
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
		if(amount <= 0) 
			throw new IllegalArgumentException("음수, 0 입금 시도");
		else if(amount > Integer.MAX_VALUE - balance)
			throw new ArithmeticException("입금: 오버플로우");
		balance += amount;
	}
	public void withdraw(int amount) throws InsufficientFundException {
		if(amount <= 0)
			throw new IllegalArgumentException("음수, 0 출금 시도");
		else if(amount > balance)
			throw new InsufficientFundException();
		balance -= amount;
	}
}
