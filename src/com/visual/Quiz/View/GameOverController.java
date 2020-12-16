package com.visual.Quiz.View;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;

public class GameOverController implements Initializable{

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button botonSalir;

    @FXML
    private Label puntuacion;

    @FXML
    private Label aciertos;
    
    @FXML
    void botonSalirOnMouseClicked(MouseEvent event) {
    	System.exit(0);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image image = new Image("Recursos/score.png");
		anchorPane.setBackground(new Background(new BackgroundImage(image, null, null, null, null)));	
		puntuacion.setText(String.valueOf(105));
		aciertos.setText(String.valueOf(7));
	}
	
}
