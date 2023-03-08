/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * SiberianHusky 클래스: 부모 클래스 Dog
 * 2장 생성자 연습 (상속은 4장에서 설명함)
 */
public class SiberianHusky extends Dog {
	public SiberianHusky() {}
	public SiberianHusky(String name) {
		super(name); // 사용하지 않으면? 부모의 기본 생성자가 호출됨 
	}
	public void bark(){
		super.bark();
		System.out.println("멍멍");
	}
}
