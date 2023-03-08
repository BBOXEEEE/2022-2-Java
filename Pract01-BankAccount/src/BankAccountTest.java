/**
 * BankAccountTest.java
 * @version 2022년 9월 
 * @author 2019136056 박세현 
 * BankAccount & 자식 클래스 Test 프로그램 
 */

public class BankAccountTest {
	public static void savingsAccount_test() throws InsufficientFundException {
		BankAccount aliceAccount = new SavingsAccount(10_000, 5.0);
		aliceAccount.deposit(5_000);
		aliceAccount.withdraw(3_000);
		if(aliceAccount instanceof SavingsAccount account)
			account.addInterest();
	}
	
	public static void main(String[] args) throws InsufficientFundException {
		BankAccount aliceAccount = new BankAccount();
		BankAccount bobAccount = new BankAccount(10_000);
		System.out.printf("%, d원\n", aliceAccount.getBalance());
		System.out.printf("%, d원\n", bobAccount.getBalance());
		try {
			aliceAccount.deposit(5_000);
			bobAccount.withdraw(7_000);
			System.out.printf("%, d원\n", aliceAccount.getBalance());
			System.out.printf("%, d원\n", bobAccount.getBalance());
		}
		catch(InsufficientFundException e) {
			e.printStackTrace();
		}
	}

}
