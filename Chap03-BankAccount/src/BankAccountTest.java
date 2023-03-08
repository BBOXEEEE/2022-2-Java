import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {
	private BankAccount aliceAccount = null;
	private BankAccount bobAccount = null;
	
	@BeforeEach
	public void constructBankAccounts() {
		aliceAccount = new BankAccount();
		bobAccount = new BankAccount(10000);
	}
	
	@Test
	public void constructorTest() {
		// BankAccount aliceAccount = new BankAccount();
		// BankAccount bobAccount = new BankAccount(10000);		
		BankAccount charlieAccount = new BankAccount(-5_000);
		assertEquals(aliceAccount.getBalance(), 0);
		assertEquals(bobAccount.getBalance(), 10_000);
		assertEquals(charlieAccount.getBalance(), 0);	
	}
	
	@Test
	public void depositTest() {
		// BankAccount aliceAccount = new BankAccount();
		// BankAccount bobAccount = new BankAccount(10000);		
		aliceAccount.deposit(5000);
		bobAccount.deposit(5000);
		assertEquals(aliceAccount.getBalance(), 5_000);
		assertEquals(bobAccount.getBalance(), 15_000);
		aliceAccount.deposit(-5000);
		assertEquals(aliceAccount.getBalance(), 5_000);
	}

	@Test
	public void withdrawTest() {
		// BankAccount aliceAccount = new BankAccount();
		// BankAccount bobAccount = new BankAccount(10000);
		aliceAccount.withdraw(5_000);
		bobAccount.withdraw(5_000);
		assertEquals(aliceAccount.getBalance(), 0);
		assertEquals(bobAccount.getBalance(), 5_000);
		bobAccount.withdraw(-10_000);
		assertEquals(bobAccount.getBalance(), 5_000);
		bobAccount.withdraw(5_000);
		assertEquals(bobAccount.getBalance(), 0);
	}
}
