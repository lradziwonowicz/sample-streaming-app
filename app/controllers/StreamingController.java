package controllers;

import java.util.Date;

import play.mvc.Http.WebSocketEvent;
import play.mvc.WebSocketController;

public class StreamingController extends WebSocketController {

	public static void stream(){
		System.out.println("Connected to stream...");
		while (inbound.isOpen()) {
			outbound.send("Timestamp: " + new Date().getTime());
			await(5000);
		}
	}
}
