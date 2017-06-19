package com.chatServer.ChatServer.Frames;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatServer.ChatServer.Server;
import com.chatServer.ChatServer.Controllers.DatabaseController;

@RestController
@RequestMapping("/pass")
public class PasswordFrame extends Server{
	static Logger logger = LoggerFactory.getLogger(PasswordFrame.class);
	DatabaseController dbc = DatabaseController.getInstance();
	@RequestMapping(value= path + "password")
	public String password(){
		return "new password?";
	}
}
