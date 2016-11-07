package Game;

import processing.core.PApplet;
import processing.core.PShape;

public class Meteorite extends Thread {
	
	//Atributes
	private int x,y,damage,lvl,health, yI;
	private float scale;
	private PApplet app;
	private PShape[] shapes;
	private boolean wait, hit;
	
	
	//Constructor
	Meteorite(int _x, int _y, int _lvl, int _health, PApplet _app){
		x=_x;
		y=_y;
		lvl = _lvl;
		health = _health;
		app = _app;
		wait = false;
		hit = false;
		yI = _y;
	}
	
	public void run(){
		while(health > 0){
			try{
				if(wait == false){
					sleep(((int) app.random(0,(lvl*1000))));
					wait = true;
				}
				if (hit == false){
					fall();
				}
				
				
				sleep(100);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}

	
	private void fall(){
		while(yI+720 <= 720){
			y++;
		}
		if(yI+720 >= 720){
			hit = true;
		}
	}
	
	/**************************************
	 * Getters & Setters
	 *************************************/
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int _lvl) {
		this.lvl = _lvl;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public PShape[] getShapes() {
		return shapes;
	}

	public void setShapes(PShape[] shapes) {
		this.shapes = shapes;
	}


	
	//End Of Class
}

