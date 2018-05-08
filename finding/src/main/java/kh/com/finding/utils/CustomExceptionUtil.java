package kh.com.finding.utils;

public class CustomExceptionUtil extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String status;
	private String msg ;
	
	public CustomExceptionUtil(){
		super();
	}
	public CustomExceptionUtil(String msg){
		this.msg = msg;
	}
	public CustomExceptionUtil(String status, String msg){
		super(msg);
		this.status = status;
		this.msg  = msg ;
	}
	public CustomExceptionUtil(String status, Exception e){
		super(status, e);
	}
	
	public String getstatus(){
		return this.status; 
	}
	
	public String getMsg(){
		return this.msg;
	}

}
