/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * 제12장 접근제어, Object 클래스
 * 테스트 프로그램 
 */
public class Test {
	public static void studentTest() {
		Student s1 = new Student("홍길동", 1);
		s1.setScores(90,95,100);
		System.out.println(s1);
		
		Student s2 = s1.clone();
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode()==s2.hashCode());
		s2.setScores(100,95,90);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode()==s2.hashCode());
	}
	public static void orderTest() {
		Order order1 = new Order(1,new Item("바밤바", 500),new Item("메로나", 500),new Item("비비빅", 600));
		System.out.println(order1);
		Order order2 = order1.clone();
		order2.getItem(0).setPrice(300);
		System.out.println(order1);
		System.out.println(order2);
	}
	public static void memberTest() {
		Member m1 = new Member("홍길동");
		Member m2 = new Member("성춘향");
		
		System.out.println(m1);
		System.out.println(m1.hashCode());
		m2.setBestFriend(m1);
		System.out.println(m2);
		m1.setBestFriend(m2);
		System.out.println(m1);
		
		System.out.println(m1.hashCode());
	}
	public static void main(String[] args) {
		//studentTest();
		//orderTest();
		memberTest();
	}

}
