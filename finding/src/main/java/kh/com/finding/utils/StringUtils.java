package kh.com.finding.utils;

public class StringUtils {

	public static String nullToSetting(Object obj, String param){
		
		String defaultString = param;		
		
		if (String.valueOf(obj).equals("null") || obj == null ){
			return defaultString;
		}else{
			defaultString = (String)obj;
		}
		return defaultString;
	}
}
