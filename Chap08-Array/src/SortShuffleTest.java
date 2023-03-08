import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기 
 * @author 김상진
 * 배열 sort, shuffle
 */
public class SortShuffleTest {
	// 삽입 정렬
	// 현재 위치에 있는 요소를 앞 요소들과 비교하여 올바른 위치에 삽입
	// 매 반복할 때마다 그 위치까지는 정렬됨
	public static void insertionSort(int[] A) {
		for(int i=1; i<A.length; i++) {
			int temp = A[i];
			int j=i-1;
			while(j>=0 && temp<A[j]){
				A[j+1] = A[j];
				--j;
			}
			A[j+1] = temp;
		}
	}
	// 선택 정렬
	// 전체에서 가장 작은 값을 맨 앞으로
	public static void selectionSort(int[] A) {
		for(int i=0; i<A.length-1; i++) {
			int minLoc = i;
			for(int j=i+1; j<A.length; j++) {
				if(A[minLoc]>A[j]) minLoc = j;
			}
			if(minLoc!=i) {
				int tmp = A[minLoc];
				A[minLoc] = A[i];
				A[i] = tmp;
			}
		}
	}
	// 버블 정렬
	// 서로 비교하여 계속 바꾼다.
	public static void bubbleSort(int[] A) {
		for(int i=0; i<A.length-1; i++) {
			boolean flag = false;
			for(int j=A.length-1; j>=i+1; j--) {
				if(A[j-1]>A[j]) {
					int tmp = A[j];
					A[j] = A[j-1];
					A[j-1] = tmp;
					flag = true;
				}
			}
			if(!flag) break;
		}
	}
	public static void sortTest() {
		System.out.println("Sort Test");
		int[] nums = {5, 1, 6, 2, 9, 4, -1};
		System.out.println(Arrays.toString(nums));
		int[] other = nums.clone();
		insertionSort(other);
		System.out.println(Arrays.toString(other));
		other = nums.clone();
		selectionSort(other);
		System.out.println(Arrays.toString(other));
		other = new int[]{7,6,5,4,3,2,1};
		bubbleSort(other);
		System.out.println(Arrays.toString(other));
		other = nums.clone();
		Arrays.sort(other);
		System.out.println(Arrays.toString(other));
	}
	
	public static void shuffle(int A[]) {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		int n = A.length;
		for(int i=0; i<A.length; i++) {
			int r = random.nextInt(n);
			int tmp = A[n-1];
			A[n-1] = A[r];
			A[r] = tmp;
			--n;
		}
	}
	
	public static void shuffleTest() {
		System.out.println("Shuffle Test");
		int[] nums = {5, 1, 6, 2, 9, 4, -1};
		System.out.println(Arrays.toString(nums));
		int[] other = nums.clone();
		shuffle(other);
		System.out.println(Arrays.toString(other));
		
		ArrayList<Integer> list = new ArrayList<>();
		for(var n: nums) list.add(n);
		Collections.shuffle(list);
		int[] array = list.stream().mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		sortTest();
		shuffleTest();
	}

}
