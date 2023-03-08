/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Dog 클래스: 4장 상속 실습
 * Pet의 자식 클래스
 */
public class Dog extends Pet {
	public Dog(String name) {
		super(name);
	}
	public String makeSound() {
		return super.makeSound()+"멍멍";
	}
}
