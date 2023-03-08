import java.util.Scanner;
import java.util.Arrays;

public class findCommonFreq {
	public static int ALPHA = 26;
	
	public static String solve(String[] words) {
		int[] commonFreq = new int[ALPHA];
		Arrays.fill(commonFreq, 987654321);
		for(String word: words) {
			int[] alphaFreq = new int[ALPHA];
			for(char c: word.toCharArray())
				++alphaFreq[c-'a'];
			for(int i=0; i<ALPHA; ++i)
				commonFreq[i] = Math.min(commonFreq[i], alphaFreq[i]);
		}
		int len = 0;
		for(var n: commonFreq) len += n;
		StringBuilder ret = new StringBuilder(len);
		for(int i=0; i<ALPHA; ++i)
			for(int j=0; j<commonFreq[i]; ++j)
				ret.append("" + (char)(i+'a'));
		return ret.toString();

		/* repeat method 활용 
		for(int i=0; i<ALPHA; ++i)
			if(commonFreq[i]>0) ret.append(("" + (char)(i+'a')).repeat(commonFreq[i]));
		return ret.toString();
		*/
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=0; t<T; ++t) {
			int N = in.nextInt();
			String[] words = new String[N];
			for(int i=0; i<N; ++i)
				words[i] = in.next();
			System.out.println(solve(words));
		}
		in.close();
	}
}
