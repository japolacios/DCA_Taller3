package Game;

import java.util.ArrayList;

import processing.core.PApplet;

public class Game {
	
	//Atributes
	private int level;
	private PApplet app;
	//Relations
	ArrayList<Level> levels;
	Player player;
	
	
	//Constructor
	Game(PApplet _app){
		app = _app;
		level = 1;
	}
}
