/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * BankAccountTest 클래스: 5장 예외처리 연습
 */
public class BankAccountTest {

	public static void main(String[] args)  {
		try {
			BankAccount aliceAccount = new BankAccount();
			BankAccount bobAccount = new BankAccount(10_000);
			System.out.printf("%,d원%n", aliceAccount.getBalance());
			System.out.printf("%,d원%n", bobAccount.getBalance());
			aliceAccount.deposit(5_000);
			bobAccount.withdraw(15_000);
			System.out.printf("%,d원%n", aliceAccount.getBalance());
			System.out.printf("%,d원%n", bobAccount.getBalance());
		}
		catch(InsufficientFundException e) {
			System.out.println(e.getMessage());
		}
	}

}
