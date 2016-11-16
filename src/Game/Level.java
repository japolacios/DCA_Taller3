package Game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import com.jogamp.common.util.RunnableExecutor.CurrentThreadExecutor;

import ddf.minim.AudioSample;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Level extends Observable implements Observer {

	// Atributes
	private int lvl, numOfBuildingFires;
	private PApplet app;
	private boolean lvlCompleted;
	private Minim minim;
	private AudioSample boom;

	// Relations
	Meteorite selectedM;
	ArrayList<Meteorite> meteorites;
	ArrayList<Meteorite> mMeteorites;
	ArrayList<Fire> fires;

	// Constructor
	Level(PApplet _app, int _lvl) {
		app = _app;
		lvl = _lvl;
		meteorites = new ArrayList<Meteorite>();
		fires = new ArrayList<Fire>();
		setLvlDificulty();
		
		minim = new Minim(app);
		boom = minim.loadSample("../data/fx/explosion_audio.mp3", 512);
		
		runMeteorites();
		
		System.out.println("Level Initialized");
	}

	public void setLvlDificulty() {
		if (lvl == 0) {
			for (int i = 0; i < 1; i++) {
				Meteorite tempMeteorite = new Meteorite(app, i);
				tempMeteorite.addObserver(this);
				meteorites.add(tempMeteorite);
				System.out.println("Meteorite " + i + " initialized");
			}
		}
		if (lvl == 1) {
			for (int i = 0; i < 2; i++) {
				Meteorite tempMeteorite = new Meteorite(app, i);
				tempMeteorite.addObserver(this);
				meteorites.add(tempMeteorite);
				System.out.println("Meteorite " + i + " initialized");
			}
		}
		if (lvl == 2) {
			for (int i = 0; i < 3; i++) {
				Meteorite tempMeteorite = new Meteorite(app, i);
				tempMeteorite.addObserver(this);
				meteorites.add(tempMeteorite);
				System.out.println("Meteorite " + i + " initialized");
			}
		}
	}
	
	public void checkComplete(){
		
		if(meteorites == null || meteorites.size() <= 0){
			if (numOfBuildingFires <= 0) {
				setChanged();
				notifyObservers("done");
				clearChanged();
			}
		}
		
	}
	public void runMeteorites() {
		for (int i = 0; i < meteorites.size(); i++) {
			Thread threadTemp = new Thread(meteorites.get(i));
			threadTemp.start();
			System.out.println("Meteorite " + i + " Runing");
		}
	}

	public void paintMeteorite() {
		for (int i = 0; i < meteorites.size(); i++) {
			if (meteorites != null) {
				if (meteorites.get(i) != null) {
					meteorites.get(i).paint();
				}
			}
		}
	}

	public void paint() {
		paintMeteorite();
		paintFire();
		checkComplete();
	}

	public void createFire(int _x, int _y) {
		Fire fireTemp = new Fire(_x, _y + 50, 100, 100, app);
		fires.add(fireTemp);
		fireTemp.start();
	}

	public void paintFire() {
		if (fires != null) {
			for (int i = 0; i < fires.size(); i++) {
				fires.get(i).reciveDamage();
				fires.get(i).paint();
				if(fires.get(i).getHealth()<= 0){
					fires.remove(i);
				}
			}
		}
	}

	public void selectMeteorite() {
		if (selectedM == null) {
			
			for (int i = 0; i < meteorites.size(); i++) {

				if (app.dist(meteorites.get(i).getX(), meteorites.get(i).getY(), app.mouseX, app.mouseY) <= 30) {

					if (meteorites.get(i).getSelected() == false) {
						selectedM = meteorites.get(i);
						selectedM.setSelected();
					}
				}
			}
		}
	}

	public void dragMeteorite() {
		if (selectedM != null) {
			selectedM.move(app.mouseX, app.mouseY);
		}
	}

	public void releaseMeteorite() {
		if (selectedM != null) {
			selectedM.setSelected();
			selectedM = null;
		}
	}
	
	public void setNumOfFires(int _n){
		numOfBuildingFires = _n;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		if (arg.equals("dead")) {
			int id;
			Meteorite tempMeteorite = (Meteorite) o;
			id = tempMeteorite.getIdM();
			for (int i = 0; i < meteorites.size(); i++) {
				if (meteorites.get(i).getIdM() == id) {
					meteorites.remove(i);
				}
				
			}
		}
		
		if (arg.equals("move")) {
			// System.out.println("Got move");
			int newX, newY, id;
			Meteorite tempMeteorite = (Meteorite) o;
			newX = tempMeteorite.getX();
			newY = tempMeteorite.getY();
			id = tempMeteorite.getIdM();
			// if(mMeteorites != null){
			for (int i = 0; i < meteorites.size(); i++) {
				if (meteorites.get(i).getIdM() == id) {
					meteorites.get(i).setX(newX);
					meteorites.get(i).setY(newY);
					// System.out.println("New X: "+ newX + " - New Y: " +
					// newY);
				}
				// }
			}
		}
		if (arg.equals("ground")) {
			setChanged();
			boom.trigger();
			notifyObservers(o);
			clearChanged();
		}
	}
}
