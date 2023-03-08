import java.util.Scanner;

public class ArraySign {
	public static int solve(int[] nums) {
		int ret = 1;
		for(int num: nums) {
			if(num == 0) return 0;
			if(num < 0) ret *= -1;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=0; t<T; ++t) {
			int N = in.nextInt();
			int[] numberArray = new int[N];
			for(int i=0; i<N;++i) 
				numberArray[i] = in.nextInt();
			System.out.println(solve(numberArray));
		}
		in.close();
	}
}