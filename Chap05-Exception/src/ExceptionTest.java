import java.util.Scanner;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * ExceptionTest 클래스: 5장 예외처리 연습
 * 예외 발생 관찰하기. 예외 처리하기
 */
public class ExceptionTest {
	public static void arrayTest01() {
		int[] list = {1,2,3,4,5};
		Scanner in = new Scanner(System.in);
		System.out.print("정수 입력(1~5): ");
		int index = in.nextInt();
		System.out.println(list[index-1]);
		in.close();
	}
	public static void arrayTest02() {
		int[] list = {1,2,3,4,5};
		try(
			Scanner in = new Scanner(System.in);
		){
			System.out.print("정수 입력(1~5): ");
			int index = in.nextInt();
			System.out.println(list[index-1]);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		/*
		// error: unreachable code
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		*/
		System.out.println("함수의 끝");
	}
	// 예외에 해당되지만 예외가 발생하지 않는 경우도 있음 (오버플로우)
	public static void overflowTest() {
		int x = Integer.MAX_VALUE;
		x = x + 10;
		System.out.println(x);
	}
	// 0 나누기 예외 발생
	public static void divideByZeroTest01() {
		int x = 10;
		int y = 0;
		int z = 0;
		z = x/y;
		System.out.println("함수의 끝: "+z);
	}
	// 예외가 발생하지만 그것을 catch하여 처리함. 
	// 이 경우 프로그램은 중단되지 않음
	public static void divideByZeroTest02() {
		try {
			int x = 10;
			int y = 0;
			int z = 0;
			z = x/y;
			System.out.println("z = "+z);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		System.out.println("함수의 끝");
	}
	public static void main(String[] args) {
		divideByZeroTest01();
		//divideByZeroTest02();
		//overflowTest();
		//arrayTest01();
		//arrayTest02();
	}

}
