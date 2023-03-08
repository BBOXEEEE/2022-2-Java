/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2022년도 2학기
 * @author 김상진 
 * 10장 인터페이스 두 번째 이야기
 * interface에 private 메소드 활용 예제
 */

interface ManyDefaults{
	default void f1() {
		f();
		System.out.println("f1");
	}
	default void f2() {
		f();
		System.out.println("f2");
	}
	default void f3() {
		f();
		System.out.println("f3");
	}
	default void f4() {
		f();
		System.out.println("f4");
	}
	default void f() {
		System.out.println("Shared Output");
	}
}

interface ManyDefaultsWithPrivate{
	default void f1() {
		f();
		System.out.println("f1");
	}
	default void f2() {
		f();
		System.out.println("f2");
	}
	default void f3() {
		f();
		System.out.println("f3");
	}
	default void f4() {
		f();
		System.out.println("f4");
	}
	private void f() {
		System.out.println("Shared Output");
	}
}


public class PrivateInterfaceMethod {
	public static void main(String[] args) {
	}
}
