package kh.com.finding.utils;

public class StringUtils {

	public static String nullToSetting(Object obj, String param){
		
		String defaultString = "";		
		
		if (String.valueOf(obj).equals("null") || String.valueOf(obj) == "" || String.valueOf(obj).length() == 0 ){
			return defaultString = param;
		}else{
			defaultString = (String)obj;
		}
		return defaultString;
	}
}
