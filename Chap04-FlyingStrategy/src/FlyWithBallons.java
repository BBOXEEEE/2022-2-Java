/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * FlyWithBallons 클래스: 4장 interface 실습
 * fly 방법을 구체적으로 구현하는 클래스
 */
public class FlyWithBallons implements FlyingStrategy {
	@Override
	public void doFly() {
		System.out.println("풍선을 이용하여 하늘을 날고 있어");
	}
}
