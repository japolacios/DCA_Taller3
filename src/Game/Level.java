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
		meteorites = new ArrayList<Thread>();
		setLvlDificulty();
		runMeteorites();
		
		System.out.println("Level Initialized");
	}
	
	
	public void setLvlDificulty(){
		if(lvl <= 200){
			for (int i = 0; i < 1; i++) {
				Meteorite tempMeteorite = new Meteorite(app, i);
				tempMeteorite.addObserver(this);
				Thread threadTemp = new Thread(tempMeteorite);
				meteorites.add(threadTemp);	
				System.out.println("Meteorite "+ i + " initialized");
			}
			
		}
	}
	
	public void runMeteorites(){
		for (int i = 0; i < meteorites.size(); i++) {
			meteorites.get(i).run();
			System.out.println("Meteorite "+ i + " Runing");
		}
	}
	


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg.equals("ground")){
			int impactX, impactY;
				Meteorite tempMeteorite = (Meteorite) o;
				impactX = tempMeteorite.getX();
				impactY = tempMeteorite.getY();
				
				System.out.println("Meteorite " + tempMeteorite.getId() + " hit ground");
				//Iniciar Fuegos con coordenadas del Impacto - Disminuir salud
		}
	}
}
