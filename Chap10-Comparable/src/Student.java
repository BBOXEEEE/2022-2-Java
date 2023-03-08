/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Student 클래스: 10장 Comparable 추가
 * 부모가 Comparable을 구현하고 있으므로 Comparable 추가 불필요
 * 부모가 Comparable을 구현하고 있으므로 compareTo를 재정의할 때
 * 인자가 Student 타입이 아니라 Person임
 */
public class Student extends Person{
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
		this.number = number;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	// 인자가 Student가 아니라 Person임을 주의해야 함
	// 타입 변환 필요
	@Override public int compareTo(Person p) {
		Student s = (Student)p;
		int comp = super.compareTo(p);
		return comp==0? year-s.year: comp;
	}
}
