package kh.com.finding.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import kh.com.finding.entities.EntityUser;
import kh.com.finding.utils.ConstsUtils;
import kh.com.finding.utils.JsonResponses;
import kh.com.finding.utils.StringUtils;

@Component("ajaxAuthenticationSuccessHandler")
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//String targetUrl = determineTargetUrl(authentication);
		//System.out.println("User has been logged in successfully and redirect to " + targetUrl);
		/*if(response.isCommitted()){
			System.out.println("Response has already been committed. Unable to redirect to " + targetUrl);
			return;
		}
		*/
		
		
		EntityUser entityUser = (EntityUser) authentication.getPrincipal();
		System.out.println( "url = " + StringUtils.nullToSetting(request.getParameter("redictUrl"),"/"));
		request.getSession().setAttribute("ENTITY_USER", entityUser);
		
		ObjectMapper mapper = new ObjectMapper();		
		JsonResponses msg = new JsonResponses(ConstsUtils.DEFAULT_SUCCESS_STATUS, StringUtils.nullToSetting(request.getParameter("redictUrl"),"/"));
		String str = mapper.writeValueAsString(msg);
	    response.getWriter().print(str);
	    response.getWriter().flush();
	}

	public String determineTargetUrl(Authentication authentication){
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		List<String> roles = new ArrayList<String>();
		for(GrantedAuthority authority: authorities){
			System.out.println("ROLE: "+ authority.getAuthority());
			roles.add(authority.getAuthority());
		}
		if(roles.contains("ROLE_ADMIN")){
			return "/khmoney";
		}else{
			return "/error/403"; // Access Denied
		}
	}
}
