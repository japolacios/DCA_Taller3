package Game;

import java.util.Observable;


import processing.core.PApplet;
import processing.core.PImage;


public class Meteorite extends Observable implements Runnable {
	
	//Atributes
	private int x,y,damage,fallF,health,id, ground;
	private float scale;
	private PApplet app;
	private PImage[] shapes;
	private boolean isGround, moved, selected, impacto = false;

	
	//Constructor
	Meteorite(PApplet _app,int _id){
		app = _app;
		id = _id;
		init();
	}
	
	public void run(){
		while(true){
			try{
				Thread.sleep(2);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			fall();
			
			//System.out.println(fallF);
			if (moved == true){
				setChanged();
				notifyObservers("move");
				//System.out.println("move");
				clearChanged();	
			}
			if(x <= 65 && y <= 435 && y >= 285){
				setChanged();
				notifyObservers("dead");
				clearChanged();
			}
			if(fallF <= 0 && isGround == false){
				setChanged();
				notifyObservers("ground");
				System.out.println("Hit ground on thread");
				clearChanged();
				isGround = true;
				impacto = true;
				moved = false;
			}
			
		}
	}
	
	public void init(){
		y = (int) (app.random(-450,-100));
		x = (int) (app.random(120,1100));
		scale = 1;
		fallF = 720;
		health = 100;
		isGround = false;
		shapes = new PImage[2];
		moved = true;
		selected = false;
		ground = y + 720;
		loadGraphics();
		
	}
	
	public void fall(){
		if (fallF >= 0 && isGround == false){
			y++;
			fallF--;
		}
		if (isGround == true && y <= ground && selected == false){
			y++;
		}
		
	}
	
	public void loadGraphics(){
		shapes[0] = app.loadImage("rock_00.png");
		
		System.out.println("Meteorite image Loaded");
	}

	public void paint(){
		
		app.imageMode(app.CENTER);
		app.image(shapes[0], x, y);
		
	}
	
	public void move(int _x,int _y){
		x = _x;
		y = _y;
	}
	
	/**************************************
	 * Getters & Setters
	 *************************************/
	
	public boolean getSelected(){
		return selected;
	}
	
	public void setSelected(){
		
		
		
		if(selected == false){
			selected = true;
		}
		if (selected == true){
			selected = false;
		}
	}
	
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
	
	public int getIdM(){
		return id;
	}

	public boolean isImpacto() {
		return impacto;
	}

	public void setImpacto(boolean impacto) {
		this.impacto = impacto;
	}
	
	

	
	//End Of Class
}

