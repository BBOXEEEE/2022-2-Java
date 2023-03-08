import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * Student 클래스 - 부모 클래스: Person
 * 복사 생성자
 */
public final class Student extends Person{
	private int year;
	private Professor supervisor;
	public Student(String name, int year, Professor supervisor) {
		super(name);
		setYear(year);
		setSupervisor(supervisor);
	}
	public Student(Student other) {
		super(other);
		year = other.year;
		supervisor = new Professor(other.supervisor);
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setSupervisor(Professor supervisor) {
		this.supervisor = Objects.requireNonNull(supervisor);
	}
	@Override public String toString() {
		return String.format("(%s, 학년: %d, 지도교수: %s)", super.toString(), year, supervisor.toString());
	}
	@Override public boolean equals(Object other) {
		if(!super.equals(other)) return false;
		Student s = (Student)other;
		return year==s.year && supervisor.equals(s.supervisor);
	}
	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), year, supervisor);
	}
	@Override public int compareTo(Person p) {
		Student s = (Student)p;
		int comp = super.compareTo(p);
		return comp==0? year-s.year: comp;
	}
}
