/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Duck class: 4장 interface 실습
 * LivingInWater, LivingInSky interface를 구현
 */
public class Duck implements LivingInWater, LivingInSky {
	@Override
	public void eat() {
		System.out.println("오리: 얌얌");
	}

	@Override
	public void swim() {
		System.out.println("오리: 수영");
	}
	
	@Override
	public void fly() {
		System.out.println("오리: 날고 있음");
	}
}
