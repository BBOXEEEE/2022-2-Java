import java.util.Objects;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Dog 클래스: 2장 생성자 연습
 */
public class Dog {
	private String mName;
	// this를 이용한 다른 생성자의 호출은 무조건 첫 문장이어야 함
	// 주석된 것을 포함하여 실행하여 this를 이용한 생성자 호출
	// 어떻게 동작하는지 이해할 필요가 있음
	public Dog() {
		this("이름 없음");
		// System.out.println("Dog()\n");
	}
	public Dog(String name) {
		setName(name);
		// System.out.println("Dog(name)\n");
	}
	public String getName() {
		return mName;
	}
	// 1) Objects.requireNonNull은 name이 null이면 예외 발생
	// setName을 통해 mName을 초기화하고 있고 갱신하고 있으므로
	// mName은 절대 null이 될 수 없음
	// 2) setter가 인자에 대한 어떤 검사도 하지 않으면 mName을 private으로
	// 지정하고 getter를 만들 이유가 없음. 그냥 public으로...
	public void setName(String name) {
		mName = Objects.requireNonNull(name);
	}
	public void bark(){
		System.out.printf("%s: ", mName);
	}
}
