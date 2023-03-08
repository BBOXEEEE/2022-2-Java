import javafx.scene.Group;
import javafx.scene.paint.Color;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 테트리스 메인 게임 화면과 다음 테트로미노 화면
 */
public class TetrisGrid extends Group {
	private TetrisGridCell[][] gridCells;
	public TetrisGrid(int height, int width) {
		resize(width*20, height*20);
		gridCells = new TetrisGridCell[height][width];
		for(int row=0; row<height; row++)
			for(int col=0; col<width; col++){
				gridCells[row][col] = new TetrisGridCell(col*20, row*20);
				getChildren().add(gridCells[row][col]);
			}
	}
	
	void update(Cell[][] cells) {
		for(int r=0; r<cells.length; ++r) {
			for(int c=0; c<cells[0].length; ++c) {
				Color setColor = (cells[r][c].state()==0)? Color.GRAY: cells[r][c].shapeType().shapeColor;
				gridCells[r][c].setColor(setColor);
			}
		}
	}
}
