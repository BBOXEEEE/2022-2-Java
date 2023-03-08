import java.util.Scanner;

public class Maximum69 {
	public static int solve(int number) {
		return Integer.parseInt(("" + number).replaceFirst("6", "9"));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; ++i) {
			int number = in.nextInt();
			System.out.println(solve(number));
		}
		in.close();
	}
}