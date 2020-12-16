package com.visual.Quiz.View.Animation;

import javafx.scene.image.Image;

public class AnimatedImage {
	private Image[] frames;
	private double duration;
	
	public void setFrames(Image [] frames) {
		this.frames = frames;
	}
	
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public Image getFrame(double time) {
		int index = (int)((time %(frames.length * duration))/ duration);
		return frames [index];
	}
}
