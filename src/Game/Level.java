package Game;

import java.util.ArrayList;

import processing.core.PApplet;

public class Level {
	
	//Atributes
	private int lvl, playerLevel;
	private PApplet app;
	private boolean lvlCompleted;
	
	//Relations
	ArrayList<Thread> meteorites;
	ArrayList<Thread> fires;
	
	//Constructor
	Level(PApplet _app, int _lvl){
		app = _app;
		lvl = _lvl;
	}
	
	public void recivePlayerStats(int _p, int _c, int _i){
		playerLevel = _p+_c+_i;
	}
	
	public void setLvlDificulty(){
		//Sets the amount of meteorites that fall, and how destructive they are
		if (playerLevel < 100){
			lvl = 1;
		}
		if (playerLevel >= 100 && 500< playerLevel){
			lvl = 2;
		}
		if (playerLevel >= 500 && 700< playerLevel){
			lvl = 3;
		}
		if (playerLevel >= 700 && 1000< playerLevel){
			lvl = 5;
		}
		if (playerLevel >= 1000 ){
			lvl =(int) ((playerLevel*0.1)/15);
		}
	}
	
	public void resetLevel(){
		meteorites = null;
		fires = null;
	}
	
	public void runLevel(){
		
	}
	
	public void checkLvlClear(){
		//Check if all the meteorites where desroyed and fire out
	}
}
