/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 타입 변환 예제
 * 확장 변환에 해당하지만 정보 손실이 발생할 수 있는 경우
 * int -> float, long -> float, long -> double
 */
public class TypecastTest {
	public static void precisionProblem() {
		int n = 123_456_789;
		float f = n;	// 문법 오류 아님
		System.out.println(n);
		System.out.printf("%f%n",f);
		long l = 123_456_789_123_456_789L;
		f = l;			// 문법 오류 아님
		System.out.println(l);
		System.out.printf("%f%n",f);
		double d = l;	// 문법 오류 아님
		System.out.printf("%f%n",d);
	}
	
	public static void main(String[] args) {
		precisionProblem();
	}
}
