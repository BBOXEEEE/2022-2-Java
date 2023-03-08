/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 부동소수 타입 예제
 */
public class DoubleTest {
	public static void underflowTest() {
		double d = Double.MIN_VALUE;
		d /= 10;
		System.out.println(d);
	}
	
	public static void overflowTest() {
		double d = Double.MAX_VALUE;
		d *= 10;
		System.out.println(d);
		d = -Double.MAX_VALUE;
		d *= 10;
		System.out.println(d);
	}
	
	public static void divideByZero() {
		double d = 0.0;
		System.out.println(10.0/d);
		System.out.println(-10.0/d);
		System.out.println(
			Double.compare(Double.POSITIVE_INFINITY, 10/d));
		System.out.println(d/d);	// NaN
	}
	
	public static void roundOffError() {
		double d = 3e16;
		double e = d-5;
		System.out.println(e);
	}
	
	public static void compareTest() {
		double d = Double.MIN_VALUE;
		double e = -d;
		d = d/10;
		e = e/10;
		System.out.println(d);
		System.out.println(e);	
		System.out.println(d==e);
		System.out.println(Double.compare(d, e));
	}
	
	public static void main(String[] args) {
		//overflowTest();
		//underflowTest();
		//divideByZero();
		//roundOffError();
		//compareTest();
	}
}
