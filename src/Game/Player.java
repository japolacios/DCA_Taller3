package Game;
import java.util.ArrayList;

import Buildings.Building;
import Buildings.Farm;
import Buildings.House;
import Buildings.Silo;
import processing.core.PApplet;
import processing.core.PImage;

public class Player {
	//Atributes
	private PApplet app;
	private int money;
	private int population;
	private int corn;
	private int industry;
	
	//ImageList
	PImage[] casasImg;
	PImage[] farmsImg;
	
	//Relations
	Water water;
	ArrayList<Building> buildings;
	ArrayList<Thread> drops;
	
	//Constructor
	Player(PApplet _app){
	app = _app;
	money = 0;
	
	buildings = new ArrayList<Building>();
	
	population = checkPopulation();
	corn = checkCorn();
	industry = checkIndustry();
	//Creates Arrays For Image Files and Loads images in to them
	loadShapes();
	
	//Creates Initial Bouildings
	createInitialBuildings();
	
	System.out.println("Player Initialized");
	}
	
	private void loadShapes(){
		casasImg = new PImage[2];
		casasImg[0] =  app.loadImage("casa1.png");
		
		farmsImg = new PImage[2];
		farmsImg[0] = app.loadImage("trigo.png");
	}
	
	private void createInitialBuildings(){
		House house1 = new House(300, 300, 1000, 1, 50, 1, casasImg, app);
		Farm farm1 = new Farm(500, 300, 1000, 1, 50, 1, farmsImg, app);
		
		buildings.add(house1);
		buildings.add(farm1);
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
				if (((Water) drops.get(i)).isHit() == true){
					drops.get(i).interrupt();
				} 
			}
		}
	}
	
	public void paint(){
		paintBuildings();
	}
	
	public void paintBuildings(){
		for (int i = 0; i < buildings.size(); i++) {
			buildings.get(i).paint();
		}
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
