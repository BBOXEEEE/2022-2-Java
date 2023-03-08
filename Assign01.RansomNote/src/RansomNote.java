import java.util.Scanner;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 2019136056 박세
 * 과제1. RansomNote
 */

public class RansomNote {
	
	public static boolean canConstruct(String ransomNote, String magazine) {
		int[] freq = new int[26];
		for(int i = 0; i<magazine.length(); ++i)
			++freq[magazine.charAt(i) - 'a'];
		for(int i = 0; i<ransomNote.length(); ++i)
			--freq[ransomNote.charAt(i) - 'a'];
		for(int i = 0; i<26; ++i)
			if(freq[i] < 0) return false;
		return true;
	}
	
	public static boolean checkDone() {
		Scanner in = new Scanner(System.in);
		System.out.printf("계속y/n)? ");
		char c = in.next().charAt(0);
		in.close();
		if(c == 'y' || c == 'Y')
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean done = true;
		while(done) {
			System.out.printf("랜섬 노트 입력 : ");
			String ransomNote = in.nextLine();
			System.out.printf("잡지 문자열 입력 : ");
			String magazine = in.nextLine();
			if(ransomNote.length() > magazine.length()) {
				System.out.printf("잡지 문자열을 랜섬 노트보다 길게 입력%n");
				done = checkDone();
			}
			else {
				System.out.printf(canConstruct(ransomNote, magazine) ?
						"랜섬 노트 작성 가능%n": "랜섬 노트 작성 불가%n");
					done = checkDone();
			}
		}
		in.close();
	}

}