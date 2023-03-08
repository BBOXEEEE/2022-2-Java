import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2022년도 2학기
 * @author 김상진
 * Stream의 중간 연산 flatMap 사용법 
 * 원시타입에 대해서는 flatMapToInt, flatMapToLong, flatMapToDouble 사용
 */
public class FlapMapTest {
	// 문자 a 또는 A의 등장 빈도
	public static void test1() {
		long count = Stream.of("Firmino", "Milner", "Mane", "Salah")
			.flatMap(s -> s.chars().mapToObj(Character::toLowerCase))
			//.filter(ch -> ch == 'a' || ch == 'A')
			.filter(ch -> ch == 'a')
			.count();
		System.out.println(count);
	}
	// 문자 a 또는 A의 등장 빈도
	public static void test2() {
		long count = Stream.of("Firmino", "Milner", "Mane", "Salah")
			.flatMapToInt(s -> s.chars())
			.filter(ch -> ch == 'a' || ch == 'A')
			.count();
		System.out.println(count);
	}
	// 문자 a 또는 A의 등장 빈도
	public static void test3() {
		long count = Stream.of("Firmino", "Milner", "Mane", "Salah")
			.flatMapToInt(name->IntStream.range(0, name.length()).map(name::charAt))
			.filter(ch -> ch == 'a' || ch == 'A')
			.count();
		System.out.println(count);
	}
	// 문자 a 또는 A의 등장 빈도
	public static void test4() {
		long count = Stream.of("Firmino", "Milner", "Mane", "Salah")
			.flatMapToInt(s -> s.chars().filter(ch -> ch == 'a' || ch == 'A'))
			.count();
		System.out.println(count);
	}
	
	public static void test5() {
		int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
		int[] oddNumbers = Stream.of(array)
			.flatMapToInt(a->Arrays.stream(a).filter(n->(n&1)==1)).toArray();
		System.out.println(Arrays.toString(oddNumbers));
	}
	public static void main(String[] args) {
		//test1();
		//test2();
		//test3();
		//test4();
		test5();
	}

}
