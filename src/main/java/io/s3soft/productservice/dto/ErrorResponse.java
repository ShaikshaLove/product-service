package io.s3soft.productservice.dto;

public class ErrorResponse extends Response{
   
    private String exception;

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public ErrorResponse(String content,int status,String exception) {
		super();
		this.exception = exception;
		super.content=content;
		super.status=status;
	}

	public ErrorResponse() {
		super();
	}
	

}
