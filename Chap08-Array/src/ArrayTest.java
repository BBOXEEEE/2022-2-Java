import java.util.Arrays;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기 
 * @author 김상진
 * 배열 관련 기본 예제
 */
public class ArrayTest {
	
	// 자바에서 배열은 모두 동적 생성
	public static void arrayConstruction() {
		System.out.println("\n배열 생성");
		int[] list = new int[5];	// 동적배열은 초기화됨
		System.out.println(Arrays.toString(list));
		int[] other = new int[0];	// 용량이 0인 배열도 생성 가능
		System.out.println(Arrays.toString(other));
		int[] numbers = {1,2,3,4,5};
		System.out.println(Arrays.toString(numbers));
	}
	
	// 자바에서 배열은 객체이며, Object는 배열도 유지할 수 있음
	public static void arrayIsAObject() {
		System.out.println("\n배열은 객체이다.");
		int[] numbers = {1, 4, 3, 5, 7};
		Object o = numbers;
		int[] list = (int[])o;
		System.out.println(o.getClass().getName());
		System.out.println(list[0]);
		
		System.out.println(numbers);
		System.out.println(numbers.hashCode());
		int[] x = {1, 4, 3, 5, 7};
		System.out.println(numbers.equals(x));
		
	}
	
	public static void usingVarWithArray() {
		char[] a1 = {'a', 'b', 'c', 'd', 'e'};
		char a2[] = {'a', 'b', 'c', 'd', 'e'};
		//var[] v1 = {'a', 'b', 'c', 'd', 'e'};
		//var v2[] = {'a', 'b', 'c', 'd', 'e'};
		//var v3 = {'a', 'b', 'c', 'd', 'e'};
		var v4 = new char[] {'a', 'b', 'c', 'd', 'e'};
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		System.out.println(Arrays.toString(v4));
	}
	
	// 자바에서 배열을 인자로 전달하는 것은 객체를 인자로 전달하는 것과 같음
	// 배열은 객체이기 때문에 배열의 용량을 별도로 전달하지 않아도 
	// 매개변수를 통해 배열의 용량을 알 수 있음
	// 하지만 값 전달이기 때문에 매개변수 array가 다른 배열을 가리키도록 변경하더라도
	// 인자에는 영향을 주지 않음
	public static void arrayParameter(int[] array) {
		System.out.println(array.length);
		array[0] = 0;
		array = new int[] {8,8,8};
	}
	public static int[] returningArray(int[] array) {
		int[] tmp = Arrays.copyOf(array, array.length*2);
		return tmp;
	}
	public static void testingReturningArray() {
		System.out.println("\n배열 반환");
		int[] A = {1,2,3,4,5};
		System.out.println(Arrays.toString(A));
		A = returningArray(A);
		System.out.println(Arrays.toString(A));
	}
	// 자바에서 배열은 용량을 유지하는 public final 멤버인 length를 가지고 있음
	public static void lengthMember() {
		System.out.println("\n배열 용량");
		int[] numbers = {1, 4, 3, 5, 7};
		System.out.println(numbers.length);
		arrayParameter(numbers);
		System.out.println(Arrays.toString(numbers));
	}
	// 자바에서 2차원 배열은 연속적 공간으로 할당되지 않음
	// 각 행의 용량이 다른 배열을 정의할 수 있음
	public static void twoDimensionArray() {
		System.out.println("\n2차원 배열");
		int[][] matrix = new int[3][3];
		System.out.println(Arrays.deepToString(matrix));
		int[][] other01 = {{1,2,3},{3,2,1},{1,2,3}};
		System.out.println(Arrays.deepToString(other01));
		int[][] other02 = {{1,2,3},{1},{2,2}};
		System.out.println(Arrays.deepToString(other02));
	}
	public static void main(String[] args) {
		//arrayConstruction();
		//lengthMember();
		arrayIsAObject();
		//testingReturningArray();
		//twoDimensionArray();
	}

}
