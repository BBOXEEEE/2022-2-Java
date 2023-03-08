/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Door 클래스: 4장 상속 실습
 * lock, unlock을 추상 메소드로 추가
 * 추상 메소드를 가지고 있으면 추상 클래스가 되어야 함
 */
public abstract class Door {
	private boolean isOpen = false;
	public Door() {}
	public boolean isOpen() {
		return isOpen;
	}
	public void open(){
		if(isOpen) System.out.println("문이 이미 열려 있음");
		else{
			System.out.println("문이 열림");
			isOpen = true;
		}
	}
	public void close(){
		if(isOpen){
			 System.out.println("문이 닫힘");
			 isOpen = false;
		}
		else System.out.println("문이 이미 닫혀 있음");
	}
	public abstract void lock();
	public abstract void unlock();
}
