/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 문자 타입 예제
 */
public class CharTest {
	public static void foo(int n) {
		System.out.println("foo: int");
	}
	
	public static void foo(char c) {
		System.out.println("foo: char");
	}
	
	public static void foo() {
		foo('a'+'z');  // char + char ==> int + int ==> int
	}
	
	public static char nextChar(char c) {
		return (char)(c+1);
	}
	
	public static void nextCharTest() {
		System.out.println(nextChar('A'));
		System.out.println(nextChar('c'));
		System.out.println(nextChar('3'));
	}
	
	public static void varTest() {
		var x = 'a'+2;
		char y = 'b'+3;
		System.out.println(x);
		System.out.println(y);
		y = 100+5;
		System.out.println(y);
		//int n = 3;
		//char z = 'c'+n;
	}
	public static void integralTypeTest() {
		char n = (char)-10;	// unsigned로 타입 변환 
		char c = 97;
		System.out.println((int)n);
		System.out.println(c);
	}
	
	public static void emoij() {
		System.out.println("\ud83d\ude00");
		int cp = 0x0001F92E;
		char c[] = new char[2];
		c[0] = Character.highSurrogate(cp);
		c[1] = Character.lowSurrogate(cp);
		System.out.println(c);
		String s = "🤣"; 
		System.out.println(s);
		System.out.println(s.length());
		System.out.println(s.codePointAt(0));
		System.out.printf("%x%n",s.codePointAt(0));
	}
	
	public static void main(String[] args) {
		foo();
		//nextCharTest();
		//varTest();
		//integralTypeTest();
		//emoij();
	}

}
