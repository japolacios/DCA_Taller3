package Game;
import java.util.ArrayList;

import Buildings.Building;
import Buildings.Farm;
import Buildings.House;
import Buildings.Silo;
import ddf.minim.AudioSample;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PImage;

public class Player {
	//Atributes
	private PApplet app;
	private int money;
	private int population;
	private int corn;
	private int industry;
	private Minim minim;
	private AudioSample dropS;
	private int totalFires;
	
	//ImageList
	PImage[] casasImg;
	PImage[] farmsImg;
	PImage hud;
	PImage casasImg3;
	//Relations
	Water water;
	ArrayList<Building> buildings;
	ArrayList<Thread> drops;
	
	//Constructor
	Player(PApplet _app){
	app = _app;
	money = 0;
	
	buildings = new ArrayList<Building>();
	drops = new ArrayList<Thread>();
	population = checkPopulation();
	corn = checkCorn();
	industry = checkIndustry();
	minim = new Minim(app);
	dropS = minim.loadSample("../data/fx/drop_audio.mp3", 512);
	//Creates Arrays For Image Files and Loads images in to them
	loadShapes();
	
	//Creates Initial Bouildings
	createInitialBuildings();
	runBuildings();
	System.out.println("Player Initialized");
	}
	
	private void loadShapes(){
		casasImg = new PImage[3];
		casasImg[0] =  app.loadImage("casa1.png");
		casasImg[1] = app.loadImage("casa2.png");
		casasImg3 = app.loadImage("casa3.png");
		farmsImg = new PImage[2];
		farmsImg[0] = app.loadImage("trigo.png");
		hud = app.loadImage("hug.png");
	}
	
	private void createInitialBuildings(){
		int silo = 2;
		House house1 = new House(300, 300, 1000, 1, 50, 1, casasImg, app);
		Farm farm1 = new Farm(500, 300, 1000, 1, 50, 1, farmsImg, app);

		House house2 = new House(1000, 500, 1000, 1, 50, 1, casasImg, app);
		Farm farm2 = new Farm(800, 600, 1000, 1, 50, 1, farmsImg, app);
		

		//Silo silos = new Silo(700, 300, 1500, 1, 50, 1, casasImg3, app);
		//buildings.add(silos);

		buildings.add(house1);
		buildings.add(farm1);
		buildings.add(house2);
		buildings.add(farm2);
	}
	
	//Check for de Actual data of Player game stats
	private int checkPopulation(){
		int salida = 0;
		if (buildings != null){
			for (int i = 0; i < buildings.size(); i++) {
				if(buildings.get(i) instanceof House){
					salida = salida + buildings.get(i).getProduction();
				}
			}
		}
		return salida;
	}
	
	private int checkCorn(){
		int salida = 0;
		if (buildings != null){
			for (int i = 0; i < buildings.size(); i++) {
				if(buildings.get(i) instanceof Farm){
					salida = salida + buildings.get(i).getProduction();
				}
			}
		}
		return salida;
	}
	
	private int checkIndustry(){
		int salida = 0;
		if (buildings != null){
			for (int i = 0; i < buildings.size(); i++) {
				if(buildings.get(i) instanceof Silo){
					salida = salida + buildings.get(i).getProduction();
				}
			}
		}
		return salida;
	}
	
	public void throwWater(){
		Water tempDrop = new Water(app.mouseX,app.mouseY,app);
		Thread tempThread = new Thread(tempDrop);
		drops.add(tempThread);
		if(drops != null){
			for (int i = 0; i < drops.size(); i++) {
				
			 drops.get(i).run();
			}
		}
	}
	
	//Method to kill a drop if it has hit o fallen
	public void checkDrops(){
		if(drops != null){
			for (int i = 0; i < drops.size(); i++) {
				for (int j = 0; j < buildings.size(); j++) {
					if(buildings.get(j).giveFire() != null && drops.get(i)!= null){
					if(app.dist(buildings.get(j).giveFire().getX(), buildings.get(j).giveFire().getY(),
							((Water) drops.get(i)).getX(), ((Water) drops.get(i)).getY())<= 30){
						buildings.get(j).giveFire().reciveDamage();
						drops.get(i).interrupt();
						drops.remove(i);
					}
					}
				}
				}
			for(int i = 0; i < drops.size(); i++) {
			if ( drops.get(i)!= null){
				if (((Water) drops.get(i)).isHit() == true){
					drops.get(i).interrupt();
					drops.remove(i);
				//	System.out.println("Drop Interrupted");
				} 
			}
			}
		}
	}
	
	public void paint(){
		paintBuildings();
		paintDrops();
	}
	
	public void paintDrops(){
		if(drops != null){
			checkDrops();
		for (int i = 0; i < drops.size(); i++) {
			 ((Water) drops.get(i)).paint(); 
		}
	}
	}
	
	public void paintBuildings(){
		for (int i = 0; i < buildings.size(); i++) {
			buildings.get(i).paint();
			if(buildings.get(i).getHealth()<= 0){
				buildings.remove(i);
			}
		}
	}
	
	public void runBuildings(){
		System.out.println("Running Buildings");
		for (int i = 0; i < buildings.size(); i++) {
			buildings.get(i).start();
		}
	}
	
	public void addDrop(int _x,int _y){
		Water dropTemp = new Water(_x, _y, app);
		drops.add(dropTemp);
		dropS.trigger();
		dropTemp.start();
		
	}
	
	public int countFires(){
		int salida = 0;
		if(buildings != null){
			for (int i = 0; i < buildings.size(); i++) {
				if(buildings.get(i).giveFire() != null){
					salida++;
				}
			}
		}
		return salida;
	}
	/******************
	Getters & Setters 
	 *****************/
	
	//Getters
	public int getMoney(){
		return money;
	}
	
	public int getPopulation(){
		return population;
	}
	
	public int getCorn(){
		return corn;
	}
	
	public int getIndustry(){
		return money;
	}
	
	//Setters
	public void setMoney(int input){
		money = input;
	}
	
	public void setPopulation(int input){
		 population  = input;
	}
	
	public void setCorn(int input){
		corn  = input;
	}
	
	public void setIndustry(int input){
		money  = input;
	}
}
