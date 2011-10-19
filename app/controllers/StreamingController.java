package controllers;

import java.util.Date;

import play.mvc.WebSocketController;
import twitter4j.*;

public class StreamingController extends WebSocketController {

	public static void stream(){
		System.out.println("Connected to stream...");
		
//		twitterStream twitterStream = new TwitterStreamFactory().getInstance();
//        StatusListener listener = new StatusListener() {
//            public void onStatus(Status status) {
//                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
//            }
//
//            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
//                System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
//            }
//
//            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
//                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
//            }
//
//            public void onScrubGeo(long userId, long upToStatusId) {
//                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
//            }
//
//            public void onException(Exception ex) {
//                ex.printStackTrace();
//            }
//        };
//        twitterStream.addListener(listener);
//        twitterStream.sample();
		
		while (inbound.isOpen()) {
			outbound.send("Timestamp: " + new Date().getTime());
			await(10000);
		}
	}
}
