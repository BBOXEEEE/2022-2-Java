import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2022년도 2학기
 * @author 김상진
 * java.util.function에 있는 함수형 interface 활용
 */
public class Java_util_function_test {
	public static int countif(String[] list, Predicate<String> p) {
		int count = 0;
		for(String s: list)
			if(p.test(s)) ++count;
		return count;
	}
	public static void countif_test() {
		String[] list1 = {"apple", "", "", "banana", "grape"};
		System.out.println(countif(list1, s->s.length()==0));
		System.out.println(countif(list1, String::isEmpty));
		String[] list2 = {"apple", null, "banana", null, "grape"};
		System.out.println(countif(list2, s->s!=null));
		System.out.println(countif(list2, Objects::nonNull));
		System.out.println(countif(list2, s->Objects.nonNull(s)));	
	}
	public static void primitiveFI_test() {
		IntPredicate isPositive = x -> x>0;
		IntPredicate isOdd = x -> (x&1)==1;
		IntPredicate isSmallerThan100 = x -> x<100;
		System.out.println(isPositive.negate().test(50));
		System.out.println(isOdd.test(14));
		System.out.println(isPositive.and(isSmallerThan100).test(50));
	}
	
	// 원시타입 전용 함수형 interface를 사용할 수 있는 경우에는 
	// 범용타입 함수형 interface를 사용하지 않는 것이 효율성을 높이는 방법
	public static void Wrong_UsePrimitiveFI() {
		Predicate<Integer> isPositive = x -> x>0;
		Predicate<Integer> isSmallerThan100 = x -> x<100;
		System.out.println(isPositive.negate().test(50));
		System.out.println(isPositive.and(isSmallerThan100).test(50));
	}
	
	public static void foo(BiFunction<String,String,String> joiner){
		String s1 = "Hello";
		String s2 = "World";
		System.out.println(joiner.apply(s1, s2));
	}
	
	public static void foo(IntBinaryOperator intOperation){
		int n1 = 10;
		int n2 = 5;
		System.out.println(intOperation.applyAsInt(n1, n2));
	}
	
	// IntBinaryOperator: (int, int) -> int
	// BiFunction<String, String, String>: (String, String) -> String
	// 하지만 같은 타입의 인자를 받아 받은 인자와 같은 타입의 값을 하나 반환하는 측면에서 
	// 모호할 수 있음
	public static void foo_test() {
		//foo((x, y) -> x + " " + y);	// error, ambiguous
		//foo((x, y) -> x + y); 		// error, ambiguous
		IntBinaryOperator adder = (x,y)->x+y;
		foo(adder);
		foo((int x, int y)->x+y);
		foo((IntBinaryOperator)((x,y)->x+y));
	}
	
	public static void biConsumer_test() {
		Map<String, Integer> map = new HashMap<>();
		map.put("apple", 5);
		map.put("grape", 2);
		map.put("banana", 3);
		map.put("melon", 4);
		map.put("blueberry", 30);
		BiConsumer<String, Integer> printEntry 
			= (K,V)->System.out.println(K+": "+V);
		map.forEach(printEntry);
	}
	
	public static void main(String[] args) {
		//primitiveFI_test();
		//Wrong_UsePrimitiveFI();
		//countif_test();
		//foo_test();
		//biConsumer_test();
	}

}
