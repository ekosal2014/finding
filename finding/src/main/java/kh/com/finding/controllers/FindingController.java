package kh.com.finding.controllers;

import static org.mockito.Matchers.anyBoolean;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kh.com.finding.captcha.ICaptchaService;
import kh.com.finding.entities.EntityService;
import kh.com.finding.entities.EntityUser;
import kh.com.finding.services.UserServiceImpl;
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
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value = {"/{locale:en|kh}","/"}, method = RequestMethod.GET)
	public String loadingHome(){
		return "index";		
	}
	
	@RequestMapping(value = "/{locale:en|kh}/accessDenied", method = RequestMethod.GET)
	public String loadingAccessDenied(){	  
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loadingLogin(){	
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if ( !authentication.getPrincipal().equals("anonymousUser") ){
			return "redirect:/";
		}
		
		return "login";
	}

	@RequestMapping(value = "/{locale:en|kh}/register", method = RequestMethod.GET)
	public String loadingRegister(){	  
		return "register";
	}
	
	@RequestMapping(value = "/{locale:en|kh}/register", method = RequestMethod.POST)
	public @ResponseBody JsonResponses registerUser(@Valid @ModelAttribute EntityUser entityUser ,  HttpServletRequest request,BindingResult result){	  
		System.out.println(LocaleContextHolder.getLocaleContext().getLocale());
		userValidator.validate(entityUser, result);	
		
		/*if ( !iCaptchaService.processResponse(request.getParameter("g-recaptcha-response"),result) ){
			ObjectError error = new ObjectError("g-recaptcha-response",new String[]{"g-recaptcha-response"},null, messageSource.getMessage(ConstsUtils.NOTEMPTY_CAPTCHA  , null ,LocaleContextHolder.getLocale()));
			result.addError(error);
		}*/
		
		JsonResponses json = new JsonResponses();	
		
		if ( result.hasErrors() ){			
			json.setStatus(ConstsUtils.DEFAULT_ERROR_STATUS);
			json.setResutl(result.getAllErrors());
			
		}else{
			json = userServiceImpl.registerUserInfo(entityUser);
		}
		
		return json;
	}
	
	
	
}
