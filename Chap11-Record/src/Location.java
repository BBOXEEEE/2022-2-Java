/* 
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * @file Location.java
 * record는 클래스를 정의하는 또 다른 방법임
 * 일반 클래스와 차이점.
 * 1) 일반 멤버 변수는 생성자 매개 변수 목록에 의해 고정됨 (추가할 수 없음)
 * 2) 기본적으로 제공되는 생성자의 접근 권한을 바꿀 수 없음
 * 3) 다른 클래스를 상속할 수 없음
 * 4) record를 상속하여 확장할 수 없음
 */
public record Location(int row, int col) implements Comparable<Location> {
	public Location{
		if(row<0||col<0) throw new IllegalArgumentException(); 
		//System.out.println("ha ha");
	}
	// 생성자를 추가로 정의할 수 있지만 반드시 기본적으로 제공되는 생성자를 호출해야 함
	public Location(int row) {
		this(row, 0);
		//System.out.println("ho ho");
	}
	@Override
	public int compareTo(Location o) {
		return row-o.row;
	}
}

//class X extends Location{} // error