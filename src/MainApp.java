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
	@Override
	public void settings() {

		// Set Size
<<<<<<< HEAD
		int alto = 600;
		int ancho = 1000;
//hola khe ahxwe
=======
		int alto = 720;
		int ancho = 1280;

>>>>>>> 088d9dede4868f698c5e5aca173ba4e7ac45d4ec
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
			System.err.println("Logic Runing");
			
			
		}

		
		// LEAP MOTION 
 for (Hand hand : leap.getHands ()) {
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

			
			
 }
	}

	@Override
	public void draw() {

		// Set Background White
		background(255, 255, 255);

		// Call Logic Paint
		logica.paint();
		
		// leap motion 
		for (Hand hand : leap.getHands ()) {
	
			ellipse(hand.getFinger(1).getPosition().x, hand.getFinger(1).getPosition().y, 100,100);
			
			if (hand.getFinger(1).getPosition().x>width-500 && hand.getFinger(1).getPosition().x<width-300 && hand.getFinger(1).getPosition().y>height/2 && hand.getFinger(1).getPosition().y<height ) {
				logica.setPantallas(1);
				
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
	}
	
	@Override
	public void mouseReleased() {
		logica.release();
	}

	@Override
	public void mouseDragged() {
		logica.drag();
	}

	@Override
	public void mouseClicked() {
		
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
