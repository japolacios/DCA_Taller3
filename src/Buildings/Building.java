package Buildings;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public abstract class Building extends Thread{

	//State selects if the building is new, or damaged
	protected int x, y, health, scale, production, state;
	protected PImage[] shape;
	private PApplet app;
	
	Building(int _x, int _y, int _health, int _scale, int _production, int _state, PImage[] _shape, PApplet _app ){
		x =_x;
		y =_y;
		health =_health;
		scale =_scale;
		production =_production;
		state=_state;
		shape = _shape;
		app =_app;
	}
	
	public int getProduction(){
		return production;
	}

	public void paint(){
		app.imageMode(app.CENTER);
		app.image(shape[0], x, y);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}
