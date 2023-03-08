import java.util.Arrays;
import java.util.Comparator;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2022년도 2학기
 * @author 김상진
 * 람다 표현식의 활용 예: 함수형 프로그래밍 지원되기 이전에는 함수를 다른 함수에 전달하기
 * 위해 클래스를 정의함. 이와 같은 클래스는 객체지향에서 말하는 상태와 행위를 가지는 클래스가 아님
 */
public class WhyLambda {
	
	public static void sort01(String[] list) {
		class StringLengthComparator implements Comparator<String> {
			@Override
			public int compare(String s1, String s2){
				return s1.length() - s2.length(); 
			} // compare
		} // method inner class
		Arrays.sort(list, new StringLengthComparator());
		System.out.println(Arrays.toString(list));
	}
	
	// anonymous class
	public static void sort02(String[] list) {
		Arrays.sort(list, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2){
				return s1.length() - s2.length(); 
			}
		});
		System.out.println(Arrays.toString(list));
	}
	
	// using lambda
	public static void sort03(String[] list) {
		Arrays.sort(list, (s1, s2)->s1.length()-s2.length());
		System.out.println(Arrays.toString(list));
	}
	
	public static void sort04(String[] list) {
		Arrays.sort(list, (s1, s2)->Integer.compare(s1.length(), s2.length()));
		System.out.println(Arrays.toString(list));
	}
	
	// using method reference
	public static void sort05(String[] list) {
		Arrays.sort(list, Comparator.comparing(String::length));
		System.out.println(Arrays.toString(list));
	}
	
	// sort05보다는 이 방법이 더 올바른 방법
	public static void sort06(String[] list) {
		Arrays.sort(list, Comparator.comparingInt(String::length));
		System.out.println(Arrays.toString(list));
	}
	
	public static void sort07(String[] list) {
		Arrays.sort(list, Comparator.comparingInt(String::length).reversed());
		System.out.println(Arrays.toString(list));
	}
	
	public static void main(String[] args) {
		String[] list = {"apple", "kiwi", "banana", "strawberry", "blueberry"};
		sort01(list.clone());
		sort02(list.clone());
		sort03(list.clone());
		sort04(list.clone());
		sort05(list.clone());
		sort06(list.clone());
		sort07(list.clone());
	}

}
