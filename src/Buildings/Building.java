package Buildings;

import processing.core.PApplet;
import processing.core.PShape;

public abstract class Building extends Thread{

	//State selects if the building is new, or damaged
	protected int x, y, health, scale, production, state;
	protected PShape[] shape;
	private PApplet app;
	
	Building(int _x, int _y, int _health, int _scale, int _production, int _state, PShape[] _shape, PApplet _app ){
		x =_x;
		y =_y;
		health =_health;
		scale =_scale;
		production =_production;
		state=_state;
		shape = _shape;
		app =_app;
	}

}
