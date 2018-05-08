package kh.com.finding.validations;

import org.apache.commons.lang3.StringUtils;

import kh.com.finding.utils.ConstsUtils;
import kh.com.finding.utils.CustomRuntimeExcptionUtil;

public class Validations {

	/**
	 * 
	 * @param val
	 * @param message
	 */
	public static void isEmpty(String val, String message){
		
		if (StringUtils.isBlank(val)  || StringUtils.isEmpty(val) ){
			throw new CustomRuntimeExcptionUtil(ConstsUtils.DEFAULT_ERROR_STATUS, message);
		}
		
	}
	
	
}
