import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * Person 클래스, 부모 클래스: Object
 */
public class Person implements Cloneable, Comparable<Person>{
	private String name;
	private Team team;
	// private int age;
	public Person(String name, Team team){
		setName(name);
		setTeam(team);
	}
	public void setName(String name) {
		this.name = Objects.requireNonNull(name);
	}
	public void setTeam(Team team) {
		this.team = Objects.requireNonNull(team);
	}
	public String getName(){
		return name;
	}
	public Team getTeam() {
		return team;
	}
	
	// toString method는 debug 목적으로 간단히 객체의 상태를 알고 싶을 때 간결하게 정의 
	@Override public String toString() {
		return String.format("(%s, %s)", name, team.toString());
	}
	
	// name이 null일 수 없으므로 Objects.equals를 이용할 필요가 없음
	// 모든 멤버변수를 비교해줘야함 
	@Override public boolean equals(Object other) {
		if(other == null || getClass() != other.getClass()) return false;
		if(this == other) return true;
		Person p = (Person)other;
		return name.equals(p.name) && team.equals(p.team);
		// return Objects.equals(name, p.name);  null 검사를 안할 때, Object.equals 사용 
	}
	
	@Override public int hashCode() {
		return Objects.hash(name.hashCode(), team.hashCode());
	}
	
	@Override public Person clone() throws CloneNotSupportedException {
		Person cloned = (Person)super.clone();
		cloned.team = team.clone();
		return cloned;
		
		// return (Person)super.clone();
	}
	
	@Override public int compareTo(Person other) {
		return name.compareTo(other.name);
		// return age-other.age;					   오버플로우 발생 가능
		// return Integer.compare(age, other.age);		// Wrapper 클래스의 compare 메소드 활용 시 오버플로우 걱정없이 비교 가능! 
	}
}
