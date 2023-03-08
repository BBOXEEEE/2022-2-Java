/**
 *  @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 *  @version 2022년도 2학기
 *  @author 김상진 
 *  PairTest.java
 *  범용 클래스 Pair<U, V> 테스트 프로그램
 */
public class PairTest {
	public static void template_getClass_test() {
		Pair<String,String> sPair = new Pair<>("apple" ,"banana") ;
		Pair<Integer,Integer> iPair = new Pair<>(3,7) ;
		System.out.println(sPair.getClass()==iPair.getClass());
		// 아래와 같이는 검사할 수 없음
		//System.out.println(sPair instanceof Pair<String,String>);
		System.out.println(sPair instanceof Pair<?,?>);
		System.out.println(sPair instanceof Pair);
		//System.out.println(sPair instanceof Pair<? extends String, ? extends String>); // error
		System.out.println(sPair.getFirst() instanceof String);
	}
	public static Pair<String, String> minmax(String[] a){
		if(a == null || a.length == 0) return null;
		String min = a[0];
		String max = a[0];
		for(int i=1; i<a.length; i++){
			if(min.compareTo(a[i])>0) min = a[i];
			if(max.compareTo(a[i])<0) max = a[i];
		}
		return new Pair<>(min, max);
	} // minmax
	// 위 minmax와 달리 g_minmax는 범용 메소드임
	public static <T extends Comparable<? super T>> Pair<T, T> g_minmax(T[] a){
		if(a == null || a.length == 0) return null;
		T min = a[0];
		T max = a[0];
		for(int i=1; i<a.length; i++){
			if(min.compareTo(a[i])>0) min = a[i];
			if(max.compareTo(a[i])<0) max = a[i];
		}
		return new Pair<>(min, max);
	} // g_minmax
	public static void minmax_test() {
		String[] fruits = {"grape", "apple", "banana", "melon", "kiwi", "strawberry"};
		Pair<String, String> result = minmax(fruits);
		System.out.println("MIN: "+result.getFirst()+", MAX: "+result.getSecond());
		result = g_minmax(fruits);
		System.out.println("MIN: "+result.getFirst()+", MAX: "+result.getSecond());
	}
	public static <T> void swap(Pair<T,T> p){
		T t = p.getFirst();		
		p.setFirst(p.getSecond());
		p.setSecond(t);
	} // swap
	public static void swap_test() {
		Pair<String, String> a = new Pair<>("apple", "banana");
		System.out.println(a.getFirst()+", "+a.getSecond());
		swap(a);
		System.out.println(a.getFirst()+", "+a.getSecond());
		Pair<String, Integer> b = new Pair<>("grape",5);
		System.out.println(b.getFirst()+", "+b.getSecond());
		//swap(b); // error
	}
	public static void array_test() {
		//Pair<String, String>[] list = new Pair<String, String>[10];
		Pair<?, ?>[] list = new Pair<?,?>[10];
		list[0] = new Pair<String, String>("apple", "banana");
		list[1] = new Pair<Integer, Integer>(2,3);
	}
	public static boolean hasNull(Pair<?,?> p){
		return (p.getFirst() == null || p.getSecond() == null);
	} // hasNull
	public static <T> boolean hasNullV2(Pair<T,T> p) {
		return (p.getFirst() == null || p.getSecond() == null);
	} // hasNullV2
	public static void hasNull_test() {
		Pair<String, String> a = new Pair<>("apple", "banana");
		//System.out.println(hasNull(a));
		System.out.println(hasNullV2(a));
	}
	public static void main(String[] args) {
		// template_getClass_test();
		// minmax_test();
		// swap_test();
		hasNull_test();
	}

}
