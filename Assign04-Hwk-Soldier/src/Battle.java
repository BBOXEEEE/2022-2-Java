
/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 2019136056 박세현  
 * @file Battle.java
 * 두 명의 군인이 전투
 */
public class Battle {
	// 라운드마다 각자 공격을 함
	// 공격 후 죽지 않았으면 회복 가능
	public static void battle(Soldier a, Soldier b) {
		int round = 1;
		while(true) {
			a.defend(b.attack());
			b.defend(a.attack());
			System.out.printf("Attack Round %d: A(%d), B(%d)%n", 
				round, a.getHealth(), b.getHealth());
			if(!a.isLive() || !b.isLive()) break;
			a.heal();
			b.heal();
			System.out.printf("Healing Round %d: A(%d), B(%d)%n", 
				round, a.getHealth(), b.getHealth());
			++round;
		}
		if(!a.isLive() && !b.isLive()) System.out.println("DRAW");
		else if(!a.isLive()) System.out.println("B win");
		else System.out.println("A win");
	}
	
	public static void main(String[] args) {
		Soldier alice = new Soldier();
		Soldier bob = new Soldier();
		System.out.println("================================");
		System.out.println("Soldier  vs  Soldier");
		System.out.println("================================");
		battle(alice, bob);
		
		Soldier alice1 = new SpecialSoldier();
		Soldier bob1 = new Soldier();
		System.out.println("================================");
		System.out.println("SpecialSoldier  vs  Soldier");
		System.out.println("================================");
		battle(alice1, bob1);
		
		Soldier alice2 = new Soldier(new MedicSoldier());
		Soldier bob2 = new Soldier();
		System.out.println("================================");
		System.out.println("MedicSoldier  vs  Soldier");
		System.out.println("================================");
		battle(alice2, bob2);
		
		Soldier alice3 = new Soldier(new MedicSoldier());
		Soldier bob3 = new SpecialSoldier();
		System.out.println("================================");
		System.out.println("MedicSoldier  vs  SpecialSoldier");
		System.out.println("================================");
		battle(alice3, bob3);
	}

}
