import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import processing.core.PApplet;
import stage.display.Stage;
import stage.websocket.WebSocketConnector;

public class StageTest extends PApplet implements WindowFocusListener {

	private static final long serialVersionUID = 1;

	public static final int WIDTH = 960;
	public static final int HEIGHT = 540;

	public static int screenWidth = WIDTH;
	public static int screenHeight = HEIGHT;

	public Stage stage;
	public WebSocketConnector ws;

	public void setup() {

		// Setup
		size(screenWidth, screenHeight, OPENGL);
		hint(ENABLE_OPENGL_ERRORS);
		hint(DISABLE_TEXTURE_MIPMAPS);

		// Focus listener
		frame.addWindowFocusListener(this);
		
		// New stage
		stage = new Stage(this,width, height);
		
		// WebSocket connector
		ws = new WebSocketConnector(this, stage, 8080, "stage");
	}

	public void draw() {
		background(random(0, 255));
		stage.update();

//		  ws.socket.broadcast("hello from processing!");
		  
		stage.draw(this);
	}

	public void windowGainedFocus(WindowEvent e) {
		println("WindowFocusListener method called: windowGainedFocus.");
	}

	public void windowLostFocus(WindowEvent e) {
		println("WindowFocusListener method called: windowLostFocus.");
	}

	public void mouseMoved() {
		super.mouseMoved();
	}

	public void keyPressed() {
		super.keyPressed();
	}

	public void mousePressed() {
		super.mousePressed();
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { "--bgcolor=#000000", StageTest.class.getName() });

	}

}
