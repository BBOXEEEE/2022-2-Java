import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * BankAccountJUnitTest 클래스: 5장 예외처리 연습
 * JUnit5를 이용한 테스트 프로그램
 */
class BankAccountJUnitTest {
	private BankAccount aliceAccount = null;
	private BankAccount bobAccount = null;
	
	@BeforeEach
	public void prepareAccounts() {
		aliceAccount = new BankAccount();
		bobAccount = new BankAccount(10_000);
	}
	
	@Test
	void constructorTest() {
		assertEquals(aliceAccount.getBalance(), 0);
		assertEquals(bobAccount.getBalance(), 10_000);
	}

	@Test
	void depositTest() {
		aliceAccount.deposit(5_000);
		bobAccount.deposit(15_000);
		assertEquals(aliceAccount.getBalance(), 5_000);
		assertEquals(bobAccount.getBalance(), 25_000);
		assertThrows(IllegalArgumentException.class, 
		  ()->bobAccount.deposit(-1000));
	}
	
	@ParameterizedTest
	@ValueSource(ints= {10_000,20_000,30_000,40_000})
	void withdrawTest(int amount) throws InsufficientFundException {
		aliceAccount.deposit(5_000);
		bobAccount.deposit(amount);
		aliceAccount.withdraw(2_000);
		bobAccount.withdraw(10_000);
		assertEquals(aliceAccount.getBalance(), 3_000);
		assertEquals(bobAccount.getBalance(), amount);
		assertThrows(InsufficientFundException.class, ()->aliceAccount.withdraw(10_000));
	}
	
}
