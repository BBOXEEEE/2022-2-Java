/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 2019136056 박세현 
 * @file DogTest.java
 * 테스트 프로그램
 * WWStrategy ==> 왈왈 
 * MMStrategy ==> 멍멍
 */
public class DogTest {
	
	public static void main(String[] args) {
		Dog mimi = new Dog("미미");
		mimi.setBarkStrategy(new WWStrategy());
		mimi.bark();
		Dog general = new Dog("장군");
		general.setBarkStrategy(new MMStrategy());
		general.bark();		
		general.setBarkStrategy(new WWStrategy());
		general.bark();		
	}

}
