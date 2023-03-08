import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2022년도 2학기
 * @author 김상진
 * Stream의 중간 연산 사용법 
 * 1) sorted, distinct, filter, map
 * 2) filter 결합 방법
 * 3) anyMatch, allMatch
 */
public class IntermediateOperatorTest {
	public static void sorted_test() {
		List<String> list = Arrays.asList("monkey", "zebra", "lion", "tiger", "elephant");
		list = list.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(list);
		list = list.stream().distinct().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
		System.out.println(list);
	}
	public static void filter_test01() {
		int[] array = {1, -1, 3, 2, 5, 10, -4, 0, 6, 20};
		System.out.println(Arrays.stream(array).
			filter(n->(n&1)==1).map(n->n*n).reduce(Integer::sum));
	}
	public static void filter_test02() {
		int[] array = {1, -1, 3, 2, 5, 10, -4, 0, 6, 20};
		// 두 가지 조건 충족
		int[] result = IntStream.of(array).filter(x->x>0).filter(x->x%3==0).toArray(); 
		System.out.println(Arrays.toString(result));
		result = IntStream.of(array).filter(x->x>0&&x%3==0).toArray();
		System.out.println(Arrays.toString(result));
		// 두 가지 조건 중 하나만 만족하여도 ...
		IntPredicate isNegative = x->x<0;
		IntPredicate isMultipleOf3 = x->x%3==0;
		List<IntPredicate> predicates = Arrays.asList(isNegative, isMultipleOf3);
		result = IntStream.of(array).filter(x->x<0||x%3==0).toArray();
		System.out.println(Arrays.toString(result));
		result = IntStream.of(array).filter(isNegative.or(isMultipleOf3)).toArray();
		System.out.println(Arrays.toString(result));
		result = IntStream.of(array).filter(n->predicates.stream().anyMatch(p->p.test(n))).toArray();
		System.out.println(Arrays.toString(result));
		
	}
	
	// stream을 생성하여 사용하면서 원 자료 수정하면 실행 시간 오류
	public static void interference_test() {
		List<String> list = Arrays.asList("monkey", "zebra", "lion", "tiger", "elephant");
		list.stream().filter(s->s.length()==5).forEach(s->list.add("haha"));
		System.out.println(list);
	}
	
	public static List<String> getCities(List<Student> students){
		return students.stream().map(Student::getCity).distinct()
			.collect(Collectors.toList());
	}

	public static List<Student> getStudents(
		List<Student> students, List<Predicate<Student>> predicates){
		return students.stream()
			.filter(s->predicates.stream().allMatch(p->p.test(s)))
			.collect(Collectors.toList());
	}
	
	public static void filter_test03() {
		List<Student> students = Arrays.asList(
			new Student("홍길동",1,"천안","컴퓨터공학부"), 
			new Student("장길산",2,"서울","컴퓨터공학부"),
			new Student("장보고",4,"목포","전기전자통신공학부"), 
			new Student("임꺽정",2,"부산","컴퓨터공학부"));
		List<String> cities = getCities(students);
		System.out.println(cities);
		List<Predicate<Student>> predicates = Arrays.<Predicate<Student>>asList( 
			s->s.getYear()==2, s->s.getDepartment().equals("컴퓨터공학부"));
		List<Student> sophomore = getStudents(students, predicates);
		System.out.println(sophomore);
	}
	
	public static void stream_can_only_be_used_once() {
		List<String> list = Arrays.asList("monkey", "zebra", "lion", "tiger", "elephant");
		Stream<String> tmp = list.stream().distinct();
		System.out.println(tmp.filter(s->s.length()<5).count());
		// 중간 연산을 수행한 stream을 보관할 수 있지만 보관하더라도 한번만 사용할 수 있음
		//System.out.println(tmp.filter(s->s.length()>=5).count());
	}
	
	public static void filter_performance_test() {
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<10_000; ++i)
			list.add(ThreadLocalRandom.current().nextInt());
		long startTime = System.nanoTime();
		list.stream().filter(s->(s&1)==1).filter(s->s>0).count();
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.printf("filter(a).filter(b): %,d%n",totalTime);
		startTime = System.nanoTime();
		list.stream().filter(s->(s&1)==1 && s>0).count();
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.printf("filter(a && b): %,d%n",totalTime);
	}
	
	
	public static void main(String[] args) {
		//sorted_test();
		//filter_test01();
		//filter_test02();
		//filter_test03();
		//interference_test();
		//stream_can_only_be_used_once();
		filter_performance_test();
	}

}
