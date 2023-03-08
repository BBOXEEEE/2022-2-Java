/**
 * SavingsAccount.java
 * @version 2022년 9월 
 * @author 2019136056 박세현 
 * BankAccount 클래스를 상속받아 이율을 계산하여 잔액에 추가하는 클래스 
 */

public class SavingsAccount extends BankAccount {
	private double interestRate;
	
	public SavingsAccount(double interestRate) {
		// super(); 사용하지 않아도 부모의 기본생성자 호출 가능
		this.interestRate = interestRate;
	}
	public SavingsAccount(int amount, double interesRate) {
		super(amount);
		this.interestRate = interesRate;
	}
	
	void addInterest() {
		int interest = (int)(getBalance() * interestRate / 100);
		deposit(interest);
	}
}
