import java.util.concurrent.ThreadLocalRandom;

// import java.util.concurrent.ThreadLocalRandom;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 2019136056 박세현 
 * @file Soldier.java
 * Soldier 객체보다 회복력이 우수하도록 heal 메소드 재정의 
 */

public class MedicSoldier implements HealStrategy{
	@Override
	public int heal() {
		return ThreadLocalRandom.current().nextInt(2);
	}
}

/*
 * 포함관계의 이점
 * 클래스 및 객체가 상속을 받는 것보다 느슨하게 결합한다. 
 * 즉, 부모 클래스의 구성명세가 변경될 경우 구성요소를 쉽게 변경할 수 있어 상속보다 더 많은 유연성을 제공할 수 있다.
*/