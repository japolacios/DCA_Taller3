import processing.core.PApplet;
import processing.core.PImage;

public class Stage {
	private PApplet app;
	private PImage instru, fin, tiger, logo, fondo;
	private int pantalla = 0;
	private int contador = 0;
	private boolean zonaSensible = false;

	public Stage(PApplet app, int pantalla) {
		this.app = app;
		this.pantalla = pantalla;
		fondo = app.loadImage("../data/Fondo.png");
		tiger = app.loadImage("../data/tiger.png");
		logo = app.loadImage("../data/Logo.png");
		instru = app.loadImage("../data/casa1.png");
		fin = app.loadImage("../data/casa2.png");
	}

	public void pintar() {
		 System.out.println("mx: "+app.mouseX+" "+"my: "+app.mouseY+" "+"cont: "+contador+" "+"zona: "+zonaSensible+" "+"pant: "+pantalla);
		switch (pantalla) {
		// PANTALLA INICIAL
		case 0:
			app.image(fondo, 0, 0);
			app.imageMode(app.CENTER);
			app.image(tiger, app.width / 2, app.height / 2, 840, 860);
			app.imageMode(app.CORNER);
			app.image(logo, 10, 10, 534 / 2, 279 / 2);
			app.rectMode(app.CENTER);

			// BOT�N JUGAR Y �REA SENSIBLE
			if (app.mouseX > 188 && app.mouseX < 388 && app.mouseY > 525 && app.mouseY < 575) {
				app.fill(255, 119, 0);
				app.rect(app.width / 2 - 210, app.height / 2 + 250, 210, 60, 7);
				app.fill(0);
				app.textSize(38);
				app.text("Jugar", app.width / 2 - 260, app.height / 2 + 262);
			} else {
				app.fill(255, 119, 0);
				app.rect(app.width / 2 - 210, app.height / 2 + 250, 200, 50, 7);
				app.fill(0);
				app.textSize(32);
				app.text("Jugar", app.width / 2 - 250, app.height / 2 + 260);
			}
			// BOT�N INSTRUCCIONES Y �REA SENSIBLE
			if (app.mouseX > 573 && app.mouseX < 824 && app.mouseY > 525 && app.mouseY < 575) {
				app.fill(255, 119, 0);
				app.rect(app.width / 2 + 200, app.height / 2 + 250, 260, 60, 7);
				app.fill(0);
				app.textSize(36);
				app.text("Instrucciones", app.width / 2 + 88, app.height / 2 + 262);
			} else {
				app.fill(255, 119, 0);
				app.rect(app.width / 2 + 200, app.height / 2 + 250, 250, 50, 7);
				app.fill(0);
				app.textSize(32);
				app.text("Instrucciones", app.width / 2 + 100, app.height / 2 + 260);
			}

			app.rectMode(app.CORNER);

			break;
		// INSTRUCCIONES
		case 1:
			app.image(instru, 0, 0);
			break;
		// IN GAME
		case 2:

			break;
		// PANDALLA FINAL
		case 3:
			app.background(0);
			app.fill(0);
			app.textSize(50);
			app.text("Instrucciones", app.width / 2, app.height / 2);
			break;

		default:
			break;
		}

	}

	public void buttons() {
		float mx = app.mouseX;
		float my = app.mouseY;
		// Contador para la zona sensible (si deja la mano sobre la zona del
		// boton x tiempo se contar� como si fuese un click)
		if (zonaSensible) {
			if (app.frameCount % 60 == 0) {
				contador++;
			}
		} else {
			contador = 0;
		}
		if (pantalla > 1) {
			pantalla = 1;
		}
		// zona sensible del boton
		if (mx > 715 && mx < 975 && my > 585 && my < 635 && pantalla == 0) {
			zonaSensible = true;
			if (contador > 3) {
				pantalla += 1;
				zonaSensible = false;
			}
		} else {
			zonaSensible = false;
		}

	}

}
