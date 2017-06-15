package com.chatServer.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageController {
	static Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	MessageController(){
		logger.info("Initialized controller");
	}
}
