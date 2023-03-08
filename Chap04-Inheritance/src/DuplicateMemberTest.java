/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 4장 상속 실습
 * 부모와 동일 이름의 멤버 변수를 정의하는 것은 가능하지만 바람직하지 않음
 */

class A{
	private int n;
	protected int x;
	public void setA(int n) {
		this.n = n;
	}
	public int getA() {
		return n;
	}
}

class B extends A{
	private int n;
	private int x;
	public void setB(int n) {
		this.n = n;
	}
	public int getB() {
		return n;
	}
	public void foo() {
		super.x = 3; // 부모의 x가 private이면 super를 이용하여도 접근할 수 없음
		x = 2;
	}
	public int getX() {
		return x;
	}
}

public class DuplicateMemberTest {
	public static void main(String[] args) {
		B b = new B();
		b.setA(10);
		b.setB(5);
		System.out.println(b.getA()+", "+b.getB());
		b.foo();
		System.out.println(b.getX());
	}
}
