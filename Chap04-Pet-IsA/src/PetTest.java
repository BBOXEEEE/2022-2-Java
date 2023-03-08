/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * PetTest 클래스: 4장 상속 실습
 * foo 메소드는 Pet의 모든 후손 클래스 객체를 인자로 받을 수 있음
 */
public class PetTest {
	public static void foo(Pet p) {
		System.out.println(p.makeSound());
	}
	public static void main(String[] args) {
		Dog dog = new Dog("스팟");
		Pet cat = new Cat("프리");
		foo(dog);
		foo(cat);
		foo(new Dog("장군"));	
	}
}
