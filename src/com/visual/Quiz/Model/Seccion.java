package com.visual.Quiz.Model;
import java.util.ArrayList;

import javafx.scene.image.Image;

public class Seccion {
	
	private ArrayList<Pregunta> preguntas;
	private ArrayList<String> listaOpciones;
	
	//Se hace uso del constructor para inicializar los atributos
	public Seccion() {
		Image image;
		Pregunta p;
		preguntas = new ArrayList<>();
		listaOpciones = new ArrayList<>();
		
		//Llenar arrayList de preguntas
		for(int i = 0; i < arregloPregunta.length; i++) {
			image = new Image(imagenes[i]);
			p = new Pregunta(image, arregloPregunta[i], arregloRespuesta[i]);
			preguntas.add(p);
		}
		
		//Llenar arrayList de opciones
		for(int i = 0; i < opciones.length; i++) {
			listaOpciones.add(opciones[i]);
		}		
	}
	
	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public ArrayList<String> getListaOpciones() {
		return listaOpciones;
	}

	public void setListaOpciones(ArrayList<String> listaOpciones) {
		this.listaOpciones = listaOpciones;
	}	
	
	private String [] arregloPregunta = {"Quien soy?",
										 "Nombre del personaje? (Pelicula: Star Wars)",
										 "Quien fue el primer presidente de Mexico?",
										 "Cuantas copas del mundo ha ganado Brasil?",
										 "Nombre de la pelicula que se muestra en la imagen?",
										 "Periodo que se llevo a cabo la Segunda Guerra Mundial?",
										 "En que año se fundo la ciudad de Tenochtitlan?",
										 "Nombre de la pelicula protagonizada por Will Smith",
										 "Cancion mas famosa del duo Frances Daft Punk?",	
										 "Es un lenguaje de script basado en prototipos \ndinamico y orientado a objetos",
										 " "
										};
			
	private String [] arregloRespuesta = {"Harry Potter",
										"Ahsoka",
										"Guadalupe Victoria",
										"5",
										"La vida es bella",
										"1939-1945",
										"1345",
										"En busca de la felicidad",
										"Get Lucky",
										"JavaScript",
										" "
										};
		
	private String [] imagenes = {"Recursos/harry.png",
								  "Recursos/ahsoka.png",
								  "Recursos/banderaMexico.png",
								  "Recursos/brasil.png",
								  "Recursos/vidaBella.png",
								  "Recursos/guerraMundial.png",
								  "Recursos/tenoch.png",
								  "Recursos/felicidad.png",
								  "Recursos/daftPunk.png",
								  "Recursos/lenguaje.png",
								  "Recursos/wallpaper.png",
								  " "
								 };	
	
	private String [] opciones = {"Harry Potter", "Severus Snape" , "Albus Dumbledore", 
								  "Leia Organa", "Ahsoka", "Padme Amidala",
								  "Guadalupe Victoria", "Vicente Guerrero", "Pedro Velez",
								  "4" , "6" , "5",
								  "La vida es bella", "1917", "Jojo Rabbit",
								  "1939-1945", "1938-1935", "1940 - 1944",
								  "1234", "1345", "1320",
								  "Siete almas","En busca de la felicidad", "Belleza inesperada",
								  "Instant Crush", "One more Time", "Get Lucky",
								  "Java", "JavaScript", "Python",
								  " ", " ", " "			  
								  };	
}
