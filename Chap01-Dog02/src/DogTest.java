/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * DogTest 클래스
 * 조건문을 사용하지 않고 상속을 이용하여 강아지 종에 따라 다른 소리로 짖고 있음
 */
public class DogTest {

	public static void main(String[] args) {
		Dog sh = new SiberianHusky();
		sh.setName("장군");
		sh.bark();
		Dog st = new ShihTzu();
		st.setName("미미");
		st.bark();
	}

}
