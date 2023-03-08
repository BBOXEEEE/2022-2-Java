import java.util.Scanner;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * InputTest 클래스
 */
public class InputTest {
	/**
	 * 두 개의 정수를 입력받아 그것의 합을 출력
	 */
	public static void intInput() {
		Scanner in = new Scanner(System.in);
		System.out.print("정수 입력: ");
		int n1 = in.nextInt();
		System.out.print("정수 입력: ");
		int n2 = in.nextInt();
		System.out.printf("%d +%d = %d%n", n1, n2, n1+n2);
		in.close();
	}
	/**
	 * n개의 문자열을 입력받아 출력함
	 * Scanner의 next 이용
	 */
	public static void stringInput() {
		Scanner in = new Scanner(System.in);
		System.out.print("문자열 개수: ");
		int N = in.nextInt();
		//in.nextLine();
		for(int i=0; i<N; i++) {
			String S = in.next();
			System.out.println(S);
		}
		in.close();
	}
	/**
	 * n개의 라인을 입력받아 출력함
	 * Scanner의 nextLine 이용
	 * 버퍼 처리에 주의해야 함
	 */
	public static void stringLineInput() {
		Scanner in = new Scanner(System.in);
		System.out.print("라인 수: ");
		int N = in.nextInt();
		// 아래 주석된 라인이 꼭 필요한 이유는?
		//in.nextLine();
		for(int i=0; i<N; i++) {
			String S = in.nextLine();
			System.out.printf("%d: %s%n", i+1, S);
		}
		in.close();
	}
	
	
	public static void bufferTest() {
		Scanner in = new Scanner(System.in);
		System.out.print("라인 수: ");
		int N = in.nextInt();
		System.out.println(N);
		in.close();
	}
	public static void main(String[] args) {
		intInput();
		//stringInput();
		//stringLineInput();
		//bufferTest();
	}
}
