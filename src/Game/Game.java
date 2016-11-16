package Game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Buildings.Building;
import processing.core.PApplet;
import processing.core.PImage;

public class Game implements Observer {
	
	//Atributes
	private int level, impactZone;
	private PApplet app;
	private PImage background, trash;
	private boolean winGame = false;
	//Relations
	Level cLevel;
	Player player;
	
	
	//Constructor
	public Game(PApplet _app){
		app = _app;
		level = 0;
		player = new Player(app);
		impactZone = 250;
		newLevel(level);
		background = app.loadImage("background.png");
		trash = app.loadImage("trash.png");
		System.out.println("Class Game Initialized");
	}
	
	public void newLevel(int _lvl){
		cLevel = new Level(app, _lvl);
		cLevel.addObserver(this);
		
	}
	
	
	
	public Player getPlayer(){
		if(player != null){
			return player;
		} else{
			return null;
		}
	}
	
	public void getPlayerLevel(){
		 if(level > 3){
			cLevel = null;
			winGame = true;
		}
	}
	
	public void  passActiveFires(){
		cLevel.setNumOfFires( player.countFires() );
	}
	
	public void paint(){
		if(winGame == false){
		paintBackground();
		player.paint();
		cLevel.paint();
		paintTrash();
		passActiveFires();
		getPlayerLevel();
		} else if (winGame == true ){
			
			
			//-----------------------------
			//CUANDO EL JUGADOR HA PASADO LOS 3 NIVELES
			//------------------------------
			
			
		}
	}
	
	public void paintTrash(){
		app.imageMode(app.CENTER);
		app.image(trash, 15, 360);
	}
	
	public void levelManager(){
		if(cLevel != null){
			cLevel = null;
			newLevel(level);
		}
	}
	
	public void paintBackground(){
		app.imageMode(app.CENTER);
		background.resize(app.width, app.height);
		app.image(background, app.width/2, app.height/2);
	}
	
	public Level getLevel(){
		return cLevel;
	}
	//Recives event to create fire
	@Override
	public void update(Observable o, Object arg) {
		
		
		if (arg.equals("done")){
			level++;
			levelManager();
			System.out.println("Done");
		} else {
		// TODO Auto-generated method stub
		System.out.println("Impact Recived");
		
		Meteorite tempMeteorite = (Meteorite) arg;
		int impactX, impactY;
		impactX = tempMeteorite.getX();
		impactY = tempMeteorite.getY();
		cLevel.createFire(impactX, impactY);
		
		//Check for near buildings
		for (int i = 0; i < player.buildings.size(); i++) {
			Building buildTemp = player.buildings.get(i);
			System.out.println("Checking Buildings");
			if(app.dist(impactX, impactY, buildTemp.getX(), buildTemp.getY()) < impactZone){
				System.out.println("Near Buildings Found");
				buildTemp.createFire(buildTemp.getX(), buildTemp.getY()+50);
			}
		}
		}
		
	}
}
