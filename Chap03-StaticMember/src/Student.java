import java.util.Objects;
/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Student 클래스: 3장 static 멤버변수 연습
 * 학생 정보>> 상태: 이름, 학번, 행위: 
 * 학번: 생성된 순서에 따라 1, 2, ...
 * 초기화 블록을 이용
 */
public class Student {
	private String name;
	private int studentNumber;
	private static int lastAssignedNumber = 1;
	{
		studentNumber = lastAssignedNumber;
		++lastAssignedNumber;
	}
	public Student(){
		this("무명");
	} // Student()
	public Student(String name){
		this.name = Objects.requireNonNull(name);
	} // Student(int)
	public String getName() {
		return name;
	}
	public int getStudentNumber() {
		return studentNumber;
	}
}
