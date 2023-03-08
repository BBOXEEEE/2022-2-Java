/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * ExceptionTest 클래스: 5장 예외처리 연습
 * Checked 예외와 Unchecked 예외의 처리
 * Checked 예외가 발생되는 메소드는 그것을 공표하거나 직접 처리해야 함. 
 * 하지 않으면 문법 오류
 * Unchecked 예외는 처리에 대해 강제화된 것이 없음
 */

class CheckedException extends Exception {
	private static final long serialVersionUID = 3572524678561213823L;
	public CheckedException() {
		super("Checked 예외 발생");
	}
	public CheckedException(String msg) {
		super(msg);
	}
}

class UncheckedException extends RuntimeException {
	private static final long serialVersionUID = 2255732978776704762L;
	public UncheckedException() {
		super("Unchecked 예외 발생");
	}
	public UncheckedException(String msg) {
		super(msg);
	}
}

public class ExceptionTest {
	// 예외가 발생하지 않은 함수
	public static void baz() {
		System.out.println("executing baz...");
	}
	// unchecked 예외 발생 함수
	public static void bar() { 
		System.out.println("executing bar...");
		throw new UncheckedException();
	}
	// checked 예외 발생 함수 
	public static void foo() throws CheckedException {
		System.out.println("executing foo...");
		throw new CheckedException();
	}
	// checked 예외 발생하는 함수를 사용하지만 예외 처리
	public static void ham() {
		try {
			System.out.println("executing ham...");
			foo(); 
		}
		catch(Exception e) {
			System.out.println("ham에서 예외 처리");
		}
	}
	public static void main(String[] args) {	
		try {
			baz();
			ham();
			foo(); 
			bar();
		} 
		catch (CheckedException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 끝");
	}

}
