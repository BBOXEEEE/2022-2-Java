/**
 *  @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 13장 예제
 *  @version 2022년도 2학기
 *  @author 김상진 
 *  Pet.java
 *  Pet <= Cat <= Siamese
 *  Pet <= Dog <= ShihTzu
 */
public abstract class Pet {
	private String name;

	public Pet(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract String makeSound();	
}

class Cat extends Pet {
	public Cat(String name) {
		super(name);
	}

	@Override
	public String makeSound() {
		return "야옹";
	}
}


class Siamese extends Cat{
	public Siamese(String name) {
		super(name);
	}
}

class Dog extends Pet {
	public Dog(String name) {
		super(name);
	}

	@Override
	public String makeSound() {
		return "멍멍";
	}
}

class Shihtzu extends Dog{
	public Shihtzu(String name) {
		super(name);
	}	
}