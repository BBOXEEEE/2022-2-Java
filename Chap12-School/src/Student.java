import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * Student 클래스 - 부모 클래스: Person
 */
public final class Student extends Person{
	private int year;
	private Professor supervisor;
	public Student(String name, int year, Professor supervisor) {
		super(name);
		setYear(year);
		setSupervisor(supervisor);
	}
	public void setYear(int year) {
		if(year>=1992 && year<2100) this.year = year;
	}
	public void setSupervisor(Professor supervisor) {
		this.supervisor = Objects.requireNonNull(supervisor);
	}
	@Override public String toString() {
		return String.format("학생: %s, %d, %s", getName(), year, supervisor.getName());
	}
	@Override public boolean equals(Object other) {
		if(!super.equals(other)) return false;
		Student s = (Student)other;
		return year==s.year && supervisor.equals(s.supervisor);
	}
	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), year, supervisor.hashCode());
	}
	@Override public Student clone() {
		Student cloned = null;
		try {
			cloned = (Student)super.clone();
			cloned.supervisor = supervisor.clone();
		}
		catch(CloneNotSupportedException e) {}
		return cloned;
	}
	@Override public int compareTo(Person other) {
		Student s = (Student)other;
		int comp = super.compareTo(other);
		return comp==0? year-s.year: comp;
	}
}
