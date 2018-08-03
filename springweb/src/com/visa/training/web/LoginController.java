package com.visa.training.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.training.domain.User;

@Controller
public class LoginController {
	
	@Autowired
	LoginValidator validator;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String displayLoginForm(Map<String,Object> model){
		User user = new User();
		user.setName("");
		user.setPassword("");
		model.put("user", user);
		return "loginpage";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String handleFormSubmission(@ModelAttribute("user")User user,Errors errors){
		
		validator.validate(user, errors);
		if(errors.hasErrors()){
			return "loginpage";
		}
		
		if(user.getName().equalsIgnoreCase(user.getPassword())){
			return "loginsuccess";
		}else{
			return "loginfailed";
		}
	}

}
