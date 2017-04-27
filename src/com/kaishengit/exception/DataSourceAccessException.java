package com.kaishengit.exception;

public class DataSourceAccessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataSourceAccessException(String message){
		super(message);
	}
	
	public DataSourceAccessException(Throwable th){
		super(th);
	}
	
	public DataSourceAccessException(String message,Throwable th){
		super(message,th);
	}
	
}
