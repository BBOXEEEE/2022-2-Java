/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기 
 * @author 김상진
 * Weapon 열거형
 */
public enum Weapon {
	Dagger(2,1), Sword(10,2), Axe(5,2), Hammer(2,2), 
	Spear(1,2), LongSword(15,3), Mjolnir(30,10), StormBreaker(30,10);
	public final int attackPower;
	public final int weight;
	private Weapon(int attackPower, int weight) {
		this.attackPower = attackPower;
		this.weight = weight;
	}
}
