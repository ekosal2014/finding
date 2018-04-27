package kh.com.finding.utils;

public class CustomRuntimeExcptionUtil extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code; 
	private String msg ;
	
	
	public CustomRuntimeExcptionUtil(String msg){
		super(msg);
	}

	public CustomRuntimeExcptionUtil(String code,String msg){
		this.code = code;
		this.msg  = msg ; 
	}

	public CustomRuntimeExcptionUtil(String code,  Exception e){
		super(code,e);
	}
	
	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
