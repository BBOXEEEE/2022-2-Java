/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * BankAccount 클래스: 3장 클래스 정의 연습
 * 은행 계좌>> 상태: 잔액, 행위: 입금, 인출, 잔액조회
 * 입금, 인출의 예외적 상황 처리: 예외적 상황이 발생하면 아무것도 하지 않음
 */
public class BankAccount {
	private int balance = 0;
	public BankAccount(){
	} // BankAccount()
	public BankAccount(int amount){
		deposit(amount);
	} // BankAccount(int)
	public int getBalance(){
		return balance;
	} // getBalance()
	public void deposit(int amount){
		if(amount>0 && balance<=Integer.MAX_VALUE-amount) balance += amount;
	} // deposit(int)
	public void withdraw(int amount){
		if(amount>0 && balance>=amount) balance -= amount;
	} // withdraw(int)
}
