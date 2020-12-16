package com.visual.Quiz.Model;

public class Quiz {

	private int aciertos = 0;
	private int score = 0;
	private int siguiente;
	private Seccion seccion;
	private boolean acertado;
	
	public Quiz() {
		seccion = new Seccion();
	}
	
	public int getAciertos() {
		return aciertos;
	}
	
	public boolean acertado(String opcion) {
		for (int i = 0; i < getSeccion().getPreguntas().size(); i++) { 
    		if(getSeccion().getPreguntas().get(i).getRespuesta().equals(opcion)) {
    	    	acertado = true; 
    	    	break;
    		}
    	    else {
    	    	acertado = false;
    	    }
    	}		
		return acertado;
	}
	
	public void setAciertos(int aciertos) {
		this.aciertos = aciertos;
	}
		
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void calcularPuntos() {
		score += 15;
	}
	
	public void calcularAciertos() {
		aciertos++;
	}
	
	public Seccion getSeccion() {
		return seccion;
	}
	
	public void siguiente() {
		siguiente++;
	}
	
	public int getSiguiente() {
		return siguiente;
	}
}
