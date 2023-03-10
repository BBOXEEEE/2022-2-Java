import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2022년도 2학기 학기 프로젝트: Tetris
 * @author 김상진 
 * 명예의전당을 보여주는 클래스
 */
public class HallOfFame {
	private Button okBtn = new Button("확인");
	private Stage mainStage = null;
	
	private ObservableList<HallOfFameData> loadData(int currentScore){
		ObservableList<HallOfFameData> fameData = FXCollections.observableArrayList();
		fameData.clear();
		try(ObjectInputStream obj_in = 
			new ObjectInputStream(new FileInputStream(new File("score.dat")))){
			HallOfFameData initData = (HallOfFameData)obj_in.readObject();
			int size = initData.getRank();
			for(int i=0; i<size; ++i){
				HallOfFameData scoreData = (HallOfFameData)obj_in.readObject();
				fameData.add(scoreData);
			}
			// 이번 점수 10위 이내이면 추가
			if(size<10||currentScore>fameData.get(size-1).getScore()){
				HallOfFameData currentData = getUserNickname(currentScore);
				if(size<10) fameData.add(currentData);
				else fameData.set(size-1, currentData);
				fameData.sort(Comparator.comparingInt(HallOfFameData::getScore).reversed().thenComparing(HallOfFameData::getDate, Comparator.reverseOrder()));
			}
		} 
		catch (FileNotFoundException e) {
			HallOfFameData currentData = getUserNickname(currentScore);
			currentData.setRank(1);
			fameData.add(currentData);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return fameData;
	}
	
	private void saveData(ObservableList<HallOfFameData> fameData) {
		int n=1;
		for(HallOfFameData scoreData: fameData){
			scoreData.setRank(n);
			++n;
		}
		//if(size>10) size = 10;
		try(ObjectOutputStream obj_out = 
			new ObjectOutputStream(new FileOutputStream(new File("score.dat")))){
			// 첫 레코드에는 데이터의 수만 저장
			HallOfFameData initData = new HallOfFameData();
			initData.setRank(fameData.size());
			obj_out.writeObject(initData);
			for(HallOfFameData scoreData: fameData){
				obj_out.writeObject(scoreData);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ObservableList<HallOfFameData> loadAndSaveData(int currentScore){
		ObservableList<HallOfFameData> fameData = loadData(currentScore);
		saveData(fameData);
		return fameData;
	}
	
	private HallOfFameData getUserNickname(int score){
		TextInputDialog dialog = new TextInputDialog("별명 입력");
		dialog.setTitle("별명 입력창");
		dialog.setHeaderText(null);
		dialog.setContentText("별명:");
		ImageView icon = new ImageView(new Image("tetris.png"));
		icon.setFitHeight(80);
		icon.setPreserveRatio(true);
		dialog.setGraphic(icon);

		String nickName = dialog.showAndWait().orElseGet(()->"");
		return new HallOfFameData(nickName,LocalDateTime.now(),score);
	}
	
	@SuppressWarnings("unchecked")
	private TableView<HallOfFameData> constructTable() {
		TableView<HallOfFameData> table = new TableView<>();
		TableColumn<HallOfFameData, String> colRank = new TableColumn<>("순위");
		colRank.setMinWidth(40);
		colRank.setStyle("-fx-alignment: center");
		colRank.setCellValueFactory(new PropertyValueFactory<HallOfFameData, String>("Rank"));
		TableColumn<HallOfFameData, String> colName = new TableColumn<>("별명");
		colName.setMinWidth(80);
		colName.setStyle("-fx-alignment: center");
		colName.setCellValueFactory(new PropertyValueFactory<HallOfFameData, String>("Name"));
		TableColumn<HallOfFameData, String> colDate = new TableColumn<>("날짜");
		colDate.setMinWidth(180);
		colDate.setStyle("-fx-alignment: center");
		colDate.setCellValueFactory(new PropertyValueFactory<HallOfFameData, String>("GameDate"));		
		TableColumn<HallOfFameData, String> colScore = new TableColumn<>("점수");
		colScore.setMinWidth(80);
		colScore.setStyle("-fx-alignment: center");
		colScore.setCellValueFactory(new PropertyValueFactory<HallOfFameData, String>("GameScore"));
		table.getColumns().addAll(colRank, colName, colDate, colScore);
		return table;
	}
	
	public void show(int score){
		mainStage = new Stage();
		mainStage.initModality(Modality.APPLICATION_MODAL);
		mainStage.setTitle("Hall of Fame");
		mainStage.setMinWidth(400);
		
		TableView<HallOfFameData> table = constructTable();
		table.setItems(loadAndSaveData(score));
		
		BorderPane mainPane = new BorderPane();
		mainPane.setPadding(new Insets(10));
		FlowPane btnPane = new FlowPane();
		btnPane.setPadding(new Insets(10));
		btnPane.getChildren().add(okBtn);
		btnPane.setAlignment(Pos.CENTER);
		mainPane.setCenter(table);
		mainPane.setBottom(btnPane);
		okBtn.setOnAction(e->mainStage.close());

		mainStage.setScene(new Scene(mainPane));
		mainStage.showAndWait();
	}
}
