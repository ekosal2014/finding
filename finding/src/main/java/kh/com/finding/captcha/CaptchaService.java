package kh.com.finding.captcha;

import java.net.URI;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;


@Service("captchaService")
public class CaptchaService implements ICaptchaService{

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private CaptchchaSettings  captchchaSettings;

	
	@Autowired
	private ReCaptchaAttemptService reCaptchaAttemptService;
	
	@Autowired
	private RestOperations restTemplate;
	
	public static final Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");
	
	@Override
	public void processResponse(String response) {
		// TODO Auto-generated method stub
		//System.out.println(" adfasdf " + getClientIP());
		if (reCaptchaAttemptService.isBlock(getClientIP())){
			throw new RuntimeException("reCaptchaAttemptService");
		}
		
		if (!responseSanityCheck(response)){
			throw new RuntimeException("responseSanityCheck");
		}
		
		final URI verityUri = URI.create(String.format(getReCaptchaUrl()+"?secret=%s&response=%s&remoteip=%s", getReCaptchaSecret(),response,getClientIP()));
		
		try{
			
			
			
		}catch(RestClientException e){
			e.printStackTrace();
		}
		
		
	}

	private boolean responseSanityCheck(final String response){
		return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
 	}
	
	@Override
	public String getReCaptchaSite() {
		// TODO Auto-generated method stub
		
		return captchchaSettings.getSite();
	}

	@Override
	public String getReCaptchaSecret() {
		// TODO Auto-generated method stub
		return captchchaSettings.getSecret();
	}
	
	private String getClientIP(){
		final String xfHeader = request.getHeader("X-Forwarded-For");
		if ( xfHeader == null ){
			return request.getRemoteAddr();
		}
		return xfHeader.split(",")[0];
	}

	@Override
	public String getReCaptchaUrl() {
		// TODO Auto-generated method stub
	
		return captchchaSettings.getUrl();
	}

}
