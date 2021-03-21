package com.uniovi.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.uniovi.entities.*;

@Component
public class AddOfferFormValidator implements Validator {

	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Offer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Offer offer = (Offer) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "Error.empty");
		if (offer.getTitle().length() < 5 || offer.getTitle().length() > 24) {
			errors.rejectValue("title", "Error.offer.title.length");
		}
		
		if (offer.getDetails().length() < 8 || offer.getDetails().length() > 50) {
			errors.rejectValue("details", "Error.offer.details.length");
		}
		if(offer.getAmount() <= 0.0) {
			errors.rejectValue("amount", "Error.offer.amount.less.than.zero");
		}
		
	}

}
