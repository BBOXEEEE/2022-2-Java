 /**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * TetrominoPresenter
 * 프리젠터 클래스: 뷰와 모델 사이에 위치한 중계자
 */
public class TetrisPresenter {
	private TetrisModel model;
	private TetrisView view;
	public TetrisPresenter(TetrisModel model, TetrisView view){
		this.model = model;
		this.view = view;
		view.setPresenter(this);
	}
	public void init() {
		model.init();
		updateAll();
		startNewBlock();
	}
	
	private void updateAll() {
		view.updateLevel(model.getLevel());
		view.updateScore(model.getScore());
		view.updateLine(model.getNumberOfLines());
	}
	
	public void startNewBlock() {
		if(model.insertTetromino()) {
			view.updateCells(model.getCells());
			view.updateNextCells(model.getNextCells());
		}
		else {
			view.endGame(model.getScore());
		}
	}
	
	public void moveTetrominoDown() {
		boolean downSuccessful = model.moveTetrominoDown();
		if(downSuccessful) {
			Sound.play("Move");
			view.updateCells(model.getCells());
		}
		else removeFullRows();
	}
	
	private void removeFullRows() {
		int removedLines = model.removeFullRows();
		switch(removedLines){
		case 1: Sound.play("SingleLineClear"); break;
		case 2: Sound.play("DoubleLineClear"); break;
		case 3: Sound.play("TripleLineClear"); break;
		}
		if(model.updateScore(removedLines))
			view.levelUp(model.getLevel());
		updateAll();
		model.next();
		startNewBlock();
	}
	
	void moveTetrominoLeft() {
		if(model.moveTetrominoLeft()) {
			Sound.play("Move");
			view.updateCells(model.getCells());
		}
	}
	
	public void moveTetrominoRight() {
		if(model.moveTetrominoRight()) {
			Sound.play("Move");
			view.updateCells(model.getCells());
		}
	}
	
	public void rotateTetromino() {
		if(model.rotateTetromino()) {
			Sound.play("Rotate");
			view.updateCells(model.getCells());
		}
	}
	
	public void dropTetromino() {
		model.dropTetromino();
		Sound.play("HardDrop");
		view.updateCells(model.getCells());
		removeFullRows();
	}
}
