package Game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;

public class Game implements Observer {
	
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
		System.out.println("Class Game Initialized");
	}
	
	public void newLevel(){
		cLevel = new Level(app, level);
	}
	
	public void paint(){
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
