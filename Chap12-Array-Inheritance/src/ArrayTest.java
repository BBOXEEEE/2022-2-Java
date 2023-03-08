/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2022년도 2학기
 * @author 김상진 
 * 12장 접근제어, Object 클래
 * ArrayTest 클래스
 * 객체 배열에서 배열 타입이 상속 관계에 있을 때 주의할 점
 * 원칙. void foo(Object[] list)와 같은 메소드가 있으면
 *      모든 종류의 객체 배열을 인자로 전달할 수 있음
 *      즉, 특정 타입의 객체 배열은 그것의 자식 타입의 모든 배열을 가리킬 수 있음
 */

class A{

}
class B extends A{

}
class C extends A{

}

public class ArrayTest {
	
	// B가 A의 자식이므로 A 타입 배열에 B 타입의 객체를 유지할 수 있음
	// 특정 타입의 배열은 그것의 상위 타입 배열 변수로 조작할 수 있지만
	// 그 반대는 가능하지 않음
	// 강제 타입 변환으로도 가능하지 않음
	public static void test01() {
		A[] list = new A[10];
		for(int i=0; i<list.length; i++) {
			list[i] = new B();
		}
		// B[] array1 = (B[])list; // ClassCastException
		Object[] array = list;
		System.out.println(list.getClass().getName());
		System.out.println(array.getClass().getName());
		// A a = new A();
		// B b = (B)a; // ClassCastException
	}
	// 상위 타입 배열 변수가 실제 하위 타입 배열을 가리키고 있으면
	// 원래 타입으로 타입 변환이 가능
	// 배열은 그것의 원래 타입을 기억하고 있기 때문에
	// 그것을 가리키는 배열 변수 타입과 무관하게 엉뚱한 타입을 
	// 저장할 수 없음
	public static void test02() {
		A[] aList = new B[10];
		B[] bList = new B[10];
		A[] xList = bList;
		// ArrayStoreException
		// xList[0] = new C();
		System.out.println(aList.getClass().getName());
		System.out.println(bList.getClass().getName());
		System.out.println(xList.getClass().getName());
		Object[] oList = bList;
		B[] bList1 = (B[])oList;
		B[] bList2 = (B[])aList;
		System.out.println(bList1.getClass().getName());
		System.out.println(bList2.getClass().getName());
		
	}
	public static void test03() {
		int[] list = {1,2,3,4,5};
		Object o = list;
		int[] array = (int[])o;
		array[0] = 0;
		
		A[] aList = new A[10];
		for(int i=0; i<list.length; i++) {
			aList[i] = new B();
		}
		Object[] x = aList;
		A[] nList = (A[])x;
		nList[0] = new B();
		
	}
	public static void main(String[] args) {
		test01();
		test02();
		test03();
	}
}
