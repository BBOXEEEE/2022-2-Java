import java.util.Arrays;

/**
 *  @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 *  @version 2022년도 2학기
 *  @author 김상진 
 *  Test.java
 *  범용 메소드를 정의하는 방법
 */

public class GenericMethod {

	private static class A{
		private int n;
		public A(int n) {
			this.n = n;
		}
		@Override public String toString() {
			return String.format("(%d)", n);
		}
	}
	
	public static <T> T getMiddle(T[] a){
		if(a == null || a.length == 0) return null;
		return a[a.length/2];
	} // getMiddle
	
	@SafeVarargs
	public static <T extends Comparable<? super T>> T min(T... a){
		if(a.length == 0) return null;
		T smallest = a[0];
		for(int i=1; i<a.length; i++){
			if(smallest.compareTo(a[i])>0) smallest = a[i];
		} // for
		return smallest;
	} // min
	
	// min과 달리 배열을 인자로 전달할 수 없음
	// 하지만 min의 첫 번째 문장과 같은 예외 처리가 불필요
	@SafeVarargs
	public static <T extends Comparable<? super T>> T max(T m, T... a){
		T max =  m;
		for(var n: a){
			if(max.compareTo(n)<0) max = n;
		} // for
		return max;
	} // max
	
	public static void getMiddle_test() {
		String[] fruits = {"grape", "apple", "banana", "melon", "kiwi", "strawberry"};
		System.out.println(getMiddle(fruits));
		// System.out.println(Test.<String>getMiddle(fruits));
	}
	
	public static void min_test() {
		String[] fruits = {"grape", "apple", "banana", "melon", "kiwi", "strawberry"};
		System.out.println(min(fruits));
		System.out.println(max("grape", "apple", "banana", "melon", "kiwi", "strawberry"));

		// Error: A는 Comparable interface를 구현하고 있지 않음
		A[] list = {new A(3),new A(4),new A(2),new A(1)};
		//System.out.println(min(list));	// error
		System.out.println(Arrays.toString(list));
	}
		
	public static void main(String[] args) {
		//getMiddle_test();
		//min_test();
	}
}
