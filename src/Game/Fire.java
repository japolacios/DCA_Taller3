package Game;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class Fire  extends Thread{
	
	//Atributes
	private int x,y,damage,size,health,iImg;
	private float scale;
	private PApplet app;
	private PImage[] shapes;
	
	Fire(int _x, int _y, int _size, int _health, PApplet _app){
		
		x=_x;
		y=_y;
		size = _size;
		health = _health;
		app = _app;
		iImg = 0;
		System.out.println("New Fire");
		init();
	}
	
	public void init(){
		loadImages();
	}
	
	public void loadImages(){
		shapes = new PImage[4];
		shapes[0] = app.loadImage("fire_00.png");
		shapes[1] = app.loadImage("fire_01.png");
		shapes[2] = app.loadImage("fire_03.png");
		shapes[3] = app.loadImage("fire_04.png");
	}
	
	public void changeFire(){
		if (iImg >= 3){
			iImg = 0;
		}
		if (iImg<3){
			iImg++;
		}
	}
	
	public void scaleFire(){
		shapes[iImg].resize( (shapes[iImg].width)*(int)(scale/100), (shapes[iImg].height) * (int)(scale/100));
	}
	
	public void paint(){
		//scaleFire();
		app.imageMode(app.CENTER);
		app.image(shapes[iImg], x, y-50);
	}
	
	public void run(){
		while(health > 0){
			try{
				//Some Stuff (hit the fire - hit the Floor )
				sleep(60);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			changeFire();
			
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


	public PImage[] getShapes() {
		return shapes;
	}


	public void setShapes(PImage[] shapes) {
		this.shapes = shapes;
	}
	
	
	
	//End Of Class
}
