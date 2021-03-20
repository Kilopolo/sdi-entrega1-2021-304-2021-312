package com.uniovi.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.uniovi.entities.User;
import com.uniovi.services.UsersService;
@Component
public class LoginFormValidator implements Validator {

	@Autowired
	private UsersService usersService;


	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Error.empty");

		if (usersService.getUserByEmail(user.getEmail()) != null) {
			if (!usersService.getUserByEmail(user.getEmail()).getPassword().equals(user.getPassword())) {
				errors.rejectValue("email", "Error.login.email.wrongPassword");
			}
		} else {
			errors.rejectValue("email", "Error.login.email.notRegistered");
		}

		
	}
}
