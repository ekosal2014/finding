package kh.com.finding.captcha;

public interface ICaptchaService {
	
	void processResponse(final String response);
    String getReCaptchaSite();

    String getReCaptchaSecret();
    String getReCaptchaUrl();
}
