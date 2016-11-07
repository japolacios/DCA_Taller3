package Game;

import java.util.ArrayList;

import processing.core.PApplet;

public class Level {
	
	//Atributes
	private int lvl;
	private PApplet app;
	private boolean lvlCompleted;
	
	//Relations
	ArrayList<Meteorite> meteorites;
	ArrayList<Fire> fires;
	
	//Constructor
	Level(PApplet _app, int _lvl){
		app = _app;
		lvl = _lvl;
	}
	
	
	public void setLvlDificulty(){
		//Sets the amount of meteorites that fall, and how destructive they are
	}
	
	public void checkLvlClear(){
		//Check if all the meteorites where desroyed and fire out
	}
}
