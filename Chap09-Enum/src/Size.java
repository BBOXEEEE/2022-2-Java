/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기 
 * @author 김상진
 * Size 열거형
 * 각 열거형마다 추가 데이터가 필요할 경우
 * 1) 각 열거형의 멤버 변수로 데이터 추가 (생성자 추가 필요)
 *  - 보통 멤버 변수는 public final (getter 불필요)
 * 2) static 데이터를 정의하고 ordinal로 접근 (getter 필요) 
 */
public enum Size {
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
	// private static String[] abbreviations = {"S", "M", "L", "XL"};
	// public String getAbbreviation(){ return abbreviations[this.ordinal()]; }
	public final String abbreviation;
	private Size(String abbreviation){
		this.abbreviation = abbreviation;
	}
	public Size nextSize() {
		Size[] sizes = Size.values();
		int curr = this.ordinal();
		if(curr!=sizes.length-1) ++curr;
		return sizes[curr];
	}
	public Size prevSize() {
		Size[] sizes = Size.values();
		int curr = this.ordinal();
		if(curr!=0) --curr;
		return sizes[curr];
	}
	
}
