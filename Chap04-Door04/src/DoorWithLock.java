/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * DoorWithLock 클래스: 4장 상속 실습
 */
public class DoorWithLock extends Door {
	private boolean isLocked = false;
	@Override
	public void open() {
		if(isLocked) System.out.println("문이 잠겨 있어 열 수 없음");
		else super.open();
	}
	@Override
	public void lock(){
		if(isOpen()) System.out.println("문이 열려 있어 잠글 수 없음");
		else if(isLocked) System.out.println("문이 이미 잠겨 있음");
		else{
			System.out.println("문을 잠금");
			isLocked = true;
		}
	}
	@Override
	public void unlock(){
		if(isLocked){
			 System.out.println("문의 잠금을 해제함");
			 isLocked = false;
		}
		else System.out.println("문이 잠겨 있지 않아 해제할 필요가 없음");
	}
}
