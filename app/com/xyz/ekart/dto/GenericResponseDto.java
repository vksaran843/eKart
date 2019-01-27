package com.xyz.ekart.dto;

public class GenericResponseDto {

	private String responseCode;
	
	private String status;
	
	private String errorCode;
	
	private String errorMessage;
	
	private Object responseObj;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getResponseObj() {
		return responseObj;
	}

	public void setResponseObj(Object responseObj) {
		this.responseObj = responseObj;
	}

	@Override
	public String toString() {
		return "GenericResponseDto [responseCode=" + responseCode + ", status=" + status + ", errorCode=" + errorCode
				+ ", errorMessage=" + errorMessage + ", responseObj=" + responseObj + "]";
	}
	
}
