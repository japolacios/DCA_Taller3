package Game;

import processing.core.PApplet;
import processing.core.PShape;

public class Water extends Thread {

	//Atributes
	private int x,y,damage,gravity, cycles;
	private float scale;
	private PApplet app;
	private PShape[] shapes;
	boolean hit;
	
	Water(int _x, int _y, PApplet _app){
		app = _app;
		x=_x + change();
		y=_y + change();
		hit = false;
		gravity = 1;
		damage = 2;
		cycles = 20;
		
	}
	
	public int change(){
		int salida;
		float temp;
		temp = (int) app.random(-10, 10);
		salida = (int)temp;
		//System.out.println("RANDOM: "+ salida);
		return salida;
	}
	
	public void run(){
		while(hit == false){
			try{
				sleep(5);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			fall();
			if(cycles <= 0){
				hit = true;
				
			}			
		}
	}
	
	public void paint(){
		app.fill(0,0,255);
		app.ellipse(x, y, 5, 5);
	}

	public void fall(){
		cycles--;
		if(cycles>= 0){
		x = x-(int)(cycles/3);
		y = y + 5;
		}
	}
	
	public void checkHit(int _x, int _y){
		if (app.dist(x, y,_x, _y)<= 10){
			hit = true;
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

	public void setHit(boolean _hit) {
		hit = _hit;
	}
	

	
	
	
	//End Of Class
}
