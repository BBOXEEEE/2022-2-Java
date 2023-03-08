
/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 2019136056 박세현 
 * 테스트 프로그램
 */
public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		Company hyundai = new Company("현대", "대한민국");
		Company bmw = new Company("BMW", "독일");
		Engine e2497 = new Engine(EngineType.Gasoline, 2497);
		Engine e1998 = new Engine(EngineType.Gasoline, 1998);
		Vehicle c1 = new Car("그랜저", e2497, CarType.LARGE, hyundai, 2022);
		Vehicle c2 = new Car("BMW5", e1998, CarType.LARGE, bmw, 2022);
		Vehicle c3 = c1.clone();
		System.out.printf("%s: hash = %d%n",c1, c1.hashCode());
		System.out.printf("%s: hash = %d%n",c2, c2.hashCode());
		System.out.printf("%s: hash = %d%n",c3, c3.hashCode());
		System.out.println(c1!=c3);
		System.out.println(c1.hashCode()==c3.hashCode());
		System.out.println(c1.equals(c3));
		c3.setName("쏘나타");
		c3.setEngine(new Engine(EngineType.Gasoline, 1999));
		((Car)c3).setCarType(CarType.MEDIUM);
		System.out.printf("%s: hash = %d%n", c3, c3.hashCode());
		System.out.println(c1.hashCode()!=c3.hashCode());
		System.out.println(c1.equals(c3));
		System.out.println(c1.compareTo(c3));
	}

}
