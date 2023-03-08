/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 함수 내에 클래스 정의
 * 접근 제어
 * 내부 클래스 멤버들의 접근제어는 외부 클래스에게는 의미가 없음
 * 외부 클래스 멤버들의 접근제어는 내부 클래스에게는 의미가 없음
 * 
 */
class A{
	private int x1 = 0;
	protected int x2 = 0;
	public int x3 = 0;
	int x4 = 0;
	
	// A 외부에서 사용할 때 n1, n2, n3, n4의 접근 제어 구분이 의미가 있음 
	public static class B{
		private int n1 = 1;
		protected int n2 = 1;
		public int n3 = 1;
		int n4 = 1;
		public void bar() {
			A a = new A();
			a.x1 = n1;
			a.x2 = n2;
			a.x3 = n3;
			a.x4 = n4;
		}
	}
	// private이므로 밖에서는 C 클래스를 사용할 수 없음
	// 하지만 그것의 객체는 상위 타입이나 interface를 통해 사용할 수 있음
	// C 클래스는 특별한 클래스를 상속하거나 interface를 구현하고 있지 않으므로 
	// 밖에서 그것의 객체를 사용하기 위한 내부 클래스는 아님 
	private class C{
		private int n1 = 1;
		protected int n2 = 1;
		public int n3 = 1;
		int n4 = 1;
		public void bar() {
			x1 = n1;
			x2 = n2;
			x3 = n3;
			x4 = n4;
		}
	}
	public class D{
		private int n1 = 1;
		protected int n2 = 1;
		public int n3 = 1;
		int n4 = 1;
		public void bar() {
			x1 = n1;
			x2 = n2;
			x3 = n3;
			x4 = n4;
		}
	}
	
	public void foo() {
		// static 내부 클래스 객체 멤버 변수에 대한 접근
		// 접근 제어가 의미 없음
		B b = new B(); 
		b.n1 = x1;
		b.n2 = x2;
		b.n3 = x3;
		b.n4 = x4;
		// 일반 내부 클래스 객체 멤버 변수에 대한 접근
		// 접근 제어가 의미 없음
		C c = new C(); 
		c.n1 = x1;
		c.n2 = x2;
		c.n3 = x3;
		c.n4 = x4;
		c.bar();
	}
}

class E{
	public void foo() {
		// 다른 클래스의 내부 클래스에 대한 접근
		// 접근 권한이 의미가 있음
		// 이와 같은 형태로 사용하는 것은 적절하지 않음 -> 독립 클래스
		A.B b = new A.B();
		//b.n1 = 0;
		b.n2 = 0;
		b.n3 = 0;
		b.n4 = 0;
		/*
		// D는 A 내에서만 생성 가능 
		// A의 멤버 변수, 지역 변수
		A.D d = new A.D(); 
		d.n1 = 0;
		d.n2 = 0;
		d.n3 = 0;
		d.n4 = 0;
		*/
	}
}

public class ClassInnerClass {
	public static void main(String[] args) {
	}
}
