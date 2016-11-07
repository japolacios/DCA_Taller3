import processing.core.PApplet;
import processing.core.PImage;

public class Stage {
	private PApplet app;
	private PImage panIni, instru, fin;
	private int pantalla = 0;
	private int contador = 0;
	private boolean zonaSensible = false;

	public Stage(PApplet app, int pantalla) {
		this.app = app;
		this.pantalla = pantalla;
		panIni = app.loadImage("../data/casa1.png");
		instru = app.loadImage("../data/casa2.png");
		fin = app.loadImage("../data/casa3.png");
	}

	public void pintar() {
		//System.out.println("mx: "+app.mouseX+" "+"my: "+app.mouseY+" "+"cont: "+contador+" "+"zona: "+zonaSensible+" "+"pant: "+pantalla);
		switch (pantalla) {
		case 0:
			app.image(panIni, 0, 0);
			break;
		case 1:
			app.image(instru, 0, 0);
			break;
		case 3:
			app.image(fin, 0, 0);
			break;

		default:
			break;
		}

	}
	public void buttons() {
		float mx = app.mouseX;
		float my = app.mouseY;
		// Contador para la zona sensible (si deja la mano sobre la zona del boton x tiempo se contará como si fuese un click)
		if (zonaSensible) {
			if (app.frameCount % 60 == 0) {
				contador++;
			}
		} else {
			contador = 0;
		}
		if (pantalla > 1){
			pantalla = 1;
		}
		// zona sensible del boton
		if (mx > 50 && mx < 100 && my > 50 && my < 100) {
			zonaSensible = true;
			if (contador > 3) {
				pantalla+=1;
				zonaSensible = false;
			}
		} else {
			zonaSensible = false;
		}

		
	}
 
}
