/* 
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * @file LocationTest.java
 */
public class LocationTest {
	public static void test01() {
		Location loc1 = new Location(1,2);
		System.out.println(loc1);
		Location loc2 = new Location(1);
		System.out.println(loc2.row());
		System.out.println(loc1.hashCode());
		System.out.println(loc2.hashCode());
		System.out.println(loc1.equals(loc2));
	}
	public static void test02() {
		Location loc1 = new Location(-1, 0);
		System.out.println(loc1);
	}
	public static void main(String[] args) {
		test01();
	}
}
