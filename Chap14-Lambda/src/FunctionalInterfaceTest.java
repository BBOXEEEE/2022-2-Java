import java.util.function.BiFunction;

@FunctionalInterface
interface IntFunction{
	int apply(int a);
}

@FunctionalInterface
interface IntBiFunction{
	int apply(int a, int b);
}

@FunctionalInterface
interface MyBiFunction<T>{
	T apply(T a, T b);
}

class intADD implements IntBiFunction{
	public int apply(int a, int b) {
		return a+b;
	}
}

@FunctionalInterface
interface Doggy{
	int apply(int a, int b);
}

@FunctionalInterface
interface Catty{
	int apply(int a, int b);
}

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2022년도 2학기
 * @author 김상진
 * 함수형 interface를 정의하여 사용하기
 */
public class FunctionalInterfaceTest {
	public static int foo(int a, IntFunction uFunc) {
		return uFunc.apply(a);
	}
	public static int func(int a, int b, IntBiFunction biFunc) {
		return biFunc.apply(a,b);
	}
	public static <T> T doOP(T a, T b, BiFunction<T,T,T> f){
		return f.apply(a,b);
	}
	public static <T,B> B doTest(T a, T b, BiFunction<T,T,B> f){
		return f.apply(a,b);
	}
	public static int bar() {
		return 9;
	}
	
	public static void ham(Doggy doggy, int a, int b) {
		System.out.println(doggy.apply(a, b));
	}
	
	public static void hen(Catty catty, int a, int b) {
		System.out.println(catty.apply(a, b));
	}
	
	// Doggy와 Catty는 모두 같은 SAM을 정의하는 interface이지만 서로 다른 타입임 
	// 이 때문에 Doggy에 맞는 람다 표현식이지만 Catty 리모컨에 유지하고 있으면 ham 메소드에 전달할 수 없음
	// 거꾸로도 마찬가지
	public static void hamTest() {
		Doggy sum = (a, b) -> a+b;
		Catty prod = (a, b) -> a*b;
		ham(sum, 2, 3);
		//ham(prod, 2, 3);
		ham((a,b)->a*b, 2, 3);
		//hen(sum, 2, 3);
		hen((a,b)->a+b, 2, 3);
		hen(prod, 2, 3);
	}
	
	public static void main(String[] args) {
		System.out.println(foo(3, a->a+3));		
		System.out.println(foo(3, e->bar()));
		
		System.out.println(func(2,3, new intADD())); // old style
		System.out.println(func(2,3, (a,b)->a+b));
		IntBiFunction intSubtractor = (a,b)->a-b;
		System.out.println(intSubtractor.apply(2, 3));
		System.out.println(func(2,3, intSubtractor));
		
		MyBiFunction<Integer> adder = (a,b)->a+b;
		System.out.println(adder.apply(2, 3));
		System.out.println(FunctionalInterfaceTest.<Integer>doOP(3, 5, (a,b)->a+b));
		System.out.println(doOP(10, 5, (a,b)->a-b));
		System.out.println(doOP("hello","world", (a,b)->a+" "+b));
		System.out.println(doTest(10, 5, (a,b)->a%b==0));
		System.out.println(doTest("ababccd", "abc", (a,b)->a.contains(b)));
	}
}
