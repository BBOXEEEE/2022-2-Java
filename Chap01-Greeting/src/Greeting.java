/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Greeting 클래스
 */
public class Greeting {
	private String mName;
	private String mGreeting;
	
	public void setName(String name) {
		mName = name;
	}
	public void setGreeting(String greeting) {
		mGreeting = greeting;
	}
	public String sayHello() {
		return mGreeting + ", " + mName;
	}
}
