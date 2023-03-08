import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2022년도 2학기
 * @author 김상진
 * Optional 사용법
 */
public class OptionalTest {
	private static class Product{
		private int price;
		public int getPrice() {
			return price;
		}
	}
	
	public static List<Student> getStudents(List<Student> students, Predicate<Student> test){
		return students.stream().filter(test).collect(Collectors.toList());
	}
	public static Optional<Student> getStudentByName(List<Student> students, String name){
		for(Student student: students)
			if(student.getName().equals(name)) return Optional.<Student>of(student);
		return Optional.<Student>empty();
	}
	public static void getStudentsTest(List<Student> students) {
		List<Student> list = getStudents(students, s->s.getYear()==4);
		list.forEach(System.out::println);
	}
	public static void getStudentByNameTest(List<Student> students) {
		Optional<Student> student = getStudentByName(students, "홍길동");
		student.ifPresent(System.out::println);
		student.ifPresentOrElse(System.out::println, ()->System.out.println("해당 이름의 학생이 없음"));
	}
	public static Optional<Integer> getDiscountPrice(Product item, String id){
		return Optional.empty();
	}
	public static void orElseTest() {
		Product item = new Product();
		//int price = getDiscountPrice(item, "sangjin").orElse(item.getPrice());
		int price = getDiscountPrice(item, "sangjin").orElseGet(item::getPrice);
		System.out.println(price);
	}
	
	public static void main(String[] args) {
		
	}
}
