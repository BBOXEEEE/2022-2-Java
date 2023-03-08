/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * FunnyTest 클래스: 5장 예외처리 연습
 * 이 프로그램의 출력 결과는?
 */
public class FunnyTest {
	public static void main(String[] args) {
		try {
			int d = 0;
			int n = 10;
			System.out.println("Start");
			System.exit(0);
			n = n/d;
		}
		catch(Exception e) {
			System.out.println("Exception Caught");
		}
		finally {
			System.out.println("Finally");
		}
		System.out.println("Program ends");
	}
}
