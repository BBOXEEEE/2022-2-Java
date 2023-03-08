enum PlayerType {BATTER, PITCHER};

class Player{
	private String name;
	private String team;
	private PlayerType type;
	public Player(String name, String team, PlayerType type) {
		this.name = name;
		this.team = team;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public String getTeam() {
		return team;
	}
	public PlayerType getType() {
		return type;
	}
	public String toString() {
		return String.format("(%s, %s, %s)", 
			team, type==PlayerType.BATTER? "타자": "투수", name);
	}
}
