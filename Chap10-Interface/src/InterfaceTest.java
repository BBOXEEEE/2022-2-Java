/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2022년도 2학기
 * @author 김상진 
 * 10장 인터페이스 두 번째 이야기
 * Interface를 정의하면 Object에 있는 public 메소드가 자동 포함됨
 */
interface I{
}

class X implements I{
}

public class InterfaceTest {
	public static void main(String[] args) {
		I o1 = new X();
		I o2 = new X();
		System.out.println(o1.hashCode());
		System.out.println(o1.getClass().getName());
		System.out.println(o1.toString());
		System.out.println(o1.equals(o2));	
	}
}
