package kh.com.finding.utils;

public class CustomExceptionUtil extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String msg ;
	
	public CustomExceptionUtil(){
		super();
	}
	public CustomExceptionUtil(String msg){
		this.msg = msg;
	}
	public CustomExceptionUtil(String code, String msg){
		super(msg);
		this.code = code;
		this.msg  = msg ;
	}
	public CustomExceptionUtil(String code, Exception e){
		super(code, e);
	}
	
	public String getCode(){
		return this.code; 
	}
	
	public String getMsg(){
		return this.msg;
	}

}
