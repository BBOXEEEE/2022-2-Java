import java.util.Objects;

/**
 *  @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 *  @version 2022년도 2학기
 *  @author 김상진 
 *  Pair.java
 *  쌍을 유지하는 범용 클래스
 *  Pair<U,V>와 Pair<V,V>, Pair<T>의 차이 이해 필요
 */
public class Pair<U, V>{
	private U first = null;
	private V second = null;
	public Pair(U first, V second) {
		setFirst(first);
		setSecond(second);
	}
	public U getFirst() { return first; }
	public V getSecond() { return second; }
	public void setFirst(U value) {
		// null도 유지할 수 있어야 하면 그냥 first = value로 프로그래밍함
		first = Objects.requireNonNull(value);
	}
	public void setSecond(V value) {
		second = Objects.requireNonNull(value);
	}
	// 아래와 같이 정의하면 모호하기 때문에 문법 오류
	//public void set(U value) { first = value; }
	//public void set(V value) { second = value; }
} // class Pair<U, V>
