package models;

import java.util.Date;

import play.libs.F.ArchivedEventStream;
import play.libs.F.EventStream;

public class MessageFactory {
	final ArchivedEventStream<MessageFactory.Msg> msgEvents = new ArchivedEventStream<MessageFactory.Msg>(
			25);

	public EventStream<MessageFactory.Msg> connect() {
        return msgEvents.eventStream();
    }
	
	public void createMsg() {
		msgEvents.publish(new Msg("Timestamp: " + new Date().getTime()));
    }
	
	static MessageFactory instance = null;
    public static MessageFactory get() {
        if(instance == null) {
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
