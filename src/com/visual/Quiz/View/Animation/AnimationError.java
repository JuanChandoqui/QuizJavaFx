package com.visual.Quiz.View.Animation;	

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AnimationError{
	private GraphicsContext graphicsError;
	private Image[] framesError;
	private AnimatedImage error;
	private Timeline timeLineError;
		
	public AnimationError(Canvas canvasError) {				
		//error
		graphicsError = canvasError.getGraphicsContext2D();	
		framesError = new Image[14];
		for(int i = 0; i < framesError.length; i++) {
			framesError[i] = new Image("RecursosAnimation/oops_" + i + ".png");
		}
		
		error = new AnimatedImage();
		error.setFrames(framesError);
		error.setDuration(0.100);
		
	}
	
	public void showAnimationError() {		
		//TIMELINE
		timeLineError = new Timeline();
		timeLineError.setCycleCount(Timeline.INDEFINITE);
		Variable datos = new Variable();
		datos.startNanotime = System.nanoTime();
			
		// LOS TIMELINES NECESITAN UN KEYFRAME
		KeyFrame kf = new KeyFrame(
								Duration.seconds(0.017),
								new EventHandler<ActionEvent>() {
									public void handle (ActionEvent ae) {
												double t = (System.nanoTime() - datos.startNanotime)/1000000000.0;
												graphicsError.drawImage(error.getFrame(t), 0, 0);
													
												if(datos.x > 464)
													datos.iX = -1;
												if(datos.x<1)
													datos.iX = 1;
												if(datos.y > 464)
													datos.iY = -1;
												if(datos.y<1)
													datos.iY = 1;
													
												datos.x += datos.iX;
												datos.y+=datos.iY;				
												datos.x += datos.iX;												
											}
			});
			timeLineError.getKeyFrames().add(kf);
			timeLineError.play();
	}
	
	public void stopError() {
		timeLineError.stop();
	}
	
}