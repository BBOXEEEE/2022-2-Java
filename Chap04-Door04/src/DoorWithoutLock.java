/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * DoorWithoutLock 클래스: 4장 상속 실습
 * 불필요한 클래스로 생각할 수 있지만 타입 구분에 유용하게 사용할 수 있음
 */
public class DoorWithoutLock extends Door {
	@Override
	public void lock(){}
	@Override
	public void unlock(){}
}
