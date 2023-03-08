/* 
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * @file DataTest.java
 * record는 불변 클래스이어야 함
 * 불변 객체가 아닌 객체를 멤버 변수로 유지하면 불변 클래스가 되지 않음
 * 생성자에서는 받은 인자를 복제해서 멤버 변수에 할당해야 하고,
 * getter를 재정의하여 복제해서 반환해 주어야 함
 * 이것은 효율적이지 못하기 때문에 불변 객체와 원시 타입만 유지하는 record를
 * 정의해 사용하는 것이 바람직함
 */

class A implements Cloneable{
	private int v;
	public A(int v) {
		this.v = v;
	}
	public int get() {
		return v;
	}
	public void set(int v) {
		this.v = v;
	}
	@Override public String toString() {
		return ""+v;
	}
	@Override public A clone() {
		A cloned = null;
		try {
			cloned = (A)super.clone();
		}
		catch(CloneNotSupportedException e) {}
		return cloned;
	}
}

class B{
	private int v;
	public B(int v) {
		this.v = v;
	}
	public int get() {
		return v;
	}
	public void set(int v) {
		this.v = v;
	}
	@Override public String toString() {
		return ""+v;
	}
}

// A, B 모두 불변 클래스가 아님
// 하지만 a 객체는 이 문제를 해결하기 위한 조치를 하고 있음
record Data(int n, A a, B b, String name) {
	Data{
		a = a.clone();
	}
	@Override public A a() {
		return a.clone();
	}
}

public class DataTest{
	public static void main(String[] args) {
		A a = new A(2);
		B b = new B(3);
		Data d = new Data(1, a, b, "apple");
		a.set(3);
		b.set(4);
		System.out.println(d);
		d.a().set(5);
		d.b().set(6);
		System.out.println(d);
	}
}
