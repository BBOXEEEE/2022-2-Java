/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Dog 클래스
 */
public class Dog {
	private String mName;

	public String getName() {
		return mName;
	}
	public void setName(String name) {
		mName = name;
	}
	public void bark(){
		System.out.printf("%s: 멍멍%n", mName);
	}
}

/*
// 두 번째 버전
public class Dog {
	private String mName;
	private String mBreed;

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}
	
	public void setBreed(String breed) {
		mBreed = breed;
	}
	
	public void bark(){
		System.out.printf("%s: ", mName);
		if(mBreed.equals("시추"))
			System.out.println("왈왈");
		else System.out.println("멍멍");
		
	}
}
*/