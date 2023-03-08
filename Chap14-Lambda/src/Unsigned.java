
public final class Unsigned {
	private int n = 0;
	public Unsigned() {}
	public Unsigned(int n) {
		set(n);
	}
	public void set(int n) {
		if(n>=0) this.n = n;
	}
	public int get() {
		return n;
	}
	@Override public int hashCode() {
		return Integer.hashCode(n);
	}
	@Override public boolean equals(Object other) {
		if(other==null||getClass()!=other.getClass()) return false;
		if(this==other) return true;
		Unsigned u = (Unsigned)other;
		return n==u.n;
	}
	@Override public String toString() {
		return String.format("%d", n);
	}
	
	// 이 예제처럼 람다 표현식을 정의하고 바로 실행하는 경우는 거의 없음
	// 캡쳐를 설명하기 위한 예제일 뿐
	// 접근 권한에 영향을 받지 않음
	public void test() {
		Magic x = ()->{ this.n = 10; };
		x.doAnything();
	}
}
