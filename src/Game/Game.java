package Game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;
import processing.core.PImage;

public class Game implements Observer {
	
	//Atributes
	private int level;
	private PApplet app;
	private PImage background;
	
	//Relations
	Level cLevel;
	Player player;
	
	
	//Constructor
	public Game(PApplet _app){
		app = _app;
		level = 1;
		player = new Player(app);
		cLevel = new Level(app, level);
		background = app.loadImage("background.png");
		System.out.println("Class Game Initialized");
	}
	
	public void newLevel(){
		cLevel = new Level(app, level);
	}
	
	public void paint(){
		paintBackground();
		cLevel.paint();
	}
	
	public void paintBackground(){
		app.imageMode(app.CENTER);
		background.resize(app.width, app.height);
		app.image(background, app.width/2, app.height/2);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
