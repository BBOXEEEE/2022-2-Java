import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * 제12장 접근제어, Object 클래스
 * 이 예처럼 두 객체가 상호참조할 경우 toString, hashCode, equals, clone 등이
 * 무한반복 될 수 있음
 */
public final class Member extends Person {
	private Member bestFriend = null;
	public Member(String name) {
		super(name);
	}
	public void setBestFriend(Member bestFriend) {
		this.bestFriend = Objects.requireNonNull(bestFriend);
	}
	public Member getBestFriend(){
		return bestFriend;
	}
	@Override public String toString() {
		//String tmp = bestFriend==null? "없음": bestFriend.toString();
		//해결책 (친구의 이름만 이용)
		String tmp = bestFriend==null? "없음": bestFriend.getName();
		return String.format("(%s, 절친: %s)", super.toString(), tmp);
	}
	@Override public boolean equals(Object other) {
		if(!super.equals(other)) return false;
		Member m = (Member)other;
		//return Objects.equals(bestFriend, m.bestFriend);
		//해결책 (친구의 이름만 이용)
		String bestFriendName = bestFriend==null? null: bestFriend.getName();
		String otherBestFriendName = m.bestFriend==null? null: m.bestFriend.getName();
		return Objects.equals(bestFriendName, otherBestFriendName);
	}
	@Override public int hashCode() {
		//return Objects.hash(super.hashCode(), bestFriend);
		int code = bestFriend==null? 0: bestFriend.getName().hashCode();
		return Objects.hash(super.hashCode(), code);
	}
	@Override public Member clone(){
		Member cloned = null;
		try {
			cloned = (Member)super.clone();
			//cloned.bestFriend = bestFriend.clone();
			//해결책: 일부러 얕은 복사를 할 수 있음
		}
		catch(CloneNotSupportedException e) {}
		return cloned;
	}
}
