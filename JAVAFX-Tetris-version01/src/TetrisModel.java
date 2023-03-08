/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * TetrominoModel
 * 모델 클래스: 게임의 각종 정보를 유지하고 로직을 유지함
 * - 프리젠터를 통해 뷰와 소통함
 */
public class TetrisModel {
	
	private int score  = 0;
	private int numberOfLines = 0;
	private int level = 1;
	private Cell[][] cells = new Cell[Tetris.HEIGHT][Tetris.WIDTH];
	private Cell[][] nextCells = new Cell[Tetris.NEXTHEIGHT][Tetris.NEXTHEIGHT];
	private Tetromino currTetromino;
	private Location tetrominoLoc;
	private TetrominoFactory tetrominoFactory = new TetrominoFactory();
	public TetrisModel() {
		clearCells();
		clearNextCells();
	}
	public void init() {
		level = 0;
		score = 0;
		numberOfLines = 0;
		clearCells();
	}
	public int getLevel() {
		return level;
	}
	public int getScore() {
		return score;
	}
	public int getNumberOfLines() {
		return numberOfLines;
	}
	public Cell[][] getCells(){
		return cells;
	}
	public Cell[][] getNextCells(){
		return nextCells;
	}
	public void clearCells() {
		for(int r=0; r<Tetris.HEIGHT; ++r)
			for(int c=0; c<Tetris.WIDTH; ++c)
				cells[r][c] = Cell.emptyCell;
	}
	public void clearNextCells() {
		for(int r=0; r<Tetris.NEXTHEIGHT; ++r)
			for(int c=0; c<Tetris.NEXTWIDTH; ++c)
				nextCells[r][c] = Cell.emptyCell;
	}
	//
	public void next() {
		tetrominoFactory.next();
	}
	//
	public boolean insertTetromino(){
		this.currTetromino = tetrominoFactory.getCurrent();
		tetrominoLoc = new Location(0,3);
		if(isEmptyRow(1)&&canMove(tetrominoLoc, currTetromino.getCurrentBlock())){
			applyBlock();
			insertNextTetromino();
			return true;
		}
		return false;
	}
	
	public void insertNextTetromino() {
		clearNextCells();
		Tetromino nextTetromino = tetrominoFactory.getNext();
		byte[][] blockShape = nextTetromino.getCurrentBlock();
		Location startLoc = new Location(1,1);
		for(int r=0; r<4; r++){
			int row = r+startLoc.r();
			for(int c=0; c<4; c++){
				int col = c+startLoc.c();
				if(blockShape[r][c]==1) nextCells[row][col] = Cell.getInstance(nextTetromino.shapeType);
			}
		}
	}
	
	//
	private boolean isEmptyRow(int r){
		int sum = 0;
		for(int c=0; c<Tetris.WIDTH; c++)
			sum += cells[r][c].state();
		return sum==0;
	}
	
	// 현재 테트로미노를 tetrominoLoc 위치에서 제거함 
	// 테트로미노가 1인 위치를 다시 emptyCell로 바꿈
	private void eraseBlock(){
		for(int r = tetrominoLoc.r(); r<tetrominoLoc.r()+4; ++r)
			for(int c = tetrominoLoc.c(); c<tetrominoLoc.c()+4; ++c)
				cells[r][c] = Cell.emptyCell;
	}
	// 현재 테트로미노를 tetrominoLoc 위치에 추가함 
	// 테트로미노가 1인 위치를 해당 Cell 타입으로 바꿈
	private void applyBlock(){
		for(int r = tetrominoLoc.r(); r<tetrominoLoc.r()+4; ++r)
			for(int c = tetrominoLoc.c(); c<tetrominoLoc.c()+4; ++c)
				if(currTetromino.getCurrentBlock()[r-tetrominoLoc.r()][c-tetrominoLoc.c()] == 1)
					cells[r][c] = Cell.getInstance(currTetromino.shapeType);
	}
	
	// 주어진 위치에 테트로미노를 추가할 수 있는지 검사함 
	private boolean canMove(Location newLoc, byte[][] shapeBlock){
		for(int r=newLoc.r(); r<newLoc.r()+4; ++r)
			for(int c = newLoc.c(); c<newLoc.c()+4; ++c)
				if(shapeBlock[r-newLoc.r()][c-newLoc.c()] == 1 && cells[r][c].state() == 1)
					return false;
		return true;
	}
	
	public boolean moveTetrominoDown(){		
		return move(new Location(tetrominoLoc.r()+1, tetrominoLoc.c()));
	}

	private boolean move(Location newLoc){
		boolean flag = false;
		eraseBlock();
		if(canMove(newLoc, currTetromino.getCurrentBlock())){
			tetrominoLoc = newLoc;
			flag = true;
		}
		applyBlock();
		return flag;
	}
}
