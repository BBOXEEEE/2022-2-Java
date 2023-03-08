import java.util.concurrent.locks.ReentrantLock;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * ThreadTest 클래스
 * 9개의 쓰레드를 생성하여 병행 수행
 * 동기화 함수, 동기화 블록 
 */
class A{
	private String name;
	private static int count = 0;
	//private ReentrantLock lock = new ReentrantLock();
	private static ReentrantLock lock = new ReentrantLock();
	
	public A(String name) {
		this.name = name;
	}
	// 함수의 특정 부분을 동기화하고 싶을 때 사용하는 기법
	public void foo() {
		synchronized(A.class){ // synchronized(this)
			System.out.println(this+": "+name+": synchronize start");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			++count;
			System.out.println(this+": "+name+": "+count);
			System.out.println(this+": "+name+": synchronize end");
		}
	}
	public void bar() {
		System.out.println(this+": "+name+": bar method start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		++count;
		System.out.println(this+": "+name+": "+count);
		System.out.println(this+": "+name+": bar method end");
	}
	// static이 아니라 일반 메소드이면 한 객체에 의한 동시 접근을 막는 효과만 있음
	public static synchronized void baz(A a) {
		System.out.println(a+": "+a.name+": baz method start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		++count;
		System.out.println(a+": "+a.name+": "+count);
		System.out.println(a+": "+a.name+": baz method end");
	}
	// static lock을 사용하는 경우와 객체 lock을 사용하는 경우 비교
	// 멤버 변수에 있는 두 개의 lock을 번갈아 사용하여 실행해 보세요
	public void ham() {
		lock.lock();
		try {
			System.out.println(this+": "+name+": bar method start");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			++count;
			System.out.println(this+": "+name+": "+count);
			System.out.println(this+": "+name+": bar method end");
		}
		finally {
			lock.unlock();
		}
		
	}
}

class FooTask implements Runnable{
	private A a;
	public FooTask(A a) {
		this.a = a;
	}
	@Override
	public void run() {
		//A.baz(a);
		a.ham();
	}
}

public class LockingTest {

	public static void main(String[] args) throws InterruptedException {
		A a1 = new A("dog");
		A a2 = new A("cat");
		A a3 = new A("horse");
		FooTask[] tasks = new FooTask[9];
		tasks[0] = new FooTask(a1);
		tasks[1] = new FooTask(a2);
		tasks[2] = new FooTask(a3);
		tasks[3] = new FooTask(a1);
		tasks[4] = new FooTask(a2);
		tasks[5] = new FooTask(a3);
		tasks[6] = new FooTask(a1);
		tasks[7] = new FooTask(a2);
		tasks[8] = new FooTask(a3);
		Thread[] threads = new Thread[9];
		for(int i=0; i<9; i++)
			threads[i] = new Thread(tasks[i]);
		for(int i=0; i<9; i++)
			threads[i].start();
		for(int i=0; i<9; i++)
			threads[i].join();
	}
}
