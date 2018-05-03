package kh.com.finding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@RequestMapping(value = "/{locale:en|kh}/user-info", method = RequestMethod.GET)
	public String loadingUserInfo(){
		return "index";
	}
	@RequestMapping(value = "/{locale:en|kh}/admin-info", method = RequestMethod.GET)
	public String loadingAdminInfo(){
		return "index";
	}
}
