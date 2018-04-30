package kh.com.finding.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kh.com.finding.entities.EntityUser;

@Component
@ConfigurationProperties()
public class UserValidator implements Validator{

	@Autowired
	private MessageSource messageSource;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return EntityUser.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email"   , "msg.email"   ,messageSource.getMessage("msg.reg.email"   , null ,LocaleContextHolder.getLocale()));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "msg.passowrd",messageSource.getMessage("msg.reg.passowrd", null ,LocaleContextHolder.getLocale()));
		
	}



}
