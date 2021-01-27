package com.luv2code.springdemo.studentException;

public class StudentErrorResponse {
	
	private int status;
	private String messege;
	private long time;
	
	public StudentErrorResponse(){
		
	}

	public StudentErrorResponse(int status, String messege, long time) {
		this.status = status;
		this.messege = messege;
		this.time = time;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
}
