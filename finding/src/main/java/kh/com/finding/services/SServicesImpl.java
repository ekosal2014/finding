package kh.com.finding.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kh.com.finding.entities.EntityService;
import kh.com.finding.entities.EntityUser;
import kh.com.finding.mappers.ServiceMappers;
import kh.com.finding.utils.ConstsUtils;
import kh.com.finding.utils.DateUtils;
import kh.com.finding.utils.JsonResponses;


@Service
public class SServicesImpl {
	
	@Autowired
	private ServiceMappers serviceMappers;
	
	public JsonResponses insertServiceInformation(EntityService service){
		
		// ** (: ------------------------------------------------
		// ** 0. initialize renew object variable
		JsonResponses result  = new JsonResponses();
		EntityUser entityuser = new EntityUser();
		Authentication auth   = SecurityContextHolder.getContext().getAuthentication();
		
		try{
			
			// ** (: -----------------------------------------------
			// ** 1. start check user login session
			if ( !auth.getPrincipal().equals("anonymousUser") ){
				
				entityuser = (EntityUser) auth.getPrincipal();

			}
			
			// ** (: --------------------------------------------------
			// ** 2. start initialize value into service object			
			service.setUser_cd(entityuser.getUser_cd());
			service.setReg_dt(DateUtils.getDateTime(DateUtils.dt_format));
			service.setSts("1");
			
			// ** (: --------------------------------------------------
			// ** 3. start insert value into table user_services 
			serviceMappers.insertServiceInformation(service);
			
			result.setStatus(ConstsUtils.DEFAULT_SUCCESS_STATUS);
			result.setResutl("sucess");
			
		}catch(Exception e){
			
			result.setStatus(ConstsUtils.DEFAULT_ERROR_STATUS);
			result.setResutl("fails");
			e.printStackTrace();
		}
		
		return result;
		
	}

}
