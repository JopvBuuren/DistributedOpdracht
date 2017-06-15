package com.chatServer.ChatServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chatServer.Controllers.DatabaseController;

public class SessionManager {
static Logger logger = LoggerFactory.getLogger(DatabaseController.class);
	
	SessionManager(){
		logger.info("Initialized Session Manager");
	}
	
	boolean isActive(int id){
		return false;
	}
	
	int createSession(){
		return 0;
	}
	
	void deleteSession(int id){
		
	}
}
