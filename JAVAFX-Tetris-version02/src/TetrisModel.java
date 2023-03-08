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
		level = 1;
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
	private boolean isFullRow(int r){
		int sum = 0;
		for(int c=0; c<Tetris.WIDTH; c++)
			sum += cells[r][c].state();
		return sum==Tetris.WIDTH;
		
	}
	
	// 현재 테트로미노를 tetrominoLoc 위치에서 제거함 
	// 테트로미노가 1인 위치를 다시 emptyCell로 바꿈
	private void eraseBlock(){
		byte[][] blockShape = currTetromino.getCurrentBlock();
		int row = 0, col = 0;
		for(int r=0; r<4; r++){
			row = r+tetrominoLoc.r();
			for(int c=0; c<4; c++){
				col = c+tetrominoLoc.c();
				if(blockShape[r][c]==1&&Location.valid(row,col))
					cells[row][col] = Cell.emptyCell;
			}
		}
	}
	
	// 현재 테트로미노를 tetrominoLoc 위치에 추가함 
	// 테트로미노가 1인 위치를 해당 Cell 타입으로 바꿈
	private void applyBlock(){
		byte[][] blockShape = currTetromino.getCurrentBlock();
		int row = 0, col = 0;
		for(int r=0; r<4; r++){
			row = r+tetrominoLoc.r();
			for(int c=0; c<4; c++){
				col = c+tetrominoLoc.c();
				if(blockShape[r][c]==1&&Location.valid(row,col))
					cells[row][col] = Cell.getInstance(currTetromino.shapeType);
			}
		}
	}
	
	// 주어진 위치에 테트로미노를 추가할 수 있는지 검사함 
	private boolean canMove(Location newLoc, byte[][] shapeBlock){
		for(int row=0; row<4; row++){
			int r = newLoc.r()+row;
			for(int col=0; col<4; col++){
				int c = newLoc.c()+col;
				if((shapeBlock[row][col]==1)&&
					(!Location.valid(r,c) || (Location.valid(r,c)&&cells[r][c].state()==1))){ 
						return false;
				}
			}
		}
		return true;
	}
	//
	public boolean moveTetrominoDown(){		
		return move(new Location(tetrominoLoc.r()+1, tetrominoLoc.c()));
	}
	
	public void dropTetromino(){
		while(moveTetrominoDown());
	}
	public boolean moveTetrominoLeft(){
		return move(new Location(tetrominoLoc.r(), tetrominoLoc.c()-1));
	}
	public boolean moveTetrominoRight(){
		return move(new Location(tetrominoLoc.r(), tetrominoLoc.c()+1));
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
	
	public boolean rotateTetromino(){
		boolean flag = false;
		eraseBlock();
		if(canMove(tetrominoLoc, currTetromino.getNextBlock())){
				currTetromino.rotate();
				flag = true;
		}
		applyBlock();
		return flag;
	}
	
	//
	private void removeRow(int delRow){
		for(int r = delRow; r>=0; r--) {
			if(isEmptyRow(r)) return;
			for(int c=0; c<Tetris.WIDTH; c++)
				cells[r][c] = cells[r-1][c];
		}
		if(isEmptyRow(delRow))
			return;
	}
	//
	public int removeFullRows(){
		int numberOfRows = 0;
		int r=Tetris.HEIGHT-1;
		while(r>=0 && !isEmptyRow(r)){
			if(isFullRow(r)){
				removeRow(r);
				++numberOfRows;
			}
			else --r;
		}
		return numberOfRows;
	}
	
	// 점수 계산: 삭제한 줄 수 기반
	// @return 레벨이 올라가면 true를 반환 
	public boolean updateScore(int removedLines) {
		if(isEmptyRow(Tetris.HEIGHT-1)) score += 1000;
		score += removedLines*40 + 4;
		numberOfLines += removedLines;
		return updateLevel();
	}
	
	// 레벨 증가
	// 지금까지 삭제한 줄을 기반으로 레벨 증가 여부 판단
	// @return 레벨이 올라가면 true를 반환 
	private boolean updateLevel() {
		/*
		if(numberOfLines > 0 && numberOfLines % 10 == 0) {
			level = numberOfLines / 10 +1 ;
			return true;
		}
		return false;
		*/
		int prevLevel = level;
		level = numberOfLines/10 + 1;
		return (level == prevLevel+1);
	}
}
