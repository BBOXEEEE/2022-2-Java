import java.util.Arrays;
import java.util.Comparator;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2022년도 2학기
 * @author 김상진 
 * Comparator 실습
 * 10장 인터페이스 두 번째 이야기
 * 특정 클래스에 Comparable Interface를 구현하면 비교 방식이 고정됨
 * 이를 극복하는 다양한 방법
 */

class StudentNumberComparator implements Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		return o1.getNumber().compareTo(o2.getNumber());
	}
}

public class ComparableTest {

	public static void main(String[] args) {
		Student[] students = {
			new Student("홍길동", "2018001", 1),
			new Student("임꺽정", "2018005", 1),
			new Student("김유신", "2016001", 3),
			new Student("홍길동", "2016009", 3),
			new Student("장보고", "2015001", 2),
			new Student("장길산", "2015006", 4),
		};
		Arrays.sort(students);
		System.out.println(Arrays.toString(students));
		Arrays.sort(students, new StudentNumberComparator());
		System.out.println(Arrays.toString(students));
		Arrays.sort(students, new Comparator<Student>(){
			@Override public int compare(Student o1, Student o2) {
				return Integer.compare(o1.getYear(),o2.getYear());
			}
		});
		System.out.println(Arrays.toString(students));
		Arrays.sort(students, (s1,s2)->s1.getNumber().compareTo(s2.getNumber()));
		System.out.println(Arrays.toString(students));
		Arrays.sort(students, (s1,s2)->{
			int comp = s1.getYear()-s2.getYear();
			return (comp==0)? s1.compareTo(s2): comp;
		});
		System.out.println(Arrays.toString(students));
		Arrays.sort(students, Comparator.comparing(Student::getYear));
		System.out.println(Arrays.toString(students));
	}

}
