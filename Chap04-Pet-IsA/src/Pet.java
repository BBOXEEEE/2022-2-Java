import java.util.Objects;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Pet 클래스: 4장 상속 실습
 * 모든 애완동물은 이름을 가지고 있음
 * abstract 클래스: 객체를 생성할 수 없는 클래스
 * abstract 메소드: 선언만 하는 메소드
 */
public abstract class Pet {
	private String name;
	public Pet(String name) {
		this.name = Objects.requireNonNull(name);
	}
	public String getName() {
		return name;
	}
	public String makeSound() {
		return name+": ";
	}
}
