package job;

import models.MessageFactory;
import play.jobs.Every;
import play.jobs.Job;

@Every("3s")
public class MessageCreator extends Job {
	
	public MessageFactory mFactory = MessageFactory.get();
	
	public void doJob(){
		mFactory.createMsg();
	}

}
