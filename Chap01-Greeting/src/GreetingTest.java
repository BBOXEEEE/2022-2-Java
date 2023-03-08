/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 1학기
 * @author 김상진
 * GreetingTest 클래스
 */
public class GreetingTest {
	public static void main(String[] args) {
		Greeting greeting = new Greeting();
		greeting.setName("상진");
		greeting.setGreeting("안녕");
		System.out.println(greeting.sayHello());
		greeting.setName("길동");
		System.out.println(greeting.sayHello());
		Greeting engGreeting = new Greeting();
		engGreeting.setName("Sangjin");
		engGreeting.setGreeting("Hi Brother");
		System.out.println(engGreeting.sayHello());
	}
}
