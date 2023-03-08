/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * TetrominoFactory
 * 현재와 다음 테트로미노를 유지하고 있으며, 
 * next를 통해 다음 테트로미노가 현재 테트로미노가 되고,
 * 새 랜덤 테트로미노가 다음 테트로미노로 설정됨
 */
public class TetrominoFactory {
	private Tetromino currTetromino;
	private Tetromino nextTetromino;
	public TetrominoFactory(){
		currTetromino = Tetromino.getInstance(ShapeType.getRandomShape());
		nextTetromino = Tetromino.getInstance(ShapeType.getRandomShape());
	}
	
	public Tetromino getCurrent(){
		return currTetromino;
	}
	public Tetromino getNext(){
		return nextTetromino;
	}
	
	public void next(){
		currTetromino = nextTetromino;
		nextTetromino = Tetromino.getInstance(ShapeType.getRandomShape());
	}
}
