import java.util.Arrays;
import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * 제12장 접근제어, Object 클래스
 * Student 클래스
 * 배열 타입의 멤버변수가 있을 때 hashCode, equals, clone, toString의 구현 
 * 원시타입인 경우 Arrays를 이용하면 됨
 * 객체배열인 경우에는 올바르게 깊은 복사를 해야 하면 각 요소를 복제해야 함
 */
public final class Student extends Person{
	private int year;
	private int[] scores = null;
	public Student(String name, int year) {
		super(name);
		this.year = year;
	}
	public void setScores(int... scores) {
		if(scores.length==0) throw new IllegalArgumentException();
		this.scores = scores;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString(){
		return String.format("(%s, 학년: %d, 점수: %s)", super.toString(), year, Arrays.toString(scores));
	}
	// 배열은 Objects.hash에 바로 전달하면 올바른 방법이 아님
	// 배열에 대해 hashCode를 호출할 수 있는데, 이 경우 Object의 hashCode를 호출함
	// Object의 hashCode는 객체가 저장된 주소를 이용함 (내용 기반이 아님)
	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), year, Arrays.hashCode(scores));
	}
	@Override
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		Student s = (Student)o;
		return year == s.year && Arrays.equals(scores, s.scores);
	}
	@Override
	public Student clone() {
		Student cloned = null;
		try {
			cloned = (Student)super.clone();
			cloned.scores = scores.clone();
		}
		catch(CloneNotSupportedException e) {	
		}
		return cloned;
	}
}
