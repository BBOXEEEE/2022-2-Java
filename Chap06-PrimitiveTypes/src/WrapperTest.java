/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Wrapper 타입 예제
 */
public class WrapperTest {
	public static void foo(Byte b) {
		System.out.println("foo: Byte");
	}
	
	public static void foo(Number n) {
		System.out.println("foo: Number");
	}
	
	// Overloading
	// byte: byte, Byte, Number 순
	public static void foo() {
		foo((byte)1);
		foo(2);
		foo((byte)1+(byte)2);
	}
	
	public static void booleanTest() {
		Boolean b1 = Boolean.valueOf("1");
		Boolean b2 = Boolean.valueOf("0");
		System.out.println(b1||b2);
		b1 = Boolean.valueOf("True");
		b2 = Boolean.valueOf("true");
		System.out.println(b1+", "+b2);
	}
	
	public static void stringToInt() {
		int n = 10;
		String s = "21";
				
		int x1 = Integer.valueOf(s).intValue();
		int x2 = Integer.valueOf(s); // use autoboxing
		int x3 = Integer.parseInt(s);
		System.out.printf("%d, %d, %d%n", x1, x2, x3);
		
		String str1 = ""+n;
		String str2 = Integer.toString(n);
		String str3 = Integer.valueOf(n).toString();
		System.out.printf("%s, %s, %s%n", str1, str2, str3);
	}
	
	public static void main(String[] args) {
		//booleanTest();
		//foo();
		//stringToInt();
	}
}
