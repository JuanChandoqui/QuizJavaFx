package com.visual.Quiz.Model;

import javafx.scene.image.Image;

public class Pregunta{
	private Image imagen;
	private String pregunta;
	private String respuesta;

	public Pregunta(Image imagen, String pregunta, String respuesta) {
		this.imagen = imagen;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
	}
		
	public Image getImagen() {
		return imagen;
	}
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}	
}
