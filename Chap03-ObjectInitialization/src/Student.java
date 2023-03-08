
/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @author 김상진 
 * @version 2022년도 2학기
 * @file Student.java
 * 대학생의 정보를 유지하는 클래스
 * 학년: 현재 학년, 시작은 1 아니면 3(편입생) >> 시작값 유동변수
 * 입학 연도: 변하지 않는 정보. 학생마다 다를 수 있음 >> 객체 상수
 * 이수학점: 항상 0에서 시작 >> 시작값 고정변
 * 졸업최소이수학점: 모든 학생의 졸업최소이수학점은 150학점. (여기에 선언되어야 하나?) >> 클래스 상수
 * 생성된 학생 수: 생성자에서 증가시킴 >> 클래스 변수
 */
public class Student {
	private int year;								// 학년	
	public final int ENTRANCEYEAR;					// 입학년도	
	private int currentCredit = 0;					// 이수학점	
	public static final int TOTALMINCREDIT = 150;	// 졸업최소이수학점	
	private static int numberOfStudents = 0;		// 생성된 학생 수
	public Student(int year, int entraceYear){		
		this.year = year;		
		ENTRANCEYEAR = entraceYear;	
		++numberOfStudents;
	} // Student(int, int)
	public int getYear() {
		return year;
	}
	public int getCurrentCredit() {
		return currentCredit;
	}
	public static int getNumberOfStudents() {
		return numberOfStudents;
	}
}
