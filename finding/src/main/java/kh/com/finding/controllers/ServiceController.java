package kh.com.finding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.finding.entities.EntityService;
import kh.com.finding.utils.JsonResponses;

@Controller
public class ServiceController {

	@RequestMapping( value = "/{locale:en|kh}/userinfo/serviceNew", method = RequestMethod.POST)
	public @ResponseBody JsonResponses loadingServiceInfo(@RequestParam("a")  String a) 
	{
		System.out.println();
		return new JsonResponses(a);
	}
}
