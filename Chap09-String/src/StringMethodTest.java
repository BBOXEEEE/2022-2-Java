/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기 
 * @author 김상진
 * 문자열 클래스 String의 각 종 메소드 사용 예제
 */
public class StringMethodTest {
	
	public static void startsWith_EndsWith_Test() {
		System.out.println("\nstartsWith, endsWith Test\n");
		String[] fruits = {"apple", "banana", "grape", 
				"kiwi", "melon", "mango"};
		for(String fruit: fruits){
			if(fruit.startsWith("m")) System.out.print(fruit+",");
		}
		System.out.println();
		for(String fruit: fruits){
			if(fruit.endsWith("e")) System.out.print(fruit+",");
		}
		System.out.println();
	}
	
	// 특수 문자의 사용
	public static void codePointTest() {
		System.out.println("codePoints, codePointCount method test");
		String withSpecialChars = "Drink🍺";
		int length = withSpecialChars.length();
		System.out.println(length);
		System.out.println(withSpecialChars.codePointCount(0,length));
		int[] codePoints = withSpecialChars.codePoints().toArray();
		for(var n: codePoints) {
			if(Character.isSupplementaryCodePoint(n))
				System.out.println(Character.toChars(n));
			else System.out.println((char)n);
		}
	}
	// static method인 join
	public static void joinTest() {
		System.out.println("join static method test");
		String fruits = "apple grape banana melon";
		String[] fruitList = fruits.split(" ");
		
		String s = String.join(", ", fruitList);
		//String fruits = String.join(", ", "apple", "banana", "melon");
		System.out.println(s);
	}
	// lines 메소드: 나중에 람다표현식과 stream을 이해하여야 함
	public static void lineTest() {
		System.out.println("lines method test");
		String fruits = "apple\ngrape\nbanana\nmelon";
		fruits.lines().forEach(System.out::println);;	
	}
	public static void splitTest() {
		System.out.println("split method test");
		String fruits = "apple grape banana melon";
		String[] fruitList = fruits.split(" ");
		for(var s: fruitList) System.out.print(s+", ");
		System.out.println();
		String lineFruits = "apple\ngrape\nbanana\nmelon";
		//fruitList = lineFruits.split("\\n");
		fruitList = lineFruits.split("\\s");
		//fruitList = lineFruits.split("\\R");
		for(var s: fruitList) System.out.print(s+", ");
		System.out.println();
	}
	public static void repeatTest() {
		System.out.println("repeat method test");
		String s = "CSE".repeat(5); 
		System.out.println(s);
		String blanks = " ".repeat(10);
		System.out.println(blanks);
	}
	
	public static void main(String[] args) {
		startsWith_EndsWith_Test();
		codePointTest();
		joinTest();
		lineTest();
		repeatTest();
		splitTest();
	}

}
