/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * VarTest 클래스
 * var에 대한 이해: 컴파일 시간에 초깃값을 바탕으로 타입 유추
 * 다중 정의에 대한 이해 
 * 원시타입이 아닌 상속 관계에서 타입 유추는 4장에서 설명함
 */

class Pet{
}

class Dog extends Pet{
}

class Cat extends Pet{
}

public class VarTest {
	public static void foo(byte n) {
		System.out.println("byte");
	}
	public static void foo(short n) {
		System.out.println("short");
	}
	public static void foo(int n) {
		System.out.println("int");
	}
	public static void foo(long n) {
		System.out.println("long");
	}
	public static void foo(float n) {
		System.out.println("float");
	}
	public static void foo(double n) {
		System.out.println("double");
	}
	public static void bar(Pet p) {
		System.out.println("Pet");
	}
	public static void bar(Dog d) {
		System.out.println("Dog");
	}
	public static void bar(Cat c) {
		System.out.println("Cat");
	}
	public static void varWithPrimitiveTypes() {
		var a = 1;
		var b = 1L;
		var c = 1.5F;
		var d = 1.5;
		short s = 1;
		var e = s;
		foo(a);
		foo(b);
		foo(c);
		foo(d);
		foo(e);
	}
	// 자바 다중정의. 가장 정확하게 일치하는 타입. 컴파일 시간에 결정
	public static void varWithObjectTypes() {
		var a = new Dog();
		var b = new Cat();
		//b = a;
		Pet c = new Dog();
		var d = c;
		//a = d;
		bar(a);
		bar(b);
		bar(d);
		d = a;
		d = b;
		bar(d);
	}
	public static void main(String[] args) {
		varWithPrimitiveTypes();
		varWithObjectTypes();
	}

}
