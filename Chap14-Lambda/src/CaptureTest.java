import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2022년도 2학기
 * @author 김상진
 * 14장 예제. 자유변수의 캡쳐
 * 참조변수와 this를 캡쳐할 수 있기 때문에
 * 람다 표현식이 순수 함수라고 말하기 힘듦
 */

public class CaptureTest {
	// 람다 표현식은 정의할 때 this를 capture하여 사용할 수 있음
	public static void capturingThis() {
		Unsigned a = new Unsigned();
		a.set(5);
		a.test(); // 이 메소드 내에서 람다 표현식을 실행됨
		System.out.println(a.get());
	}
	
	// 지역 참조 변수 캡처 
	public static void capturingReference() {
		Unsigned a = new Unsigned();
		Magic x = ()->{
			// a.n = 5; // 접근 권한 때문에 오류
			a.set(5);
		};
		x.doAnything();
		System.out.println(a.get());
	}
	
	// 지역 원시타입 변수 캡처
	public static void capturingLocalVariable() {
		int n = 7;
		Magic x = ()->{
			// n = 3; // capture한 변수는 수정할 수 없음
			System.out.println(n);
		};
		x.doAnything();
	}
	
	// 원시타입 매개변수 캡처
	public static void capturinParameter(int n) {
		Magic x = ()->{
			// n = 3; // capture한 변수는 수정할 수 없음
			System.out.println(n);
		};
		x.doAnything();
	}
	
	public static void scope_test() {
		int n = 1;
		// 람다에 사용한 매개변수 n과 지역변수와 같은 이름이기 때문에 사용할 수 없음
		// IntPredicate isOdd = n ->  ((n & 1) == 1);  // error
		IntPredicate isOdd = num ->  ((num & n) == 1);
		System.out.println(isOdd.test(3));
	}
	
	public static void forCapture_test() {
		/*
		// 색인변수 capture할 수 없음. 계속 변하기 때문
		for(int i=1; i<=10; i++){
			IntUnaryOperator getMultiple = x -> x*i;	// error
			System.out.println(getMultiple.applyAsInt(1));
		}
		*/
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		// foreach for 문의 변수는 루프마다 고정된 값이기 때문에 capture할 수 있음
		for(int n: array){
			IntUnaryOperator getMultiple = x -> x*n;
			System.out.println(getMultiple.applyAsInt(1));
		}
		
	}
	
	public static void main(String[] args) {
		capturingThis();
		capturingReference();
		capturingLocalVariable();
		capturinParameter(10);
		capturinParameter(20);
		scope_test();
		forCapture_test();	
	}
}
