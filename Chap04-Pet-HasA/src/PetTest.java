/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * PetTest 클래스: 상속을 이용한 Pet과 Has-a를 이용한 Pet 비교
 */

class WWDogSound implements SoundStrategy{
	@Override
	public String getSound() {
		return "왈왈";
	}
}

public class PetTest {
	public static void foo(Pet p) {
		System.out.println(p.makeSound());
	}
	public static void main(String[] args) {
		Pet dog = new Pet("스팟", new DogSound());
		Pet cat = new Pet("프리", new CatSound());
		foo(dog);
		foo(cat);
		foo(new Pet("장군", new DogSound()));	
		dog.setSoundStrategy(new WWDogSound());
		foo(dog);
	}
}
