package kh.com.finding.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kh.com.finding.entities.EntityService;
import kh.com.finding.utils.JsonResponses;

@Controller
public class ServiceController {

	@RequestMapping( value = "/{locale:en|kh}/serviceNew", method = RequestMethod.POST)
	public @ResponseBody JsonResponses loadingServiceInfo(@RequestParam(value="file"/*, required=false*/)  MultipartFile file) {
		//System.out.println(service.toString());
		System.out.println(file);
		return new JsonResponses();
	}
}
