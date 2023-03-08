import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 2019136056 박세현 
 * Company: 차량 제조사
 */
public record Company(String name, String country) {
	public Company{
		Objects.requireNonNull(name);
		Objects.requireNonNull(country);
	}
}