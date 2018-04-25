package kh.com.finding.controllers;


import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kh.com.finding.utils.SimpleModelAndView;

@Controller
public class FindingController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private SimpleModelAndView simpleModelAndView;
	
	@RequestMapping(value = {"/{locale:en|kh}/","/"}, method = RequestMethod.GET)
	public ModelAndView loadingHome(){

		//System.out.println(LocaleContextHolder.getLocale().getLanguage());
		
		//System.out.println(messageSource.getMessage("label.password", new Object[0], new Locale(LocaleContextHolder.getLocale().getLanguage())));
		simpleModelAndView.setViewName("index");
		simpleModelAndView.addObject("url", LocaleContextHolder.getLocale().getLanguage());
		
		return simpleModelAndView;
		
	}
	
	@RequestMapping(value = "/{locale:en|kh}/login2", method = RequestMethod.GET)
	public String loadingLogin(){
		  
		System.out.println(LocaleContextHolder.getLocale().getLanguage());
		
		System.out.println(messageSource.getMessage("label.password", new Object[0], new Locale(LocaleContextHolder.getLocale().getLanguage())));
		
		return "login";
		
	}
	
	
}
