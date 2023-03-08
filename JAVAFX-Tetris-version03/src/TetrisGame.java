import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * 테트리스 게임
 */
public class TetrisGame extends Application {
	private TetrisView view = new TetrisView();
	private TetrisModel model = new TetrisModel();
	@SuppressWarnings("unused")
	private TetrisPresenter presenter = new TetrisPresenter(model, view);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Koreatech JavaFX Tetris");
		primaryStage.setScene(new Scene(view));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
