package job;

import models.MessageFactory;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import twitter4j.FilterQuery;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

//@Every("3s")
@OnApplicationStart
public class MessageCreator extends Job {

	MessageFactory mFactory = MessageFactory.get();
	ConfigurationBuilder cb = new ConfigurationBuilder();
	TwitterStream twitterStream = null;

	public void doJob() {
		// mFactory.createMsg("Timestamp: " + new Date().getTime());
		StatusListener listener = new StatusListener() {
			public void onStatus(Status status) {
				String tweet = status.getUser().getName() + " : "
						+ status.getText();
				mFactory.createMsg(tweet);
			}

			public void onDeletionNotice(
					StatusDeletionNotice statusDeletionNotice) {
			}

			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
			}

			public void onException(Exception ex) {
				ex.printStackTrace();
			}

			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub
			}
		};

		// create your own twitter4j.properties in conf folder
		twitterStream = new TwitterStreamFactory().getInstance();
		twitterStream.addListener(listener);
		// sample() method internally creates a thread which manipulates
		// TwitterStream and calls these adequate listener methods continuously.
		// twitterStream.sample();
		FilterQuery fq = new FilterQuery();
		String[] keywords = { "android 4.0" };
		twitterStream.filter(fq.track(keywords));
	}

}
