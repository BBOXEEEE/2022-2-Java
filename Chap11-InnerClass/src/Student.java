import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Student 클래스: 11장 내부 클래스 실습 
 * ComparatorTest에서 사용함
 */
public class Student implements Comparable<Student>{
	private String name;
	private String number;
	private int year;
	public Student(String name, String number){
		this(name,number,1);
	}
	public Student(String name, String number, int year) {
		this.name = Objects.requireNonNull(name);
		this.number = Objects.requireNonNull(number);
		this.year = year;
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
	@Override
	public int compareTo(Student o) {
		return name.compareTo(o.name);
	}
	@Override
	public String toString() {
		return String.format("(%s %s %d)", name, number, year);
	}
}
