package com.example.demo;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class RegisterLogin {

	@RequestMapping("/login")
	public @ResponseBody String login(@ModelAttribute User user) {
		return "login  for name ->"+user.getName() +"  and pass -> "+user.getPass();
	}

	@RequestMapping("/register")
	public @ResponseBody String register(@ModelAttribute User user) {
		return "register for name ->"+user.getName() +"  and pass -> "+user.getPass();
	}
	
}
