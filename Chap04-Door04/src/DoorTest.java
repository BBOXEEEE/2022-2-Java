/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * DoorTest 클래스: 4장 상속 실습
 */
public class DoorTest {
	public static void doorSimulation(Door door) {
		door.open();
		door.close();
		door.lock();
		door.open();
		door.unlock();
		door.open();
		door.close();
	}
	public static void main(String[] args) {
		doorSimulation(new DoorWithLock());
		doorSimulation(new DoorWithoutLock());
	}
}
