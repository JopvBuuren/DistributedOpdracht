package com.chatServer.ChatServer.Frames;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatServer.ChatServer.Server;

@RestController
public class ErrorFrame extends Server {
	static Logger logger = LoggerFactory.getLogger(Server.class);
	/*
	@RequestMapping(value = path + "error")
	public String errorFrame(){
		logger.warn("user error");
		return "Error!";
	}*/

}
