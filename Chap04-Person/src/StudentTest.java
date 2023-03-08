/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * StudentTest 클래스: 4장 상속 실습
 */
public class StudentTest {
	public static void main(String[] args) {
		Person p = new Student("홍길동","201901");
		Student s = new Student("성춘향","201802",2);
		System.out.println(p.getName());
		System.out.println(s.getName());
	}
}
