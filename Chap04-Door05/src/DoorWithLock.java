/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 김상진
 * DoorWithLock 클래스: 4장 상속 실습
 * Has-a를 이용한 잠금장치 있는 문의 구현
 * Has-a를 사용한다고 코드 중복이 있는 것은 아님
 * 기존 클래스를 수정하지 않고 확장하는 방법: 1) 상속, 2) 포함 관계
 * 포함 관계를 이용할 경우 pass through 형태의 메소드를 종종 정의해야 함 (예: isOpen)
 * 일반적으로 포함 관계를 이용하여 확장할 경우 포함하는 객체의 일부 기능만 활용할 수 있음
 */
public class DoorWithLock{
	private boolean isLocked = false;
	// 이렇게 하지 않고 생성자에서 Door 객체를 받는 형태로 정의할 수 있음
	private Door door = new Door();
	public boolean isOpen() {
		return door.isOpen();
	}
	public void open() {
		if(isLocked) System.out.println("문이 잠겨 있어 열 수 없음");
		else door.open();
	}
	public void close() {
		door.close();
	}
	public void lock(){
		if(isOpen()) System.out.println("문이 열려 있어 잠글 수 없음");
		else if(isLocked) System.out.println("문이 이미 잠겨 있음");
		else{
			System.out.println("문을 잠금");
			isLocked = true;
		}
	}
	public void unlock(){
		if(isLocked){
			 System.out.println("문의 잠금을 해제함");
			 isLocked = false;
		}
		else System.out.println("문이 잠겨 있지 않아 해제할 필요가 없음");
	}
}
