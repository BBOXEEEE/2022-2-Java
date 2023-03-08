/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Dolphin class: 4장 interface 실습
 * LivingInWater, LivingInSky interface를 구현
 */
public class Dolphin implements LivingInWater {

	@Override
	public void eat() {
		System.out.println("돌고래: 얌얌");
	}

	@Override
	public void swim() {
		System.out.println("돌고래: 수영");
	}
}
