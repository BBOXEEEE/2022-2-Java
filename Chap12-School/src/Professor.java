import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * Professor 클래스 - 부모 클래스: Person
 */
public final class Professor extends Person{
	private ProfessorType professorType;
	public Professor(String name, ProfessorType professorType) {
		super(name);
		this.professorType = professorType;
	}
	public void setProfessorType(ProfessorType professorType) {
		this.professorType = professorType;
	}
	@Override public String toString() {
		return String.format("교수: %s, %s", getName(), professorType);
	}
	@Override public boolean equals(Object other) {
		if(!super.equals(other)) return false;
		Professor p = (Professor)other;
		return professorType==p.professorType;
	}
	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), professorType);
	}
	@Override public Professor clone() {
		Professor cloned = null;
		try {
			cloned = (Professor)super.clone();
		}
		catch(CloneNotSupportedException e) {}
		return cloned;
	}
}
