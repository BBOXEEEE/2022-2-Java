/* 
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * @file SealedTest.java
 * 상속할 수 있는 또는 interface를 구현할 수 있는 클래스를 제한하는 방법
 */
sealed interface Service permits Car, Truck, Van{
	void foo();
}

abstract sealed class Vehicle permits Car, Truck{
	public abstract void bar();
}

// non-sealed 키워드가 이상해??? 어떻게 식별자 내에 -을 사용하지???
// sealed 클래스를 상속하거나 sealed interface를 구현할 경우 옵션
// - non-sealed, final, sealed
// - non-sealed이면 제한이 풀리는 것
// - sealed이면 추가로 허용하는 것만 가능
non-sealed class Car extends Vehicle implements Service{
	@Override public void foo() {
	}

	@Override public void bar() {
	}
}

final class Truck extends Vehicle implements Service{
	@Override public void foo() {
	}

	@Override public void bar() {
	}
}

// Car는 non-sealed이므로
class AutoCar extends Car{	
}

final class Van implements Service{
	@Override public void foo() {	
	}
}

public class SealedTest {

}
