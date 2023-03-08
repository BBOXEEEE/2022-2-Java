/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2022년도 2학기
 * @author 김상진 
 * switch문 - pattern matching (자바18 - preview 기능)
 */

class Pet{
	public void makeSound() {
		System.out.println("pet");
	}
}

class Dog extends Pet{
	public void bark() {
		System.out.println("bark");
	}
}

class Cat extends Pet{
	public void meow() {
		System.out.println("meow");
	}
}

public class PatternMatchinTest {
	// Object는 total type case에 해당 (이 예에서)
	// o의 타입이 Pet이면 Pet이 total type case임
	// 인자가 null이면 total type case가 처리함
	// total type case를 사용하면 null case를 사용할 수 없음
	// default와 total type case도 동시에 사용할 수 없음
	@SuppressWarnings("preview")
	public static void test01(Object o) {
		switch(o) {
		case Cat c: c.meow(); break;
		case Dog d: d.bark(); break;
		//default: o.toString(); 
		case Object ox: System.out.println("xx"); 
		}
	}

	@SuppressWarnings("preview")
	public static void test02(Object o) {
		switch(o) {
		case Cat c: c.meow(); break;
		case Pet p: p.makeSound(); break;
		case null: System.out.println("xx"); break;
		default: o.toString(); 
		}
	}

	public static void main(String[] args) {
		test01(null);
		test01(new Dog());
		test01(new Cat());	
		
		test02(null);
		test02(new Dog());
		test02(new Cat());	
	}
}
