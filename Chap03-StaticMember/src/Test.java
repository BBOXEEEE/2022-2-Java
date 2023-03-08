/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Test 클래스: 3장 static 멤버변수 연습
 */
public class Test {
	public static void accountNumberTest() {
		BankAccount aliceAccount = new BankAccount();
		BankAccount bobAccount = new BankAccount(10_000);
		BankAccount charlieAccount = new BankAccount(5_000);
		System.out.println(aliceAccount.getAccountNumber());
		System.out.println(bobAccount.getAccountNumber());
		System.out.println(charlieAccount.getAccountNumber());
	}
	public static void employeeIDTest() {
		Employee alice = new Employee("성춘향");
		Employee bob = new Employee("홍길동");
		Employee charlie = new Employee();
		Employee dave = bob.clone();
		System.out.println(alice.getID());
		System.out.println(bob.getID());
		System.out.println(charlie.getID());
		System.out.println(dave.getID());
	}
	public static void studentNumberTest() {
		Student alice = new Student("성춘향");
		Student bob = new Student("홍길동");
		Student charlie = new Student();
		System.out.println(alice.getStudentNumber());
		System.out.println(bob.getStudentNumber());
		System.out.println(charlie.getStudentNumber());
	}
	public static void main(String[] args) {
		accountNumberTest();
		employeeIDTest();
		studentNumberTest();
	}

}
