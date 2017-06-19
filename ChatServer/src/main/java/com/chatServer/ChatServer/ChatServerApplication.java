package com.chatServer.ChatServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chatServer.ChatServer.Controllers.MessageController;

@SpringBootApplication
public class ChatServerApplication {
	
	static Logger logger = LoggerFactory.getLogger(ChatServerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ChatServerApplication.class, args);
		MessageController msgc = new MessageController();
		msgc.start();
	}
	
	 
}
