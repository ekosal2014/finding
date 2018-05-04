package kh.com.finding.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

@Component("logoutSuccessHandlers")
public class LogoutSuccessHandlers implements LogoutSuccessHandler{

	private RedirectStrategy redirect = new DefaultRedirectStrategy();
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession(false);
		if ( session != null ){
			session.removeAttribute("user");
		}
		
		if ( authentication != null ) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		
		redirect.sendRedirect(request, response, "/");
		
	}

}
