import java.util.Scanner;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * ScannerTest 클래스
 */

// 동작하지 않음
// 한 프로그램에서 System.in을 close하면 다시 open할 수 없음
// foo, bar에서 close를 하지 않으면 동작하지만 warning 발생
/*
public class ScannerTest {
	public static void foo() {
		Scanner in = new Scanner(System.in);
		System.out.print("정수 입력: ");
		int n1 = in.nextInt();
		System.out.print("정수 입력: ");
		int n2 = in.nextInt();
		System.out.printf("%d + %d = %d\n", n1, n2, n1+n2);
		in.close();
	}
	public static void bar() {
		Scanner in = new Scanner(System.in);
		System.out.print("정수 입력: ");
		int n1 = in.nextInt();
		System.out.print("정수 입력: ");
		int n2 = in.nextInt();
		System.out.printf("%d * %d = %d\n", n1, n2, n1*n2);
		in.close();
	}
	public static void main(String[] args) {
		foo();
		bar();
	}
}
*/

// 인자로 전달하는 방법
/*
public class ScannerTest {
	public static void foo(Scanner in) {
		System.out.print("정수 입력: ");
		int n1 = in.nextInt();
		System.out.print("정수 입력: ");
		int n2 = in.nextInt();
		System.out.printf("%d + %d = %d\n", n1, n2, n1+n2);
	}
	public static void bar(Scanner in) {
		System.out.print("정수 입력: ");
		int n1 = in.nextInt();
		System.out.print("정수 입력: ");
		int n2 = in.nextInt();
		System.out.printf("%d * %d = %d\n", n1, n2, n1*n2);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		foo(in);
		bar(in);
		in.close();
	}
}
*/

// static 변수 활용
// static 변수는 한 클래스의 객체를 여러 개 생성하여도 하나만 생성됨
// 객체들이 공유하는 변수
public class ScannerTest {
	private static Scanner in = new Scanner(System.in);
	public static void foo() {		
		System.out.print("정수 입력: ");
		int n1 = in.nextInt();
		System.out.print("정수 입력: ");
		int n2 = in.nextInt();
		System.out.printf("%d + %d = %d\n", n1, n2, n1+n2);
	}
	public static void bar() {
		System.out.print("정수 입력: ");
		int n1 = in.nextInt();
		System.out.print("정수 입력: ");
		int n2 = in.nextInt();
		System.out.printf("%d * %d = %d\n", n1, n2, n1*n2);
	}
	public static void main(String[] args) {
		foo();
		bar();
		in.close();
	}
}