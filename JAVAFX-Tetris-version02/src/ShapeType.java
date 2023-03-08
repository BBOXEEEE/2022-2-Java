import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.paint.Color;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 테트로미노 모양 정보를 나타내는 열거형 
 * 모두 같은 크기로 나타내기 위해 4x4 배열을 사용함
 * 회전을 했을 때 모습도 포함
 */
public enum ShapeType {
	O_SHAPE(Color.YELLOW, new byte[][][]{
		{
			{0, 0, 0, 0},
			{0, 1, 1, 0},
			{0, 1, 1, 0},
			{0, 0, 0, 0}
		},
		{
			{0, 0, 0, 0},
			{0, 1, 1, 0},
			{0, 1, 1, 0},
			{0, 0, 0, 0}
		}
	}), 
	Z_SHAPE(Color.RED, new byte[][][]{
		{
			{0, 0, 0, 0},
			{1, 1, 0, 0},
			{0, 1, 1, 0},
			{0, 0, 0, 0}
		},
		{
			{0, 0, 0, 0},
			{0, 0, 1, 0},
			{0, 1, 1, 0},
			{0, 1, 0, 0}
		},
		{
			{0, 0, 0, 0},
			{0, 0, 0, 0},
			{1, 1, 0, 0},
			{0, 1, 1, 0}
		},
		{
			{0, 0, 0, 0},
			{0, 1, 0, 0},
			{1, 1, 0, 0},
			{1, 0, 0, 0}
		}
	}), 
	S_SHAPE(Color.GREEN, new byte[][][]{
		{
			{0, 0, 0, 0},
			{0, 1, 1, 0},
			{1, 1, 0, 0},
			{0, 0, 0, 0}
		},
		{
			{0, 0, 0, 0},
			{0, 1, 0, 0},
			{0, 1, 1, 0},
			{0, 0, 1, 0}
		},
		{
			{0, 0, 0, 0},
			{0, 0, 0, 0},
			{0, 1, 1, 0},
			{1, 1, 0, 0}
		},
		{
			{0, 0, 0, 0},
			{1, 0, 0, 0},
			{1, 1, 0, 0},
			{0, 1, 0, 0}
		}
	}),
	L_SHAPE(Color.ORANGE, new byte[][][]{
		{
			{0, 0, 0, 0},
			{1, 1, 1, 0},
			{1, 0, 0, 0},
			{0, 0, 0, 0}
		},
		{
			{1, 1, 0, 0},
			{0, 1, 0, 0},
			{0, 1, 0, 0},
			{0, 0, 0, 0}
		},
		{
			{0, 0, 1, 0},
			{1, 1, 1, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0}
		},
		{
			{0, 1, 0, 0},
			{0, 1, 0, 0},
			{0, 1, 1, 0},
			{0, 0, 0, 0}
		}
		
	}), 
	J_SHAPE(Color.BLUE, new byte[][][]{
		{
			{0, 0, 0, 0},
			{1, 1, 1, 0},
			{0, 0, 1, 0},
			{0, 0, 0, 0}
		},
		{
			{0, 1, 0, 0},
			{0, 1, 0, 0},
			{1, 1, 0, 0},
			{0, 0, 0, 0}
		},
		{
			{1, 0, 0, 0},
			{1, 1, 1, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0}
		},
		{
			{0, 1, 1, 0},
			{0, 1, 0, 0},
			{0, 1, 0, 0},
			{0, 0, 0, 0}
		}
	}), 
	T_SHAPE(Color.MAGENTA, new byte[][][]{
		{
			{0, 0, 0, 0},
			{1, 1, 1, 0},
			{0, 1, 0, 0},
			{0, 0, 0, 0}
		},
		{
			{0, 1, 0, 0},
			{1, 1, 0, 0},
			{0, 1, 0, 0},
			{0, 0, 0, 0}
		},
		{
			{0, 1, 0, 0},
			{1, 1, 1, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0}
		},
		{
			{0, 1, 0, 0},
			{0, 1, 1, 0},
			{0, 1, 0, 0},
			{0, 0, 0, 0}
		}
		
	}), 
	I_SHAPE(Color.CYAN, new byte[][][]{
		{
			{0, 0, 0, 0},
			{1, 1, 1, 1},
			{0, 0, 0, 0},
			{0, 0, 0, 0}
		},
		{
			{0, 0, 1, 0},
			{0, 0, 1, 0},
			{0, 0, 1, 0},
			{0, 0, 1, 0}
		},
		{
			{0, 0, 0, 0},
			{0, 0, 0, 0},
			{1, 1, 1, 1},
			{0, 0, 0, 0}
		},
		{
			{0, 1, 0, 0},
			{0, 1, 0, 0},
			{0, 1, 0, 0},
			{0, 1, 0, 0}
		}
	})/*,
	D_SHAPE(Color.BLACK, new byte[][][]{
		{
			{0, 0, 0, 0},
			{0, 1, 0, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0},
		}
	}),
	U_SHAPE(Color.MISTYROSE, new byte[][][] {
		{
			{0, 0, 0, 0},
			{1, 0, 1, 0},
			{1, 1, 1, 0},
			{0, 0, 0, 0}
		},
		{
			{1, 1, 0, 0},
			{1, 0, 0, 0},
			{1, 1, 0, 0},
			{0, 0, 0, 0}
		},
		{
			{0, 0, 0, 0},
			{1, 1, 1, 0},
			{1, 0, 1, 0},
			{0, 0, 0, 0}
		},
		{
			{1, 1, 0, 0},
			{0, 1, 0, 0},
			{1, 1, 0, 0},
			{0, 0, 0, 0}
		}
	})*/;
	public static final int NumberOfShapes = values().length;
	public final Color shapeColor;
	public final byte[][][] block;
	private ShapeType(Color shapeColor, byte[][][] block) {
		this.shapeColor = shapeColor;
		this.block = block;
	}
	public static ShapeType getRandomShape() {
		return values()[ThreadLocalRandom.current().nextInt(NumberOfShapes)];
	}
}