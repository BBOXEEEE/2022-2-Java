import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Student 클래스: 4장 상속 실습
 * Person이 부모 클래스
 * 생성자에서 부모 생성자를 직접 호출하지 않으면 부모의 기본 생성자
 * 자동 호출됨
 */
public class Student extends Person {
	private String number;
	private int year;
	public Student(String name, String number){
		this(name,number,1);
	}
	public Student(String name, String number, int year) {
		super(name);
		this.number = number;
		this.year = year;
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
		if(year>=1) this.year = year;
	}
}
