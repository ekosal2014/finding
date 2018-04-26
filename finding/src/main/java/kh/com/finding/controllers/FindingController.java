package kh.com.finding.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.finding.captcha.ICaptchaService;


@Controller
public class FindingController {
	
	
	@Autowired
	private ICaptchaService iCaptchaService;
	
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
	public @ResponseBody String registerUser(HttpServletRequest request){	  
		iCaptchaService.processResponse(request.getParameter("g-recaptcha-response"));
		return "register";
	}
	
	
}
