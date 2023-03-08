import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 2019136056 박세현 
 * Car: 자동차 클래스, 부모 클래스: Vehicle
 */
public final class Car extends Vehicle {
	private CarType carType;	// 차종
	public Car(String name, Engine engine, CarType carType, Company maker, int year){
		super(name, engine, maker, year);
		setCarType(carType);
	}
	
	public void setCarType(CarType carType) {
		this.carType = Objects.requireNonNull(carType);
	}
	public CarType carType() {
		return carType;
	}
	
	@Override public String toString() {
		return String.format("(%s, %s)", super.toString(), carType.toString());
	}
	
	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), carType.hashCode());
	}
	
	@Override public boolean equals(Object other) {
		if(!super.equals(other)) return false;
		Car c = (Car)other;
		return carType.equals(c.carType);
	}
	
	@Override public Car clone(){
		Car cloned = null;
		try {
			cloned = (Car)super.clone();
		}
		catch(CloneNotSupportedException e) {}
		return cloned;
	}
	
	@Override public int compareTo(Vehicle other) {
		int comp = super.compareTo(other);
		Car c = (Car)other;
		return comp==0? carType.compareTo(c.carType): comp;
	}
}

