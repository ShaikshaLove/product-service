package io.s3soft.productservice.dto;

public class Response {
	  String content;
	  int status;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Response(String content, int status) {
		super();
		this.content = content;
		this.status = status;
	}
	public Response() {
		super();
	}
}
