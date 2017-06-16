package com.chatServer.ChatServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server {
	protected static final String path = "/";
	private boolean state = true;
	
	public Server(){
		
	}
	
	public void activate(){
		state = true;
	}
	
	public void deActivate(){
		state = false;
	}
	
	public boolean isActive(){
		return state;
	}

}
