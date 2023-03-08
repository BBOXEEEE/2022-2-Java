import java.util.Objects;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Student 클래스: 5장 예외처리 연습
 * Objects 클래스 활용 연습
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
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = Objects.requireNonNullElse(name, "이름없음");
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = Objects.requireNonNull(number);
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return String.format("(%s, %s, %d)", name, number, year);
	}
}
