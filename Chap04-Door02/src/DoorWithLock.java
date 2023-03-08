/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * DoorWithLock 클래스: 4장 상속 실습
 * 문제가 있는 버전 (어떤 문제?) 
 */
public class DoorWithLock extends Door {
	private boolean isLocked = false;
	public void lock(){
		if(isLocked) System.out.println("문이 이미 잠겨 있음");
		else{
			System.out.println("문을 잠금");
			isLocked = true;
		}
	} // 코드에 논리 오류가 있음
	public void unlock(){
		if(isLocked){
			 System.out.println("문의 잠금을 해제함");
			 isLocked = false;
		}
		else System.out.println("문이 잠겨 있지 않아 해제할 필요가 없음");
	}
}
