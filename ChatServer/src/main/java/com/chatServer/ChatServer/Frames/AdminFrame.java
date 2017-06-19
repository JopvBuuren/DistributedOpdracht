package com.chatServer.ChatServer.Frames;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatServer.ChatServer.Server;
import com.chatServer.ChatServer.Controllers.DatabaseController;

@RestController
@RequestMapping("/admin")
public class AdminFrame extends Server{
	static Logger logger = LoggerFactory.getLogger(AdminFrame.class);
	DatabaseController dbc = DatabaseController.getInstance();
	
	@RequestMapping(value = "")
	public String admin(){
		 return "admin page";
	}
	
	@RequestMapping(value = "delete")
	public String deleteall(@RequestParam(value="del", required=true) String param1){
		if(param1.equals("true")){
			dbc.deleteDatabase();
		}else{
			logger.info("Denied");
		}
		return "del page";
	}
	
	@RequestMapping(value = "init")
	public String initall(@RequestParam(value="init", required=true) String param1){
		if(param1.equals("true")){
			dbc.init();
		}else{
			logger.info("Denied");
		}
		return "init page";
	}
	
}
