/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * if문 예제
 */
public class IfTest {
	public static void drawFranceFlagV1(int width) {
		int x = 0;
		for(; x<width/3; ++x) System.out.print("B");
		for(; x<width/3*2; ++x) System.out.print("W");
		for(; x<width; ++x) System.out.print("R");
		System.out.println();
	}
	public static void drawFranceFlagV2(int width) {
		int third = width/3;
		if(width%3==2) ++third;
		int x = 0;
		for(; x<third; ++x) System.out.print("B");
		for(; x<width-third; ++x) System.out.print("W");
		for(; x<width; ++x) System.out.print("R");
		System.out.println();
	}
	public static void drawFranceFlag(int width) {
		if(width<=2) throw new IllegalArgumentException();
		if(width%3==0) drawFranceFlagV1(width);
		else drawFranceFlagV2(width);
	}
	public static void test_drawFranceFlag() {
		drawFranceFlag(9);
		drawFranceFlag(10);
		drawFranceFlag(11);
	}
	public static void main(String[] args) {
		test_drawFranceFlag();
	}

}
