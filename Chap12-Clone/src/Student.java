import java.lang.reflect.Field;
import java.util.Objects;

final class X implements Cloneable{
	private int n;
	public X(int n) {
		this.n = n;
	}
	public int get() {
		return n;
	}
	public void set(int n) {
		this.n = n;
	}
	@Override public int hashCode() {
		return Integer.hashCode(n);
	}
	@Override public boolean equals(Object other) {
		if(other==null||getClass()!=other.getClass()) return false;
		if(this==other) return true;
		X x = (X)other;
		return n==x.n;
	}
	@Override public String toString() {
		return String.valueOf(n);
	}
	@Override public X clone() {
		X cloned = null;
		try {
			cloned = (X)super.clone();
		}
		catch(CloneNotSupportedException e) {}
		return cloned;
	}
}

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * Student 클래스
 * 멤버 변수 중 final 멤버 변수가 있는 경우
 * 원시타입 멤버 변수가 final: 얕은 복사 (super.clone() 호출) 이후 값을 바꿀 수 없음
 * 객체타입 멤버 변수가 final: 깊은 복사가 가능하지 않음 
 * final인 변수를 deepcopy할 필요가 있을까?
 */
public class Student implements Cloneable, Comparable<Student>{ 
	private String name;
	private int year;
	public final int entranceYear;
	private int currentCredit = 0;
	private final X x;
	public static final int TOTALMINCREDITS = 150;
	public Student(String name, int year, int entranceYear, X x) {
		setName(name);
		setYear(year);
		this.entranceYear = entranceYear;
		this.x = x;
	}
	public void setName(String name) {
		this.name = Objects.requireNonNull(name);
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override public String toString() {
		return String.format("(이름: %s, 학년: %d, 입학년도: %d, 이수학점: %d, X: %s)", 
			name, year, entranceYear, currentCredit, x);
	}
	@Override public boolean equals(Object other) {
		if(other==null||getClass()!=other.getClass()) return false;
		if(this==other) return true;
		Student s = (Student)other;
		return name.equals(s.name) && year==s.year 
				&& entranceYear==s.entranceYear 
				&& currentCredit == s.currentCredit
				&& x.equals(s.x);
	}
	@Override public int hashCode() {
		return Objects.hash(name, year, entranceYear, currentCredit, x);
	}
	@Override public Student clone() {
		Student cloned = null;
		try {
			cloned = (Student)super.clone();
			//cloned.x = x.clone(); // error: x is final
			// 객체타입 
			Field f =  getClass().getDeclaredField("x");
			f.setAccessible(true);
			X cloned_x = x.clone();
			cloned_x.set(3);
			f.set(cloned, cloned_x);
			// 원시타입 
			f =  getClass().getDeclaredField("entranceYear");
			f.setAccessible(true);
			f.setInt(cloned, 2020);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cloned;
	}
	@Override public int compareTo(Student other) {
		return name.compareTo(other.name);
	}
	public static void main(String[] args) {
		Student s1 = new Student("홍길동", 1, 2022, new X(1));
		Student s2 = s1.clone();
		System.out.println(s1);
		System.out.println(s2);
	}
}
