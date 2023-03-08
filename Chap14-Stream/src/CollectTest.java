import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2022년도 2학기
 * @author 김상진
 * Stream의 최종 연산 collect 사용법
 */

public class CollectTest {	
	
	public static void toArray_test() {
		List<String> list = Arrays.asList("lion","tiger","zebra","elephant");
		String[] result = 
			list.stream().filter(s->s.length()>4).toArray(String[]::new);
		System.out.println(Arrays.toString(result));
		
		// char 배열로 모으는 것은 힘듦
		Character[] alpha = list.stream().flatMap(w->w.chars().boxed()).distinct()
			.map(c->(char)c.intValue()).toArray(Character[]::new);
		// 다음과 같이 정수 배열로는 가능
		//int[] alpha = list.stream().flatMap(w->w.chars().boxed()).distinct()
		//	.mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(alpha));
		
		int[] array = {3,2,5,4,8,10,11,6,13};
		array = IntStream.of(array).filter(x->(x&1)==1).toArray();
		System.out.println(Arrays.toString(array));
		
		int[] nums = IntStream.rangeClosed(1, 10).toArray();
		System.out.println(Arrays.toString(nums));
	}
	
	public static void toList_test01() {
		List<String> list = Arrays.asList("lion","tiger","zebra","elephant");
		List<String> result = 
			list.stream().map(String::toUpperCase).collect(Collectors.toList());
		result.forEach(System.out::println);
		List<String> fruits = Arrays.asList("apple","melon","kiwi","mango", "orange", "apple", 
				"cherry", "banana");
		ArrayList<String> fruit5 = fruits.stream().distinct()
					.filter(s->s.length()==5).map(String::toUpperCase)
						.collect(Collectors.toCollection(ArrayList<String>::new));
		System.out.println(fruit5);
		LinkedList<String> fruit5_ll = fruits.stream().distinct()
				.filter(s->s.length()==5).map(String::toUpperCase)
				.collect(LinkedList<String>::new, LinkedList<String>::push, LinkedList<String>::addAll);
		System.out.println(fruit5_ll);
	}
	
	// collect(Collectors.toList()) ==> modifiable list
	// toList() ==> unmodifiable list
	public static void toList_test02() {
		List<String> list = Arrays.asList("lion","tiger","zebra","elephant");
		List<String> result1 = 
			list.stream().map(String::toUpperCase).collect(Collectors.toList());
		List<String> result2 =
			list.stream().map(String::toUpperCase).toList();
		result1.set(0, "HIPPO");
		result2.set(0, "HIPPO"); // exception
	}
	
	public static void toSet_test() {
		List<String> animals = Arrays.asList("lion","tiger","lion","zebra","elephant","zebra");
		Set<String> animalSet = animals.stream().collect(Collectors.toSet());
		System.out.println(animalSet.size());
		System.out.println(animalSet.contains("zebra"));
	}
	
	public static void toMap_test01() {
		List<Student> list = Arrays.asList(
			new Student("홍길동",1), new Student("장길산",2),
			new Student("장보고",4), new Student("임꺽정",1));
		Map<String,Student> studentMap = list.stream()
			.collect(Collectors.toMap(Student::getName, Function.identity()));
		System.out.println(studentMap.get("장보고"));
	}
	
	public static void toMap_test02() {
		List<Student> list = Arrays.asList(
			new Student("홍길동",1),new Student("장길산",2),
			new Student("장보고",4),new Student("임꺽정",1),
			new Student("장보고",3));
		Map<String,Student> studentMap =
			list.stream().collect(
				Collectors.toMap(Student::getName, Function.identity(), 
					(oldV,newV)->oldV, TreeMap<String,Student>::new));
		System.out.println(studentMap.size());
		System.out.println(studentMap.get("장보고").getYear());
	}
	
	public static void toMap_test03() {
		List<String> animals = Arrays.asList("lion","tiger","lion","zebra","elephant","tiger");
		Map<String, Long> animalCountMap = animals.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		for(var entry: animalCountMap.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}	
	}
	
	public static void grouping_test() {
		List<Player> list = Arrays.asList(new Player("양의지", "NC", PlayerType.BATTER), 
				new Player("정수빈", "두산", PlayerType.BATTER), 
				new Player("김재환", "두산", PlayerType.BATTER),
				new Player("곽빈", "두산", PlayerType.PITCHER));
		Map<String, List<Player>> teamMap = list.stream()
			.collect(Collectors.groupingBy(Player::getTeam));
		List<Player> doosan = teamMap.get("두산");
		doosan.forEach(System.out::println);
		Map<String, Long> playerCount = list.stream()
			.collect(Collectors.groupingBy(Player::getTeam, Collectors.counting()));
		System.out.println(playerCount.get("두산"));
		
		Map<PlayerType, Set<Player>> playerTypeMap = list.stream()
				.collect(Collectors.groupingBy(Player::getType, Collectors.toSet()));
		Set<Player> batter = playerTypeMap.get(PlayerType.BATTER);
		batter.forEach(System.out::println);
	}
	
	public static void partitioning_test() {
		List<Player> list = Arrays.asList(new Player("양의지", "NC", PlayerType.BATTER), 
			new Player("정수빈", "두산", PlayerType.BATTER), 
			new Player("김재환", "두산", PlayerType.BATTER),
			new Player("곽빈", "두산", PlayerType.PITCHER));
		Map<Boolean, List<Player>> pitcherBatterList = list.stream()
			.collect(Collectors.partitioningBy(p -> p.getType()==PlayerType.BATTER));
		List<Player> pitchers = pitcherBatterList.get(false);
		pitchers.forEach(System.out::println);
	}
	
	public static void collect_test() {
		List<Student> list = Arrays.asList(
			new Student("홍길동",1), new Student("장길산",2),
			new Student("장보고",4), new Student("임꺽정",1));
		List<Student> students = list.stream().sorted(Comparator.comparing(Student::getName))
			.collect(LinkedList<Student>::new,LinkedList<Student>::push,LinkedList<Student>::addAll);
		System.out.println(students);
		PriorityQueue<Student> pq = list.stream()
			.collect(()->{
				PriorityQueue<Student> queue 
					= new PriorityQueue<>(Comparator.comparingInt(Student::getYear).reversed());
				return queue;
			}, PriorityQueue<Student>::add, PriorityQueue<Student>::addAll);
		while(!pq.isEmpty())
			System.out.println(pq.poll());
	}
	
	public static void main(String[] args) {
		toArray_test();
		//toList_test01();
		//toList_test02();
		//toSet_test();
		//toMap_test01();
		//toMap_test02();
		//grouping_test();
		//partitioning_test();
		//collect_test();
	}

}
