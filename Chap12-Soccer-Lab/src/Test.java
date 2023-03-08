
/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * 테스트 프로그램
 */
public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		Team liverpool = new Team("Liverpool");
		Team barcelona = new Team("Barcelona");
		liverpool.addResult(GameResult.WIN);
		barcelona.addResult(GameResult.WIN);
		Player p1 = new Player("Trent Alexader-Arnold",liverpool,66);
		p1.setGoals(1);
		Player p2 = new Player("Gavi",barcelona,30);
		p2.setAssists(1);
		Player p3 = p2.clone();
		System.out.printf("%s: hash = %d%n",p1, p1.hashCode());
		System.out.printf("%s: hash = %d%n",p2, p2.hashCode());
		System.out.printf("%s: hash = %d%n",p3, p3.hashCode());
		System.out.println(p2!=p3);
		System.out.println(p2.hashCode()==p3.hashCode());
		System.out.println(p2.equals(p3));
		p3.setName("Pedri");
		p3.setNumber(8);
		p3.setGoals(1);
		p3.setAssists(0);
		System.out.printf("%s: hash = %d%n",p3, p3.hashCode());
		System.out.println(p2.hashCode()!=p3.hashCode());
		System.out.println(p2.equals(p3));
		System.out.println(p2.compareTo(p3));
	}

}
