package kh.com.finding.captcha;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"success","challenge_ts","hostname","error-codes"})
public class GoogelResponse {
	
	@JsonProperty("success")
	private boolean success;
	@JsonProperty("challenge_ts")
	private String challenge_ts;
	@JsonProperty("hostname")
	private String hostname;
	@JsonProperty("error-codes")
	private ErrorCode[] errorCode; 
	
	static enum ErrorCode {
		MissingSecret,InvalidSecret,MissingResponse,InvalidResponse;
		
		private static Map<String,ErrorCode> errorsMap = new HashMap<String,ErrorCode>(4);
		
		static {
			
			   errorsMap.put("missing-input-secret", MissingSecret);
	           errorsMap.put("invalid-input-secret", InvalidSecret);
	           errorsMap.put("missing-input-response", MissingResponse);
	           errorsMap.put("invalid-input-response", InvalidResponse);
			
		}
		
		@JsonCreator
		public static ErrorCode forValue(final String value){
			return errorsMap.get(value.toLowerCase());
		}
		
		
		
	}
	@JsonProperty("success")
	public boolean isSuccess() {
		return success;
	}
	@JsonProperty("success")
	public void setSuccess(boolean success) {
		this.success = success;
	}
	@JsonProperty("challenge_ts")
	public String getChallenge_ts() {
		return challenge_ts;
	}
	@JsonProperty("challenge_ts")
	public void setChallenge_ts(String challenge_ts) {
		this.challenge_ts = challenge_ts;
	}
	@JsonProperty("hostname")
	public String getHostname() {
		return hostname;
	}
	@JsonProperty("hostname")
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	@JsonProperty("error-codes")
	public ErrorCode[] getErrorCode() {
		return errorCode;
	}
	@JsonProperty("error-codes")
	public void setErrorCode(ErrorCode[] errorCode) {
		this.errorCode = errorCode;
	}

	@JsonIgnore
	public boolean hasClientError(){
		
		final ErrorCode[] errors = getErrorCode();
		
		if (errors == null ){
			return false;
		}
		
		for (final ErrorCode error : errors){
			switch(error){
			case InvalidResponse:
			case MissingResponse:
				 return true;
			default:
				break;
			}
		}
		
		return false;
	}
	
	
}
