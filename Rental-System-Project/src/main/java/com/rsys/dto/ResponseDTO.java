package com.rsys.dto;

import org.springframework.http.HttpStatus;

public class ResponseDTO<T> 
{
	private HttpStatus status;
	private T data;
	private String message;
	
	public ResponseDTO() {
		// TODO Auto-generated constructor stub
	}

	public ResponseDTO(HttpStatus status, T data, String message) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseDTO [status=" + status + ", data=" + data + ", message=" + message + "]";
	}
	
}
