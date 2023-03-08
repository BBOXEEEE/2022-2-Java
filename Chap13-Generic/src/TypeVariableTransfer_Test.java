/**
 *  @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 *  @version 2022년도 2학기
 *  @author 김상진 
 *  13장 범용 프로그래밍 예제
 *  타입 전달
 */
class Com<T> {
	private static class S<T>{
		void bar() {
			System.out.println(this.getClass().toGenericString());
		}
	}
	public void foo() {
		S<T> s = new S<>();
		s.bar();
	}
}

// 타입 매개변수 중 일부만 전달
class Edu<U,V> {
	private  static class B<V>{
		void bar() {
			System.out.println(this.getClass().toGenericString());
		}
	} 
	public void foo() {
		B<V> b = new B<>();
		b.bar();
	}
}

// 타입 매개변수를 전달하고 있지 않음 (서로 독립적)
class Net<U>{
	private  static class B<V>{
		void bar() {
			System.out.println(this.getClass().toGenericString());
		}
	}
	public void foo() {
		B<String> b = new B<>();
		b.bar();
	}
}

// static 내부 클래스가 아닐 경우에 외부 클래스의
// 타입 매개변수를 그대로 사용할 수 있음
class Org<T> {
	private class B{
		void bar(T t) {
			System.out.println(t);
		}
	}
	private B b = new B();
	public void foo(T t) {
		b.bar(t);
	}
}

class Gov {
	private class B<T>{
		void bar(T t) {
			System.out.println(t);
		}
	}
	public void foo() {
		B<String> b = new B<>();
		b.bar("hello");
	}
	public void bar() {
		B<Double> b = new B<>();
		b.bar(3.14);
	}
}

public class TypeVariableTransfer_Test {
	public static void innerClass_test() {
		Org<String> c = new Org<>();
		c.foo("hello");
		Gov d = new Gov();
		d.foo();
		d.bar();
	}
	public static void staticInnerClass_test() {
		Com<String> a = new Com<>();
		a.foo();
		Edu<String, Integer> x = new Edu<>();
		x.foo();
		Net<Double> y = new Net<>();
		y.foo();
	}
	public static void main(String[] args) {
		staticInnerClass_test();
	}

}
