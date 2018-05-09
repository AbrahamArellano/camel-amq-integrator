package org.myitbasics.camel;

import javax.jms.Message;
import javax.jms.MessageListener;

public class Consumer implements MessageListener {
	
	public void onMessage(Message jmsMessage) {
		System.out.println("Consuming message");
	}

}
