package models;

import play.libs.F.ArchivedEventStream;
import play.libs.F.EventStream;

public class MessageFactory {
	final ArchivedEventStream<MessageFactory.Msg> msgEvents = new ArchivedEventStream<MessageFactory.Msg>(
			100);

	public EventStream<MessageFactory.Msg> connect() {
		return msgEvents.eventStream();
	}

	public void createMsg(String tweet) {
		// msgEvents.publish(new Msg("Timestamp: " + new Date().getTime()));
		msgEvents.publish(new Msg(tweet));
	}

	static MessageFactory instance = null;

	public static MessageFactory get() {
		System.out.println("MessageFactory.get()");
		if (instance == null) {
			instance = new MessageFactory();
		}
		return instance;
	}

	public static class Msg {

		final public String text;

		public Msg(String text) {
			this.text = text;
		}

	}
}
