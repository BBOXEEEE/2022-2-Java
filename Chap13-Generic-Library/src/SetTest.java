import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *  @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 *  @version 2022년도 2학기
 *  @author 김상진 
 *  SetTest.java
 */

enum WeekDay {
	SUN, MON, TUE, WED, THU, FRI, SAT
}

public class SetTest {
	public static void hashSet_test() {
		Set<Integer> s = new HashSet<>(7);
		s.add(5);
		s.add(3);
		s.add(7);
		s.add(5);
		System.out.println(s.size());
		System.out.println(s.contains(5));
		s.remove(3);
		System.out.println(s.size());
	}
	
	// TreeSet, SortedSet
	public static void treeSet_test01() {
		Set<Integer> s = new TreeSet<>();
		s.add(5);
		s.add(3);
		s.add(7);
		s.add(5);
		s.add(9);
		System.out.println(s.size());
		System.out.println(s.contains(5));
		s.remove(3);
		System.out.println(s.size());
		
		SortedSet<Integer> x = (SortedSet<Integer>) s;
		System.out.println(x.last());
		System.out.println(x.first());
		SortedSet<Integer> y = x.tailSet(7);
		for(var n: y)
			System.out.print(n+",");
		System.out.println();
	}
	
	// TreeSet에 저장하는 데이터는 Comparable interface를 구현하거나
	// 구현하지 않는 경우 비교에 사용할 메소드를 생성할 때 제공해야 함
	public static void treeSet_test02() {
		Set<Unsigned> s = new TreeSet<>(Comparator.comparingInt(Unsigned::get));
		s.add(new Unsigned(5));
		s.add(new Unsigned(3));
		s.add(new Unsigned(7));
		s.add(new Unsigned(1));
		System.out.println(s.size());
		System.out.println(s.contains(new Unsigned(3)));
		s.remove(new Unsigned(3));
		System.out.println(s.size());
	}
	
	// EnumSet 
	public static void enumSet_test() {
		Set<WeekDay> weekend = EnumSet.<WeekDay>of(WeekDay.SUN, WeekDay.SAT);
		Set<WeekDay> workingDay = EnumSet.range(WeekDay.MON, WeekDay.FRI);
		WeekDay w = WeekDay.MON;
		if(weekend.contains(w)) System.out.println(w+" is a weekend");
		if(workingDay.contains(w)) System.out.println(w+" is a working day");
	}
	
	public static boolean containDuplicates(int[] list) {
		if(list==null||list.length<=1) return false;
		Set<Integer> set = new HashSet<>();
		for(int n: list)
			if(set.contains(n)) return true; 
			else set.add(n);
		return false;
	}
	
	// 중복 검사
	public static void containDuplicates_test() {
		int[] list = {1,3,4,2,7,9,11,0,-1};
		System.out.println(containDuplicates(list));
		list = new int[]{1,3,4,3,9,9,0,1};
		System.out.println(containDuplicates(list));
 	}
	
	public static void main(String[] args) {
		hashSet_test();
		//enumSet_test();
		//treeSet_test01();
		//treeSet_test02();
		//containDuplicates_test();
	}

}
