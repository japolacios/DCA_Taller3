package Game;
import processing.core.PApplet;

public class Player {
	//Atributes
	private PApplet app;
	private int money;
	private int population;
	private int corn;
	private int industry;
	
	//Constructor
	
	Player(PApplet _app){
	app = _app;
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
