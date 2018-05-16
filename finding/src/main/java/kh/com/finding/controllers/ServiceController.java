package kh.com.finding.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kh.com.finding.entities.EntityService;
import kh.com.finding.entities.Images;
import kh.com.finding.services.SServicesImpl;
import kh.com.finding.utils.ConstsUtils;
import kh.com.finding.utils.JsonResponses;
import kh.com.finding.utils.UploadFileUtils;

@Controller
public class ServiceController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private SServicesImpl sServicesImpl;

	@RequestMapping(value = "/{locale:en|kh}/userinfo/services", method = RequestMethod.GET)
	public String loadingServiceSearch(){	  
		return "userinfo/service_new";
	}
	
	@RequestMapping( value = "/{locale:en|kh}/userinfo/serviceNew", method = RequestMethod.POST)
	public @ResponseBody JsonResponses loadingServiceInfo(@ModelAttribute EntityService service,@RequestParam("file") MultipartFile file,HttpServletRequest request) 
	{
		//System.out.println(System.getProperty("user.dir"));
		//System.out.println(request.getLocalName());
		//System.out.println(env.getProperty(ConstsUtils.PATH_PROFILE_USER_IMAGE));
		// * --------------------------------------------------------------------
		// * 
		// *---------------------------------------------------------------------
		String path  = System.getProperty("user.dir") + env.getProperty(ConstsUtils.PATH_PROFILE_USER_IMAGE);
		Images image = new Images();
		// * --------------------------------------------------------------------
		// * 
		// *---------------------------------------------------------------------
		if (UploadFileUtils.UploadSingleFile(image, file, path)){
		   service.setLogo(image.getImage());
		}
		
		
		
		return sServicesImpl.insertServiceInformation(service);
	}
	
}
