package kh.com.finding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.finding.entities.EntityService;
import kh.com.finding.utils.JsonResponses;

@Controller
public class ServiceController {

	@RequestMapping( value = "/{locale:en|kh}/serverNew", method = RequestMethod.POST)
	public @ResponseBody JsonResponses loadingServiceInfo(@ModelAttribute EntityService service) {
		System.out.println(service.toString());
		return new JsonResponses();
	}
}
