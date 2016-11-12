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
	
	private int pantalla = 0;

	// Relations

	// Constructor
	public Logica(PApplet _app) {
		app = _app;
		stage = new Stage(_app, pantalla);

	}

	// Paint Method
	public void paint() {
		if(pantalla == 0){
			paintStage();
		} else if(pantalla == 1){
			paintElements();
		}
		

	}
	
	public void paintStage(){		
			stage.buttons();
			stage.pintar();
	}
	
	// Paint Elements - Loop that calls paint method on every element
	public void paintElements() {
		if(game != null){
			game.paint();
		}
	}

	// Slice Data, Create Elements
	public void createElements() {
		game = new Game(app);
	}
	
	public void stageClick(){
		if (app.mouseX > 330 && app.mouseX < 540 && app.mouseY > 585 && app.mouseY < 645) {
			pantalla = 1;
			
		}
	}

	// ------------------------------
	// Mouse Events
	// ------------------------------
	public void click(){
		if(pantalla == 0){
			stageClick();
		}
	}
	
	public void press() {

	}

	public void drag() {

	}

	public void release() {

	}

	public void keyPressed() {

	}
	// End Class
}
