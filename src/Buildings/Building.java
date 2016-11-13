package Buildings;

import java.util.Observer;

import Game.Fire;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public abstract class Building extends Thread{

	//State selects if the building is new, or damaged
	protected int x, y, health, scale, production, state;
	protected PImage[] shape;
	private PApplet app;
	public Fire fire;
	
	
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
	
	public void createFire(int _x, int _y){
		fire = new Fire(_x, _y+50, 100, 100, app);
		fire.start();
	}

	public void paint(){
		app.imageMode(app.CENTER);
		app.image(shape[0], x, y);
		paintFire();
	}
	
	public void paintFire(){
		if(fire != null){
			fire.paint();
		}
	}
	
	public void run(){
		while(true){
		
			try{
				sleep(10);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			//System.out.println("Building Damage");
			if(fire != null && fire.getHealth()>=0 && health > 0){
			health = health - fire.getDamage();
			}
			if(health<= 0){
			//	System.out.println("Building Burned  -  " + health);
			}
		}
		
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
}
