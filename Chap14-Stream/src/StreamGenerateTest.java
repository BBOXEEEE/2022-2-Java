import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2022년도 2학기
 * @author 김상진
 * 스트림의 생성 
 */
public class StreamGenerateTest {
	
	// 일반적인 collection 타입은 stream 메소드를 이용하여 stream 생성
	public static void collectionTest() {
		List<String> fruitList = List.of("banana", "grape", "kiwi", "melon", "lemon", "apple");
		Set<String> fruitSet = Set.of("banana", "grape", "kiwi", "melon", "lemon", "apple");
		Map<String,Integer> fruitMap = Map.of("banana", 1, "grape", 2, "kiwi", 3, 
			"melon", 4, "lemon", 5, "apple", 6);
		
		System.out.println(fruitList.stream().filter(s->s.endsWith("e")).count());
		System.out.println(fruitSet.stream().filter(s->s.length()>5).count());
		System.out.println(fruitMap.entrySet().stream().
			filter(e->e.getKey().length()==5).map(e->e.getValue()).reduce(0, Integer::sum));
	}
	
	public static void iterateTest01() {
		List<Integer> numbers =
			Stream.iterate(3, n->n+3).limit(10).collect(Collectors.toList());
		System.out.println(numbers);
	}
	
	public static void iterateTest02() {
		String word = "abcdefghi";
		String s = IntStream.iterate(0, n->n<word.length(), n->n+2)
			.mapToObj(word::charAt).collect(
			 StringBuilder::new,StringBuilder::append,StringBuilder::append).toString();
			//.mapToObj(word::charAt).map(String::valueOf).collect(Collectors.joining());
		System.out.println(s);
	}
	
	public static void randomGeneration() {
		List<Integer> randoms = 
			Stream.generate(ThreadLocalRandom.current()::nextInt)
				.filter(x->x>0).limit(10).collect(Collectors.toList());
		System.out.println(randoms);
	}
	
	public static void primeGeneration() {
		List<Integer> primes //= Stream.generate(ThreadLocalRandom.current()::nextInt)
			= Stream.generate(()->ThreadLocalRandom.current().nextInt(1000))
			.filter(n->n>0).map(BigInteger::valueOf)
			.filter(n->n.isProbablePrime(10)).map(BigInteger::intValue)
			.limit(10).collect(Collectors.toList());
		System.out.println(primes);
	}
	
	public static void primitiveArrayToStream() {
		int[] numbers = {1,2,5,3,9};
		long count = Arrays.stream(numbers).filter(n->(n&1)==1).count();
		System.out.println(Arrays.toString(numbers)+": 홀수의 개수: "+count);
		count = IntStream.of(numbers).filter(n->(n&1)==0).count();
		System.out.println(Arrays.toString(numbers)+": 짝수의 개수: "+count);
		char[] characters = {'a','x','d','e','g','x'};
		//count = Arrays.stream(characters).filter(c->"aeiou".indexof(c)!=-1).count();  // error
		//count = IntStream.of(characters).filter(Character::isLowerCase).count();	// error
		count = String.valueOf(characters).chars().filter(c->c=='x').count();
		System.out.println(Arrays.toString(characters)+": x 문자 수: "+count);
		count = IntStream.range(0, characters.length).mapToObj(i->characters[i]).filter(c->c=='x').count();
		System.out.println(Arrays.toString(characters)+": x 문자 수: "+count);
		
	}
	
	public static void main(String[] args) {
		collectionTest();
		//iterateTest01();
		//iterateTest02();
		//randomGeneration();
		//primeGeneration();
		//primitiveArrayToStream();
	}

}
