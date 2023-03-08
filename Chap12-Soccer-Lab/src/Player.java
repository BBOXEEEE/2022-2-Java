import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * Player: 축구 선수 클래스, 부모 클래스: Person
 */
public final class Player extends Person {
	private int number;
	private int goal = 0;
	private int assist = 0;
	
	public Player(String name, Team team, int number){
		super(name, team);
		setNumber(number);
	}

	public void setNumber(int number) {
		if(number<0) throw new IllegalArgumentException("");
		this.number = number;
	}
	
	public void setGoals(int goals) {
		if(goals<0) throw new IllegalArgumentException("");
		goal = goals;
	}
	
	public void setAssists(int assists) {
		if(assists<0) throw new IllegalArgumentException("");
		assist = assists;
	}
	
	@Override public String toString() {
		return String.format("(%s, %d, goal = %d, assist = %d)", 
			super.toString(), number, goal, assist);
	}
	
	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), number, goal, assist);
	}
	
	@Override public boolean equals(Object other) {
		if(!super.equals(other)) return false;
		Player p = (Player)other;
		return number == p.number && goal == p.goal && assist == p.assist;
	}
	
	@Override public Player clone(){
		Player cloned = null;
		try {
			cloned = (Player)super.clone();
		}
		catch(CloneNotSupportedException e) {}
		return cloned;
	}
	
	@Override public int compareTo(Person other) {
		int comp = super.compareTo(other);
		Player p = (Player)other;
		return comp==0? goal-p.goal: comp;
	}
}

