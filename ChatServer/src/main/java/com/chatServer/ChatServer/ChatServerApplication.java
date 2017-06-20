package com.chatServer.ChatServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.chatServer.ChatServer.Controllers.MessageController;

@SpringBootApplication
public class ChatServerApplication extends SpringBootServletInitializer  {
	
	static Logger logger = LoggerFactory.getLogger(ChatServerApplication.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ChatServerApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ChatServerApplication.class, args);
		MessageController msgc = new MessageController();
		msgc.start();
	}
	
	 
}
