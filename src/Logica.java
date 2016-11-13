import java.util.ArrayList;

import Game.Game;
import Game.Player;
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
			app.background(255,255,255);
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
		System.out.println("New Game Created");
	}
	
	public void stageClick(){
		if (app.mouseX > 330 && app.mouseX < 540 && app.mouseY > 585 && app.mouseY < 645) {
			pantalla = 1;
			System.out.println("Click for Game");
			createElements();
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
	
	public void rightClick(){
		if (game != null){
			if (game.getPlayer() != null){
				Player playerTemp = game.getPlayer();
				playerTemp.addDrop(app.mouseX, app.mouseY);
			}
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
