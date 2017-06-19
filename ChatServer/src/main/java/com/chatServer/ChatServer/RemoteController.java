package com.chatServer.ChatServer;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatServer.ChatServer.Controllers.DatabaseController;

// class for remote api (android)
@RestController
@RequestMapping("/rest")
public class RemoteController {
	MessageBuffer msgBuffer = MessageBuffer.getInstance();
	DatabaseController dbc = DatabaseController.getInstance();
	
	@RequestMapping(value = "get")
    public String get(@RequestParam(value="sender") String sender,
    		@RequestParam(value="receiver") String receiver,
    		@RequestParam(value="date") String date
    		) {
		// TODO: check Session
		if(true ){
			ArrayList<Message> msgs = dbc.getChat(Integer.parseInt(sender), Integer.parseInt(receiver), date);
			String t = "";
			for(Message msg : msgs){
				t +="@" + msg.getTime() + ": \n" + msg.getContent() + "\n";
			}
			return t;
		}
        return "text 2";
    }
	
	@RequestMapping(value = "post")
    public String post() {
        return "text 2";
    }
}
