/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * CauseTest 클래스: 5장 예외처리 연습
 * 예외의 원인이 되는 예외를 설정할 수 있음
 * initCause를 이용하거나 원인 예외를 받는 생성자 사용
 * 보통 예외를 재차 발생할 때 사용
 */
class ExceptionA extends RuntimeException{
	private static final long serialVersionUID = -5970188238854330533L;
	public ExceptionA() {
		super("A 예외");
	}
	public ExceptionA(String msg) {
		super(msg);
	}
}

class ExceptionB extends RuntimeException{
	private static final long serialVersionUID = -8587599700865950455L;
	public ExceptionB() {
		super("B 예외");
	}
	public ExceptionB(String msg) {
		super(msg);
	}
}

class ExceptionC extends RuntimeException{
	private static final long serialVersionUID = -2942507702076879817L;
	public ExceptionC() {
		super("B 예외");
	}
	public ExceptionC(String msg) {
		super(msg);
	}
	public ExceptionC(String msg, Exception e) {
		super(msg, e);
	}
}

public class CauseTest {
	public static void foo() {
		throw new ExceptionA();
	}
	public static void bar() {
		try {
			foo();
		}
		catch(ExceptionA e) {
			RuntimeException re = new ExceptionB("ㅠ.ㅠ");
			re.initCause(e);
			throw re;
		}
	}
	public static void ham() {
		try {
			foo();
		}
		catch(ExceptionA e) {
			throw new ExceptionC(":-)",e);
		}
	}
	public static void main(String[] args) {
		try {
			bar();
		}
		catch(Exception e) {
			System.out.println("Cause: " + e.getCause());
		}
		// ham();
	}

}
