import java.util.Scanner;

public class CountDigit {
	public static int countDigit(int number, int digit) {
		if(digit >= 10 || digit < 0) return 0;
		String strNum = Integer.toString(number);
		int count = 0;
		for(int i=0; i<strNum.length(); ++i) {
			if((strNum.charAt(i) - digit) == '0')
				++count;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; ++i) {
			int number = in.nextInt();
			int digit = in.nextInt();
			System.out.println(countDigit(number, digit));
		}
		in.close();
	}
}
