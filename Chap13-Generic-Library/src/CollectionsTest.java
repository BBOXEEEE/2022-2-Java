import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *  한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 *  @version 2022년도 2학기
 *  @author 김상진 
 *  CollectionsTest.java
 */
public class CollectionsTest {
	
	public static void simple_test() {
		String[] sList = {"apple", "grape", "banana", "strawberry", "kiwi"};
		List<String> list = Arrays.asList(sList);
		System.out.println(Collections.min(list));
		System.out.println(Collections.max(list));
		Collections.sort(list);
		System.out.println(list.get(0));
		Collections.reverse(list);
		System.out.println(list.get(0));
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
	}
	
	public static void nCopies_test() {
		List<Unsigned> list01 = Collections.nCopies(10, null).stream()
			.map(n->new Unsigned()).collect(Collectors.toList());
		list01.get(0).set(1);
		System.out.println(list01);
		
		List<Unsigned> list02 = IntStream.range(0, 10)
			.mapToObj(n->new Unsigned()).collect(Collectors.toList());
		list02.get(0).set(1);
		System.out.println(list02);
		
		// 10개의 객체가 모두 동일 객체
		List<Unsigned> list03 = new ArrayList<>(Collections.nCopies(10, new Unsigned()));
		list03.get(0).set(1);
		System.out.println(list03);
		
		List<Unsigned> list04 = new ArrayList<>(10);
		Collections.nCopies(10, null).forEach(i->list04.add(new Unsigned()));
		list04.get(0).set(1);
		System.out.println(list04);
		
		Unsigned[] arr = new Unsigned[10];
		IntStream.range(0, 10).forEach(i->arr[i]=new Unsigned());
		arr[0].set(1);
		System.out.println(Arrays.toString(arr));
		
		Vector<Unsigned> list06 = new Vector<>();
		list06.setSize(10);
		System.out.println(list06);
	}
	
	public static void main(String[] args) {
		simple_test();
		nCopies_test();
	}

}
