/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기 
 * @author 김상진
 * StringBuilder 예제
 * StringBuilder을 기본 생성자로 생성하면 초기 용량은 16임
 */
public class StringBuilderTest {
	public static void simpleTest() {
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		s1.setLength(6);
		s2.setLength(6);
		s1.setCharAt(0, 'b');
		s2.setCharAt(0, 'b');
		s1.setCharAt(5, 'a');
		s2.setCharAt(4, 'a');
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(s1.compareTo(s2));
	}
	public static boolean isPalindrome(String s){
		return s.equals((new StringBuilder(s)).reverse().toString());
	}
	// LeetCode 482
	// 주어진 문자열을 재구성. 
	// 첫 번째 구간을 제외하고 나머지 구간은 모두 k 길이어야 함
	// 각 구간은 '-'로 구분
	// 모든 영문자는 대문자로 바꾸어야 함
	public static String licenseKeyFormatting(String s, int k) {
        String R = s.replace("-","").toUpperCase();
        int RLen = R.length();
        if(RLen==0) return "";
        int i = RLen%k; 
        if(i==0) i = k;
        StringBuilder ret = new StringBuilder(s.length());
        ret.append(R.substring(0, i));
        while(i+k<RLen){
            ret.append("-");
            ret.append(R.substring(i, i+k));
            i += k;
        }
        if(i<RLen){
            ret.append("-");    
            ret.append(R.substring(i)); 
        }
        return ret.toString();
    }
	public static void licenseKeyFormattingTest() {
		System.out.println(licenseKeyFormatting("5F3Z-2e-9-w",4));
		System.out.println(licenseKeyFormatting("2-5g-3-J",2));
		System.out.println(licenseKeyFormatting("---",3));
		System.out.println(licenseKeyFormatting("2-4A0r7-4k",4));
	}
	
	public static void main(String[] args) {
		simpleTest();
		System.out.println(isPalindrome("abba"));
		licenseKeyFormattingTest();
	}
}
