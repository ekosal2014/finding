package kh.com.finding.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.finding.captcha.ICaptchaService;
import kh.com.finding.entities.EntityUser;
import kh.com.finding.utils.ConstsUtils;
import kh.com.finding.utils.JsonResponses;
import kh.com.finding.validations.UserValidator;


@Controller
public class FindingController {
	
	
	@Autowired
	private ICaptchaService iCaptchaService;

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	UserValidator userValidator;
	
	
	@RequestMapping(value = {"/{locale:en|kh}","/"}, method = RequestMethod.GET)
	public String loadingHome(){
		return "index";		
	}
	
	@RequestMapping(value = "/{locale:en|kh}/login", method = RequestMethod.GET)
	public String loadingLogin(){	  
		return "login";
	}
	
	@RequestMapping(value = "/{locale:en|kh}/register", method = RequestMethod.GET)
	public String loadingRegister(){	  
		return "register";
	}
	
	@RequestMapping(value = "/{locale:en|kh}/register", method = RequestMethod.POST)
	public @ResponseBody JsonResponses registerUser(@Valid @ModelAttribute EntityUser entityUser ,  HttpServletRequest request,BindingResult result){	  

		userValidator.validate(entityUser, result);	
		
		if ( !iCaptchaService.processResponse(request.getParameter("g-recaptcha-response"),result) ){
			ObjectError error = new ObjectError("g-recaptcha-response",new String[]{"g-recaptcha-response"},null, messageSource.getMessage("msg.reg.captchaError"   , null ,LocaleContextHolder.getLocale()));
			result.addError(error);
		}
		
		JsonResponses json = new JsonResponses();	
		
		if ( result.hasErrors() ){			
			json.setStatus(ConstsUtils.DEFAULT_ERROR_STATUS);
			json.setResutl(result.getAllErrors());
			
		}else{
			json.setStatus(ConstsUtils.DEFAULT_SUCCESS_STATUS);
			json.setResutl("success");
		}
		
		return json;
	}
	
	
}
