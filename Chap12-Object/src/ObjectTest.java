
/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2022년도 2학기
 * @author 김상진 
 * 12장 접근제어, Object 클래스 
 * ObjectTest 클래스
 * Object은 자바에 존재하는 모든 객체 타입을 유지할 수 있음
 * 자바에서는 배열과 열거형 상수도 객체 타입임
 */

// 빈 클래스에 대해 할 수 있는 것은? ==> testX 메소드 참조
class X{
}

class Dog{
	@Override public String toString() {
		return "강아지";
	}
}

enum Direction {NORTH, SOUTH, EAST, WEST};

public class ObjectTest {
	public static void testX() {
		X x1 = new X();
		System.out.println(x1);
		System.out.println(x1.toString());
		X x2 = new X();
		System.out.println(x1.equals(x2));
		System.out.println(x1.equals(x1));
		System.out.println(x1.hashCode());
		System.out.println(x2.hashCode());
		//X x3 = x1.clone(); // Object의 clone은 protected method 
		Class<? extends X> c = x1.getClass();
		System.out.println(c.getName());
		System.out.println(c==X.class);
	}
	
	public static void object_array_test() {
		int[] integerArray = new int[10];
		Dog[] dogs = new Dog[10];
		dogs[0] = new Dog();
		Object o = null;
		o = integerArray;
		if(o instanceof int[]) System.out.println("ha ha");
		System.out.println(o);
		int[] a = (int[])o;
		System.out.println(a[0]);
		o = dogs;
		System.out.println(o);
		Dog[] d = (Dog[])o;
		System.out.println(d[0]);
		o = dogs[0];
		System.out.println(o);
	}
	public static void object_enum_test() {
		Object o = null;
		o = Direction.NORTH;
		System.out.println(o);
		Direction d = (Direction)o;
		System.out.println(d);
	}
	// 문자열 제외하고 나머지는 원시타입 
	// 원시타입을 o에 대입하면 autoboxing에 의해 자동 객체로 포장
	public static void object_primitive_test() {
		Object o = null;
		o = 1;
		System.out.println(o);
		o = 1.5;
		System.out.println(o);
		o = true;
		System.out.println(o);
		o = 'a';
		System.out.println(o);
		o = "hello";
		System.out.println(o);
	}
	public static void main(String[] args) {
		testX();
		//object_array_test();
		//object_enum_test();
		//object_primitive_test();
	}

}
