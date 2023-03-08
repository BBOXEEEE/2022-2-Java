/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 불변 클래스를 정의하는 방법
 * C는 일반 클래스 
 * D는 불변 클래스
 * 원시타입만 유지할 경우 모든 맴버를 public final로 수식하고, getter를 만들지 않음 
 * 모든 멤버 변수를 초기화하는 생성자를 정의해야 함
 * A, B: 불변 클래스
 * 원시타입과 참조타입을 멤버 변수로 유지함
 * 멤버 변수가 원시타입 또는 불변객체이면 public final로 수식, getter를 만들지 않음 
 * 멤버 변수가 일반객체이면 private final로 수식, getter를 제공해야 함
 * 초기화할 때 인자로 전달된 것을 복제하여 초기화해야 함
 * getter는 멤버 변수를 복제하여 반환하여야 함
 * B는 복제하는 조치를 하지 않음
 * clone의 정의는 12장에서 설명함
 * record를 이용하여 불변 클래스를 정의할 때도 동일함
 * E는 조치를 하지 않아 문제가 있음
 */

// 클래스가 final이면 상속할 수 없음
// 클래스가 final인 경우에 clone을 정의하는 방법이 달라짐 (자세한 것은 12장)
final class C implements Cloneable{
	private int n = 0;
	public C() {}
	public C(int n) {
		this.n = n;
	}
	public void set(int n) {
		this.n = n;
	}
	public int get() {
		return n;
	}
	public C clone() {
		C cloned = null;
		try {
			cloned = (C)super.clone();
		}
		catch(Exception e) {}
		return cloned;
	}
}

class D{
	public final int val;
	public D() {
		this(0);
	}
	public D(int n) {
		this.val = n;
	}
}

// 불변객체가 아닌 c에 대해 필요한 조치를 하지 않아
// B는 온전한 불변 클래스가 아님
class B{	
	public final int n;
	private final C c;
	public final D d;
	public B(int n, C c, D d){
		this.n = n;
		this.c = c;
		this.d = d;
	}
	public C getC(){
		return c;
	}
	// 필요한 다른 기능
}

class A{	
	public final int n;
	private final C c;
	public final D d;
	public A(int n, C c, D d){
		this.n = n;
		this.c = c.clone();
		this.d = d;
	}
	public C getC(){
		return c.clone();
	}
	// 필요한 다른 기능
}

// 불변객체가 아닌 c에 대해 필요한 조치를 하지 않아
// E는 온전한 불변 클래스가 아님
record E(int n, C c, D d) {}

record F(int n, C c, D d) {
	public F(int n, C c, D d) {
		this.n = n;
		this.c = c.clone();
		this.d = d;
	}
	public C c() {
		return c.clone();
	}
}


public class Test {
	public static void testA() {
		System.out.println("Testing A: correct implementation");
		A a = new A(2, new C(3), new D(4));
		//a.d.val = 2;
		a.getC().set(4);
		System.out.printf("%d, %d, %d%n", a.n, a.getC().get(), a.d.val);
	}
	public static void testB() {
		System.out.println("Testing B: incorrect implementation");
		B b = new B(2, new C(3), new D(4));
		//b.d.val = 2;
		b.getC().set(4);
		System.out.printf("%d, %d, %d%n", b.n, b.getC().get(), b.d.val);
	}
	public static void testF() {
		System.out.println("Testing F(record): correct implementation");
		F f = new F(2, new C(3), new D(4));
		//f.d().val = 2;
		f.c().set(4);
		System.out.printf("%d, %d, %d%n", f.n(), f.c().get(), f.d().val);
	}
	public static void testE() {
		System.out.println("Testing E(record): incorrect implementation");
		E e = new E(2, new C(3), new D(4));
		//e.d().val = 2;
		e.c().set(4);
		System.out.printf("%d, %d, %d%n", e.n(), e.c().get(), e.d().val);
	}
	public static void main(String[] args) {
		testA();
		testB();
		testF();
		testE();
	}

}
