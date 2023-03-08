import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2022년도 2학기
 * @author 김상진
 * 일반 스트림과 parallel stream의 속도 비교 
 */
public class ParallelTest {
	
	public static void normalStringTest(List<String> list) {
		long startTime = System.nanoTime();
		System.out.println(
			list.stream().
				filter(s->s.startsWith("a")).count()
		);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.printf("string test using stream: %,d%n",totalTime);
	}
	
	public static void parallelStringTest(List<String> list) {
		long startTime = System.nanoTime();
		System.out.println(
			list.parallelStream().
				filter(s->s.startsWith("a")).count()
		);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.printf("string test using parallelstream: %,d%n",totalTime);
	}
	
	public static void normalIntTest(int[] list) {
		long startTime = System.nanoTime();
		System.out.println(
			Arrays.stream(list).
				filter(n->(n&1)==1).count()
		);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.printf("Int test using Arrays.stream: %,d%n",totalTime);
	}
	
	public static void normalIntTest_different(int[] list) {
		long startTime = System.nanoTime();
		System.out.println(
			IntStream.of(list).
				filter(n->(n&1)==1).count()
		);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.printf("Int test using IntStream: %,d%n",totalTime);
	}
	
	public static void parallelIntTest(int[] list) {
		long startTime = System.nanoTime();
		System.out.println(
			Arrays.stream(list).parallel().
				filter(n->(n&1)==1).count()
		);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.printf("Int test using Arrays.stream, parallel: %,d%n",totalTime);
	}
	
	public static void parallelIntTest_different(int[] list) {
		long startTime = System.nanoTime();
		System.out.println(
			IntStream.of(list).parallel().
				filter(n->(n&1)==1).count()
		);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.printf("Int test using IntStream, parallel: %,d%n",totalTime);
	}
	
	public static int[] createRandomIntList() {
		return IntStream.generate(()->ThreadLocalRandom.current().nextInt(1000))
			.limit(1000).toArray();
	}
	
	public static char generateRandomCharacter() {
		return (char)(ThreadLocalRandom.current().nextInt(26)+'a');
	}
	
	public static String generateRandomString() {
		return Stream.generate(()->""+generateRandomCharacter())
			.limit(8).collect(Collectors.joining());
	}
	
	public static List<String> createRandomStringList(){
		return Stream.generate(ParallelTest::generateRandomString)
			.limit(1000).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		int[] list = createRandomIntList();
		normalIntTest(list);
		normalIntTest_different(list);
		parallelIntTest(list);
		parallelIntTest_different(list);
		List<String> sList = createRandomStringList();
		normalStringTest(sList);
		parallelStringTest(sList);
	}
}
