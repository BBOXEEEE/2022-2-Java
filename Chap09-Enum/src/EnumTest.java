/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기 
 * @author 김상진
 * Weekday, Size 열거형 사용 예제
 */
public class EnumTest {
	public static void sizeTest() {
		System.out.println("Size Test");
		Size size = Size.MEDIUM;
		System.out.println(size);
		System.out.println(size.ordinal());
		System.out.println(size.abbreviation);
		System.out.println(Size.valueOf("LARGE"));
		System.out.println(size.nextSize());
		System.out.println(size.prevSize());
	}
	public static void weekdayTest() {
		System.out.println("Weekday Test");
		Weekday wday = Weekday.WED;
		System.out.println(wday);
		System.out.println(wday.ordinal());
		System.out.println(wday.nextDays(5));
		System.out.println(wday.prevDays(15));
		System.out.println(Weekday.valueOf(3));
		System.out.println(Weekday.valueOf("WED"));
		wday = Weekday.SAT;
		System.out.println(wday.nextDay());
	}
	public static void main(String[] args) {
		//sizeTest();
		//weekdayTest();
	}
}
