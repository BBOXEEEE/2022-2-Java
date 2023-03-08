/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * InsufficientFundException 클래스: 5장 예외처리 연습
 * 잔액부족 예외 처리 클래스: 사용자 정의 예외 클래스
 * Checked 예외는 Exception 상속하여 정의하고
 * Unchecked 예외는 RuntimeException 상속하여 정의함
 * 예외 클래스를 정의할 때에는 기본적으로 두 개의 생성자를 정의함
 */
public class InsufficientFundException extends Exception {
	private static final long serialVersionUID = 9080030439799198831L;
	public InsufficientFundException() {
		super("잔액 부족");
	}
	public InsufficientFundException(String msg) {
		super(msg);
	}
}
