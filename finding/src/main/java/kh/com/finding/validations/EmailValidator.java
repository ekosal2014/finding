package kh.com.finding.validations;

import java.util.regex.Pattern;

public class EmailValidator {
	
	private static EmailValidator instance = null;
	private Pattern pattern = Pattern.compile("^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$");
	
	public static EmailValidator Instance(){
		
		if ( instance  == null){
			return new EmailValidator();
		}
		 
		return instance;
	}
	
	public boolean isValid(String email){
		
		if ( pattern.matcher(email).matches() ){
			return true;
		}
		return false;
	}

}
