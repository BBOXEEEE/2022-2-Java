import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진
 * TetrominoView
 * 뷰 클래스: 화면 처리, 사용자 상호작용을 받아 프리젠터와 소통함
 */
public class TetrisView extends BorderPane {
	private TetrisPresenter presenter;
	// GUI Nodes
	private Button startButton = new Button("시작");
	private Button pauseButton = new Button("멈춤");
	private boolean paused = false;
	private TextField levelField = new TextField();
	private TextField scoreField = new TextField();
	private TextField lineField = new TextField();
	private TetrisGrid mainGrid = new TetrisGrid(Tetris.HEIGHT,Tetris.WIDTH);
	private TetrisGrid nextGrid = new TetrisGrid(Tetris.NEXTHEIGHT,Tetris.NEXTWIDTH);
	// 게임 진행 타이머 
	private Timeline tetrominoDownTimer = new Timeline();
	
	public TetrisView() {	
		tetrominoDownTimer.setCycleCount(Animation.INDEFINITE);
		tetrominoDownTimer.getKeyFrames().add(new KeyFrame(Duration.millis(500),e->moveTetrominoDown()));
		setTop(constructActionPane());
		setCenter(constructMainPane());
		setRight(constructStatePane());
	}
	public HBox constructActionPane() {
		HBox actionBox = new HBox();
		actionBox.setAlignment(Pos.CENTER);
		actionBox.setSpacing(10);
		actionBox.setPadding(new Insets(10));
		startButton.setOnAction(e->startGame());
		pauseButton.setOnAction(e->pauseGame());
		pauseButton.setDisable(true);
		actionBox.getChildren().addAll(startButton, pauseButton);
		return actionBox;
	}
	public VBox constructMainPane() {
		VBox mainBox = new VBox();
		mainBox.setPadding(new Insets(10,10,20,20));
		mainBox.getChildren().add(mainGrid);
		return mainBox;
	}
	public VBox constructStatePane() {
		VBox stateBox = new VBox();
		stateBox.setAlignment(Pos.TOP_CENTER);
		stateBox.setPadding(new Insets(10,20,20,0));
		
		VBox.setMargin(nextGrid, new Insets(0,0,120,0));
		levelField.setMaxWidth(120);
		VBox.setMargin(levelField, new Insets(0,0,20,0));
		scoreField.setMaxWidth(120);
		VBox.setMargin(scoreField, new Insets(0,0,20,0));
		lineField.setMaxWidth(120);
		
		levelField.setEditable(false);
		scoreField.setEditable(false);
		lineField.setEditable(false);
		
		stateBox.getChildren().addAll(nextGrid,new Label("레벨"),
				levelField,new Label("점수"),scoreField,new Label("줄"),lineField);
		
		return stateBox;
	}
	void setPresenter(TetrisPresenter presenter) {
		this.presenter = presenter;
	}
	//
	void startGame() {
		tetrominoDownTimer.stop();
		presenter.init();
		pauseButton.setDisable(false);
		tetrominoDownTimer.play();
		mainGrid.setOnKeyPressed(e->handleKeyEvent(e));
		mainGrid.requestFocus();
	}
	void endGame(int score) {
		tetrominoDownTimer.stop();
		mainGrid.setOnKeyPressed(null);
		showHallOfFame(score);
		startButton.requestFocus();
	}
	void updateLevel(int level) {
		levelField.setText(""+level);
	}
	void updateScore(int score) {
		scoreField.setText(""+score);
	}
	void updateLine(int numberOfLines) {
		lineField.setText(""+numberOfLines);
	}
	void updateCells(Cell[][] cells) {
		mainGrid.update(cells);
	}
	void updateNextCells(Cell[][] cells) {
		nextGrid.update(cells);
	}
	//
	void moveTetrominoDown() {
		presenter.moveTetrominoDown();
	}
	//
	void pauseGame() {
		if(!paused){
			pauseButton.setStyle("-fx-text-fill: gray;");
			tetrominoDownTimer.stop();
			mainGrid.setOnKeyPressed(null);
			paused = true;
		}
		else{
			pauseButton.setStyle("-fx-text-fill: black;");
			paused = false;
			mainGrid.setOnKeyPressed(e->handleKeyEvent(e));
			mainGrid.requestFocus();
			tetrominoDownTimer.play();
		}
	}
	//
	void handleKeyEvent(KeyEvent event) {
		switch(event.getCode()){
		case LEFT: presenter.moveTetrominoLeft(); break;
		case RIGHT: presenter.moveTetrominoRight(); break;
		case UP: presenter.rotateTetromino(); break;
		case DOWN: presenter.moveTetrominoDown(); break;
		case SPACE: presenter.dropTetromino(); break;
		default:
		}
		event.consume();
	}
	//
	public void levelUp(int level){
		tetrominoDownTimer.stop();
		tetrominoDownTimer.getKeyFrames().clear();
		tetrominoDownTimer.getKeyFrames().add(new KeyFrame(Duration.millis(500-(level-1)*20),
			e->moveTetrominoDown()));
		tetrominoDownTimer.play();
	}
	//
	public void showHallOfFame(int score) {
		Platform.runLater(new Runnable() {
            @Override public void run() {
				HallOfFame dialog = new HallOfFame();
				dialog.show(score);
            }
		});
	}
}