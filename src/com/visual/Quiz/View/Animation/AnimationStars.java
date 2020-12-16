package com.visual.Quiz.View.Animation;	

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AnimationStars{
	private Image[] framesStar;
	private GraphicsContext graphicsStar;
	private AnimatedImage star;
	private Timeline timeLineStar;
		
	public AnimationStars(Canvas canvasStar) {			
		//estrellas

		graphicsStar = canvasStar.getGraphicsContext2D();	
		framesStar = new Image[11];	
		for(int i = 0; i < framesStar.length; i++) {
			framesStar[i] = new Image("RecursosAnimation/starColor_" + i + ".png");
		}		
		star = new AnimatedImage();
		star.setFrames(framesStar);
		star.setDuration(0.100);
		
		
	}
	
	//OBJETO ANIMATEDIMAGE	
	public void showAnimationStar() {		
		//TIMELINE
		timeLineStar = new Timeline();
		timeLineStar.setCycleCount(Timeline.INDEFINITE);
		Variable datos = new Variable();
		datos.startNanotime = System.nanoTime();
			
		// LOS TIMELINES NECESITAN UN KEYFRAME
		KeyFrame kf = new KeyFrame(
								Duration.seconds(0.017),
								new EventHandler<ActionEvent>() {
									public void handle (ActionEvent ae) {
												double t = (System.nanoTime() - datos.startNanotime)/1000000000.0;
												graphicsStar.drawImage(star.getFrame(t), 20, 10);
													
												if(datos.x > 464)
													datos.iX = 1;
												if(datos.x<1)
													datos.iX = 0;
												if(datos.y > 464)
													datos.iY = 1;
												if(datos.y<1)
													datos.iY = 0;
													
												datos.x += datos.iX;
												datos.y+=datos.iY;				
												datos.x += datos.iX;												
											}
			});
			timeLineStar.getKeyFrames().add(kf);
			timeLineStar.play();
	}
	
	public void stopStar() {
		timeLineStar.stop();
	}
		
}