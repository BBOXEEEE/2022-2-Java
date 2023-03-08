/**
 *  @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 *  @version 2022년도 2학기
 *  @author 김상진 
 *  TypeErasureTest.java
 *  범용 함수 또는 범용 클래스를 정의하면 자바는 문법 검사를 한 후에
 *  범용 함수를 일반 함수, 범용 클래스를 일반 클래스로 바꾼다.
 *  이 과정을 erasure라 한다.
 *  erasuer 과정
 *  1) 타입 매개변수가 unbound이면 Object로 바꾸고, 
 *  bound이면 첫 번째 제한 타입으로 바꿈
 *  2) 필요한 타입 변환을 추가한다.
 *  3) 특수한 상황에서 필요한 메소드(이를 bridge 메소드라 )를 추가한다.
 */

interface I1{
	void foo();
}

interface I2{
	void bar();
}

class XX implements I1, I2{
	@Override public void foo() { System.out.println("XX::foo"); }
	@Override public void bar() { System.out.println("XX::bar"); }
}

public class TypeErasureTest {
	public static <T extends I1 & I2> T ham(T x) {
		x.foo();
		x.bar();
		return x;
	}
	public static I1 ham01(I1 x) {
		x.foo();
		((I2)x).bar();
		return x;
	} // erasure 후
	// 보통 과거 메소드(template 도입 이전)와 호환을 유지하기 위해 Object로 전환
	public static <T extends Object & I1 & I2> T hen(T x) {
		x.foo();
		x.bar();
		return x;
	}
	public static Object hen01(Object x) {
		((I1)x).foo();
		((I2)x).bar();
		return x;
	} // erasure 후
	public static void main(String[] args) {
		XX x = new XX();
		x = ham(x);
		x = (XX)ham01(x);
		x = hen(x);
		x = (XX)hen01(x);
	}
}
