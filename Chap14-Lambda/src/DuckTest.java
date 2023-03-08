import java.util.Objects;

@FunctionalInterface
interface FlyingStrategy{
	void doFly();
}

class FlyNoWay implements FlyingStrategy{
	@Override public void doFly() {
		System.out.println("하늘을 날 수 없어요. ㅠ.ㅠ");
	}
}

class FlyWithWings implements FlyingStrategy{
	@Override public void doFly() {
		System.out.println("날개로 하늘을 날고 있어...");
	}
}

class Duck{
	private FlyingStrategy flyingStrategy;
	public Duck(FlyingStrategy flyingStrategy) {
		setFlyingStrategy(flyingStrategy);
	}
	public void setFlyingStrategy(FlyingStrategy flyingStrategy) {
		this.flyingStrategy 
			//= Objects.requireNonNullElse(flyingStrategy, new FlyNoWay());		
			= Objects.requireNonNullElseGet(flyingStrategy, FlyNoWay::new);
	}
	public void fly() {
		flyingStrategy.doFly();
	}
}

public class DuckTest {

	public static void main(String[] args) {
		Duck duck01 = new Duck(null);
		Duck duck02 = new Duck(()->System.out.println("로켓으로 하늘을 날고 있어요!!!"));
		duck01.fly();
		duck02.fly();
		duck01.setFlyingStrategy(new FlyWithWings());
		duck01.fly();
	}

}
