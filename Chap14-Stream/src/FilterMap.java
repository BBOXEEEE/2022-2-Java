import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 14장 예제
 * @version 2022년도 2학기
 * @author 김상진
 * filter map의 생성과 중간 연산 allMatch 사용법 
 */

public class FilterMap {
	private static class TestObject {
		  private int property1;
		  private int property2;
		  private int property3;

		  public TestObject(int property1, int property2, int property3) {
		      this.property1 = property1;
		      this.property2 = property2;
		      this.property3 = property3;
		  }

		  public int getProperty(int key) {
		      switch(key){
		          case 1: return property1;
		          case 2: return property2;
		          default: return property3;
		      }
		  }
	}

	public static void main(String[] args) {
		List<TestObject> list = new ArrayList<>();
	    list.add(new TestObject(1, 2, 3));
	    list.add(new TestObject(1, 2, 4));
	    list.add(new TestObject(1, 4, 3));
	    list.add(new TestObject(2, 2, 3));
	    
	    Map<Integer, Integer> filterMap = new HashMap<>();
	    filterMap.put(3, 3); //Filter property3 == 3
	    filterMap.put(2, 2); //Filter property2 == 2
	    
	    List<TestObject> newList = 
	    	list.stream().filter(x->filterMap.entrySet().stream().allMatch(e->x.getProperty(e.getKey())==e.getValue())).collect(Collectors.toList());
	    newList.forEach(x->System.out.printf("%d, %d, %d%n", x.getProperty(1), x.getProperty(2), x.getProperty(3)));
	}

}
