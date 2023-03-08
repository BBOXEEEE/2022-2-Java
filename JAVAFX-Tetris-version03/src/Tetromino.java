/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Tetromino
 * 총 7종류의 Tetromino 객체를 생성하여 사용함
 * 참고. 게임에서 현재 움직이고 있는 테트로미노는 항상 유일함
 */
public class Tetromino {
	public final ShapeType shapeType;
	private int formIndex  = 0;
	private static Tetromino[] tetrominoList = new Tetromino[ShapeType.NumberOfShapes];
	static{
		int i=0;
		for(var type: ShapeType.values())
			tetrominoList[i++] = new Tetromino(type);
	}
	private Tetromino(ShapeType type){
		shapeType = type;
	}
	
	public static Tetromino getInstance(ShapeType type) {
		Tetromino tetromino = tetrominoList[type.ordinal()];
		tetromino.formIndex = 0;
		return tetromino;
	}
	
	public byte[][] getCurrentBlock(){
		return shapeType.block[formIndex];
	}
	
	public byte[][] getNextBlock(){
		int nextIndex = (formIndex+1) % shapeType.block.length;
		return shapeType.block[nextIndex];
	}
	
	public void rotate(){
		formIndex = (formIndex+1) % shapeType.block.length;
	}
}
