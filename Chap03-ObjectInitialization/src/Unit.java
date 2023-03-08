
/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2022년도 2학기
 * @author 김상진 
 * @file Unit.java
 * 게임에 등장하는 유니트
 * 체력: 항상 100에서 시작 >> 시작값 고정
 * 레벨: 생성될 때 각 유니트의 레벨은 다를 수 있음 >> 시작값 유동 
 * 이동속도: 모든 유니트의 이동속도는 1이고 변하지 않음  >> 클래스 상수
 * 차지하는 공간: 각 유니트마다 다를 수 있지만 변하지 않음 >> 객체 상수
 */
public class Unit {
	private int stamina = 100;			// 체력. 0이 되면 죽음
	private int level;					// 1~5 중 하나 
	public static final int SPEED = 1;	// 이동속도 
	public final int SPACE;				// 차지하는 공간
	public Unit(int level, int space) {
		this.level = (level>=1&&level<=5)? level: 1;
		SPACE = space;
	}
	public int getStamina() {
		return stamina;
	}
	public int getLevel() {
		return level;
	}
}
