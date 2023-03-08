/**
 * 한국기술교육대학교 2022학년도 2학기 자바프로그래밍 과제3
 * @author 2019136056 박세현 
 * @version 2022학년도 2학기
 * CharacterTest.java
 * 객체 생성 및 메소드 동작 여부 확인을 위한 Test 프로그램 
 */

public class CharacterTest {

	public static void main(String[] args) {
		Character soldier = new Character("솔져");
		for(int i=0; i<=100; ++i)
			soldier.Attack();
		soldier.LevelUp();
		for(int i=0; i<=100; ++i)
			soldier.Defence();
		soldier.LevelUp();
		soldier.Emotion();
	}
	
}
