import java.util.concurrent.ThreadLocalRandom;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 2019136056 박세현 
 * @file Soldier.java
 * 군인 클래스를 상속받은 SpecialSoldier 클래스
 * 항상 최소 2의 피해는 입히도록 attack 메소드 재정의 
 */
public class SpecialSoldier extends Soldier{
	private static final int PLUSDAMAGE = 2;
	
	@Override
	public int attack() {
		return ThreadLocalRandom.current().nextInt(3) + PLUSDAMAGE;
	}
}
