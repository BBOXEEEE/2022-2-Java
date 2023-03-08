import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SchoolTest {

	@Test
	void equalsTest() {
		Professor p1 = new Professor("김상진", ProfessorType.PROFESSOR);
		Professor p2 = new Professor("한연희", ProfessorType.PROFESSOR);
		assertFalse(p1.equals(p2));
		assertFalse(p1.hashCode()==p2.hashCode());
		Student s1 = new Student("홍길동", 1, p1);
		Student s2 = new Student("홍길동", 1, p1);
		Student s3 = new Student("홍길동", 1, p2);
		assertTrue(s1.equals(s2));
		assertFalse(s1.equals(s3));
	}

	@Test
	void cloneTest() {
		Professor p1 = new Professor("김상진", ProfessorType.PROFESSOR);
		Professor p2 = p1.clone();
		assertTrue(p1.equals(p2));
		assertFalse(p1==p2);
		assertTrue(p1.hashCode()==p2.hashCode());
		p2.setName("한연희");
		assertFalse(p1.equals(p2));
		assertFalse(p1.hashCode()==p2.hashCode());
		Student s1 = new Student("홍길동", 1, p1);
		Student s2 = s1.clone();
		s1.setName("성춘향");
		assertFalse(s1.equals(s2));
		assertFalse(s1.hashCode()==s2.hashCode());
	}
}
