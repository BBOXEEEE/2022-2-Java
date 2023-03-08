package koreatech.cse;

import koreatech.eec.Electronics;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Test 클래스
 * 한 파일에 하나의 public 클래스만 정의할 수 있는 이유는 import와 관련 있음
 */
public class Test {
	public static void main(String[] args) {
		Software track = new Software();
		track.output();
		Electronics major = new Electronics();
		major.output();
	}
}
