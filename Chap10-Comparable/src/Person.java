/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Person 클래스: 10장 Comparable 추가
 * - 이름을 이용하여 비교
 */
public abstract class Person implements Comparable<Person>{
	private String name;
	public Person(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override public int compareTo(Person p) {
		return name.compareTo(p.name);
	}
}
