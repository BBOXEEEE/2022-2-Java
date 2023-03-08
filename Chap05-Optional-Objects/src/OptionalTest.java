import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * ExceptionTest 클래스: 5장 예외처리 연습
 * Optional 활용하기
 */
public class OptionalTest {
	// Optional을 사용하지 않은 이전 방법
	public static Student getStudentsByName(List<Student> students, String name){
		for(Student student: students)
			if(student.getName().equals(name)) return student;
		return null;
	}
	public static Optional<Student> getStudentsByNameUsingOptional(List<Student> students, String name){
		for(Student student: students)
			if(student.getName().equals(name)) 
				return Optional.<Student>of(student);
		return Optional.<Student>empty();
	}
	// 없는 경우 빈 리스트 반환
	public static List<Student> getStudentsByYear(List<Student> students, int year){
		List<Student> result = new ArrayList<>();
		for(Student student: students)
			if(student.getYear()==year) result.add(student);
		return result;
	}
	public static void studentTest() {
		Student s1 = new Student("홍길동","201901",1);
		Student s2 = new Student(null,"201902",1);
		System.out.println(s1.getName());
		System.out.println(s2.getName());
		Student s3 = new Student(null,null,1);
		System.out.println(s3.getName());
	}
	public static void optionalTest() {
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("홍길동","201901",1));
		list.add(new Student("성춘향","201902",1));
		list.add(new Student("장길산","201801",2));
		list.add(new Student("임꺽정","201701",3));
		list.add(new Student("심순애","201702",3));
		list.add(new Student("서장금","201903",1));
		list.add(new Student("이몽룡","201802",2));
		list.add(new Student("전우치","201904",1));
		
		Student student = getStudentsByName(list,"김춘추");
		// System.out.println(student);	// NullPointerException
		if(student!=null) System.out.println(student);
		
		Optional<Student> o 
			= getStudentsByNameUsingOptional(list,"김춘추");
		// System.out.println(o.get()); // NoSuchElementException
		o.ifPresentOrElse(System.out::println, 
			()->System.out.println("김춘추 학생 없음"));
		if(o.isPresent()) System.out.println(o.get());
		
		o = getStudentsByNameUsingOptional(list,"서장금");
		System.out.println(o);
		o.ifPresent(System.out::println);
		
		ArrayList<Student> sList 
			= (ArrayList<Student>) getStudentsByYear(list, 4);
		for(var s: sList) System.out.println(s.getName());
	}
	public static void main(String[] args) {
		optionalTest();
	}
}
