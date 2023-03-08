import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 난수 발생 예제
 */
public class RandomTest {
	public static void diceTest() {
		Random randGen1 = new Random();
		Random randGen2 = new Random(System.currentTimeMillis());
		System.out.println(randGen1.nextInt(6)+1);
		System.out.println(randGen2.nextInt(6)+1);
		System.out.println((int)(Math.random()*6+1));
		System.out.println(ThreadLocalRandom.current().nextInt(6)+1);
	}
	
	public static boolean probTest(double p) {
		if(p<0||p>=1) throw new IllegalArgumentException();
		double d = ThreadLocalRandom.current().nextDouble();
		return Double.compare(d, p)<0;
	}
	
	public static void probTest_Test() {
		int count = 0;
		for(int i=0; i<100; i++) {
			if(probTest(0.3)) ++count;
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		//diceTest();
		probTest_Test();
	}

}
