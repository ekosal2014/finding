package kh.com.finding.captcha;

import org.springframework.validation.Errors;

public interface ICaptchaService {
	
	boolean processResponse(final String response, final Errors error);
    String getReCaptchaSite();

    String getReCaptchaSecret();
    String getReCaptchaUrl();
}
