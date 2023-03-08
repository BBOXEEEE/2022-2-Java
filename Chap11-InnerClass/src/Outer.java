/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 클래스 내부 클래스(일반 클래스) 정의
 * 보통 특정 클래스 내에서만 필요한 간단한 클래스 정의
 * 내부 클래스 객체가 외부 클래스 객체의 멤버 변수에 접근이 필요할 때 사용함
 * 필요하지 않으면 중첩(static) 클래스로 정의함 
 * 일반 내부 클래스 객체는 외부 클래스 내에서만 생성이 가능하며,
 * 해당 객체는 자신을 포함하고 있는 외부 객체에 대한 참조를 유지함 
 * 증첩 클래스 객체는 어디서든 생성이 가능하며,
 * 외부 객체에 대한 참조를 유지하지 않음
 */
public class Outer {
	private int oVal;
	private Inner x; 
	private class Inner{
		int iVal;
		Inner(int n){
			iVal = n;
		}
		void f(int n){
			iVal = oVal + n;
			iVal = Outer.this.oVal + n;
		}
	} // class Inner
	public static class SInner{
		int iVal;
		SInner(int n){
			iVal = n;
		}
		void f(int n) {
			//iVal = oVal + n;
		}
		int get() {
			return iVal;
		}
	}
	public Outer(int n1, int n2){
		oVal = n1;
		x = new Inner(n2);
	}
	public void g(int n){
		oVal = x.iVal + n;
		x.f(n);
	}
	public void print(){
		System.out.printf("oVal = %d, iVal = %d%n",
			oVal, x.iVal);
	}

	public static void main(String[] args) {
		Outer obj = new Outer(2, 3);
		// Outer.Inner x = new Outer.Inner(3); // 오류 Inner는 Outer 내에서만
		Outer.SInner y = new Outer.SInner(3);
		obj.g(3);
		obj.print();
		System.out.println(y.get());
	}

}
