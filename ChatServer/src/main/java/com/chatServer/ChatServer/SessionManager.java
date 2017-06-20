package com.chatServer.ChatServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chatServer.ChatServer.Controllers.DatabaseController;

public class SessionManager {
	static Logger logger = LoggerFactory.getLogger(DatabaseController.class);
	
	private static SessionManager instance = null;
	private List sessionList = new ArrayList();
	
	private SessionManager(){
		logger.info("Initialized Session Manager");
	}
	
	boolean isActive(int id){
		return sessionList.contains(id);
	}
	
	int createSession(){
		//aan userid koppelen vanuit loginmanager
		//opzetten sessies in loginmanager
		//thread
		//singleton
	
		Random rand = new Random();
		int randInt = rand.nextInt(50) + 1;
		int id = randInt;
		while(sessionList.contains(id)){
			id = randInt;
		}
		sessionList.add(id);
		return id;
	}
	
	void deleteSession(int id){
		int index = sessionList.indexOf(id);
		if(sessionList.indexOf(id) != -1){
			sessionList.remove(index);
		}
		else{
			logger.info("No session found");
		}
	}
	
	public static SessionManager getInstance(){
		if(instance == null){
			instance = new SessionManager();
		}
		return instance;
	}
}
