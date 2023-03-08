import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 테트리스 메인 게임 화면과 다음 테트로미노 화면을 구성하는 각 셀
 */
public class TetrisGridCell extends Rectangle{
	private Color color;
	public TetrisGridCell(int x, int y){
		super(x, y, 20, 20);
		color = Color.GRAY;
		setStroke(Color.DARKGRAY);
		setFill(color);
	}
	public void setColor(Color color){
		this.color = color;
		setFill(color);
	}
}
