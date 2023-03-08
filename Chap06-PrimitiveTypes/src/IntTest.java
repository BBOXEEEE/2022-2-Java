/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 정수타입 예제
 */
public class IntTest {
	public static void stringToIntTest() {
		int n = 10;
		String s = "21";
		
		int x1 = Integer.valueOf(s).intValue();
		int x2 = Integer.valueOf(s);
		int x3 = Integer.parseInt(s);
		
		String str1 = ""+n;
		String str2 = Integer.toString(n);
		String str3 = Integer.valueOf(n).toString();
		
		System.out.println(x1+", "+x2+", "+x3);
		System.out.println(str1+", "+str2+", "+str3);
	}
	
	public static void wrapperTest() {
		int n = 10;
		Integer o = 10;
		o = n+10;
		n = o;
		//o = new Integer(n);  // error in Java 9
		o = Integer.valueOf(n);
		n = o.intValue();
	}
	
	public static void typecastTest() {
		int a = (int)5.1f;
		int b = (int)-3.9f;
		System.out.println(a+b);
	}
	
	public static void intTest() {
		int n = -11;
		System.out.println(n%2);
	}
	
	// byte, short, char에 정수식의 대입은 그 평가 값에 따라 문법 오류 여부가 결정됨
	public static void byteTest() {
		int m = 100;
		//byte b1 = 200; 	// error
		byte n = 100;
		n = 50 * 2;
		//n = 50 * 300;
		//byte b2 = m; 	// error
		//n = n * n: 		// error
		n = 10;
		//n = n * n;
		System.out.printf("%d, %d%n", m, n);
		
		int s = 0;
		for(byte b = 0; b<128; b++) {
			++s;
		}
		System.out.println(s);
	}
	
	public static void compareTest() {
		int a = 2001921338;
		int b = -2107054364;
		System.out.printf("%d, %d%n", a, b);
		System.out.println(a-b);		
		System.out.println(Integer.compare(a,b));
	}
	
	public static void main(String[] args) {
		//intTest();
		//byteTest();
		//typecastTest();
		//stringToIntTest();
		//compareTest();
	}

}
