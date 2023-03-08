import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2022년도 2학기
 * @author 김상진
 */
public class StreamOrderingTest {
	public static void compareResults01() {
		List<Integer> list = Arrays.asList(1,5,3,4,9,6,2,8,7);
		Set<Integer> set = new HashSet<>(list);
		Queue<Integer> output = new LinkedList<>();
		list.stream().filter(n->(n&1)==1).forEachOrdered(n->output.add(n));
		System.out.println(output);
		output.clear();
		set.stream().filter(n->(n&1)==1).forEach(n->output.add(n));
		System.out.println(output);
		output.clear();
		list.parallelStream().filter(n->(n&1)==1).forEachOrdered(n->output.add(n));
		System.out.println(output);
		output.clear();
		set.parallelStream().filter(n->(n&1)==1).forEach(n->output.add(n));
		System.out.println(output);
		output.clear();
		list.stream().unordered().parallel().filter(n->(n&1)==1).forEach(n->output.add(n));
		System.out.println(output);
		output.clear();
		list.parallelStream().filter(n->(n&1)==1).forEach(n->output.add(n));
		System.out.println(output);
	}
	
	public static void compareResults02() {
		List<Integer> list = Arrays.asList(1,5,3,4,9,6,2,8,7);
		Set<Integer> set = new HashSet<>(list);
		System.out.println(Arrays.toString(list.stream().filter(n->(n&1)==1).toArray()));
		System.out.println(Arrays.toString(set.stream().filter(n->(n&1)==1).toArray()));
		System.out.println(Arrays.toString(list.parallelStream().filter(n->(n&1)==1).toArray()));
		System.out.println(Arrays.toString(set.parallelStream().filter(n->(n&1)==1).toArray()));
		System.out.println(Arrays.toString(list.stream().unordered().parallel().filter(n->(n&1)==1).toArray()));
		System.out.println(Arrays.toString(list.stream().parallel().filter(n->(n&1)==1).toArray()));
	}
	
	public static void compareResults03() {
		List<Integer> list = Arrays.asList(1,5,3,4,9,6,2,8,7);
		for(int i=0; i<10; i++) {
			System.out.println(Arrays.toString(list.parallelStream().filter(n->(n&1)==1).toArray()));
		}
	}
	public static void main(String[] args) {
		compareResults01();
		//compareResults02();
		//compareResults03();
	}

}
