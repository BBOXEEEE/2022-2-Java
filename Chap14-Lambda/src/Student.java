import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2022년도 2학기
 * @author 김상진
 *
 */
public class Student{
	private String name;
	private String number;
	private int year;
	public Student(String name, String number){
		this(name,number,1);
	}
	public Student(String name, String number, int year) {
		setName(name);
		setNumber(number);
		setYear(year);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override public String toString() {
		return String.format("(%s, %s, %d)", name==null? "": name, number, year);
	}
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
			new Student("홍길동","202001",2),
			new Student("성춘향","202002",2),
			new Student("김장철","202101",1),
			new Student("홍길동","202003",1),
			new Student("성춘향","201901",3),
			new Student("장백산","202003",2),
			new Student("임꺽정","201801",4)
		);
		//Collections.sort(students, Comparator.comparing(Student::getName).thenComparing(Student::getYear).reversed());
		Collections.sort(students, Comparator.comparing(Student::getName).thenComparing(
				Comparator.comparingInt(Student::getYear).reversed()));
		
		System.out.println(students);
	}
}

