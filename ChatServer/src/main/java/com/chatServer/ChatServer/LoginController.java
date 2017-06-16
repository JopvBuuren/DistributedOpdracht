package com.chatServer.ChatServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@RequestMapping(value = "/a")
    public String test() {
        return "text a";
    }
	@RequestMapping(value = "/b")
    public String test2() {
        return "text b";
    }
}
