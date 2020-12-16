package com.visual.Quiz;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private static Scene scene;
	private static Stage stage;
	private static Stage secondStage;
	
	public static Scene getScene() {
		return scene;
	}
	
	@Override
	public void start(Stage primaryStage){
		try {		
			scene = new Scene(loadFXML("Root"));
			scene.setFill(Color.TRANSPARENT);
			stage = primaryStage;
			stage.setScene(scene);
			stage.centerOnScreen();		
			stage.initStyle(StageStyle.TRANSPARENT);		
			stage.sizeToScene();
			stage.setTitle("Quiz 1.3");
			stage.setResizable(false);
			stage.getIcons().add(new Image("Recursos/upLogo.jpg"));
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void setFXML(String fxml, String tittle) throws IOException{
		scene.setRoot(loadFXML(fxml));
		stage.sizeToScene();
		stage.centerOnScreen();
		stage.setTitle(tittle);
	}
	
	private static Parent loadFXML(String fxml)throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/" + fxml + ".fxml"));	
		return fxmlLoader.load();
		
	}
	
	public static void subStage(String fxml, String tittle) {
		try {
			Parent nodo = loadFXML(fxml);
			secondStage = new Stage();
			Scene scene = new Scene(nodo);
			secondStage.setScene(scene);
			secondStage.setTitle(tittle);
			secondStage.initOwner(stage);
			secondStage.initModality(Modality.WINDOW_MODAL);
			secondStage.centerOnScreen();
			secondStage.showAndWait();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getSubStage() {
		return secondStage;
	}
	
	public static Stage getStage() {
		return stage;
	}
}
