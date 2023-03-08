/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * Cell record
 * TetrisModel에서 현재 게임 진행 상태를 유지하는 2차원 배열의 요소 타입 
 * - 필요한 정보: 셀이 비어있는지 여부, 셀이 비어있지 않을 경우 색 정보
 * - 한 라인 전체가 꽉 차 있는지 빠르게 계산하기 위해 비어 있는지 여부는 0 또는 1로 표현
 * - 비어있지 않을 경우 색 정보 ShapeType 열거형을 이용
 * - 220개의 Cell 객체를 생성하지 않고 총 8개만 생성하여 사용함
 */
public record Cell(int state, ShapeType shapeType) {
	public static final Cell emptyCell = new Cell(0, ShapeType.I_SHAPE);
	public static final Cell[] cells = {
		new Cell(1, ShapeType.O_SHAPE),
		new Cell(1, ShapeType.Z_SHAPE),
		new Cell(1, ShapeType.S_SHAPE),
		new Cell(1, ShapeType.L_SHAPE),
		new Cell(1, ShapeType.J_SHAPE),
		new Cell(1, ShapeType.T_SHAPE),
		new Cell(1, ShapeType.I_SHAPE),
		// new Cell(1, ShapeType.D_SHAPE),
		// new Cell(1, ShapeType.U_SHAPE)
	};
	public static Cell getInstance(ShapeType shapeType) {
		return cells[shapeType.ordinal()];
	}
}