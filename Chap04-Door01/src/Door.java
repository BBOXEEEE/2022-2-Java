/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * @file Door.java
 * Door 클래스
 * 상태: 닫혀 있거나 열려 있거나 둘 중 하나
 * 메소드 내 각종 출력은 동작 관찰용 - 실제 필요한 것은 아님
 */
public class Door {
	private boolean isOpen = false;
	public Door() {}
	// 자바는 멤버 변수의 이름과 메소드 이름이 같아도 됨
	public boolean isOpen() {
		return isOpen();
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
}
