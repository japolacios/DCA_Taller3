package Game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import com.jogamp.common.util.RunnableExecutor.CurrentThreadExecutor;

import processing.core.PApplet;

public class Level extends Observable implements Observer, Runnable {
	
	//Atributes
	private int lvl;
	private PApplet app;
	private boolean lvlCompleted;
	
	//Relations
	ArrayList<Thread> meteorites;
	ArrayList<Meteorite> mMeteorites;
	ArrayList<Fire> fires;
	
	//Constructor
	Level(PApplet _app, int _lvl){
		app = _app;
		lvl = _lvl;
		meteorites = new ArrayList<Thread>();
		mMeteorites = new ArrayList<Meteorite>();
		setLvlDificulty();
		runMeteorites();
		
		System.out.println("Level Initialized");
	}
	
	
	public void setLvlDificulty(){
		if(lvl <= 200){
			for (int i = 0; i < 1; i++) {
				Meteorite tempMeteorite = new Meteorite(app, i);
				tempMeteorite.addObserver(this);
				mMeteorites.add(tempMeteorite);
				Thread threadTemp = new Thread(tempMeteorite);
				meteorites.add(threadTemp);	
				System.out.println("Meteorite "+ i + " initialized");
			}
			
		}
	}
	
	public void runMeteorites(){
		for (int i = 0; i < meteorites.size(); i++) {
			meteorites.get(i).start();
			System.out.println("Meteorite "+ i + " Runing");
		}
	}
	
	public void paintMeteorite(){
		for (int i = 0; i < meteorites.size(); i++) {
			if(mMeteorites != null){
				if(mMeteorites.get(i) != null){
					mMeteorites.get(i).paint();
				}
			}
		}
	}

	public void paint(){
		paintMeteorite();
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg.equals("move")){
			//System.out.println("Got move");
			int newX, newY, id;
				Meteorite tempMeteorite = (Meteorite) o;
				newX = tempMeteorite.getX();
				newY = tempMeteorite.getY();
				id = tempMeteorite.getIdM();
				//if(mMeteorites != null){
				for (int i = 0; i < mMeteorites.size(); i++) {
					if(mMeteorites.get(i).getIdM() == id){
						mMeteorites.get(i).setX(newX);
						mMeteorites.get(i).setY(newY);
						//System.out.println("New X: "+ newX + " - New Y: " + newY);
					}
				//}
				}
		}
		if (arg.equals("ground")){
			int impactX, impactY;
				Meteorite tempMeteorite = (Meteorite) o;
				impactX = tempMeteorite.getX();
				impactY = tempMeteorite.getY();
				
				System.out.println("Meteorite " + tempMeteorite.getIdM() + " hit ground");
				//Iniciar Fuegos con coordenadas del Impacto - Disminuir salud
		}
	}
}
