/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * LivingHierarchyTest 클래스: 테스트 프로그램 
 */
public class LivingHierarchyTest {
	public static void livingThingTest(LivingThing livingThing) {
		livingThing.eat();
	}
	public static void livingInWaterTest(LivingInWater waterAnimal) {
		waterAnimal.eat();
		waterAnimal.swim();
		
	}
	public static void livingInSkyTest(LivingInSky flyingAnimal) {
		flyingAnimal.eat();
		flyingAnimal.fly();
	}
	public static void main(String[] args) {
		Dolphin dolphin = new Dolphin();
		Duck duck = new Duck();
		System.out.println("Eat 검사");
		livingThingTest(dolphin);
		livingThingTest(duck);
		System.out.println("\nSwim 검사");
		livingInWaterTest(dolphin);
		livingInSkyTest(duck);
		System.out.println("\nFly 검사");
		livingInSkyTest(duck);
	}

}
