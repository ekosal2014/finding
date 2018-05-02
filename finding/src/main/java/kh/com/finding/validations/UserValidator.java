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
import kh.com.finding.mappers.UserMapper;
import kh.com.finding.utils.ConstsUtils;

@Component
@ConfigurationProperties()
public class UserValidator implements Validator{

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MessageSource messageSource;
	
	private EmailValidator emailValidator = EmailValidator.Instance();
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return EntityUser.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

		EntityUser user = (EntityUser) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "full_name"   , ConstsUtils.NOTEMPTY_FULL_NAME   ,messageSource.getMessage(ConstsUtils.NOTEMPTY_FULL_NAME   , null ,LocaleContextHolder.getLocale()));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_name"   , ConstsUtils.NOTEMPTY_USER_NAME   ,messageSource.getMessage(ConstsUtils.NOTEMPTY_USER_NAME   , null ,LocaleContextHolder.getLocale()));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email"       , ConstsUtils.NOTEMPTY_EMAIL       ,messageSource.getMessage(ConstsUtils.NOTEMPTY_EMAIL        , null ,LocaleContextHolder.getLocale()));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password"    , ConstsUtils.NOTEMPTY_PASSWORD    ,messageSource.getMessage(ConstsUtils.NOTEMPTY_PASSWORD    , null ,LocaleContextHolder.getLocale()));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirm_password"    , ConstsUtils.NOTEMPTY_CONFIRM_PASSWORD    ,messageSource.getMessage(ConstsUtils.NOTEMPTY_CONFIRM_PASSWORD    , null ,LocaleContextHolder.getLocale()));
		
	
		if ( !errors.hasErrors() ){
			if ( !user.getPassword().equals(user.getConfirm_password()) ){
				errors.rejectValue( "confirm_password"   , ConstsUtils.NOTMATCH_CONFIRM_PASSWORD   ,messageSource.getMessage(ConstsUtils.NOTMATCH_CONFIRM_PASSWORD , null ,LocaleContextHolder.getLocale()));
			}
		}
		
		
		if (!errors.hasFieldErrors("user_name")){
			EntityUser entityUser = userMapper.loadingByUserName(user.getUser_name());
			if ( entityUser != null ){
				errors.rejectValue( "user_name"   , ConstsUtils.DUPLICATED_USERNAME   ,messageSource.getMessage(ConstsUtils.DUPLICATED_USERNAME , null ,LocaleContextHolder.getLocale()));
			}
		}
		
		if ( !emailValidator.isValid(user.getEmail())){
			errors.rejectValue("email", ConstsUtils.NOTVALID_EMAIL, messageSource.getMessage(ConstsUtils.NOTVALID_EMAIL , null ,LocaleContextHolder.getLocale()));
		}else{
			
			EntityUser entityUser = userMapper.loadingByUserEmail(user.getEmail());
			if ( entityUser != null ){
				errors.rejectValue("email", ConstsUtils.DUPLICATED_EMAIL, messageSource.getMessage(ConstsUtils.DUPLICATED_EMAIL , null ,LocaleContextHolder.getLocale()));
			}
			
			
		}
		
		
		
	
	}



}
