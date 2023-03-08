/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * InheritanceTest 클래스: 5장 예외처리 연습
 * Checked 예외와 상속
 * Checked 예외는 문법적으로 검사하지만 unchecked 예외는 문법적으로 검사 못함
 */

class CheckedA extends Exception {
	private static final long serialVersionUID = -8115692044547324804L;
	public CheckedA() {
		super("Checked A 예외 발생");
	}
	public CheckedA(String msg) {
		super(msg);
	}
}

class CheckedB extends Exception {
	private static final long serialVersionUID = -5877684101102261658L;
	public CheckedB() {
		super("Checked B 예외 발생");
	}
	public CheckedB(String msg) {
		super(msg);
	}
}

class CheckedC extends Exception {
	private static final long serialVersionUID = 199193888399094258L;
	public CheckedC() {
		super("Checked C 예외 발생");
	}
	public CheckedC(String msg) {
		super(msg);
	}
}


class A{
	public void foo(int n) throws CheckedA, CheckedB {
		if(n>0) throw new CheckedA();
		else throw new CheckedB();
	}
}


class B extends A{
	/*
	// 재정의하면서 더 많은 예외 발생
	@Override
	public void foo(int n) throws CheckedA, CheckedB, CheckedC{
		super.foo();
		throw new CheckedC();
	}
	*/
	/*
	// 재정의하면서 호환되지 않는 예외 발생
	@Override
	public void foo(int n) throws CheckedC{
		throw new CheckedC();
	}
	*/
	// 재정의하면서 더 적게 발생하는 것은 OK
	@Override
	public void foo(int n) throws CheckedA{
		
	}
}

public class InheritanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
