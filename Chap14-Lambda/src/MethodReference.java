import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.ToIntBiFunction;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2022년도 2학기
 * @author 김상진
 * 메소드 참조: 기존 함수를 호출하는 람다 표현식을 간결하게 작성하는 방법
 */

class StringUtil{
	public int countVowels(String word) {
		return (int)word.toLowerCase().chars().filter(c->"aeiou".indexOf(c)!=-1).count();
	}
	public int countLowerCase(String word) {
		return (int)word.chars().filter(Character::isLowerCase).count();
	}
}

public class MethodReference {
	// Type 1. objectRef::instanceMethod
	// 참고. StringUtil의 메소드는 일반 객체 메소드 대신 static 메소드로 정의해야 하는 메소드들임
	public static void type1Example() {
		StringUtil util = new StringUtil();
		List<String> list = Arrays.asList("monkey", "zebra", "lion", "tiger", "elephant"); 
		Collections.sort(list,Comparator.comparingInt(util::countVowels));
		list.forEach(System.out::println);
		Collections.sort(list,Comparator.comparingInt(util::countLowerCase));
		System.out.println(list);
	}
	// Type 2. TypeName::staticMethod
	public static void type2Example() {
		DoubleBinaryOperator pow = Math::pow;
		System.out.println(pow.applyAsDouble(2, 10));
	}
	// Type 3. ClassName::instanceMethod
	public static void type3Example01() {
		List<String> list = Arrays.asList("monkey", "zebra", "lion", "tiger", "elephant"); 
		Collections.sort(list, Comparator.comparingInt(String::length));
	}
	public static void type3Example02() {
		ToIntBiFunction<String, String> compare = String::compareTo;
		System.out.println(compare.applyAsInt("apple", "banana"));
	}
	
	public static void constructReferenceTest() {
		IntFunction<StringBuilder> createStringBuilder = StringBuilder::new;
		StringBuilder s = createStringBuilder.apply(32);
		s.append("hello");
		IntFunction<int[]> arrayCreator1 = capacity -> new int[capacity];
		int[] list1 = arrayCreator1.apply(10); 
		IntFunction<int[]> arrayCreator2 = int[]::new; 
		int[] list2 = arrayCreator2.apply(10); 
		list1[0] = 1;
		list2[0] = 1;
	}
	
	public static void comparingExample() {
		List<Student> list = 
			Arrays.asList(new Student("홍길동","2019001",1),new Student("장길산","2018001",2),
				new Student("장보고","2015001",4),new Student("임꺽정","2019002",1),
				new Student("성춘향","2019005",1),new Student("홍길동","2016001",3)
			);
		ArrayList<Student> students = new ArrayList<>(list);
		System.out.println(students);
		students.sort(Comparator.comparing(Student::getName));
		System.out.println(students);
		students.sort(Comparator.comparing(Student::getName).thenComparing(Student::getNumber));
		System.out.println(students);
		students.add(new Student(null,"2017001",3));
		students.sort(Comparator.comparing(Student::getName, Comparator.nullsFirst(Comparator.naturalOrder())));
		System.out.println(students);
		
	}
	
	public static void main(String[] args) {
		type1Example();
		//constructReferenceTest();
		//comparingExample();
	}
}
