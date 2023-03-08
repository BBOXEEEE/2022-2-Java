import java.util.ArrayList;
import java.util.Arrays;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기 
 * @author 김상진
 * Foreach For문 예제
 */
public class ForEachForTest {

	// Foreach For문은 원시타입 배열, 객체 배열에 모두 사용가능하며,
	// Iterable Interface를 구현하고 있는 모든 클래스에도 사용 가능
	public static void IteratingArray() {
		int[] numbers = {1, 4, 3, 5, 7};
		for(int n: numbers) System.out.print(n+",");
		System.out.println();
		for(var n: numbers) System.out.print(n+" ");
		System.out.println();
		String[] fruits = {"apple","grape","banana","kiwi"};
		for(var fruit: fruits) System.out.print(fruit+", ");
		System.out.println();
		ArrayList<String> list = new ArrayList<>();
		for(var fruit: fruits) list.add(fruit);
		for(var fruit: list) System.out.print(fruit+", ");
		System.out.println();
	}
	
	public static void conventionalForNeededExample() {
		System.out.println("\n전통 for문이 필요한 경우 다섯 가지");
		// 1) 용량만큼 반복하지 않을 경우
		int[] numbers = {3,5,1,2,9};
		int count = 0;
		for(int i=0; i<2; i++)
			if((numbers[i]&0x01)==1) ++count;
		System.out.println("\nThe number of odds is "+count);
		// 2) 색인이 필요할 때
		int found = -1;
		for(int i=0; i<numbers.length; i++)
			if(numbers[i]==1) {
				found = i; 
				break;
			}
		System.out.println("\n1 is at index "+found);
		// 3) 차례로 방문하지 않을 때
		System.out.println("\n거꾸로 방문");
		for(int i=numbers.length-1; i>=0; i--)
			System.out.print(numbers[i]+",");
		System.out.println();
		System.out.println("\n홀수 위치만 방문");
		for(int i=0; i<numbers.length; i+=2)
			System.out.print(numbers[i]+",");
		System.out.println();
		// 4) 여러 배열을 동시에 반복해야 할 때
		int[] others = {3,5,1,4,9};
		boolean flag = true;
		for(int i=0; i<numbers.length; i++)
			if(numbers[i]!=others[i]) {
				flag = false; 
				break;
			}
		System.out.println(flag? "\n두 배열이 같음": "\n두 배열이 같지 않음");
		// 5) 배열을 수정해야 하는 경우
		for(int i=0; i<numbers.length; i++)
			if((numbers[i]&0x01)==0) {
				++numbers[i];
			}
		System.out.println("\n"+Arrays.toString(numbers));
	}
	
	public static void main(String[] args) {
		IteratingArray();
		conventionalForNeededExample();
	}

}
