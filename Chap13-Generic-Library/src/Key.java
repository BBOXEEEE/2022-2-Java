/**
 *  한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 *  @version 2022년도 2학기
 *  @author 김상진 
 *  Key.java
 *  hashCode를 부적절하게 정의하고 있어, 충돌이 쉽게 발생함
 */
public class Key{
	public int a;
	public int b;
	public Key(int a, int b) {
		this.a = a;
		this.b = b;
	}
	@Override public int hashCode() {
		return a+b;
	}
	@Override public boolean equals(Object other) {
		if(other==null||getClass()!=other.getClass()) return false;
		if(this==other) return true;
		Key k = (Key)other;
		return a==k.a&&b==k.b;
	}
	@Override public String toString() {
		return String.format("(%d, %d)", a, b);
	}
}