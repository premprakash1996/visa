package com.visa.training.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.visa.training.domain.User;

@Component
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User u = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required", "Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required", "Password is Required");
		if(u.getName().length()<4){
			errors.rejectValue("name", "name.short", "Name must be at least 4 chars");
		}
	}

}
