package com.chatServer.ChatServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chatServer.ChatServer.Controllers.DatabaseController;
import com.chatServer.ChatServer.Controllers.IndexController;
@SpringBootApplication
public class ChatServerApplication {
	
	static Logger logger = LoggerFactory.getLogger(ChatServerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ChatServerApplication.class, args);
		DatabaseController db = new DatabaseController();
		IndexController ic = new IndexController();
	}
	
	 
}
