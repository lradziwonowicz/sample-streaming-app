package controllers;

import models.MessageFactory;
import play.libs.F.EventStream;
import play.mvc.WebSocketController;

public class StreamingController extends WebSocketController {

	public static void stream() {
		System.out.println("Connected to stream...");

		MessageFactory mFactory = MessageFactory.get();

		EventStream<MessageFactory.Msg> messagesStream = mFactory.connect();

		while (inbound.isOpen()) {
			MessageFactory.Msg msg = await(messagesStream.nextEvent());
			outbound.send(msg.text);
		}
	}
}
