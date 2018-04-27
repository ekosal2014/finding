package kh.com.finding.utils;

public class JsonResponses {
	
	public static JsonResponses instance = null;
	
	private String status;
	private Object result;
	
	public JsonResponses(){
		
	}
	
	public JsonResponses(String status){
		this.status = status;
	}
	
	public JsonResponses(String status,String result){
		this.status = status;
		this.result = result;
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public Object getResult(){
		return this.result;
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	
	public void setResutl(Object result){
		this.result = result;
	}
	
	public static JsonResponses getInstance(){
		if ( instance == null){
			new JsonResponses();
		}
		return instance;
	}

}
