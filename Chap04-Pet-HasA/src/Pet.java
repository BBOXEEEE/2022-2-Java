import java.util.Objects;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Pet 클래스
 * 상속을 사용하지 않고 조건문을 사용하지 않고 멍멍, 야옹 구현
 */
public class Pet {
	private String name;
	private SoundStrategy soundStrategy;
	public Pet(String name, SoundStrategy soundStrategy) {
		this.name = Objects.requireNonNull(name);
		setSoundStrategy(soundStrategy); 
	}
	public String getName() {
		return name;
	}
	public void setSoundStrategy(SoundStrategy soundStrategy) {
		this.soundStrategy = Objects.requireNonNull(soundStrategy);
	}
	public String makeSound() {
		return name+": "+soundStrategy.getSound();
	}
}
