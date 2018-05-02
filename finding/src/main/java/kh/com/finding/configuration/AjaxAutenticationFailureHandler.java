package kh.com.finding.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import kh.com.finding.utils.ConstsUtils;
import kh.com.finding.utils.JsonResponses;

@Component("ajaxAuthenticationFailureHandler")
public class AjaxAutenticationFailureHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();		
		JsonResponses msg = new JsonResponses(ConstsUtils.DEFAULT_ERROR_STATUS,exception.getMessage());
		String str = mapper.writeValueAsString(msg);
		response.getWriter().print(str);
		response.getWriter().flush();
	}

}
