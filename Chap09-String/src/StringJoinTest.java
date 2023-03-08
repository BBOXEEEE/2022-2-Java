import java.util.Arrays;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기 
 * @author 김상진
 * 여러 개의 문자열 결합하는 방법
 * + 연산자를 이용하는 것은 매우 비효율적임
 * 가장 효과적인 방법은 전체 길이를 계산한 후에 해당 용량으로 초기화
 * StringBuilder 생성하여 append하는 것임
 * 중간에 구분자를 추가해야 하면 StringJoiner나 String.join 메소드 이용
 */
public class StringJoinTest {
	public static void test_String_add(String[] sList) {
		long startTime = 0, stopTime = 0;
		startTime = System.nanoTime();
		String joined = "";
		for(var s: sList) joined += s;
		stopTime = System.nanoTime();
		System.out.println(joined.length());
		System.out.printf("+ operator: %,d%n", stopTime-startTime);
	}
	
	public static void test_String_join(String[] sList) {
		long startTime = 0, stopTime = 0;
		startTime = System.nanoTime();
		String joined = String.join("", sList);
		stopTime = System.nanoTime();
		System.out.println(joined.length());
		System.out.printf("String::join: %,d%n", stopTime-startTime);
	}
	
	public static void test_StringJoiner(String[] sList) {
		long startTime = 0, stopTime = 0;
		startTime = System.nanoTime();
		StringJoiner builder = new StringJoiner("");
		for(var s: sList) builder.add(s);		
		stopTime = System.nanoTime();
		System.out.println(builder.toString().length());
		System.out.printf("StringJoiner: %,d%n", stopTime-startTime);
	}
	
	public static void test_StringBuilder(String[] sList) {
		long startTime = 0, stopTime = 0;
		startTime = System.nanoTime();
		int length = 0;
		for(var s: sList) length += s.length();
		StringBuilder builder = new StringBuilder(length);
		for(var s: sList) builder.append(s);		
		stopTime = System.nanoTime();
		System.out.println(builder.toString().length());
		System.out.printf("StringBuilder: %,d%n", stopTime-startTime);
	}
	
	public static void test_stream(String[] sList) {
		long startTime = 0, stopTime = 0;
		startTime = System.nanoTime();
		String joined = Arrays.stream(sList).collect(Collectors.joining(""));		
		stopTime = System.nanoTime();
		System.out.println(joined.toString().length());
		System.out.printf("Stream: %,d%n", stopTime-startTime);
	}
	
	public static String[] createRandomStringArray() {
		String[] ret = new String[1000];
		for(int i=0; i<1000; ++i) {
			int length = ThreadLocalRandom.current().nextInt(30)+5;
			StringBuilder builder = new StringBuilder(length);
			for(int j=0; j<length; ++j) {
				char c = (char)('a'+ThreadLocalRandom.current().nextInt(26));
				builder.append(c);
			}
			ret[i] = builder.toString();
		}
		return ret;
	}
	
	public static void main(String[] args) {
		String[] sList = createRandomStringArray();
		test_String_add(sList);
		test_String_join(sList);
		test_StringBuilder(sList);
		test_StringJoiner(sList);
		test_stream(sList);
	}

}
