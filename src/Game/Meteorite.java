package Game;

import java.util.Observable;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class Meteorite extends Observable implements Runnable {
	
	//Atributes
	private int x,y,damage,fallF,health;
	private float scale;
	private PApplet app;
	private PImage[] shapes;
	
	
	//Constructor
	Meteorite(PApplet _app){
		app = _app;
		init();
	}
	
	public void run(){
		while(true){
			try{
				Thread.sleep(300);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			fall();
			paint();
			if(health <= 0){
				setChanged();
				notifyObservers("dead");
				clearChanged();
			}
			
		}
	}
	
	public void init(){
		y = (int) (app.random(-500,-230));
		x = (int) (app.random(80,1200));
		scale = 1;
		fallF = 720;
		health = 100;
		
	}
	
	public void fall(){
		if (fallF >= 0){
			y--;
		}
	}
	
	public void loadGraphics(){
		shapes[0] = app.loadImage("rock_00.png");
	}

	public void paint(){
		app.imageMode(app.CENTER);
		app.image(shapes[0], x, y);
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

	
	//End Of Class
}

