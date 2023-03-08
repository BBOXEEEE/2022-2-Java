/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 함수 내에 클래스 정의
 * 특정 함수에서만 필요한 간단한 클래스 정의
 * 클래스의 접근 제어는 무의미하며, 지정할 수 없음
 * 이와 같은 클래스는 final 지역변수나 실제적으로 final인 지역변수
 * 사용할 수 있음
 * 익명 클래스는 부모 클래스나 구현해야 하는 interface 이름을 
 * 생성자 이름으로 사용하여 정의함
 * 메소드 내부 클래스 객체는 밖에서 그것이 구현하는 interface나 
 * 부모 클래스 타입을 통해 사용할 수 있음
 */
abstract class Pet{
	public abstract void cry();
}

public class MethodInnerClass {
	// A와 같은 클래스를 정의하여 사용할 이유는 없음 (문법 소개 용도)
	public static void foo(){
		final int x = 3;
		int y = 2;
		// y = 5;
		class A{
			public int f(){
				// y = 4;
				return x+y+5;
			}
		}
		// y = 5;
		A a = new A();
		System.out.println(a.f());
	}
	public static void ham(Pet p) {
		p.cry();
	}
	public static void bar() {
		ham(new Pet() {
			@Override public void cry() {
				System.out.println("멍멍");
			}
		});
		// 다음과 같이 정의할 이유는 없음
		(new Object() {
			public void baz() {
				System.out.println("zzzz");
			}
		}).baz();
	}
	public static void main(String[] args) {
		//foo();
		bar();
	}
}
