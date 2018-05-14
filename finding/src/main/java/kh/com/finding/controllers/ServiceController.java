package kh.com.finding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kh.com.finding.entities.EntityService;
import kh.com.finding.utils.JsonResponses;

@Controller
public class ServiceController {

	@RequestMapping(value = "/{locale:en|kh}/userinfo/services", method = RequestMethod.GET)
	public String loadingServiceSearch(){	  
		return "userinfo/service_new";
	}
	
	@RequestMapping( value = "/{locale:en|kh}/userinfo/serviceNew", method = RequestMethod.POST)
	public @ResponseBody JsonResponses loadingServiceInfo(@ModelAttribute EntityService services,@RequestParam("file") MultipartFile file) 
	{
		System.out.println(services.toString());
		System.out.println(file);
		return new JsonResponses("");
	}
	
}
