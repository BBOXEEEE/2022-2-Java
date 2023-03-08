import java.util.function.IntUnaryOperator;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2022년도 2학기
 * @author 김상진
 * 14장 예제. 람다 연산자의 우선순위
 * 람다 연산자는 대입 연산자와 우선순위가 같음
 * 결합순서는 대입 연산자와 마찬가지로 거꾸로
 */

public class OperatorPrecedence {
	private int t;
	public void test() {
		IntUnaryOperator op;
		op = x->x;		// ->가 먼저 해석
		op = x->t=x; 	// t=x가 먼저 해석, 그다음 ->, 그다음 = 
		System.out.println(op.applyAsInt(3));
	}
	public void set(int t) {
		this.t = t;
	}
	public int get() {
		return t;
	}
	public static void main(String[] args) {
		OperatorPrecedence o = new OperatorPrecedence();
		o.test();
		System.out.println(o.get());
	}
}
