/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * FlyableTest 클래스: 4장 interface 실습
 * foo 메소드는 Flyable를 구현하고 있는 어떤 클래스의 객체도 인자로 받을 수 있음
 */

class Dog{
} // Flyable interface를 구현하고 있지 않음

public class FlyableTest {
	public static void foo(Flyable f) {
		f.fly();
	}
	public static void main(String[] args) {
		Flyable f1 = new Bee();
		Airplane airplane = new Airplane();
		foo(f1);
		foo(airplane);
		// foo(new Dog());	// error
	}

}
