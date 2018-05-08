package kh.com.finding.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.finding.utils.CustomExceptionUtil;
import kh.com.finding.utils.CustomRuntimeExcptionUtil;
import kh.com.finding.utils.JsonResponses;

@ControllerAdvice
public class ErrorController {
	
	@ExceptionHandler(CustomExceptionUtil.class)
	public @ResponseBody JsonResponses Exception(CustomExceptionUtil e){
		return new JsonResponses(e.getstatus(), e.getMsg());
	}
	
	@ExceptionHandler(CustomRuntimeExcptionUtil.class)
	public @ResponseBody JsonResponses RunTimeException(CustomRuntimeExcptionUtil e){
		System.out.println("status = " +e.getStatus() + " msg = " + e.getMsg());
		return new JsonResponses(e.getStatus(), e.getMsg());
	}

}
