package com.chatServer.Controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController{

	static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	IndexController(){
		logger.info("Initialized controller");
	}
	
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