/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기 
 * @author 김상진
 * String 클래스 사용법
 */
public class StringTest {
	
	public static void primitiveToString() {
		int n = 10;
		String s = ""+n;
		int a = Integer.parseInt(s);
		int b = Integer.valueOf(s);
		int c = Integer.valueOf(s).intValue();
		System.out.println(s+", "+a+", "+b+", "+c);
	}
	// 숫자, 대문자, 소문자 순
	// 문자열이 긴 것이 
	public static void compareToTest() {
		System.out.println("banana".compareTo("apple")>0);
		System.out.println("banana".compareTo("banana")==0);
		System.out.println("banana".compareTo("grape")<0);
		System.out.println("lesson10".compareTo("lesson2")<0);
		System.out.println("Apple".compareTo("apple")<0);
		System.out.println("123".compareTo("apple")<0);
		System.out.println("apples".compareTo("apple")>0);
	}
	
	public static void stringPoolTest() {
		String x = "";
		String y = x+"abcdef"; // 변수를 이용한 결합은 문자열 풀에 포함되지 않음
		System.out.println(y.intern()==y); // y.intern() 호출로 "abcdef"가 풀에 추가됨
		String z = y.intern(); // z는 풀에 있는 "abcdef"를 얻음
		String a="abc";
		String b="def";
		String c=a+b;
		String d="abc"+"def"; // 문자열 리터럴 결합은 문자열 풀에 포함됨
		String e="abcdef";
		System.out.println(c==e);
		System.out.println(d==e);
		System.out.println(y==e);
		System.out.println(z==e);
	}
	
	public static int charFrequencyUsingFor01(String s, int ch){
		char[] list = s.toCharArray();
		int count = 0;
		for(var c: list)
			if(c==ch) ++count;
		return count;
	}
	
	public static int charFrequencyUsingFor02(String s, int ch){
		char[] list = new char[s.length()];
		s.getChars(0, s.length(), list, 0);
		int count = 0;
		for(var c: list)
			if(c==ch) ++count;
		return count;
	}
	
	public static int charFrequencyUsingIndexOf(String s, int ch){
		int count = 0;
		int index = s.indexOf(ch);
		while(index!=-1) {
			++count;
			index = s.indexOf(ch, index+1);
		}
		return count;
	}
	
	public static int charFrequencyUsingReplace(String s, int ch){
		String tmp = s.replace(""+(char)ch,"");
		return s.length()-tmp.length();
	} // charFrequency(String, int)
	
	public static int vowelFrequency(String s){
		int count = 0;
		for(var c: s.toLowerCase().toCharArray()){
			if("aeiou".indexOf(c)!=-1) ++count;
		}
		return count;
	} // charFrequenc(String, int);
	
	
	public static void main(String[] args) {
		//primitiveToString();
		//compareToTest();
		stringPoolTest();
		//System.out.println(charFrequencyUsingFor01("banana",'a'));
		//System.out.println(charFrequencyUsingIndexOf("banana",'a'));
		//System.out.println(charFrequencyUsingReplace("banana",'a'));
		//System.out.println(vowelFrequency("banana"));
	}
}
