package com.chatServer.ChatServer.Controllers;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chatServer.ChatServer.Server;
import com.chatServer.ChatServer.Frames.AdminFrame;
import com.chatServer.ChatServer.Frames.ChatFrame;
import com.chatServer.ChatServer.Frames.ErrorFrame;
import com.chatServer.ChatServer.Frames.PasswordFrame;
import com.chatServer.ChatServer.Frames.RegistrationFrame;

@RestController
public class IndexController{
	private static final String PATH = "/";
	static Logger logger = LoggerFactory.getLogger(IndexController.class);

	public IndexController(){
		logger.info("Initialized controller");
	}
    
    @RequestMapping(value = "/test")
    public String test() {
        return "text 2";
    }

}