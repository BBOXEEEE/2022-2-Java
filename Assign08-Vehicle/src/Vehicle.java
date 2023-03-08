import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 2019136056 박세현 
 * Vehicle 클래스, 부모 클래스: Object
 * 멤버 변수 설정할 때 Objects.requireNonNull의 사용은 각종 Object의 메소드 재정의에 어떤 영향?
 * 멤버 변수 maker는 일반 클래스가 아니라 record임. 각종 Object의 메소드 재정의에 어떤 영향?
 * >> engine과 비교 (engine는 일반 클래스, 하지만 Engine도 record로 정의할 수 있지만 차이를 위해 일부로)
 */
public class Vehicle implements Cloneable, Comparable<Vehicle>{
	private String name;			// 차량 모델명
	private Engine engine;			// 엔진 정보
	private Company maker;			// 제조사
	private int year;				// 출시년도

	public Vehicle(String name, Engine engine, Company maker, int year){
		setName(name);
		setEngine(engine);
		setCompany(maker);
		setYear(year);
	}
	
	public void setName(String name) {
		this.name = Objects.requireNonNull(name);
	}
	public void setEngine(Engine engine) {
		this.engine = Objects.requireNonNull(engine);
	}
	public void setCompany(Company maker) {
		this.maker = Objects.requireNonNull(maker);
	}
	public void setYear(int year) {
		if(year<1950) throw new IllegalArgumentException("");
		this.year = year;
	}
	
	public String getName() {
		return name;
	}
	public Engine engine() {
		return engine;
	}
	public Company getCompany(){
		return maker;
	}
	public int getYear() {
		return year;
	}
	
	@Override public String toString() {
		return String.format("(%s, %s, %s, %d)", name, engine.toString(), maker.toString(), year);
	}
	
	@Override public boolean equals(Object other) {
		if(other == null || getClass() != other.getClass()) return false;
		if(this == other) return true;
		Vehicle v = (Vehicle)other;
		return name.equals(v.name) && engine.equals(v.engine)
				&& maker.equals(v.maker) && year == v.year;
	}
	
	@Override public int hashCode() {
		return Objects.hash(name.hashCode(), engine.hashCode(), maker.hashCode(), year);
	}
	
	@Override public Vehicle clone() throws CloneNotSupportedException {
		Vehicle cloned = (Vehicle)super.clone();
		cloned.engine = engine.clone();
		return cloned;
	}
	
	@Override public int compareTo(Vehicle other) {
		int comp = name.compareTo(other.name);
		return comp==0? year - other.year: comp;
	}
}
