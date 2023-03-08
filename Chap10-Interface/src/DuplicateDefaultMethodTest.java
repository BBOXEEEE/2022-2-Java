/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2022년도 2학기
 * @author 김상진 
 * 10장 인터페이스 두 번째 이야기
 * default 메소드 관련 예제
 * default 메소드 때문에 기존에 없던 다중 상속의 문제가 발생 가능함
 */

interface A{
	default void foo() {
		System.out.println("A: foo");
	}
}

interface B{
	default void foo() {
		System.out.println("B: foo");
	}
}

interface C{
	void foo();
}

interface D extends A{
	@Override
	default void foo() {
		System.out.println("D: foo");
	}
}

/*
// Syntax Error: Duplicate Default Method
class X1 implements A, B{	
}
*/

/* 
//Syntax Error: Default Method conflict
class X2 implements A, C{
	
}
*/

class Y implements A, B{	
	@Override
	public void foo() {
		//System.out.println("Y: foo");
		B.super.foo();
	}
}

class Z implements D{	
}

// Class Win Rule
class P{
	public void foo() {
		System.out.println("P: foo");
	}
}

// P에 foo가 정의되어 있으므로 이것이 A와 B에 있는 기본 메소드보다 우선됨 
class R extends P implements A, B{
}

public class DuplicateDefaultMethodTest {
	public static void main(String[] args) {
		Y y = new Y();
		y.foo();
		Z z = new Z();
		z.foo();
		R r = new R();
		r.foo();
	}
}
