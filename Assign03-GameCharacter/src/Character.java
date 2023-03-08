/**
 * 한국기술교육대학교 2022학년도 2학기 자바프로그래밍 과제3
 * @author 2019136056 박세현 
 * @version 2022학년도 2학기
 * Character.java
 * 오버워치 게임에서 캐릭터에 대한 상태를 유지하는 캐릭터 클래스
 */

public class Character {
	private final String NAME;			// 객체상수
	private int maxHp = 100;			// 시작값 고정 변수 
	private int hp = maxHp;				// 시작값 고정 변수 
	private int ultimateGage = 0;		// 시작값 고정 변수 
	private int level= 1;				// 시작값 고정 변수 
	
	public Character(String name) {
		NAME = name;
	}
	
	public void Attack() {
		if (ultimateGage == 100)
			System.out.printf("Ready to use Ultimate Skill!\n");
		++ultimateGage;
	}
	public void Defence() {
		if(hp == 0)
			System.out.printf(NAME + " is Die...\n");
		--hp;
		++ultimateGage;
	}
	public void Emotion() {
		System.out.printf("Emotional Dance!\n");
	}
	public void LevelUp() {
		++level;
		maxHp += 10;
		System.out.printf("LEVEL UP! LV : " + level + '\n');
	}
}

/*
* Character 클래스 : 오버워치 게임에서 개인 계정이 아닌, 게임 내 캐릭터 상태를 유지하는 클래스 
* 멤버변수
	NAME : 캐릭터의 이름을 저장하고, 이는 고유한 이름과 캐릭터가 되어 객체 선언 후 변하지 않기 때문에 객체 상수이다.
	maxHp : 캐릭터의 최대 체력을 유지한다. 최대체력은 캐릭터의 레벨과 비례해 증가하며, 모든 객체가 동일하게 100으로 시작하기 때문에 시작값 고정 변수이며 명백한 초기화를 한다.
	hp : 캐릭터의 체력을 유지하는 멤버변수, 모든 캐릭터는 게임 플레이 시 동일 체력 100(최대체력)으로 시작하기에 시작값 고정 변수이며 명백한 초기화(maxHp 사용)를 한다. 
	ultimateGage : 캐릭터 고유의 궁극기 스킬을 사용하기 위해 필요한 궁극기 게이지를 유지, 게임 플레이 시 0으로 동일하게 시작하기 때문에 시작값 고정 변수이며 명백한 초기화를 한다.
	level : 캐릭터의 레벨을 유지하는 멤버변수, 모든 캐릭터는 동일하게 1의 레벨로 시작하기 때문에 시작값 고정 변수이며 명백한 초기화를 한다.
* 메소드
	Attack : 공격 시 사용하며, 1번의 공격마다 ultimateGage가 1씩 증가, 이것이 100이 되면 궁극기를 사용할 수 있음을 사용자에게 안내한다.
	Defence : 방어 시 사용하며, 1번의 방어마다 1의 체력이 감소 및 ultimateGage 1 증, 체력이 0이 되면 캐릭터는 사망한다.
	Emotion : 캐릭터의 감정표현 춤으로 제자리에서 사용 시 감정을 표현할 수 있는 춤을 춘다.
	LevelUp : 캐릭터의 레벨을 1 증가하며, 레벨이 1 증가할때마다 캐릭터의 최대 체력이 10 올라간다.
*/