package kh.com.finding.configuration;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

public class UrlLocaleResolver implements LocaleResolver{

	private  static final String URL_LOCALE_ATTRIBUTE_NAME  = "URL_LOCALE_ATTRIBUTE_NAME";
	private  static final String URL_LOCATION_DEFAULT       = "URL_LOCATION_DEFAULT";
	private  static final String URL_CHANGE_LEANGUAGE       = "URL_CHANGE_LEANGUAGE";
	
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String uri         = request.getRequestURI();
		String defaulturl  = request.getServletContext().getContextPath();
		String prefixEn    = defaulturl + "/en";
		String prefixKh    = defaulturl + "/kh";
		
		
		
		Locale locale = null;
		
		if (uri.startsWith(prefixEn) ){
			
			locale = Locale.ENGLISH;
			
		}else if ( uri.startsWith(prefixKh) ){
			
			locale = new Locale("kh", "KH");
			
		}
		
		if ( locale != null ){
			
			request.getSession().setAttribute(URL_LOCALE_ATTRIBUTE_NAME, locale);
			
		}
		
		if ( locale == null ) {
			
			locale = (Locale) request.getSession().getAttribute(URL_LOCALE_ATTRIBUTE_NAME);
			
			if ( locale == null ) {
				
				locale = new Locale("kh", "KH");
				
			}
		}
	

		
		String urlChange   = "";
		if ( uri.length() > (defaulturl.length() + 3) ){
			
			urlChange = uri.substring(defaulturl.length() + 4, uri.length() );
			
		}
		
       
		request.getSession().setAttribute(URL_LOCATION_DEFAULT, locale.getLanguage());
		request.getSession().setAttribute(URL_CHANGE_LEANGUAGE, urlChange);
		
		return locale;
		
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		// TODO Auto-generated method stub
		
	}

}
