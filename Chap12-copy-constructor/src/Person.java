import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * Person 클래스: 부모가 Object임
 * 복사 생성자
 */
public abstract class Person implements Comparable<Person>{
	private String name;
	public Person(String name){
		setName(name);
	}
	public Person(Person other) {
		this.name = Objects.requireNonNull(other).name;
	}
	public void setName(String name) {
		this.name = Objects.requireNonNull(name);
	}
	public String getName(){
		return name;
	}
	@Override public String toString() {
		return String.format("(이름: %s)", name);
	}
	@Override public boolean equals(Object other) {
		if(other==null||getClass()!=other.getClass()) return false;
		if(this==other) return true;
		Person p = (Person)other;
		return name.equals(p.name);
	}
	@Override public int hashCode() {
		return name.hashCode();
	}
	@Override public int compareTo(Person p) {
		return name.compareTo(p.name);
	}
}
