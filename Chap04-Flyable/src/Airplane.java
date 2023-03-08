/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Airplane 클래스: 4장 interface 실습
 * Flyable interface 구현
 */
public class Airplane implements Flyable {
	@Override
	public void fly() {
		System.out.println("비행기가 하늘을 날고 있어요");
	}
}
