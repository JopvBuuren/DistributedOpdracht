package com.chatServer.ChatServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController{

    private static final String PATH = "/";

    @RequestMapping(value = PATH)
    public String test() {
        return "text";
    }
    
    @RequestMapping(value = PATH + "test")
    public String test2() {
        return "secret stuff";
    }

}