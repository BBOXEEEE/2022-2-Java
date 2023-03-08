import java.util.Objects;

class Student{
	private String name;
	private int year;
	private String city;
	private String department;
	public Student(String name, int year) {
		this.name = Objects.requireNonNull(name);
		this.year = year;
	}
	public Student(String name, int year, String city, String department) {
		this(name, year);
		this.city = Objects.requireNonNull(city);
		this.department = Objects.requireNonNull(department);
	}
	public String getName() {
		return name;
	}
	public int getYear() {
		return year;
	}
	public String getCity() {
		return city;
	}
	public String getDepartment() {
		return department;
	}
	@Override public String toString() {
		return String.format("(이름: %s, %d학년)", name, year);
	}
}