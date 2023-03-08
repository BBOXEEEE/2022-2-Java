import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Employee 클래스: 3장 static 멤버변수 연습
 * 직원 정보>> 상태: 이름, 사번, 행위: 
 * 사번: 생성된 순서에 따라 1, 2, ...
 * static 메소드를 이용하여 계좌번호 설정
 * clone을 이용한 객체 복제를 할 때에도 id는 복제된 객체와 다르게
 * 생성된 순서로 할당되어야 하면, clone에서도 assignID 메소드를 이용해야 함
 * clone은 12장에서 설명함
 */
public class Employee implements Cloneable{
	private String name;
	private int id = assignID();
	private static int lastAssignedID = 1;
	private static int assignID() {
		int current = lastAssignedID;
		++lastAssignedID;
		return current;
	}
	public Employee(){
		this("무명");
	} // Employee()
	public Employee(String name){
		this.name = Objects.requireNonNull(name);
	} // Employee(String)
	public int getID() {
		return id;
	}
	public String getName(){
		return name;
	}
	public Employee clone() {
		Employee cloned = null;
		try {
			cloned = (Employee)super.clone();
			cloned.id = assignID();
		}
		catch(Exception e){}
		return cloned;
	}
}
