package com.chatServer.ChatServer.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chatServer.ChatServer.Message;
import com.chatServer.ChatServer.MessageBuffer;

public class MessageController extends Thread{
	private final int pollTimeMS = 50;
	static Logger logger = LoggerFactory.getLogger(MessageController.class);
	MessageBuffer msgBuffer = MessageBuffer.getInstance();
	DatabaseController dbc = DatabaseController.getInstance();
	
	public MessageController(){
		logger.info("Initialized MessageController with a pollrate off: " + pollTimeMS);
	}
	
	public void run(){
		try{
			for(;;){
				if(msgBuffer.hasNew()){
					Message msg = msgBuffer.getNext();
					handleMessage(msg);
				}
				sleep(pollTimeMS);
			}
		}catch(Exception e){
			logger.error("Task Handling failed", e);
		}
	}

	private void handleMessage(Message msg) {
		if(dbc != null){
			dbc.addMessage(msg);
		}else{
			logger.error("No database!");
		}
	}
}
