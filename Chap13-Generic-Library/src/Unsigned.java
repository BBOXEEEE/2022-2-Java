
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
}
