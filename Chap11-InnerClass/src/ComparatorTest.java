import java.util.Arrays;
import java.util.Comparator;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 메소드 내부에 내부 클래스 정의하기 
 * sortByYear: 내부 클래스 정의
 * sortByNumber: 익명 클래스 정의, 변수 사용
 * sortByYearAndName: 익명 클래스 정의, 변수도 사용하지 않음
 * 지금은 이와 같은 내부 클래스 대신에 람다 표현식을 사용함
 */
public class ComparatorTest {
	public static void sortByYear(Student[] students) {
		class StudentYearComparator implements Comparator<Student>{
			@Override public int compare(Student s1, Student s2) {
				return s1.getYear() - s2.getYear();
			}
		};
		Arrays.sort(students, new StudentYearComparator());	
	}
	// 익명 클래스: 부모 클래스나 그것이 구현하는 interface를 이용하여
	// 생성자 호출을 하여 클래스를 정의하고 있음
	public static void sortByNumber(Student[] students) {
		var numberComparator = new Comparator<Student>(){
			@Override public int compare(Student s1, Student s2) {
				return s1.getNumber().compareTo(s2.getNumber());
			}
		};
		Arrays.sort(students, numberComparator);
	}
	public static void sortByYearAndName(Student[] students) {
		Arrays.sort(students, new Comparator<Student>(){
				@Override public int compare(Student s1, Student s2) {
					int comp = Integer.compare(s1.getYear(),s2.getYear());
					return (comp==0)? s1.compareTo(s2): comp;
				}
			}
		);
	}
	public static void main(String[] args) {
		Student[] students = {
			new Student("홍길동", "201901", 1),
			new Student("성춘향", "201902", 1),
			new Student("이몽룡", "201801", 2),
			new Student("장길산", "201802", 2),
			new Student("임꺽정", "201701", 3),
			new Student("전우치", "201601", 4),
		};
		Arrays.sort(students);
		System.out.println(Arrays.toString(students));
		sortByYear(students);
		System.out.println(Arrays.toString(students));
		sortByNumber(students);
		System.out.println(Arrays.toString(students));
		sortByYearAndName(students);
		System.out.println(Arrays.toString(students));
	}

}
