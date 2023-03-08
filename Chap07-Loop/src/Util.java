/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 2022년도 2학기
 * @author 김상진 
 * 반복문 활용이 필요한 간단한 문제들
 * 반복문 예제
 */
public class Util {
	// 주어진 정수의 각 자릿수에 주어진 숫자가 몇 개 등장하는지 계산하시오. 
	public static int countNumberOfDigits(int num, int digit) {
		if(digit<0||digit>9) return 0;
		if(num==0&&digit==0) return 1;
		int count = 0;
		while(num!=0) {
			if(Math.abs(num%10)==digit) ++count;
			num /= 10;
		}
		return count;
	}
	
		
	// 주어진 양의 정수보다 작은 소수의 개수를 계산
	public static int countPrimes(int n) {
		if(n<=1) return 0;
		int[] composite = new int[n];
		composite[0] = composite[1] = 1;
		for(int i=2; i<=Math.sqrt(n); ++i) {
			if(composite[i]==1) continue;
			else {
				int p = i+i;
				while(p<n) {
					composite[p] = 1;
					p += i;
				}
			}
		}
		int count=0;
		for(int i=2; i<n; ++i) {
			if(composite[i]==0) ++count;
		}
		return count;
		
	}
	
	
	// 주어진 양의 정수가 그 수를 구성하는 모든 자릿수로 나누어지면 자체 나눔수라 함
	// 주어진 양의 정수가 자체 나눔수인지 판단하는 함수를 작성하시오.
	public static boolean isSelfDividingNumber(int n) {
		if(n<=0) return false;
		int x = n;
		while(x>0) {
			int digit = x%10;
			if(digit == 0 || n % digit != 0) return false;
			x /= 10;
		}
		return true;
	}
	
	// nums = 12223 --> 32221
	public static int reverseNumber(int num) {
		boolean isNegative = num<0;
		int rev = 0;
		while(num!=0) {
			int d = Math.abs(num%10);
			if(rev>(Integer.MAX_VALUE-d)/10) 
				return isNegative? Integer.MIN_VALUE: Integer.MAX_VALUE;
			rev = rev*10 + d;
			num /= 10;
		}
		return isNegative? -rev: rev;
	}
	
	// 팰린드롬 여부를 검사 (앞으로 읽으나 뒤로 읽으나 같은 경우)
	// 문자열로 변환
	public static boolean isPalindrome01(int n) {
		long L = n;
		L = Math.abs(L);
		String x = L+"";
		int E = x.length()-1;
		int S = 0;
		while(S<E) {
			if(x.charAt(S)!=x.charAt(E)) return false;
			++S;
			--E;
		}
		return true;
	}
	
	public static boolean isPalindrome02(int n) {
		int rev = 0;
		int tmp = n;
		while(tmp!=0) {
			int d = Math.abs(tmp%10);
			if(rev>(Integer.MAX_VALUE-d)/10) 
				return false;
			rev = rev*10 + d;
			tmp /= 10;
		}
		return rev==Math.abs(n);
	}
}
