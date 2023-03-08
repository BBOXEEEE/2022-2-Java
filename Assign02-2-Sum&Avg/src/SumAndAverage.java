import java.util.Scanner;

public class SumAndAverage {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number, sum, cnt;
		number = sum = cnt = 0;
		
		while(number != -1) {
			System.out.printf("정수 입력 : (-1 입력 시 종료) : ");
			number = in.nextInt();
			sum = Math.addExact(sum, number);
			++cnt;
		} --cnt;
		double average = (double)sum / cnt;
		String result = String.format("%.3f", average);
		System.out.println(cnt + "개 정수의 합 = " + sum + ", 평균 = " + result);
		in.close();
	}
}

/* 주의할 점
 * 입력 데이터의 정수 범위 초과 : 하지만 이는 Scanner에서 입력 시 정수 범위를 초과하는 값 입력 시 예외처리를 해주고 있음.
 * 입력한 정수를 sum에 더하는 과정에서의 정수 범위 초과 : 이 문제를 해결하기 위해 Math.addExact(sum, number)를 사용,
   sum의 값이 범위를 초과 시 예외 발생
 */