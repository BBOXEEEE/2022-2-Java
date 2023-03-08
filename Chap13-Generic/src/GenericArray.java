import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class GenericArray {
	
	// 범용 클래스 배열을 만들 수 없음
	public static void test_genericArray() {
		//List<Integer>[] table = new ArrayList<Integer>[10]; // 이것이 가능하지 않음
		// 대신 Object 배열을 생성한 후에 각 요소에 범용 자료구조 객체를 저장할 수 있음
		Object[] table = new Object[10];
		for(int i=0; i<table.length; ++i)
			table[i] = new ArrayList<Integer>();
		@SuppressWarnings("unchecked")
		ArrayList<Integer> x = (ArrayList<Integer>) table[0];
		x.add(10);
		x.add(5);
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		test_genericArray();
	}

}
