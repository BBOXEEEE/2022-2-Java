import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기 
 * @author 김상진
 * HTML 문서에서 링크 추출
 */
public class LinkCollector {
	public static String getHTML() {
		return """
		<html>
		<body>
		<a href="contact.html">contact us</a>
		<a href="blog.html">blog</a>
		<a href="index.html">home</a>
		<a href="http://cse.koreatech.ac.kr">CSE</a>
		<a href="http://www.koreatech.ac.kr">Koreatech</a>
		<a href="http://judge.koreatech.ac.kr">judge</a>
		</body>
		</html>
		""";
	}
	// 전체 pattern 중 일부를 추출하는 방법 - 괄호 이용
	public static List<String> getLinkURLs(String page) {
		Pattern p = Pattern.compile("<a [^>]*href=\"([^\"]+)\"[^>]*>");
		Matcher m = p.matcher(page);
		List<String> urls = new ArrayList<>();
		while(m.find()){
			urls.add(m.group(1));
		}
		return urls;
	}
	
	public static void main(String[] args) {
		List<String> urls = getLinkURLs(getHTML());
		for(var url: urls)
			System.out.println(url);
	}

}
