import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class A implements Cloneable{
	private int n = 0;
	public A(int n) {
		this.n = n;
	}
	public void set(int n) {
		this.n = n;
	}
	public int get() {
		return n;
	}
	public A clone() {
		A cloned = null;
		try {
			cloned = (A)super.clone();
		}
		catch(CloneNotSupportedException e){}
		return cloned;
	}
}

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기 
 * @author 김상진
 * ArrayList 예제
 */
public class ArrayListTest {
	
	public static void setTest() {
		ArrayList<String> list = new ArrayList<>();
		list.add("apple");
		list.add("grape");
		list.set(0, "banana");
		for(var fruit: list) System.out.println(fruit);
	}
	
	// ArrayList를 배열로 변경
	// toArray() vs. toArray(T[])
	// toArrayTest01: 유지하는 객체가 불변객체
	// toArrayTest02: 유지하는 객체가 불변객체가 아님
	// 나중에 stream을 이용하는 방법도 있음 (14장 예제)
	public static void toArrayTest01() {
		// String은 불변객체
		ArrayList<String> list = new ArrayList<>();
		list.add("apple");
		list.add("grape");
		list.add("melon");
		list.add("banana");
		list.add("blueberry");
		Object[] array = list.toArray();
		for(var s: array) System.out.print(s+", ");
		System.out.println();
		array[2] = "kiwi";
		for(var s: list) System.out.print(s+", ");
		System.out.println();
		
		String[] sList = new String[list.size()];
		list.toArray(sList);
		sList[2] = "kiwi";
		for(var s: list) System.out.print(s+", ");
		System.out.println();
	}
	public static void toArrayTest02() {
		// StringBuilder는 불변객체가 아님
		ArrayList<StringBuilder> list = new ArrayList<>();
		list.add(new StringBuilder("apple"));
		list.add(new StringBuilder("grape"));
		list.add(new StringBuilder("melon"));
		list.add(new StringBuilder("banana"));
		list.add(new StringBuilder("blueberry"));
		Object[] array = list.toArray();
		for(var s: array) System.out.print(s+", ");
		System.out.println();
		((StringBuilder)array[2]).append("kiwi");
		for(var s: list) System.out.print(s+", ");
		System.out.println();
		
		StringBuilder[] sList = new StringBuilder[list.size()];
		list.toArray(sList);
		sList[2].append("kiwi");
		for(var s: list) System.out.print(s+", ");
		System.out.println();
	}
	
	// 배열을 리스트로 
	// 방법 1. Arrays.asList: 수정 가능하지 않은 리스트 생성
	// 방법 2. List의 addAll 메소드
	// 방법 3. Collections의 addAll 메소드
	public static void arrayToList() {
		String[] fruits = {"apple","grape","banana","kiwi"};
		List<String> list01 = Arrays.asList(fruits);
		// Arrays.asList로 생성한 리스트는 수정이 가능하지 않은 리스트이므로 다음이 가능하지 않음
		//list01.add("melon");
		for(var fruit: list01) System.out.print(fruit+", ");
		System.out.println();
		
		// 배열을 리스트로 바꾼 후 다시 리스트에 추가하는 형태이므로 비효율적인 방법
		List<String> list02 = new ArrayList<>();
		list02.addAll(Arrays.asList(fruits));
		list02.add("melon");
		for(var fruit: list02) System.out.print(fruit+", ");
		System.out.println();
		
		List<String> list03 = new ArrayList<>();
		Collections.addAll(list03, fruits);
		list03.add("strawberry");
		for(var fruit: list03) System.out.print(fruit+", ");
		System.out.println();
	}
	
	// 불변객체가 아닌 객체를 ArrayList에 추가하였을 경우 
	// 해당 참조를 가지고 있으면 ArrayList에 유지된 객체를 밖에서 변경할 수 있음
	public static void cloneTest() {
		ArrayList<A> list = new ArrayList<>();
		A a1 = new A(10);
		A a2 = new A(5);
		list.add(a1);
		list.add(a2.clone());
		list.add(new A(3));
		for(var o: list) System.out.println(o.get());
		a1.set(5);;
		for(var o: list) System.out.println(o.get());
	}
	
	public static void main(String[] args) {
		//setTest();
		//toArrayTest01();
		//toArrayTest02();
		//arrayToList();
		//cloneTest();
	}

}
