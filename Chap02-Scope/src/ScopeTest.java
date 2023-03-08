/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * ScopeTest 클래스
 * 자바는 멤버 변수와 지역 변수의 충돌만 허용
 */

class A{
	private int a = 0;

	public void f(int n){
		int a = 1;
		a = 3; // local a;
		b = 2;
		System.out.println(this.a+", "+this.b+", "+a+", "+n);
	} // f(int)
	public void g(int a){
		int c = 1;
		b = 3;
		{
			// int c = 0;  error
			int x = 0;
			System.out.println(x);
		}
		{
			int x = 1;
			System.out.println(x);
		}
		a = 2; // parameter a
		System.out.println(this.a+", "+this.b+", "+a+", "+c);
	} // g(int)
	
	// 멤버 변수는 선언 위치와 무관하게 클래스 전체에서 사용할 수 있음
	// 일반 변수와 차이가 있음 (일반 변수는 가시 영역 내에 있어도 선언 이전 줄에서는 사용할 수 없음)
	private int b = 1;
} // A

public class ScopeTest {
	public static void main(String[] args) {
		A o = new A();
		o.f(5);
		o.g(7);
	}
}
