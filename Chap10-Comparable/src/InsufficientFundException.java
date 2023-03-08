/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * InsufficientFundException 클래스: 10장
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
