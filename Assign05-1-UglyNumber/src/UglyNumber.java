import java.util.Scanner;

public class UglyNumber {
	
	public static boolean isUglyNum(int number) {
		if(number == 0) return false;
		if(number == 1) return true;
		
		if(number % 2 == 0) {
			number /= 2;
			return isUglyNum(number);
		}
		if(number % 3 == 0) {
			number /= 3;
			return isUglyNum(number);
		}
		if(number % 5 == 0) {
			number /= 5;
			return isUglyNum(number);
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; ++i) {
			int number = in.nextInt();
			System.out.println(isUglyNum(number));
		}
		in.close();
	}
}
