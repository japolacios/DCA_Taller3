package Game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;

public class Level extends Observable implements Observer, Runnable {
	
	//Atributes
	private int lvl;
	private PApplet app;
	private boolean lvlCompleted;
	
	//Relations
	ArrayList<Thread> meteorites;
	ArrayList<Fire> fires;
	
	//Constructor
	Level(PApplet _app, int _lvl){
		app = _app;
		lvl = _lvl;
		setLvlDificulty(100);
		runMeteorites();
	}
	
	
	public void setLvlDificulty(int _playerTotal){
		if(_playerTotal <= 200){
			Meteorite tempMeteorite = new Meteorite(app);
			tempMeteorite.addObserver(this);
			Thread threadTemp = new Thread(tempMeteorite);
			meteorites.add(threadTemp);
			
		}
	}
	
	public void runMeteorites(){
		for (int i = 0; i < meteorites.size(); i++) {
			meteorites.get(i).run();
		}
	}
	


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg.equals("dead")){
			for (int i = 0; i < meteorites.size(); i++) {
				Meteorite tempMeteorite = (Meteorite) o;
				//To Develop
			}
		}
	}
}
