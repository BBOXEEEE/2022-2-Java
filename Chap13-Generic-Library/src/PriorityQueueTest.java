import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 *  @version 2022년도 2학기
 *  @author 김상진 
 *  PriorityQueueTest.java
 */
public class PriorityQueueTest {
	public static void minQueue_test() {
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(5);
		queue.add(3);
		queue.add(9);
		queue.add(2);
		System.out.println(queue.peek());
		queue.poll();
		queue.remove(3);
		System.out.println(queue.size());
		System.out.println(queue.peek());
	}
	
	public static void maxQueue_test() {
		Queue<Integer> queue 
			//= new PriorityQueue<>((a,b)->b.compareTo(a));
			= new PriorityQueue<>(Comparator.reverseOrder());
		queue.add(5);
		queue.add(3);
		queue.add(9);
		queue.add(2);
		System.out.println(queue.peek());
		queue.poll();
		queue.remove(2);
		System.out.println(queue.size());
		System.out.println(queue.peek());
	}
	public static void main(String[] args) {
		//minQueue_test();
		maxQueue_test();
	}

}
