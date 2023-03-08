import java.util.Scanner;

public class strDecryption {
	public static String solve(String code) {
		/*
		for(int i=10; i<=26; ++i)
            code = code.replaceAll(i+"#", (char)('a'+(i-1))+"");
        for(int i=1; i<=9; ++i)
            code = code.replaceAll(i+"", (char)('a'+(i-1))+"");
		return code;
		*/
		String ret = "";
		for(int i=0; i<code.length(); ++i) {
			if(code.charAt(i+2) == '#' && i+2 < code.length()) {
				ret += Integer.parseInt(Character.toString(code.charAt(i) + code.charAt(i+1))) + 96;
				i += 2;
				System.out.println(ret);
			}
			else {
				System.out.println(ret);
				ret += Integer.parseInt(Character.toString(code.charAt(i))) + 96;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=0; t<T; ++t) {
			String code = in.next();
			System.out.println(solve(code));
		}
		in.close();
	}
}
