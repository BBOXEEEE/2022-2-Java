import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class UtilTest {

	@Test
	void countNumberOfDigitsTest() {
		assertEquals(Util.countNumberOfDigits(12223, 2), 3);
		assertEquals(Util.countNumberOfDigits(22_222_222, 2), 8);
		assertEquals(Util.countNumberOfDigits(-22_222_222, 2), 8);
		assertEquals(Util.countNumberOfDigits(2, 2), 1);
		assertEquals(Util.countNumberOfDigits(-2, 2), 1);
		assertEquals(Util.countNumberOfDigits(10_000_001, 0), 6);
		assertEquals(Util.countNumberOfDigits(10_000_000, 0), 7);
		assertEquals(Util.countNumberOfDigits(Integer.MIN_VALUE, 8), 2);
		assertEquals(Util.countNumberOfDigits(Integer.MAX_VALUE, 7), 2);
		assertEquals(Util.countNumberOfDigits(0, 0), 1);
	}
	
	@Test
	void countNumberOfPrimes() {
		IntFunction<Long> count = (int x)->IntStream.rangeClosed(2,x).mapToObj(BigInteger::valueOf)
				.filter(n->n.isProbablePrime(10)).count();
		assertEquals(Util.countPrimes(10), count.apply(10));
		assertEquals(Util.countPrimes(20), count.apply(20));
		assertEquals(Util.countPrimes(100), count.apply(100));
		assertEquals(Util.countPrimes(1000), count.apply(1000));
	}
	
	@Test
	void reverseNumberTest() {
		assertEquals(Util.reverseNumber(12223), 32221);
		assertEquals(Util.reverseNumber(0), 0);
		assertEquals(Util.reverseNumber(-12223), -32221);
		assertEquals(Util.reverseNumber(-1222), -2221);
		assertEquals(Util.reverseNumber(1147483647), Integer.MAX_VALUE);
		assertEquals(Util.reverseNumber(-1147483647), Integer.MIN_VALUE);
	}
	
	@Test
	void isSelfDividingNumberTest() {
		assertFalse(Util.isSelfDividingNumber(10));
		assertFalse(Util.isSelfDividingNumber(101));
		assertTrue(Util.isSelfDividingNumber(12));
		assertTrue(Util.isSelfDividingNumber(6));
	}
	
	@Test
	void isPalindromeTest01() {
		assertTrue(Util.isPalindrome01(100_001));
		assertFalse(Util.isPalindrome01(Integer.MIN_VALUE));
		assertFalse(Util.isPalindrome01(Integer.MAX_VALUE));
		assertTrue(Util.isPalindrome01(-123_321));
		assertTrue(Util.isPalindrome01(2137447312));
	}
	
	@Test
	void isPalindromeTest02() {
		assertTrue(Util.isPalindrome02(100_001));
		assertFalse(Util.isPalindrome02(Integer.MIN_VALUE));
		assertFalse(Util.isPalindrome02(Integer.MAX_VALUE));
		assertTrue(Util.isPalindrome02(-123_321));
		assertTrue(Util.isPalindrome02(2137447312));
	}
}
