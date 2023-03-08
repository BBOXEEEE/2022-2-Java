import java.util.Calendar;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Person 클래스: 객체 반환 함수를 사용할 때 주의할 점
 * 사람>> 상태: 이름, 생일, 
 * getName과 getBirthday의 차이점 분석
 * name 불변객체, birthday는 불변 객체가 아님
 * 보통 date 정보는 Calendar 클래스 대신에 불변 클래스인 LocalDate를 더 많이 사용함
 * 참조 타입의 getter 문제를 보여주기 위해 Calendar 타입을 사용하고 있음
 */
public class Person {
	private String name;
	private Calendar birthday;
	public Person(String name) {
		setName(name);
	}
	public Person(String name, Calendar birthday) {
		setName(name);
		this.birthday = birthday;
		//this.birthday = (Calendar) birthday.clone();
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName(){
		return name;
	} // ok
	public Calendar getBirthday(){
		return birthday;
		//return (Calendar) birthday.clone();
	} // problem
}
