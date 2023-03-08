/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 소스 파일은 NumberOfFiles.java 하나 만들었지만
 * bin 디렉토리를 보면
 * NumberOfFiles.class, NumberOfFiles$1C.class
 * NumberOfFiles$A.class, NumberOfFiles$B.class
 * 4개가 생성됨
 * 항상 바이트 코드는 내부/외부와 무관하게 항상 하나의 파일로 생성됨
 */
public class NumberOfFiles {
	private class A{
		private int a;
		public void bar() {
			System.out.println(a);
		}
	}
	private static class B{
		private int b;
		public void bar() {
			System.out.println(b);
		}
	}
	public void foo() {
		class C{
			int c;
			public void bar() {
				System.out.println(c);
			}
		}
		C x = new C();
		A a = new A();
		B b = new B();
		a.bar();
		x.bar();
		b.bar();
	}
	public static void main(String[] args) {
		NumberOfFiles o = new NumberOfFiles();
		o.foo();
	}
}
