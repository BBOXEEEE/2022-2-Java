import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.media.AudioClip;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기 학기 프로젝트: Tetris
 * @author 김상진 
 * mp3 파일을 play하여주는 클래스
 */
public class Sound {
	public static String dir;
    static {
        dir = "file:///" + System.getProperty("user.dir").replace('\\', '/').replaceAll(" ", "%20");
        try {
            dir = new java.net.URI(dir).toString();
        } 
        catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    private static AudioClip hardDrop = new AudioClip(dir + "/sound/HardDrop.mp3");
	private static AudioClip rotate = new AudioClip(dir + "/sound/Rotate.mp3");
	private static AudioClip move = new AudioClip(dir + "/sound/Move.mp3");
	private static AudioClip singleLineClear = new AudioClip(dir + "/sound/SingleLineClear.mp3");
	private static AudioClip doubleLineClear = new AudioClip(dir + "/sound/DoubleLineClear.mp3");
	private static AudioClip tripleLineClear = new AudioClip(dir + "/sound/TripleLineClear.mp3");
		
	private static Map<String, AudioClip> soundBox = new HashMap<>();
	static{
		soundBox.put("HardDrop", hardDrop);
		soundBox.put("Rotate", rotate);
		soundBox.put("Move", move);
		soundBox.put("SingleLineClear", singleLineClear);
		soundBox.put("DoubleLineClear", doubleLineClear);
		soundBox.put("TripleLineClear", tripleLineClear);
	}
	
	public static void play(String key){	
		AudioClip clip = soundBox.get(key);
		if(clip!=null){
			clip.play();
		}
	}
	public static void stop(String key){
		AudioClip clip = soundBox.get(key);
		if(clip!=null){
			clip.stop();
		}
	}
}
