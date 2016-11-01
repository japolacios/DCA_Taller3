package Game;

import processing.core.PApplet;
import processing.core.PShape;

public class Water extends Thread {

	//Atributes
	private int x,y,damage,gravity;
	private float scale;
	private PApplet app;
	private PShape[] shapes;
	boolean hit;
	
	Water(int _x, int _y, PApplet _app){
		
		x=_x;
		y=_y;
		app = _app;
		hit = false;
		
	}
	
	public void run(){
		while(hit == false){
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

	public int getGravity() {
		return gravity;
	}

	public void setGravity(int gravity) {
		this.gravity = gravity;
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

	public boolean isHit() {
		return hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}
	

	
	
	
	//End Of Class
}
