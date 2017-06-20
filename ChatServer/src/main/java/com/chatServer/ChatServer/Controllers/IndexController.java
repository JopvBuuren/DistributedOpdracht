package com.chatServer.ChatServer.Controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
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

@Controller
public class IndexController{
	private static final String PATH = "/";
	static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	
	public IndexController(){
		logger.info("Initialized controller");
	}
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}

}