import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * Team: 축구 구단 정보, 부모 클래스: Object
 */
public final class Team implements Cloneable{
	private String name;
	private int played = 0;
	private int wins = 0;
	private int draws = 0;
	public Team(String name) {
		this.name = Objects.requireNonNull(name);
	}
	public String getName() {
		return name;
	}
	public int wins() {
		return wins;
	}
	public int draws() {
		return draws;
	}
	public int losses() {
		return played - wins - draws;
	}
	public int score() {
		return wins * 3 + draws;
	}
	
	public void addResult(GameResult result) {
		++played;
		switch(result) {
		case WIN: ++wins; break;
		case DRAW: ++draws; break;
		default:
		}
	}
	
	@Override public String toString() {
		return String.format("%s)", name);
	}
	
	@Override public int hashCode() {
		return 0;
	}
	
	@Override public boolean equals(Object other) {
		//
		return false;
	}
	
	@Override public Team clone(){
		return null;
	}
}
