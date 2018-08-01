package com.visa.training.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleFormController {
	
	@RequestMapping(value="/simpleform", method=RequestMethod.POST)
	public String handleFormSubmission(@RequestParam("user")String userName,@RequestParam("password")String password){
		
		if(userName.equalsIgnoreCase(password)){
			return "loginsuccess";
		}else
		{
			return "loginfailed";
		}
	}

}
