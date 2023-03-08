/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 김상진
 * DoorTest 클래스: 4장 상속 실습
 * Door에는 lock과 unlock 메소드가 없음
 * Door와 DoorWithLock은 모두 객체를 생성할 수 있는 클래스임 
 */
public class DoorTest {
	public static void doorSimulation(Door door) {
		door.open();
		door.close();
		//door.lock();
		door.open();
		//door.unlock();
		door.open();
		door.close();
	}
	public static void main(String[] args) {
		DoorWithLock door1 = new DoorWithLock();
		Door door2 = new Door();
		doorSimulation(door1);
		doorSimulation(door2);
	}
}
