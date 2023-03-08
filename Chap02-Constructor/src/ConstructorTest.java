/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * DogTest 클래스: 2장 생성자 연습
 * A: 기본 생성자 없음, C: 기본 생성자 없음
 */

class A{
	private int mX;
	public A(int x) {
		mX = x;
	}
	int get() {
		return mX;
	}
}

// B는 어떤 생성자도 정의하지 않고 있으므로
// 시스템에서 기본 생성자를 제공해 줌
class B{
	private int mX;
	int get() {
		return mX;
	}
}

class C{
	private int mX;
	public C(int x){
		mX = x;
	}
	int getC() {
		return mX;
	}
}

// 상속 관계에서 자식 생성자는 무조건 부모 생성자를 호출해야 함
// 자세한 것은 4장에서 학습함
// 직접 호출하는 문장이 없으면 부모의 기본 생성자를 호출함
// C는 기본 생성자가 없기 때문에 super를 이용하여 부모 생성자를 호출하지 않으면 문법 오류
class D extends C{
	private int mY;
	public D() {
		super(0); // 이것이 없으면 오류
	}
	public D(int y) {
		super(0); // 이것이 없으면 오류 
		mY = y;
	}
	int getD() {
		return mY;
	}
}

public class ConstructorTest {

	public static void main(String[] args) {
		// error: A는 정수 하나를 받는 생성자가 있으므로 시스템에서 기본 생성자를 제공하지 않음 
		// A a = new A();
		B b = new B();
		System.out.println(b.get());
	}

}
