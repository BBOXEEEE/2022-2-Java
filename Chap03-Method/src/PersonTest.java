import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 테스트 프로그램
 * 자바는 객체를 항상 참조 타입에 유지함
 * 멤버 변수로 다른 객체를 유지할 때 그것의 getter, setter 구현할 때 주의할 점
 */
public class PersonTest {
	public static void printDate(Calendar date) {
		System.out.printf("%d년 %d월 %d일%n", 
				date.get(Calendar.YEAR), 
				date.get(Calendar.MONTH)+1, 
				date.get(Calendar.DAY_OF_MONTH));
	}
	public static void main(String[] args) {
		// 월 정보는 0기반, 1월이 0 >> 주의사항
		Calendar birthday = new GregorianCalendar(2022,11,25);;
		Person kildong = new Person("홍길동", birthday);
		System.out.println(kildong.getName());
		printDate(kildong.getBirthday());
		birthday.set(Calendar.MONTH, 0);
		
		// 문자열은 불변 객체이기 때문에 참조로 반환하여도 문제가 없음
		@SuppressWarnings("unused")
		String name = kildong.getName();
		name = "성춘향";
		System.out.println(kildong.getName());
		printDate(kildong.getBirthday());
		
		birthday = kildong.getBirthday();
		birthday.set(Calendar.DAY_OF_MONTH,1);
		System.out.println(kildong.getName());
		printDate(kildong.getBirthday());
	}
}
