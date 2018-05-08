package kh.com.finding.utils;

public class CustomRuntimeExcptionUtil extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String status; 
	private String msg ;
	
	
	public CustomRuntimeExcptionUtil(String msg){
		super(msg);
	}

	public CustomRuntimeExcptionUtil(String status,String msg){
		super();
		this.status = status;
		this.msg    = msg ; 
	}

	public CustomRuntimeExcptionUtil(String status,  Exception e){
		super(status,e);
	}
	
	public String getStatus() {
		return this.status;
	}

	public String getMsg() {
		return this.msg;
	}

	

}
