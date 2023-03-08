import java.util.Timer;
import java.util.TimerTask;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * TimerTest 클래스
 * java.util.Timer 사용법 예제
 */
public class TimerTest{
	public static void main(String[] args){	
		class CountDownTask extends TimerTask{
			private int count;
			private Timer timer;
			public CountDownTask(int init, Timer timer){
				count = init;	
				this.timer = timer;
			}
			public void run() {
				if(count>0) System.out.println(count);
				else if(count==0){
					System.out.println("Lift Off");
					timer.cancel();
				}
				--count;
			}
		}		
		Timer timer = new Timer();
		// 타이머를 task에 전달하는 이유는 나중에 타이머를 중단시키기 위함
		timer.schedule(new CountDownTask(10, timer), 1000, 1000);
		System.out.println("Countdown starts");
	} // main
} // class TimerTest