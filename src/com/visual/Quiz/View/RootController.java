package com.visual.Quiz.View;
import com.visual.Quiz.Main;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.visual.Quiz.Model.Quiz;
import com.visual.Quiz.View.Animation.AnimationError;
import com.visual.Quiz.View.Animation.AnimationStars;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;

public class RootController implements Initializable {
    @FXML
    private Label hits;
    @FXML
    private Label points;
    @FXML
    private ImageView imagen;    
    @FXML
    private Text pregunta;
    @FXML
    private Button next;       
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Pane pane;	  
    @FXML
    private Button botonA;
    @FXML
    private Button botonB;
    @FXML
    private Button botonC;  
    @FXML
    private Button salir;   
    @FXML
    private Text instruccion;
    @FXML
    private AnchorPane AnchorPaneRight;   
    @FXML
    private Canvas canvas;
    @FXML
    private Canvas canvasError;


    private Quiz quiz;       
    private int x; //contador x para las preguntas e imagenes, iniciando de la posicion 0
    private boolean correcto;

    @FXML
    void botonAOnMouseClicked(MouseEvent event) {
    	botonB.setDisable(true);
    	botonC.setDisable(true);  
    	
    	correcto = quiz.acertado(botonA.getText());   
    	
	   	if(correcto) {
			botonA.setBackground(new Background(new BackgroundFill(Color.web("#CCFF33"), CornerRadii.EMPTY, Insets.EMPTY)));
		    quiz.calcularAciertos();
		    quiz.calcularPuntos();
		    starAnimationStar();
		    stopAnimationError();
		}
		else {
			botonA.setBackground(new Background(new BackgroundFill(Color.web("#CC0000"), CornerRadii.EMPTY, Insets.EMPTY)));
			starAnimationError();
			stopAnimationStar();
		}
	}

    @FXML
    void botonBOnMouseClicked(MouseEvent event) {
    	botonA.setDisable(true);
    	botonC.setDisable(true);
    	
    	correcto = quiz.acertado(botonB.getText()); 
    	
    	if(correcto) {
	    	botonB.setBackground(new Background(new BackgroundFill(Color.web("#CCFF33"), CornerRadii.EMPTY, Insets.EMPTY)));
		    quiz.calcularAciertos();
		    quiz.calcularPuntos();
		    starAnimationStar();
		    stopAnimationError();
	    }
	    else {
	    	botonB.setBackground(new Background(new BackgroundFill(Color.web("#CC0000"), CornerRadii.EMPTY, Insets.EMPTY)));
	    	starAnimationError();
	    	stopAnimationStar();
	    }
    }

    @FXML
    void botonCOnMouseClicked(MouseEvent event) {
    	botonA.setDisable(true);
    	botonB.setDisable(true);

    	correcto = quiz.acertado(botonC.getText());
    	
    	 if(correcto) {
	    	botonC.setBackground(new Background(new BackgroundFill(Color.web("#CCFF33"), CornerRadii.EMPTY, Insets.EMPTY)));		   
		    quiz.calcularAciertos(); //si es correcta la respuesta, aumentar sus ciertos	   
		    quiz.calcularPuntos();  //al igual que si es correcta, aumentar sus puntos
		    starAnimationStar();
		    stopAnimationError();
	    }
	    else {
	    	botonC.setBackground(new Background(new BackgroundFill(Color.web("#CC0000"), CornerRadii.EMPTY, Insets.EMPTY))); 	
	    	starAnimationError();
	    	stopAnimationStar();
	    }
	}
    
    @FXML
    void nextOnMouseClicked(MouseEvent event) {
    	//MOSTRAR PREGUNTA E IMAGEN   
    	botonA.setVisible(true);
		botonB.setVisible(true);
		botonC.setVisible(true);	
		botonA.setDisable(false);
		botonB.setDisable(false);
		botonC.setDisable(false);		
		correcto = false;		
		botonA.setBackground(new Background(new BackgroundFill(Color.web("#FFFFDB"), CornerRadii.EMPTY, Insets.EMPTY))); 
		botonB.setBackground(new Background(new BackgroundFill(Color.web("#FFFFDB"), CornerRadii.EMPTY, Insets.EMPTY))); 
		botonC.setBackground(new Background(new BackgroundFill(Color.web("#FFFFDB"), CornerRadii.EMPTY, Insets.EMPTY))); 
		
		instruccion.setVisible(false);
		
    	botonA.setText(quiz.getSeccion().getListaOpciones().get(quiz.getSiguiente()));
    	quiz.siguiente();
    	botonB.setText(quiz.getSeccion().getListaOpciones().get(quiz.getSiguiente()));
    	quiz.siguiente();
    	botonC.setText(quiz.getSeccion().getListaOpciones().get(quiz.getSiguiente()));
    	quiz.siguiente();
    	
    	Image backGround = new Image ("Recursos/wallpaper.png");
    	anchorPane.setBackground(new Background(new BackgroundImage(backGround, null, null, null, null)));	
    	next.setBackground(new Background(new BackgroundFill(Color.web("#192125"), CornerRadii.EMPTY, Insets.EMPTY)));
    	next.setTextFill(Color.web("#F3F4F1"));
    	next.setText("Next");
    	
    	pane.setBackground(new Background(new BackgroundFill(Color.web("#5F6365"), CornerRadii.EMPTY, Insets.EMPTY)));
    	
    	pregunta.setText(quiz.getSeccion().getPreguntas().get(x).getPregunta());
    	imagen.setImage(quiz.getSeccion().getPreguntas().get(x).getImagen());	
    
    	hits.setText(String.valueOf(quiz.getAciertos()));
    	points.setText(String.valueOf(quiz.getScore()));
    	
    	//despues de que pase la primera pregunta se detendra la animacion, si es que responde bien la 1
    	if(x > 0) {
    		stopAnimationStar();
    		stopAnimationError();
    	}
    	
    	
    	x++; //siguiente pregunta  	
    	
    	if( x == quiz.getSeccion().getPreguntas().size()){
    		next.setVisible(false) ;
    		showScore();
    	} 
    	
    	
    	//detener la animacion despues de haber acertado
    	
    }  
    
    @FXML
    void salirOnMouseClicked(MouseEvent event) {
    	salir();
    }

    //Metodos para reducir lineas de codigo
    /* public void showAlert() {
	    Alert puntuacion = new Alert(AlertType.INFORMATION);
	    puntuacion.setTitle("Puntuacion");
	    puntuacion.setHeaderText("Felicidades!");
	   	puntuacion.setContentText("Tu puntuacion es: " + quiz.getScore()
	   							  + "\nAciertos: " + quiz.getAciertos()); 	
	    puntuacion.initStyle(StageStyle.UTILITY);
	    	
	    Optional<ButtonType> salir = puntuacion.showAndWait();
	    if(salir.get()==ButtonType.OK) {
	    	System.exit(0);
	    }
     }
     */
    
    public void showScore() {
    	Main.subStage("GameOver", "Puntuacion Final");
    }
    
     public void salir() {
    	 Alert salir = new Alert(AlertType.CONFIRMATION);
 	    salir.setTitle("Salir del juego");
 	    salir.setHeaderText(null);
 	    salir.initStyle(StageStyle.UTILITY);
 	    salir.setContentText("Seguro que quiere salir? \n se perdera tu progreso de juego"); 	
 	    	
 	    Optional<ButtonType> result = salir.showAndWait();
 	    if(result.get()==ButtonType.OK) {
 	    	System.exit(0);
 	    }
     }
     
     public void starAnimationStar() {
 		AnimationStars animationStar = new AnimationStars(canvas);
    	 canvas.setVisible(true);
    	 animationStar.showAnimationStar();
     }
     
     public void starAnimationError() {
    	 AnimationError animationError = new AnimationError(canvasError);
    	 canvasError.setVisible(true);
    	 animationError.showAnimationError();
     }
     
     public void stopAnimationStar() {
    	 canvas.setVisible(false);
     }
     
     public void stopAnimationError() {
    	 canvasError.setVisible(false);
     }
           
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Inicializar atributos
		quiz = new Quiz();
		x = 0;

		botonA.setVisible(false);
		botonB.setVisible(false);
		botonC.setVisible(false);
		instruccion.setText("BIENVENIDOS AL QUIZ!"
				+ "\nReglas del juego: "
				+ "\n-Solo tienes una oportunidad para responder, piensa muy bien!"
				+ "\n-Cada pregunta consta de 15 puntos"
				+ "\n-Diviertete!");
	}
}