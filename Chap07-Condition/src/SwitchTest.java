/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * switch문 예제
 */
public class SwitchTest {
	public static int numberOfDays01(int month) {
		switch(month){
		case 4: case 6: case 9: case 11: return 30;
		case 2: return 28;
		default: return 31;
		}
	}
	public static int numberOfDays02(int month) {
		switch(month){
		case 4, 6, 9, 11: return 30;
		case 2: return 28;
		default: return 31;
		}
	}
	public static int numberOfDays03(int month) {
		return switch(month){
			case 4, 6, 9, 11 -> 30;
			case 2 -> 28;
			default -> 31;
		};
	}
	public static String isWorkingDay(String day) {
		return switch (day) {
			case "MON", "TUE", "WED", "THU", "FRI"  -> "근무일";
			default -> {
				if(day.isEmpty()) yield "유효한 요일이 아님";
				else yield "휴일";
			}
		};
	}
	// yield를 이용하면 화살표 연산자를 사용하지 않고
	// 이전 switch 문에서 사용한 :을 사용할 수 있음
	public static int numberOfLetters(String day) {
		return switch (day) {
			case "MON", "FRI", "SUN": yield 6;
			case "TUE": yield 7;
			case "THU", "SAT": yield 8;
			default: yield 9;
		};
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
