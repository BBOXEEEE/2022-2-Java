/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 2019136056 박세현 
 * @file WWStrategy.java
 * bark 방법을 구체적으로 구현하는 클래스 
 * Bark 메소드 호출 시 "왈왈"
 */
public class WWStrategy implements BarkStrategy{
	@Override
	public String doBark() {
		return "왈왈!";
	}
}
