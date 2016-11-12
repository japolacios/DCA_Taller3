package Game;

import java.util.ArrayList;

import processing.core.PApplet;

public class Game {
	
	//Atributes
	private int level;
	private PApplet app;
	//Relations
	Level cLevel;
	Player player;
	
	
	//Constructor
	public Game(PApplet _app){
		app = _app;
		level = 1;
		player = new Player(app);
		cLevel = new Level(app, level);
	}
	
	public void paint(){
		
	}
}
