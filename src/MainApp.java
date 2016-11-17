import java.util.ArrayList;

import Game.Meteorite;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import de.voidplus.leapmotion.Arm;
import de.voidplus.leapmotion.Finger;
import de.voidplus.leapmotion.Hand;
import de.voidplus.leapmotion.LeapMotion;
import processing.core.PApplet;
import processing.core.PVector;

public class MainApp extends PApplet {

	// Relations
	Logica logica;
	LeapMotion leap;
	Minim minim;
	AudioPlayer song;
	

	@Override
	public void settings() {

		// Set Size

		int alto = 720;
		int ancho = 1280;

		size(ancho, alto, P3D);

		System.out.println("Canvas Size " + ancho + "x" + alto);
	}

	@Override
	public void setup() {
		System.out.println("Initializing Logic");
		logica = new Logica(this);
		 leap = new LeapMotion(this);
		// Check Logic its Live
		if (logica != null) {
			minim = new Minim(this);
			song = minim.loadFile("../data/fx/bg_sound.mp3",512);
			song.play();
			System.err.println("Logic Runing");
		}

		

		  
		 
		 
		 }
		 
	

	@Override
	public void draw() {
		
		

		// Set Background White
		// background(255, 255, 255);

		// Call Logic Paint
		logica.paint();
		if(logica != null){
			if(logica.game != null){
		if(logica.game.sendLevel() != null){
			logica.game.sendLevel().reciveLeap(leap);
		}
			}
		}
		 int fps = leap.getFrameRate();
		  for (Hand hand : leap.getHands ()) {


		    // ==================================================
		    // 2. Hand

		    int     handId             = hand.getId();
		    PVector handPosition       = hand.getPosition();
		    PVector handStabilized     = hand.getStabilizedPosition();
		    PVector handDirection      = hand.getDirection();
		    PVector handDynamics       = hand.getDynamics();
		    float   handRoll           = hand.getRoll();
		    float   handPitch          = hand.getPitch();
		    float   handYaw            = hand.getYaw();
		    boolean handIsLeft         = hand.isLeft();
		    boolean handIsRight        = hand.isRight();
		    float   handGrab           = hand.getGrabStrength();
		    float   handPinch          = hand.getPinchStrength();
		    float   handTime           = hand.getTimeVisible();
		    PVector spherePosition     = hand.getSpherePosition();
		    float   sphereRadius       = hand.getSphereRadius();

		    // --------------------------------------------------
		    // Drawing
		    hand.draw();

		    if(logica.game.sendLevel().sendMeteorites() != null){
		    ArrayList<Meteorite> meteoritos = logica.game.sendLevel().sendMeteorites();
		    /*
		    for (int i = 0; i < meteoritos.size(); i++) {
				if(hand.getPinchStrength() >= 0.7 && dist(meteoritos.get(i).getX(), meteoritos.get(i).getY(), 
						hand.getFinger(1).getPosition().x, hand.getFinger(1).getPosition().y) <= 50){
					//logica.click();
					//logica.drag();
			}
			*/
		    }
		    // ==================================================
		    // 3. Arm

		    if (hand.hasArm()) {
		      Arm     arm              = hand.getArm();
		      float   armWidth         = arm.getWidth();
		      PVector armWristPos      = arm.getWristPosition();
		      PVector armElbowPos      = arm.getElbowPosition();
		    }


		    // ==================================================
		    // 4. Finger

		    Finger  fingerThumb        = hand.getThumb();
		    // or                        hand.getFinger("thumb");
		    // or                        hand.getFinger(0);

		    Finger  fingerIndex        = hand.getIndexFinger();
		    // or                        hand.getFinger("index");
		    // or                        hand.getFinger(1);

		    Finger  fingerMiddle       = hand.getMiddleFinger();
		    // or                        hand.getFinger("middle");
		    // or                        hand.getFinger(2);

		    Finger  fingerRing         = hand.getRingFinger();
		    // or                        hand.getFinger("ring");
		    // or                        hand.getFinger(3);

		    Finger  fingerPink         = hand.getPinkyFinger();
		    // or                        hand.getFinger("pinky");
		    // or                        hand.getFinger(4);        


		    for (Finger finger : hand.getFingers()) {
		      // or              hand.getOutstretchedFingers();
		      // or              hand.getOutstretchedFingersByAngle();

		      int     fingerId         = finger.getId();
		      PVector fingerPosition   = finger.getPosition();
		      PVector fingerStabilized = finger.getStabilizedPosition();
		      PVector fingerVelocity   = finger.getVelocity();
		      PVector fingerDirection  = finger.getDirection();
		      float   fingerTime       = finger.getTimeVisible();
		    }
		    }
		  }
	

	// Program Runner
	public static void main(String[] args) {
		PApplet.main("MainApp");
	}

	// ------------------------------
	// Mouse Eventes
	// ------------------------------

	public void mousePressed() {
		logica.press();
		
		if (mouseButton == RIGHT) {
			
			logica.rightClick();
			//System.out.println("Click Derecho");
			
		}
	}

	@Override
	public void mouseReleased() {
		logica.release();
	}

	@Override
	public void mouseDragged() {
		logica.drag();
		if (mouseButton == RIGHT) {
			
			logica.rightClick();
		//	System.out.println("Click Derecho");
			
		}
	}

	@Override
	public void mouseClicked() {
		logica.click();

	}

	// End Class

	public void keyPressed() {

		logica.keyPressed();
	}

	void leapOnInit() {
		// println("Leap Motion Init");
	}

	void leapOnConnect() {
		// println("Leap Motion Connect");
	}

	void leapOnFrame() {
		// println("Leap Motion Frame");
	}

	void leapOnDisconnect() {
		// println("Leap Motion Disconnect");
	}

	void leapOnExit() {
		// println("Leap Motion Exit");
	}

}
