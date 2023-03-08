import java.util.Stack;

/**
 *  @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 *  @version 2022년도 2학기
 *  @author 김상진 
 *  StackTest.java
 *  괄호 검사
 */
public class StackTest {
	// 기본 괄호 검사
	public static boolean validParenthesesV1(String exp){	
		if(exp.length()==0) return true;	
		// 기본 용량이 10
		Stack<Character> stack = new Stack<>();
		stack.ensureCapacity(exp.length());
		//Deque<Character> stack = new LinkedList<>();
		for(var c: exp.toCharArray()){		
			switch(c){		
			case '(', '{', '[':			
				stack.push(c);	 
				break;		
			case ')', '}', ']':
				if(stack.isEmpty()) return false;			
				char lp = stack.pop();			
				if((lp=='(' && c==')') || (lp=='{' && c=='}') || (lp=='[' && c==']'))
					break;
				else return false;		
			}	
		} 	
		return stack.isEmpty();
	}
	
	// 기본 괄호 검사 (우선 순위 고려)
	public static boolean validParenthesesV2(String exp){	
		if(exp.length()==0) return true;	
		Stack<Character> stack = new Stack<>();	
		for(var c: exp.toCharArray()){		
			switch(c){		
			case '(', '{', '[':
				if(!stack.isEmpty()) {
					char top = stack.peek();
					if((c=='{' && top=='(') || (c=='[' && top!='[')) return false;
				}
				stack.push(c);	 
				break;		
			case ')', '}', ']':
				if(stack.isEmpty()) return false;			
				char lp = stack.pop();	
				if(lp=='(' && c==')' || lp=='{' && c=='}' ||
					lp=='[' && c==']') break;
				else return false;		
			}	
		} 	
		return stack.isEmpty();
	}
	
	public static void validParenthesesV1Test() {
		System.out.println("((()))[]: "+validParenthesesV1("((()))[]"));
		System.out.println("(){}[]: "+validParenthesesV1("(){}[]"));
		System.out.println("{()}[]: "+validParenthesesV1("{()}[]"));
		System.out.println("((())[]: "+validParenthesesV1("((())[]"));
		System.out.println("())[]: "+validParenthesesV1("())[]"));
	}
	
	public static void validParenthesesV2Test() {
		System.out.println("((()))[{()()}]: "+validParenthesesV2("((()))[{()()}]"));
		System.out.println("()()(): "+validParenthesesV2("()()()"));
		System.out.println("(){}(): "+validParenthesesV2("(){}()"));
		System.out.println("()[](): "+validParenthesesV2("()[]()"));
		System.out.println("()[{}](): "+validParenthesesV2("()[{}]()"));
		System.out.println("(){()}(): "+validParenthesesV2("(){()}()"));
		System.out.println("({})(): "+validParenthesesV2("({})()"));
		System.out.println("{()()[]}: "+validParenthesesV2("{()()[]}"));
	}
	
	public static void main(String[] args) {
		//validParenthesesV1Test();
		validParenthesesV2Test();
	}

}
