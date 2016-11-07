import java.util.ArrayList; 

import Game.Game;

import de.voidplus.leapmotion.Finger;
import de.voidplus.leapmotion.Hand;
import de.voidplus.leapmotion.LeapMotion;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import de.voidplus.leapmotion.*;

public class Logica {
	// Atributes
	PApplet app;
	Stage stage;
	Game game;
	int Pantallas;
	PImage tiger, logo, fondo;
	

	// Relations

	// Constructor
	public Logica(PApplet _app) {
		app = _app;
	fondo= app.loadImage("../data/Fondo.png");
	tiger= app.loadImage("../data/tiger.png");
	logo= app.loadImage("../data/Logo.png");
	
	}

	// Paint Method
	public void paint() {
	
		switch (Pantallas){
		
		//inicio
		case 0:
			app.image(fondo, 0,0, 1000,600); 
			app.imageMode(app.CENTER);
		app.image(tiger, app.width/2,app.height/2, 840, 860);
		app.imageMode(app.CORNER);
		app.image(logo, 10, 10, 534/2, 279/2);
			app.rectMode(app.CENTER);
		
	// BOTÓN JUGAR Y ÁREA SENSIBLE 
			if (app.mouseX>188 && app.mouseX<388 && app.mouseY>525 && app.mouseY<575) {
				app.fill(255,119,0);
				app.rect(app.width/2-210, app.height/2+250, 210,60, 7);	
				app.fill(0);
				app.textSize(38);
				app.text("Jugar", app.width/2-260, app.height/2+262);
}else {
	app.fill(255,119,0);
				app.rect(app.width/2-210, app.height/2+250, 200,50, 7);
				app.fill(0);
				app.textSize(32);
				app.text("Jugar", app.width/2-250, app.height/2+260);
				}
			// BOTÓN INSTRUCCIONES Y ÁREA SENSIBLE 
			if(app.mouseX>573 && app.mouseX<824 && app.mouseY>525 && app.mouseY<575) {
				app.fill(255,119,0);
				app.rect(app.width/2+200, app.height/2+250, 260,60, 7);
				app.fill(0);
				app.textSize(36);
				app.text("Instrucciones", app.width/2+88, app.height/2+262);
			}else {
				app.fill(255,119,0);
		app.rect(app.width/2+200, app.height/2+250, 250,50, 7);
		app.fill(0);
		app.textSize(32);
		app.text("Instrucciones", app.width/2+100, app.height/2+260);}
			
		app.rectMode(app.CORNER);
	
		
		
			
			
		break;
		// juego
		case 1: 
			break; 
			// perdida
		case 2: 
			app.background(0);
			app.fill(0);
			app.textSize(50);
			app.text("Instrucciones", app.width/2, app.height/2);
			
			break;
			
			// victoria 
		case 3:
			
			break;
		
		
		}
	}

	// Paint Elements - Loop that calls paint method on every element
	public void paintElements() {

	}

	// Slice Data, Create Elements
	public void createElements() {

	}

	// ------------------------------
	// Mouse Events
	// ------------------------------
	
	public void clic() {
		if (app.mouseX>188 && app.mouseX<388 && app.mouseY>525 && app.mouseY<575 && Pantallas==0) {
			Pantallas++;
		}
		System.out.println(Pantallas);
		
		
	System.out.println(app.mouseX); 	System.out.println(app.mouseY);
	}
	public void press() {

	}

	public void drag() {

	}

	public void release() {

	}
	
	public void keyPressed(){
		if (app.key=='Q' || app.key=='q'){
			Pantallas=2;
		}
	}
	// End Class
}
