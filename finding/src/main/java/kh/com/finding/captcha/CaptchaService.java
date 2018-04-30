package kh.com.finding.captcha;

import java.net.URI;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import ch.qos.logback.core.db.dialect.MsSQLDialect;


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
	
	//@Autowired
	//private MessageSource messageSource;
	
	public static final Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");
	
	@Override
	public boolean processResponse(String response,  Errors error) {
		// TODO Auto-generated method stub

		if (reCaptchaAttemptService.isBlock(getClientIP())){			
			//throw new RuntimeException(messageSource.getMessage("msg.captchaClientIP", new Object[0], LocaleContextHolder.getLocale()));
			return false;
			
		}
		
		if (!responseSanityCheck(response)){
			//error.rejectValue("g-recaptcha-response", "msg.captchaError", messageSource.getMessage("msg.captchaError", new Object[0], LocaleContextHolder.getLocale()));
			//throw new RuntimeException(messageSource.getMessage("msg.captchaCheck", new Object[0], LocaleContextHolder.getLocale()));
			return false;
		}
		
		final URI verityUri = URI.create(String.format(getReCaptchaUrl()+"?secret=%s&response=%s&remoteip=%s", getReCaptchaSecret(),response,getClientIP()));
		
		try{
			
			final GoogleResponse googleRespone = restTemplate.getForObject(verityUri, GoogleResponse.class);
			
			//System.out.println( googleRespone.toString());
			
			if (!googleRespone.isSuccess()) {
				if (googleRespone.hasClientError()) {
					reCaptchaAttemptService.reCaptchFailed(getClientIP());
				}
				//error.rejectValue("g-recaptcha-response", "msg.captchaError", messageSource.getMessage("msg.captchaError", new Object[0], LocaleContextHolder.getLocale()));
				//throw new RuntimeException("kasjdfa");
				return false;
			}
			
		}catch(RestClientException e){
			//error.rejectValue("g-recaptcha-response", "msg.captchaError", messageSource.getMessage("msg.captchaError", new Object[0], LocaleContextHolder.getLocale()));
			//throw new RuntimeException("asjkdf");
			return false;
		}
		
		reCaptchaAttemptService.reCaptchaSucceeded(getClientIP());
		return true;
		
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
