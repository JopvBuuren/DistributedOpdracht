package com.chatServer.ChatServer.Frames;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatServer.ChatServer.Server;

@RestController
public class ChatFrame extends Server{
	static Logger logger = LoggerFactory.getLogger(ChatFrame.class);
	
	@RequestMapping(value = path + "chat")
	public String  chat(){
		return "chat";
	}
}
