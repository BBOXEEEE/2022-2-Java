/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 4장 상속 실습
 * 자식 클래스 생성자에서 부모 클래스 생성자를 직접 호출하지 
 * 않으면 부모의 기본 생성자가 호출됨
 * 초기화 순서: 명백한 초기화와 초기화 블록 (선언, 정의된 순서) -> 생성자 몸체
 * 부모 먼저 그 다음 자식
 * this와 super는 초기화 순서에 변하를 주는 요소 (이것을 생성자 몸체로 해석하지 않음)
 * 생성자 호출 순서를 보여주는 예제
 */

class U{
	private int u;
	{
		System.out.println("U 초기화 블록 실행 중");
	}
	public U(int u) {
		System.out.println("U("+u+") 실행 중");
		this.u = u;
	}
	public int getU() {
		return u;
	}
}

class V{
	protected int v = 1;
	{
		System.out.println("V 초기화 블록 실행 중");
	}
	public V() {
		System.out.println("V() 실행 중");
	}
	public V(int v) {
		System.out.println("V("+v+") 실행 중");
		this.v = v;
	}
	public int getV() {
		return v;
	}
}

class X extends U{
	private int x;
	{
		System.out.println("X 초기화 블록 실행 중");
	}
	public X(int x) {
		super(x+3);	// error if this statement is removed
		System.out.println("X("+x+") 실행 중");
		this.x = x;
	}
	public int getX() {
		return x;
	}
}

class Y extends V{
	private int y = v;
	{
		System.out.println("Y 초기화 블록 실행 중");
	}
	// 자동으로 부모의 기본 생성자를 호출함
	public Y(int y) { 
		System.out.println("Y("+y+") 실행 중: "+this.y);
		this.y = y;
	}
	public int getY() {
		return y;
	}
}


public class ConstructorTest {
	// X는 생성자에서 부모 생성자를 직접 호출하지 않음
	public static void testX() {
		X a = new X(2);
		System.out.println("u = "+a.getU()+", x = "+a.getX());
	}
	// Y는 생성자에서 부모 생성자를 직접 호출하지 않음
	public static void testY() {
		Y b = new Y(3);
		System.out.println(b.getY());
	}
	public static void main(String[] args) {
		testX();
		// testY();
	}

}
