import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *  한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 *  @version 2022년도 2학기
 *  @author 김상진 
 *  ImmutableListTest.java
 *  수정 가능 리스트 vs. 수정 가능하지 않은 리스트
 */
public class ImmutableListTest {
	// of는 수정 가능하지 않은 리스트 반환
	public static void ofTest() {
		List<Integer> nums = List.of(1,2,3,4);
		//nums.add(5);
		//nums.set(0, 0);
		System.out.println(nums);
	}
	
	public static void viewTest() {
		List<Integer> nums = new ArrayList<>(List.of(1,2,3,4));
		nums.add(5);
		nums.set(0, 0);
		System.out.println(nums);
		// 수정 가능한 리스트를 수정 가능하지 않는 리스트로 바꾸는 방법
		List<Integer> view = Collections.unmodifiableList(nums);
		//view.add(6);
		//view.set(0, 1);
		// view는 수정할 수 없지만 view가 가리키는 리스트를 수정할 수 있으며,
		// 수정한 다음 view를 접근하면 수정된 결과를 얻을 수 있음
		nums.add(6);
		nums.set(1, 0);
		System.out.println(view);
	}
	
	public static void streamTest01() {
		// toList의 결과도 unmodifiableList임
		List<Integer> nums = IntStream.range(1, 5).boxed().toList();
		//nums.add(5);
		//nums.set(0, 0);
		System.out.println(nums);
	}
	
	public static void streamTest02() {
		List<Integer> nums = IntStream.range(1, 5).boxed().collect(Collectors.toList());
		nums.add(5);
		nums.set(0, 0);
		System.out.println(nums);
	}
	
	public static void main(String[] args) {
		//ofTest();
		viewTest();
		//streamTest01();
		//streamTest02();
	}

}
