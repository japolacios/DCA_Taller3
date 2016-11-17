package Game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Buildings.Building;
import processing.core.PApplet;
import processing.core.PImage;

public class Game implements Observer {

	// Atributes
	private int level, impactZone;
	private PApplet app;
	private PImage background, reloadBackground, trash;
	private boolean winGame = false, impacto;
	// Relations
	Level cLevel;
	Player player;

	// Constructor
	public Game(PApplet _app) {
		app = _app;
		level = 0;
		player = new Player(app);
		impactZone = 250;
		newLevel(level);
		background = app.loadImage("background.png");
		background.resize(app.width, app.height);
		reloadBackground = app.createImage(background.width, background.height, app.ARGB);
		trash = app.loadImage("trash.png");
		System.out.println("Class Game Initialized");
	}

	public void newLevel(int _lvl) {
		cLevel = new Level(app, _lvl);
		cLevel.addObserver(this);

	}

	public Player getPlayer() {
		if (player != null) {
			return player;
		} else {
			return null;
		}
	}

	public void getPlayerLevel() {
		if (level > 3) {
			cLevel = null;
			winGame = true;
		}
	}

	public void passActiveFires() {
		cLevel.setNumOfFires((int) player.countFires());
	}

	public void paint() {
		if (winGame == false) {
			paintBackground();
			player.paint();
			cLevel.paint();
			paintTrash();
			passActiveFires();
			getPlayerLevel();
			//System.out.println(background.width+" "+background.height);
		} else if (winGame == true) {

			// -----------------------------
			// CUANDO EL JUGADOR HA PASADO LOS 3 NIVELES
			// ------------------------------

		}
	}

	public void paintTrash() {
		app.imageMode(app.CENTER);
		app.image(trash, 70, 80);
	}

	public void levelManager() {
		if (cLevel != null) {
			cLevel = null;
			newLevel(level);
		}
	}

	public void paintBackground() {
		app.imageMode(app.CENTER);
		//filtroUno().resize(app.width, app.height);
		app.image(filtroUno(), app.width / 2, app.height / 2);
	}

	public Level getLevel() {
		return cLevel;
	}

	// Recives event to create fire
	@Override
	public void update(Observable o, Object arg) {

		if (arg.equals("done")) {
			level++;
			levelManager();
			System.out.println("Done");
		} else {
			// TODO Auto-generated method stub
			System.out.println("Impact Recived");

			Meteorite tempMeteorite = (Meteorite) arg;
			int impactX, impactY;
			impactX = tempMeteorite.getX();
			impactY = tempMeteorite.getY();
			cLevel.createFire(impactX, impactY);

			// Check for near buildings
			for (int i = 0; i < player.buildings.size(); i++) {
				Building buildTemp = player.buildings.get(i);
				System.out.println("Checking Buildings");
				if (app.dist(impactX, impactY, buildTemp.getX(), buildTemp.getY()) < impactZone) {
					System.out.println("Near Buildings Found");
					buildTemp.createFire(buildTemp.getX(), buildTemp.getY() + 50);
				}
			}
		}

	}

	public PImage filtroUno() {
		background.loadPixels();
		reloadBackground.loadPixels();
		for (int i = 0; i < background.height; i++) {
			for (int j = 0; j < background.width; j++) {
				int k = j + (i * background.width);
				int colorActual = background.pixels[k];
				float r = app.red(colorActual);
				float g = app.green(colorActual);
				float b = app.blue(colorActual);
				float promedio = (r + g + b) / 3;
				float distM = PApplet.dist(app.mouseX, app.mouseY, j, i);

				if (distM < 50) {
					reloadBackground.pixels[k] = app.color(PApplet.map(distM, 0, 50, r, 0),
							PApplet.map(distM, 0, 50, g, 0), PApplet.map(distM, 0, 50, b, 0), PApplet.map(distM, 0, 100,255,0));
				} else {
					reloadBackground.pixels[k] = app.color(promedio);
				}
			}

		}
		reloadBackground.updatePixels();
		return reloadBackground;
	}

}
