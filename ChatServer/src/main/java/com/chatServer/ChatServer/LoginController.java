package com.chatServer.ChatServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chatServer.ChatServer.Controllers.DatabaseController;

@Controller
@RequestMapping("/login")
public class LoginController {
	DatabaseController dbc = DatabaseController.getInstance();
	
	@RequestMapping(value = "")
    public String test() {
		ModelAndView vw = new ModelAndView();
		vw.setViewName("login");
        return "login";
    }
	
	@RequestMapping(value = "enc", method = RequestMethod.POST)
    public String test2(
    		@RequestParam(value="name", required=true) String name,
    		@RequestParam(value="pass", required=true) String pass) {
		if(dbc.isAuth(name, pass)){
			int i = dbc.getUser(name);
			return "I am user <b>" + String.valueOf(i) + "</b>";
		}
        return "text b";
    }
}
