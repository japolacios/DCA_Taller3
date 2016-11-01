package Game;

import processing.core.PApplet;
import processing.core.PShape;

public class Fire  extends Thread{
	
	//Atributes
	private int x,y,damage,size,health;
	private float scale;
	private PApplet app;
	private PShape[] shapes;
	
	Fire(int _x, int _y, int _size, int _health, PApplet _app){
		
		x=_x;
		y=_y;
		size = _size;
		health = _health;
		app = _app;
		
	}
	
	
	public void run(){
		while(health > 0){
			try{
				//Some Stuff (hit the fire - hit the Floor )
				sleep(1);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}


	/*****************************
	 * Getters & Setters
	 ****************************/
	
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


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
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
