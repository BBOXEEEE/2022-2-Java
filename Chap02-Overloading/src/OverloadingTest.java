/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * OverloadingTest 클래스
 * 메소드 다중 정의 관련 문법
 */

class A{
	void foo(int x){
		System.out.println("void foo(int);");
	}
	/*
	// 반환 타입만 다른 함수는 다중 정의할 수 없음
	int foo(int x) {
		System.out.println("int foo(int);");
	}
	*/
	void foo(int a, int b){
		System.out.println("void foo(int, int);");
	}
	void foo(float f){
		System.out.println("void foo(float);");
	}
	void foo(double f){
		System.out.println("void foo(double);");
	}
	void bar(float f) {
		System.out.println("void bar(float);");
	}
	void bar(double f) {
		System.out.println("void bar(double);");
	}
	void baz(int n, double f) {
		System.out.println("void baz(int, double)");
	}
	void baz(double f, int n) {
		System.out.println("void baz(double, int)");
	}
}


public class OverloadingTest {
	// 보통 다중 정의에서 다중 정의보다는 함수 호출에서 문법 오류가 발생함
	// 이 경우 함수 호출을 모호하지 않도록 수정하거나 추가 다중 정의가
	// 필요할 수 있음
	public static void main(String[] args) {
		A a = new A();
		a.foo(10);
		a.foo(10L);
		a.foo(1.5);
		a.foo(1.5F);
		a.bar(10);
		a.baz(1, 2.0);
		// 함수 호출이 모호함 (다중 정의가 문법 오류가 아님)
		//a.baz(1,1);
	}

}
