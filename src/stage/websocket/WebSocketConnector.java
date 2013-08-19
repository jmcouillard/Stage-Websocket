package stage.websocket;

import org.webbitserver.WebSocketConnection;

import processing.core.PApplet;
import muthesius.net.WebSocketP5;
import stage.display.Stage;

public class WebSocketConnector {

	private Stage stage;
	public WebSocketP5 socket;

	public WebSocketConnector(PApplet p, Stage stage, int port, String name) {
		this.stage = stage;

		socket = new WebSocketP5(p, port, name, this);
	}
	

	public void websocketOnMessage(WebSocketConnection con, String msg){
		PApplet.println(msg);
	}
	
	
	void mousePressed(){
	  socket.broadcast("hello from processing!");
	}


}
