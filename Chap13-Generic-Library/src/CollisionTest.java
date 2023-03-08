import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 *  @version 2022년도 2학기
 *  @author 김상진 
 *  CollectionsTest.java
 *  HashSet, HashMap을 사용할 경우에는 hashCode를 잘 정의하는 것이 중요
 *  - 충돌이 발생하지 않도록 정의해야 함
 */
public class CollisionTest {
	// k1과 k2의 해시값이 같지만 equals가 다르기 때문에 충돌
	public static void set_collision_test() {
		Key k1 = new Key(1,3);
		Key k2 = new Key(3,1);
		Set<Key> set = new HashSet<>(13);
		set.add(k1);
		set.add(k2);
		for(var x: set)
			System.out.println(x);
		Key k3 = new Key(4,0);
		if(set.contains(k3)) System.out.println(k3+" is already in the set");
	}
	
	public static void map_collision_test() {
		Key k1 = new Key(1,3);
		Key k2 = new Key(3,1);
		Map<Key, String> map = new HashMap<>(13);
		map.put(k1,"apple");
		map.put(k2,"banana");
		for(var x: map.entrySet())
			System.out.println(x.getKey()+": "+x.getValue());
		Key k3 = new Key(4,0);
		if(map.containsKey(k3)) System.out.println(k3+" is already in the set");
	}
	
	public static void main(String[] args) {
		set_collision_test();
		map_collision_test();
	}
}
