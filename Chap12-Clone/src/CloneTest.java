/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2022년도 2학기
 * @author 김상진 
 * 12장 상속 두 번째 이야기 
 * 간단한 clone 테스트 
 */

// Cloneable interface를 구현하고 있지 않으면 
// clone을 재정의하더라도 예외가 발생함 -> try-catch를 하여도 해결되는 문제는 아님

// 멤버 변수가 모두 원시 타입이므로 shallow copy만 하여도 문제가 없음
class A implements Cloneable{
	private int x;
	private int y;
	public A(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	@Override public String toString() {
		return String.format("(%d, %d)", x, y);
	}
	@Override public A clone() throws CloneNotSupportedException{
		return (A)super.clone();
	}
}

// 올바르게 deepcopy하도록 clone을 정의하고 있음
class B implements Cloneable{
	private int n;
	private A a;
	public B(int n, A a) {
		this.n = n;
		this.a = a;
	}
	public A getA() {
		return a;
		// return a.clone();
	}
	public void setX(int x) {
		a.setX(x);
	}
	@Override public String toString() {
		return String.format("(%d, %s)", n, a.toString());
	}
	
	// deep copy
	@Override public B clone() throws CloneNotSupportedException{
		B cloned = (B)super.clone();
		cloned.a = a.clone();
		return cloned;
	}
}

// 멤버 변수 A 때문에 deepcopy가 필요하지만 올바르게 clone을 정의하고 있지 않음 
class C implements Cloneable{
	private int n;
	private A a;
	public C(int n, A a) {
		this.n = n;
		this.a = a;
	}
	public A getA() {
		return a;
		// return a.clone();
	}
	public void setX(int x) {
		a.setX(x);
	}
	@Override public String toString() {
		return String.format("(%d, %s)", n, a.toString());
	}
	
	@Override public C clone() throws CloneNotSupportedException{
		C cloned = (C)super.clone();
		return cloned;
	}
}

public class CloneTest {
	public static void test_shallow_clone() throws CloneNotSupportedException {
		A a = new A(1, 2);
		C c1 = new C(3, a);
		C c2 = c1.clone();
		System.out.println(c1!=c2);
		a.setX(2);
		System.out.println(c1);
		System.out.println(c2);	
	}
	public static void test_deep_clone() throws CloneNotSupportedException {
		A a = new A(1,2);
		B b1 = new B(3, a);
		B b2 = b1.clone();
		System.out.println(b1.equals(b2));
		a.setX(2);
		System.out.println(b1);
		System.out.println(b2);	
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		test_shallow_clone();
		test_deep_clone();
	}
}
