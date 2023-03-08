import java.util.Scanner;

public class IncreaseDecreaseArray {
	public static boolean solve(int[] A) {
		return isIncrease(A) || isDecrease(A);
	}
	
	public static boolean isIncrease(int[] A) {
		for(int i=0; i<A.length-1; ++i)
			if(A[i] > A[i+1]) return false;
		return true;
	}
	
	public static boolean isDecrease(int[] A) {
		for(int i=0; i<A.length-1; ++i)
			if(A[i] < A[i+1]) return false;
		return true;
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