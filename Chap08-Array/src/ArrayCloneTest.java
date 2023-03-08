import java.util.Arrays;
/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기 
 * @author 김상진
 * 배열 복제 또는 복사
 */

class X{
	public int n;
	public X(int n) {
		this.n = n;
	}
	@Override public String toString() {
		return String.valueOf(n);
	}
}

class Y{
	public int n;
	public Y(int n) {
		this.n = n;
	}
	@Override public String toString() {
		return String.valueOf(n);
	}
}

public class ArrayCloneTest {
	// clone을 이용한 배열 복제
	// 배열 자체가 가지고 있는 기능
	// 같은 용량의 동일 내용의 배열을 만들 때 유용함
	public static void cloneTest() {
		int[] list = {1,2,3,4,5};
		int[] copy = list.clone();
		copy[0] = 0;
		System.out.println("Using clone");
		System.out.println(Arrays.toString(list));
		System.out.println(Arrays.toString(copy));
	}
	// System.arraycopy를 이용한 배열 복사
	// clone과 달리 공간 확보를 직접해야 함
	// 장점. 배열의 일부만 복사할 수 있음
	// 단점. 미리 공간이 확보되어 있어야 함
	public static void SystemArraycopy() {
		int[] list = {1,2,3,4,5};
		int[] copy = new int[list.length];
		int[] other = {1,1,1,1,1};
		System.out.println("Using System.arraycopy");
		System.arraycopy(list, 0, copy, 0, list.length);
		System.arraycopy(list, 2, other, 0, list.length-2);
		copy[0] = 0;
		System.out.println(Arrays.toString(list));
		System.out.println(Arrays.toString(copy));
		System.out.println(Arrays.toString(other));
	}
	// Arrays.copyOf를 사용한 복제
	// 장점. 복사할 때 용량을 조절할 수 있음
	public static void arraysCopyOf() {
		int[] list = {1,2,3,4,5};
		int[] copy = Arrays.copyOf(list, list.length);
		int[] other1 = Arrays.copyOf(list, list.length*2);
		int[] other2 = Arrays.copyOf(list, list.length/2);
		copy[0] = 0;
		System.out.println("Using Arrays.copyOf");
		System.out.println(Arrays.toString(list));
		System.out.println(Arrays.toString(copy));
		System.out.println(Arrays.toString(other1));
		System.out.println(Arrays.toString(other2));
	}
	
	public static void copyingObjectArrayTest() {
		X[] arr_a = new X[5];
		for(int i=0; i<arr_a.length; ++i)
			arr_a[i] = new X(i);
		Object[] arr_b = new Y[5];
		for(int i=0; i<arr_b.length; ++i)
			arr_b[i] = new Y(i);
		X[] copy_a1 = Arrays.copyOf(arr_a, arr_a.length*2);
		// 이 출력을 통해 copyOf는 shallow copy만 한다는 것을 알 수 있음
		// 복제된 배열의 각 요소가 가리키는 객체와 원 배열의 각 요소가 가리키는 객체가 같음
		for(int i=0; i<5; ++i) {
			System.out.printf("%d, %d%n", 
				System.identityHashCode(arr_a[i]),System.identityHashCode(copy_a1[i]));
		}
		Y[] copy_a2 = (Y[]) Arrays.copyOf(arr_b, arr_b.length*2);
		// ArrayStoreException
		//X[] copy_a3 = Arrays.copyOf(arr_b, arr_b.length*2, X[].class);
		// ClassCastException
		//X[] copy_a4 = (X[]) Arrays.copyOf(arr_b, arr_b.length*2);
		System.out.println(Arrays.toString(copy_a2));
	}
	
	public static void main(String[] args) {
		//cloneTest();
		//SystemArraycopy();
		//arraysCopyOf();
		
		copyingObjectArrayTest();
	}

}
