package kh.com.finding.validations;

import java.util.regex.Pattern;

public class EmailValidator {
	
	private static EmailValidator instance = null;
	private Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
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
