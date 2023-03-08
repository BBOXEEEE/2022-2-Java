/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * FlyableTest 클래스: 4장 interface 실습
 * duck의 행동이 동적으로 바뀌고 있음
 */
public class FlyableTest {
	public static void foo(Flyable f) {
		f.fly();
	}
	public static void main(String[] args) {
		Duck duck = new Duck(new FlyWithWings());
		foo(duck);
		duck.setStrategy(new FlyWithRockets());
		foo(duck);
		duck.setStrategy(new FlyWithBallons());
		foo(duck);
		duck.setStrategy(new FlyNoWay());
		foo(duck);
	}

}
