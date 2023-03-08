/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * BankAccount 클래스: 3장 static 멤버변수 연습
 * 생성자에서 계좌번호 설정 (static 멤버변수의 값을 생성자에서 증가함)
 */
public class BankAccount {
	private int balance = 0;
	private int accountNumber;
	private static int lastAssignedNumber = 1;
	
	public BankAccount(){
		accountNumber = lastAssignedNumber;
		++lastAssignedNumber;
	} // BankAccount()
	public BankAccount(int amount){
		this();
		deposit(amount);
	} // BankAccount(int)
	public int getAccountNumber() {
		return accountNumber;
	}
	public int getBalance(){
		return balance;
	} // getBalance()
	public void deposit(int amount){
		if(amount>0 && amount<=Integer.MAX_VALUE-balance) balance += amount;
	} // deposit(int)
	public void withdraw(int amount){
		if(amount>0 && balance>=amount) balance -= amount;
	} // withdraw(int)
}
