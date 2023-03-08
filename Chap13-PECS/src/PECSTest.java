import java.util.Arrays;
import java.util.List;

/**
 *  @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 13장 예제
 *  @version 2022년도 2학기
 *  @author 김상진 
 *  PECSTest.java
 *  PECS 규칙
 */
public class PECSTest {
	// Dog 포함 Dog의 후손을 타입 인자로 사용하는 List는 전달 가능
	// extends는 producer일 때 적합
	public static void foo(List<? extends Dog> list) {
		//list.add(new Dog("썬더")); // list가 실제 어떤 타입일지 알 수 없기 떄문 (PECS 규칙)
		for(Dog p: list)
			System.out.println(p.makeSound());
	}
	
	public static void foo_test() {
		var dogs = Arrays.asList(new Dog("미미"), new Dog("방울"), new Dog("장군"));
		var shihtzu = Arrays.asList(new Shihtzu("미미"), new Shihtzu("방울"), new Shihtzu("장군"));
		var cats = Arrays.asList(new Cat("프리"), new Cat("쫄쫄"), new Cat("점순"));
		foo(dogs);
		foo(shihtzu);
		// foo(cats);
		//아래와 같은 비교는 가능하지 않음
		//System.out.println(dogs instanceof List<Dog>);
		System.out.println(dogs instanceof List<?>);
		System.out.println(cats instanceof List<?>);
		System.out.println(dogs instanceof List);
	}
	
	// Cat 포함 Cat의 조상을 타입 인자로 사용하는 List는 전달 가능
	// super는 consumer일 때 적합
	public static void bar(List<? super Cat> list) {
		list.add(new Cat("가필드"));
		for(var p: list) {
			Cat c = (Cat)p;
			System.out.println(c.makeSound());
		}
	}
	
	public static void bar_test() {
		var dogs = Arrays.asList(new Dog("미미"), new Dog("방울"), new Dog("장군"));
		var shihtzu = Arrays.asList(new Shihtzu("미미"), new Shihtzu("방울"), new Shihtzu("장군"));
		var cats = Arrays.asList(new Cat("프리"), new Cat("쫄쫄"), new Cat("점순"));
		var siameses = Arrays.asList(new Siamese("프리"), new Siamese("쫄쫄"), new Siamese("점순"));
		bar(cats);
		// bar(dogs);
		// bar(siameses);
		baz(dogs);
		baz(shihtzu);
		baz(cats);
		baz(siameses);
	}
	
	public static void baz(List<?> list) { // List<? extends Object> list
		//list.add(new Dog("주주")); // list가 실제 어떤 타입일지 알 수 없기 떄문
		//list.add(new Cat("코코"));
		//list.addAll(Arrays.asList(new Cat("호호"), new Cat("히히")));
		for(var p: list) {
			System.out.println(p);
		}
	}
	
	public static void baz_test() {
		var dogs = Arrays.asList(new Dog("미미"), new Dog("방울"), new Dog("장군"));
		var shihtzu = Arrays.asList(new Shihtzu("미미"), new Shihtzu("방울"), new Shihtzu("장군"));
		var cats = Arrays.asList(new Cat("프리"), new Cat("쫄쫄"), new Cat("점순"));
		var siameses = Arrays.asList(new Siamese("프리"), new Siamese("쫄쫄"), new Siamese("점순"));
		baz(dogs);
		baz(shihtzu);
		baz(cats);
		baz(siameses);
	}
	
	public static <T extends Comparable<? super T>> T max(T[] list){
		T max = list[0];
		for(int i=1; i<list.length; ++i) if(max.compareTo(list[i])<0) max = list[i];
		return max;
	}
	
	public static <T> void copy(List<? extends T> src, List<? super T> dest) {
		for(var item: src)
			dest.add(item);
	}
	
	public static void main(String[] args) {
		foo_test();
		bar_test();
		baz_test();
	}
}
